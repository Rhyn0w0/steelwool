#!/usr/bin/env python3
"""Boots popular NeoForge mods on a Fabric dedicated server with SteelWool and reports which load.

For each mod in compat/mods.json it downloads the mod and its required dependencies from
Modrinth, starts a fresh server with SteelWool + Fabric API + those jars in mods/neoforge/,
waits for "Done", stops it, and records the result. Mods run one at a time so one failure
doesn't hide another.

Usage (after `./gradlew testBundle`):
    python3 compat/compat_check.py                 # every mod
    python3 compat/compat_check.py jei curios      # only these slugs

Output goes to build/compat/: report.md, results.json and logs/<slug>.log.
Exits with status 1 only if a mod marked "expect": "pass" no longer loads.
Uses only the Python standard library.
"""

from __future__ import annotations

import argparse
import glob
import json
import os
import queue
import re
import shutil
import subprocess
import sys
import threading
import time
import urllib.error
import urllib.parse
import urllib.request
import zipfile
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
MODRINTH = "https://api.modrinth.com/v2"
USER_AGENT = "mod-compat-check/1.0"

# Lines that explain a failure.
MISSING_API = re.compile(r"It uses NeoForge API '([^']+)', which SteelWool does not support yet")
MISSING_CLASS = re.compile(r"(?:ClassNotFoundException|NoClassDefFoundError|NoSuchMethodError|NoSuchFieldError): "
                           r"(?:Exception \S+ )?'?([\w$/.]*net[/.]neoforged[\w$/.:()\[;]*)")
FAILED_TO_LOAD = re.compile(r"NeoForge mod '([^']+)' failed to load: (.*)")
CAUSED_BY = re.compile(r"^Caused by: (\S+(?:Exception|Error)\b.*)")
EXCEPTION = re.compile(r"^(?:Exception in thread \"[^\"]*\" )?((?:[\w$]+\.)+[\w$]*(?:Exception|Error)\b.*)")
MIXIN_CAUSE = re.compile(r"(?:Invalid\w*Exception|MixinApplyError|MixinTargetAlreadyLoadedException)")


def http_json(url: str):
    req = urllib.request.Request(url, headers={"User-Agent": USER_AGENT})
    with urllib.request.urlopen(req, timeout=60) as resp:
        return json.load(resp)


def download(url: str, dest: Path) -> None:
    if dest.exists():
        return
    dest.parent.mkdir(parents=True, exist_ok=True)
    req = urllib.request.Request(url, headers={"User-Agent": USER_AGENT})
    tmp = dest.with_suffix(dest.suffix + ".part")
    with urllib.request.urlopen(req, timeout=300) as resp, open(tmp, "wb") as out:
        shutil.copyfileobj(resp, out)
    tmp.rename(dest)


class Modrinth:
    def __init__(self, minecraft: str, loader: str, cache: Path):
        self.minecraft = minecraft
        self.loader = loader
        self.cache = cache
        self.projects: dict[str, dict] = {}

    def project(self, id_or_slug: str) -> dict:
        if id_or_slug not in self.projects:
            project = http_json(f"{MODRINTH}/project/{urllib.parse.quote(id_or_slug)}")
            self.projects[project["id"]] = self.projects[project["slug"]] = project
        return self.projects[id_or_slug]

    def version(self, project: str, pin: str | None = None) -> dict | None:
        if pin:
            try:
                return http_json(f"{MODRINTH}/version/{urllib.parse.quote(pin)}")
            except urllib.error.HTTPError:
                return http_json(f"{MODRINTH}/project/{urllib.parse.quote(project)}/version/{urllib.parse.quote(pin)}")
        query = urllib.parse.urlencode({
            "loaders": json.dumps([self.loader]),
            "game_versions": json.dumps([self.minecraft]),
        })
        versions = http_json(f"{MODRINTH}/project/{urllib.parse.quote(project)}/version?{query}")
        return versions[0] if versions else None

    def resolve(self, slug: str, pin: str | None) -> tuple[dict, list[dict]]:
        """Returns the mod's version and the versions of its required dependencies (recursively)."""
        root = self.version(slug, pin)
        if root is None:
            raise LookupError(f"no {self.loader} {self.minecraft} version on Modrinth")
        deps: list[dict] = []
        seen = {root["project_id"]}
        todo = [root]
        while todo:
            for dep in todo.pop()["dependencies"]:
                if dep["dependency_type"] != "required":
                    continue
                if dep.get("version_id"):
                    version = http_json(f"{MODRINTH}/version/{dep['version_id']}")
                else:
                    version = self.version(dep["project_id"])
                    if version is None:
                        name = self.project(dep["project_id"])["slug"]
                        raise LookupError(f"required dependency '{name}' has no {self.loader} {self.minecraft} version")
                if version["project_id"] in seen:
                    continue
                seen.add(version["project_id"])
                deps.append(version)
                todo.append(version)
        return root, deps

    def fetch(self, version: dict) -> Path:
        file = next((f for f in version["files"] if f["primary"]), version["files"][0])
        dest = self.cache / version["project_id"] / file["filename"]
        download(file["url"], dest)
        return dest


def java_executable() -> str:
    home = os.environ.get("JAVA_HOME")
    return str(Path(home) / "bin" / "java") if home else "java"


def prepare_base_server(bundle: Path, work: Path, minecraft: str) -> Path:
    """Unpacks the test bundle and installs a Fabric server into work/base (reused across runs)."""
    base = work / "base"
    marker = base / ".installed"
    if marker.exists() and marker.read_text() == str(bundle.stat().st_mtime):
        return base
    shutil.rmtree(base, ignore_errors=True)
    base.mkdir(parents=True)

    with zipfile.ZipFile(bundle) as zf:
        for name in zf.namelist():
            parts = Path(name).parts[1:]  # strip steelwool-test-bundle-<version>/
            if not parts or name.endswith("/"):
                continue
            if parts[0] == "mods" and len(parts) == 2:
                target = base / "mods" / parts[1]
            elif len(parts) == 1 and parts[0].startswith("fabric-installer") and parts[0].endswith(".jar"):
                target = base / "installer" / parts[0]
            else:
                continue  # skips INSTRUCTIONS.md and the bundled test mod
            target.parent.mkdir(parents=True, exist_ok=True)
            target.write_bytes(zf.read(name))

    installer = next((base / "installer").glob("fabric-installer*.jar"))
    print(f"Installing Fabric server for Minecraft {minecraft}...", flush=True)
    subprocess.run([java_executable(), "-jar", str(installer), "server", "-mcversion", minecraft,
                    "-downloadMinecraft", "-dir", str(base)], check=True, stdout=subprocess.DEVNULL)
    marker.write_text(str(bundle.stat().st_mtime))
    return base


def make_server(base: Path, run_dir: Path, jars: list[Path]) -> None:
    shutil.rmtree(run_dir, ignore_errors=True)
    run_dir.mkdir(parents=True)
    for entry in base.iterdir():
        if entry.name in ("mods", "installer", ".installed"):
            continue
        (run_dir / entry.name).symlink_to(entry.resolve(), target_is_directory=entry.is_dir())
    shutil.copytree(base / "mods", run_dir / "mods")
    neoforge = run_dir / "mods" / "neoforge"
    neoforge.mkdir()
    for jar in jars:
        shutil.copy2(jar, neoforge / jar.name)
    (run_dir / "eula.txt").write_text("eula=true\n")
    (run_dir / "server.properties").write_text(
        "online-mode=false\nsync-chunk-writes=false\nserver-port=0\nquery.port=0\nenable-rcon=false\n")


def run_server(run_dir: Path, log_path: Path, timeout: int, memory: str) -> tuple[str, list[str], float]:
    """Returns ("done" | "exited" | "timeout", output lines, seconds)."""
    start = time.monotonic()
    proc = subprocess.Popen([java_executable(), f"-Xmx{memory}", "-jar", "fabric-server-launch.jar", "nogui"],
                            cwd=run_dir, stdin=subprocess.PIPE, stdout=subprocess.PIPE,
                            stderr=subprocess.STDOUT, text=True, errors="replace")
    lines: queue.Queue[str | None] = queue.Queue()

    def pump():
        for line in proc.stdout:
            lines.put(line)
        lines.put(None)

    threading.Thread(target=pump, daemon=True).start()
    output: list[str] = []
    state = "exited"
    deadline = start + timeout
    with open(log_path, "w") as log:
        while True:
            try:
                line = lines.get(timeout=max(0.1, deadline - time.monotonic()))
            except queue.Empty:
                state = "timeout" if state != "done" else state
                break
            if line is None:
                break
            log.write(line)
            output.append(line.rstrip("\n"))
            if state != "done" and re.search(r"\]: Done \(\d", line):
                state = "done"
                proc.stdin.write("stop\n")
                proc.stdin.flush()
                deadline = time.monotonic() + 60
            if time.monotonic() > deadline:
                state = "timeout" if state != "done" else state
                break
    if proc.poll() is None:
        proc.kill()
        proc.wait()
    return state, output, time.monotonic() - start


def short(message: str) -> str:
    message = re.sub(r"^(?:[\w$]+\.)+", "", message)  # drop the exception's package
    message = message.split(" [INJECT")[0].split(" [PREINJECT")[0]
    return message[:300]


def explain(output: list[str]) -> tuple[str, str]:
    """Picks a category and a one-line reason from a failed server's output."""
    text = "\n".join(output)
    if m := MISSING_API.search(text):
        return "missing-api", m.group(1)
    for i, line in enumerate(output):
        if "SteelWool cannot load the NeoForge mods:" in line:
            problems = [l.strip(" -") for l in output[i + 1:i + 6] if l.lstrip().startswith("- ")]
            return "dependency", "; ".join(problems) or line
    if m := MISSING_CLASS.search(text):
        name = m.group(1).replace("/", ".")
        while name.endswith(")") and name.count(")") > name.count("("):
            name = name[:-1]
        return "missing-api", name
    causes = [m.group(1) for l in output if (m := CAUSED_BY.match(l))]
    mixin = [c for c in causes if MIXIN_CAUSE.search(c.split(":")[0])]
    if mixin:
        return "mixin", short(mixin[-1])
    if m := re.search(r"^.*InvalidMixinException.*$", text, re.M):
        return "mixin", short(m.group(0).split("InvalidMixinException: ")[-1])
    if causes:
        return "crash", short(causes[-1])
    if m := FAILED_TO_LOAD.search(text):
        return "crash", m.group(2)[:300]
    for line in output:
        if m := EXCEPTION.match(line.strip()):
            return "crash", short(m.group(1))
    return "crash", (output[-1] if output else "no output")[:300]


def check(mod: dict, modrinth: Modrinth, base: Path, work: Path, timeout: int, memory: str) -> dict:
    slug = mod["slug"]
    result = {"slug": slug, "expect": mod.get("expect", "unknown"), "version": None, "dependencies": []}
    try:
        root, deps = modrinth.resolve(slug, mod.get("version"))
        for extra in mod.get("with", []):  # dependencies the Modrinth page doesn't declare
            extra_root, extra_deps = modrinth.resolve(extra, None)
            known = {root["project_id"]} | {d["project_id"] for d in deps}
            deps += [v for v in [extra_root, *extra_deps] if v["project_id"] not in known]
        jars = [modrinth.fetch(root)] + [modrinth.fetch(d) for d in deps]
    except (LookupError, OSError) as e:
        return result | {"result": "unavailable", "reason": str(e), "seconds": 0}
    result["version"] = root["version_number"]
    result["dependencies"] = [f"{modrinth.project(d['project_id'])['slug']} {d['version_number']}" for d in deps]

    log_path = work / "logs" / f"{slug}.log"
    log_path.parent.mkdir(parents=True, exist_ok=True)
    run_dir = work / "server"
    make_server(base, run_dir, jars)
    state, output, seconds = run_server(run_dir, log_path, timeout, memory)
    result["seconds"] = round(seconds)

    ignored = [l for l in output if "Ignoring " in l and "/mods/neoforge" in l]
    if ignored:
        result["warnings"] = [l.split("]: ", 1)[-1] for l in ignored]
    if state == "done":
        if not any("Found " in l and "NeoForge mod(s)" in l for l in output):
            why = "; ".join(w.split(": ", 1)[-1] for w in result.get("warnings", []))
            return result | {"result": "skipped", "reason": "SteelWool did not load the mod: " + (why or "unknown reason")}
        return result | {"result": "pass", "reason": ""}
    if state == "timeout":
        return result | {"result": "timeout", "reason": f"server did not finish starting within {timeout}s"}
    category, reason = explain(output)
    if ignored:
        reason += " (SteelWool ignored: " + ", ".join(l.split("Ignoring ", 1)[1].split(" in ")[0] for l in ignored) + ")"
    return result | {"result": category, "reason": reason}


def write_report(results: list[dict], minecraft: str, out: Path) -> str:
    icons = {"pass": "✅", "unavailable": "⚪", "timeout": "⏱️"}
    passed = sum(r["result"] == "pass" for r in results)
    lines = [
        f"# NeoForge mod compatibility (Minecraft {minecraft})",
        "",
        f"**{passed} / {len(results)}** mods start on a Fabric dedicated server with SteelWool.",
        "Each mod is tested alone, with its required dependencies.",
        "",
        "| Mod | Version | Result | Details |",
        "|---|---|---|---|",
    ]
    for r in results:
        detail = r["reason"].replace("|", "\\|")
        if r.get("dependencies"):
            detail = (detail + "<br>" if detail else "") + "with " + ", ".join(r["dependencies"])
        note = ""
        if r["expect"] == "pass" and r["result"] != "pass":
            note = " **(regression)**"
        elif r["expect"] != "pass" and r["result"] == "pass":
            note = " (new: set `expect` to `pass`)"
        icon = icons.get(r["result"], "❌")
        lines.append(f"| [{r['slug']}](https://modrinth.com/mod/{r['slug']}) | {r['version'] or '–'} "
                     f"| {icon} {r['result']}{note} | {detail} |")

    missing: dict[str, list[str]] = {}
    for r in results:
        if r["result"] == "missing-api":
            missing.setdefault(r["reason"], []).append(r["slug"])
    if missing:
        lines += ["", "## Missing NeoForge APIs (first one each mod hit)", "",
                  "| API | Mods |", "|---|---|"]
        for api, slugs in sorted(missing.items(), key=lambda kv: -len(kv[1])):
            lines.append(f"| `{api}` | {', '.join(slugs)} |")

    report = "\n".join(lines) + "\n"
    (out / "report.md").write_text(report)
    (out / "results.json").write_text(json.dumps(results, indent=2) + "\n")
    return report


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    parser.add_argument("slugs", nargs="*", help="only test these mods (Modrinth slugs from mods.json)")
    parser.add_argument("--mods", type=Path, default=ROOT / "compat" / "mods.json")
    parser.add_argument("--bundle", type=Path, help="test bundle zip (default: build/distributions/steelwool-test-bundle-*.zip)")
    parser.add_argument("--out", type=Path, default=ROOT / "build" / "compat")
    parser.add_argument("--timeout", type=int, default=300, help="seconds to wait for each server to start")
    parser.add_argument("--memory", default="3G", help="server -Xmx")
    args = parser.parse_args()

    config = json.loads(args.mods.read_text())
    mods = config["mods"]
    if args.slugs:
        unknown = set(args.slugs) - {m["slug"] for m in mods}
        if unknown:
            parser.error(f"not in {args.mods}: {', '.join(sorted(unknown))}")
        mods = [m for m in mods if m["slug"] in args.slugs]

    bundle = args.bundle
    if bundle is None:
        candidates = sorted(glob.glob(str(ROOT / "build" / "distributions" / "steelwool-test-bundle-*.zip")),
                            key=os.path.getmtime)
        if not candidates:
            parser.error("no test bundle found; run ./gradlew testBundle first or pass --bundle")
        bundle = Path(candidates[-1])

    args.out.mkdir(parents=True, exist_ok=True)
    base = prepare_base_server(bundle, args.out, config["minecraft"])
    modrinth = Modrinth(config["minecraft"], config.get("loader", "neoforge"), args.out / "downloads")

    results = []
    for i, mod in enumerate(mods, 1):
        print(f"[{i}/{len(mods)}] {mod['slug']}... ", end="", flush=True)
        r = check(mod, modrinth, base, args.out, args.timeout, args.memory)
        results.append(r)
        print(f"{r['result']} ({r['seconds']}s) {r['reason']}", flush=True)
    shutil.rmtree(args.out / "server", ignore_errors=True)

    report = write_report(results, config["minecraft"], args.out)
    if summary := os.environ.get("GITHUB_STEP_SUMMARY"):
        with open(summary, "a") as f:
            f.write(report)
    print(f"\nReport: {args.out / 'report.md'}")

    regressions = [r["slug"] for r in results if r["expect"] == "pass" and r["result"] != "pass"]
    if regressions:
        print(f"Regressions (expected to pass): {', '.join(regressions)}", file=sys.stderr)
        return 1
    return 0


if __name__ == "__main__":
    sys.exit(main())
