#!/usr/bin/env python3
"""Tidy Java files written by tools/genapi.py before committing them.

Usage: python3 tools/tidyapi.py <file.java> [<file.java> ...]

For each file it:
- replaces each placeholder `throw new UnsupportedOperationException("SteelWool: TODO")` with one
  that names the member ("SteelWool does not implement Foo.bar yet"),
- adds a class javadoc saying it is SteelWool's re-implementation of the NeoForge class, and
- turns fully qualified type names into imports where the simple name is unambiguous.

Check the result compiles: a simple name can clash with a type the class inherits (for example
`Connection` in a subclass of `ServerPlayer`); qualify those uses again by hand.
"""
import re
import sys
from pathlib import Path

TODO = 'throw new UnsupportedOperationException("SteelWool: TODO");'
DECL = re.compile(r"^(\t*)(?:[\w<>\[\],.? @&]+\s)?(\w+)\s*\([^;{]*\)\s*(?:throws [\w., ]+)?\{\s*$")
TYPE = re.compile(r"^(\t*)(?:public |protected |private |static |final |abstract |sealed |non-sealed )*(?:class|interface|enum|record|@interface) (\w+)")
FQN = re.compile(r"\b((?:net|java|javax|com|org|it|io)\.(?:[a-z_][a-z0-9_]*\.)+)([A-Z]\w*)")


def describe_todos(text: str) -> str:
    stack: list[tuple[int, str]] = []  # (indent, type name) of the enclosing types
    method = None
    out = []
    for line in text.split("\n"):
        t = TYPE.match(line)
        if t and line.rstrip().endswith("{"):
            indent = len(t.group(1))
            stack = [s for s in stack if s[0] < indent] + [(indent, t.group(2))]
        d = DECL.match(line)
        if d and not t:
            method = d.group(2)
        if TODO in line:
            indent = len(line) - len(line.lstrip("\t"))
            owners = [s[1] for s in stack if s[0] < indent]
            owner = ".".join(owners)
            what = f"the {owner} constructor" if method == owners[-1] else f"{owner}.{method}"
            line = line.replace(TODO, f'throw new UnsupportedOperationException("SteelWool does not implement {what} yet");')
        out.append(line)
    return "\n".join(out)


def add_javadoc(text: str) -> str:
    m = re.search(r"^((?:public |final |abstract |sealed |non-sealed )*(?:class|interface|enum|record|@interface) (\w+))", text, re.M)
    if not m or re.search(r"(\*/|^@\w+.*)\s*\n" + re.escape(m.group(1)), text, re.M):
        return text
    doc = ("/**\n * SteelWool re-implementation of NeoForge's {@code " + m.group(2) + "}, with the same API.\n"
           " * Members that throw {@link UnsupportedOperationException} are not implemented yet.\n */\n")
    return text[:m.start()] + doc + text[m.start():]


def use_imports(text: str) -> str:
    pkg = re.search(r"^package ([\w.]+);", text, re.M).group(1)
    head, body = text.split("\n", 1)
    declared = set(re.findall(r"\b(?:class|interface|enum|record) (\w+)", body))
    existing = set(re.findall(r"^import ([\w.]+);", body, re.M))
    uses: dict[str, set[str]] = {}
    for m in FQN.finditer(body):
        uses.setdefault(m.group(2), set()).add(m.group(1)[:-1])
    imports = set()
    replace = {}
    for name, pkgs in uses.items():
        if len(pkgs) != 1 or name in declared:
            continue
        q = next(iter(pkgs))
        if q in ("java.lang", pkg):
            replace[(q, name)] = name
        elif not any(i.endswith("." + name) and i != f"{q}.{name}" for i in existing):
            replace[(q, name)] = name
            imports.add(f"{q}.{name}")
    body = FQN.sub(lambda m: replace.get((m.group(1)[:-1], m.group(2)), m.group(0)), body)
    imports |= existing
    body = re.sub(r"^import [\w.]+;\n", "", body, flags=re.M).lstrip("\n")
    java = sorted(i for i in imports if i.startswith("java."))
    other = sorted(i for i in imports if not i.startswith("java."))
    block = "".join(f"import {i};\n" for i in java) + ("\n" if java else "")
    block += "".join(f"import {i};\n" for i in other) + ("\n" if other else "")
    return head + "\n\n" + block + body


def main() -> None:
    if len(sys.argv) < 2:
        sys.exit(__doc__)
    for arg in sys.argv[1:]:
        path = Path(arg)
        path.write_text(use_imports(add_javadoc(describe_todos(path.read_text()))))


if __name__ == "__main__":
    main()
