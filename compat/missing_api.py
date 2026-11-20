#!/usr/bin/env python3
"""List the NeoForge API a NeoForge mod jar uses that SteelWool does not provide.

Usage: python3 compat/missing_api.py [--members] <steelwool.jar> <mod.jar> [<mod.jar> ...]

With --members, it also lists which members of each missing class the mods use.

For every class in the mod jars (and the jars nested in them), it reads the classes, methods and
fields they reference in the net.neoforged packages and compares them with the ones in the SteelWool
jar (and the libraries it bundles). Members a SteelWool class inherits from a superclass are found
too, as long as the superclass is also in SteelWool. It needs `javap` (Java 25) on PATH or JAVA_HOME.

The compat check only shows the first missing class a mod hits; this shows all of them at once.
"""
from __future__ import annotations

import os
import re
import shutil
import subprocess
import sys
import tempfile
import zipfile
from collections import defaultdict
from pathlib import Path

PREFIX = "net/neoforged/"
SIGNATURE_TYPE = re.compile(r"\b(net\.neoforged\.[\w.]+\.[A-Z][\w$]*)")
REF = re.compile(r"// (Method|InterfaceMethod|Field|class) ([\w/$]+)(?:\.([\w<>$]+):(\S+))?")
HEADER = re.compile(r"^(?:[\w ]+ )?(?:class|interface|enum|record|@interface) ([\w.$]+)(?:<.*?>)?(?: extends ([\w.$]+))?")
MEMBER = re.compile(r"^\s+(?:[\w.$<>\[\], ?]+ )?([\w$<>]+)\(.*\);?$|^\s+(?:[\w.$<>\[\], ?]+ )([\w$]+);$")


def javap() -> str:
    home = os.environ.get("JAVA_HOME")
    if home and Path(home, "bin", "javap").exists():
        return str(Path(home, "bin", "javap"))
    found = shutil.which("javap")
    if not found:
        sys.exit("javap not found; set JAVA_HOME to a JDK")
    return found


def expand(jar: Path, work: Path) -> list[Path]:
    """The jar plus every jar nested in it (META-INF/jarjar, META-INF/jars), recursively."""
    jars = [jar]
    with zipfile.ZipFile(jar) as zf:
        for name in zf.namelist():
            if name.endswith(".jar") and (name.startswith("META-INF/jarjar/") or name.startswith("META-INF/jars/")):
                target = work / f"{len(list(work.iterdir()))}-{Path(name).name}"
                target.write_bytes(zf.read(name))
                jars += expand(target, work)
    return jars


def classes(jar: Path) -> list[str]:
    with zipfile.ZipFile(jar) as zf:
        return [n[:-6] for n in zf.namelist()
                if n.endswith(".class") and not n.startswith("META-INF/") and n != "module-info.class"]


def run_javap(tool: str, jar: Path, names: list[str], flags: list[str]) -> str:
    out = []
    for i in range(0, len(names), 200):
        batch = [n.replace("/", ".") for n in names[i:i + 200]]
        result = subprocess.run([tool, *flags, "-classpath", str(jar), *batch], capture_output=True, text=True)
        out.append(result.stdout)
    return "\n".join(out)


def provided(tool: str, jars: list[Path]) -> tuple[dict[str, set[str]], dict[str, str]]:
    """Class -> member names, and class -> superclass, for every net.neoforged class in the jars."""
    members: dict[str, set[str]] = {}
    supers: dict[str, str] = {}
    for jar in jars:
        names = [n for n in classes(jar) if n.startswith(PREFIX)]
        current = None
        for line in run_javap(tool, jar, names, ["-p"]).splitlines():
            header = HEADER.match(line.replace("final ", "").replace("abstract ", "").replace("sealed ", "")
                                  .replace("non-sealed ", "").replace("static ", ""))
            if line.startswith("Compiled from") or not line.strip() or line == "}":
                continue
            if header and not line.startswith(" "):
                current = header.group(1).replace(".", "/")
                members.setdefault(current, set())
                if header.group(2):
                    supers[current] = header.group(2).replace(".", "/")
                continue
            member = MEMBER.match(line)
            if current and member:
                name = member.group(1) or member.group(2)
                if name == current.split("/")[-1].split("$")[-1]:
                    name = "<init>"
                members[current].add(name)
                if " enum " in f" {line} " or "static final" in line:
                    members[current].add(name)
    return members, supers


def has_member(cls: str, name: str, members: dict[str, set[str]], supers: dict[str, str]) -> bool:
    seen = set()
    while cls and cls not in seen:
        seen.add(cls)
        if name in members.get(cls, ()):
            return True
        cls = supers.get(cls, "")
        if cls and not cls.startswith(PREFIX):
            return True  # inherited from a JDK / Minecraft class; assume it's there
    return False


def main() -> None:
    args = sys.argv[1:]
    show_members = "--members" in args
    args = [a for a in args if a != "--members"]
    if len(args) < 2:
        sys.exit(__doc__)
    tool = javap()
    with tempfile.TemporaryDirectory() as tmp:
        work = Path(tmp)
        sw_dir = work / "steelwool"
        sw_dir.mkdir()
        members, supers = provided(tool, expand(Path(args[0]), sw_dir))

        missing_classes: dict[str, set[str]] = defaultdict(set)
        missing_members: dict[str, set[str]] = defaultdict(set)
        used: dict[str, set[str]] = defaultdict(set)
        for mod in args[1:]:
            mod_dir = work / f"mod-{Path(mod).stem}"
            mod_dir.mkdir()
            for jar in expand(Path(mod), mod_dir):
                own = set(classes(jar))
                text = run_javap(tool, jar, sorted(own), ["-c", "-p"])
                # Types in the signatures of the mod's own fields and methods (such as an event
                # handler's parameter) must exist too, even if the code never names them.
                for line in text.splitlines():
                    if line.startswith("  ") and not line.startswith("   ") and ("(" in line or line.rstrip().endswith(";")):
                        for owner in SIGNATURE_TYPE.findall(line):
                            owner = owner.replace(".", "/")
                            if owner not in own and owner not in members:
                                missing_classes[owner].add(Path(mod).name)
                for kind, owner, name, _desc in REF.findall(text):
                    owner = owner.lstrip("[L").rstrip(";")
                    if not owner.startswith(PREFIX) or owner in own:
                        continue
                    if owner not in members:
                        missing_classes[owner].add(Path(mod).name)
                        if name:
                            used[owner].add(f"{name}{_desc}")
                    elif name and kind != "class" and not has_member(owner, name, members, supers):
                        missing_members[f"{owner}.{name}"].add(Path(mod).name)

    print(f"## Missing classes ({len(missing_classes)})")
    for cls in sorted(missing_classes, key=lambda c: (-len(missing_classes[c]), c)):
        print(f"{cls.replace('/', '.')}  [{', '.join(sorted(missing_classes[cls]))}]")
        if show_members:
            for member in sorted(used[cls]):
                print(f"    {member}")
    print(f"\n## Missing members of classes SteelWool has ({len(missing_members)})")
    for m in sorted(missing_members, key=lambda c: (-len(missing_members[c]), c)):
        print(f"{m.replace('/', '.')}  [{', '.join(sorted(missing_members[m]))}]")


if __name__ == "__main__":
    main()
