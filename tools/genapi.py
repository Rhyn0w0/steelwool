#!/usr/bin/env python3
"""Generate Java source skeletons for NeoForge API classes from their bytecode.

Usage: python3 tools/genapi.py <neoforge-universal.jar> <out-src-dir> <fqcn> [<fqcn> ...]

Trivial members (field getters/setters, constructors that only call super/this and assign
parameters or constants to fields, super delegates) get real bodies. Everything else gets a body
that throws and is listed on stderr as TODO, to be written by hand.
"""
import os
import re
import subprocess
import sys
import zipfile

JAVAP = os.path.join(os.environ.get("JAVA_HOME", "/opt/homebrew/opt/openjdk@25"), "bin", "javap")
PRIMS = {"Z": "boolean", "B": "byte", "C": "char", "S": "short", "I": "int", "J": "long", "F": "float", "D": "double", "V": "void"}
TODO = []


def javap(jar, names):
    out = subprocess.run([JAVAP, "-v", "-p", "-c", "-classpath", jar, *names], capture_output=True, text=True).stdout
    return out


def src_type(t):
    # javap prints nested types with '$'; source needs '.'. Keep generics intact.
    return re.sub(r"(?<=[\w>])\$(?=[A-Za-z_])", ".", t)


def split_classes(text):
    blocks = re.split(r"\n(?=Classfile )", text)
    return [b for b in blocks if b.startswith("Classfile")]


class Method:
    def __init__(self):
        self.decl = ""
        self.flags = ""
        self.code = []
        self.descriptor = ""
        self.constant = None


def parse_class(block):
    lines = block.split("\n")
    header = None
    for i, l in enumerate(lines):
        if re.match(r"^(public |protected |private |final |abstract |static |sealed |non-sealed )*(class|interface|enum|@interface|record) ", l.replace("abstract class", "abstract class")) and "Compiled from" not in l:
            header = l.strip()
            hi = i
            break
    flags_line = next((l for l in lines[hi:hi + 12] if l.strip().startswith("flags:")), "")
    # members start after the constant pool, at the line "{"
    start = lines.index("{", hi)
    members = []
    cur = None
    in_code = False
    for l in lines[start + 1:]:
        if l == "}":
            break
        if l.startswith("  ") and not l.startswith("    ") and l.strip():
            cur = Method()
            cur.decl = l.strip()
            members.append(cur)
            in_code = False
            continue
        if cur is None:
            continue
        s = l.strip()
        if s.startswith("descriptor:"):
            cur.descriptor = s.split(":", 1)[1].strip()
        elif s.startswith("flags:"):
            cur.flags = s
        elif s.startswith("ConstantValue:"):
            cur.constant = s.split(":", 1)[1].strip()
        elif s == "Code:":
            in_code = True
        elif in_code:
            m = re.match(r"^\d+: (\w+)\s*(.*)$", s)
            if m:
                cur.code.append((m.group(1), m.group(2)))
            elif s.startswith(("LineNumberTable", "LocalVariableTable", "StackMapTable", "Exception table", "RuntimeVisible", "Signature", "MethodParameters", "RuntimeInvisible")):
                in_code = False
    inner = []
    m = re.search(r"InnerClasses:\n((?:\s+.*\n)+?)(?:\S|\Z)", block + "\nX")
    if m:
        inner = m.group(1).split("\n")
    return header, flags_line, members, inner


def load_index(ins):
    op, arg = ins
    m = re.match(r"^[ailfd]load(?:_(\d)|$)", op)
    if not m:
        return None
    return int(m.group(1)) if m.group(1) is not None else int(arg.split()[0])


def const_value(ins):
    op, arg = ins
    if op == "iconst_m1":
        return "-1"
    if op.startswith("iconst_"):
        return op[7:]
    if op in ("bipush", "sipush"):
        return arg.split()[0]
    if op == "aconst_null":
        return "null"
    if op in ("lconst_0", "lconst_1"):
        return op[-1] + "L"
    if op in ("fconst_0", "fconst_1", "fconst_2"):
        return op[-1] + "f"
    if op in ("dconst_0", "dconst_1"):
        return op[-1] + ".0"
    if op in ("ldc", "ldc_w", "ldc2_w"):
        m = re.search(r"// (String|int|float|long|double) (.*)$", arg)
        if m:
            kind, v = m.groups()
            if kind == "String":
                return '"' + v.replace("\\", "\\\\").replace('"', '\\"') + '"'
            return v + {"float": "f", "long": "L", "double": "", "int": ""}[kind]
    return None


def param_types(decl):
    m = re.search(r"\((.*)\)", decl)
    if not m or not m.group(1).strip():
        return []
    depth, cur, out = 0, "", []
    for ch in m.group(1):
        if ch == "<":
            depth += 1
        elif ch == ">":
            depth -= 1
        if ch == "," and depth == 0:
            out.append(cur.strip())
            cur = ""
        else:
            cur += ch
    out.append(cur.strip())
    return out


def slot_map(params, static):
    slots, s = {}, 0 if static else 1
    for i, p in enumerate(params):
        slots[s] = i
        s += 2 if p in ("long", "double") else 1
    return slots


def desc_defaults(desc):
    """Default argument expressions for a method descriptor's parameters."""
    params = desc[desc.index("(") + 1:desc.index(")")]
    out, i = [], 0
    while i < len(params):
        dims = 0
        while params[i] == "[":
            dims += 1
            i += 1
        if params[i] == "L":
            end = params.index(";", i)
            t = params[i + 1:end].replace("/", ".").replace("$", ".")
            i = end + 1
        else:
            t = PRIMS[params[i]]
            i += 1
        if dims:
            out.append(f"({t}{'[]' * dims}) null")
        elif t == "boolean":
            out.append("false")
        elif t in PRIMS.values():
            out.append(f"({t}) 0")
        else:
            out.append(f"({t}) null")
    return out


def todo_ctor(method):
    if getattr(method, "is_enum", False):
        return []
    for op, arg in method.code:
        if op == "invokespecial" and "<init>" in arg:
            m = re.search(r'Method (?:([\w/$]+)\.)?"<init>":(\([^)]*\)V)', arg)
            if m and (m.group(1) or method.owner) in (method.owner, method.super_owner):
                target = "this" if (m.group(1) or method.owner) == method.owner else "super"
                return [f"{target}({', '.join(desc_defaults(m.group(2)))});"]
    return []


def body_for(method, cls_short, field_names, params, static, field_types=None):
    field_types = field_types or {}
    code = [c for c in method.code if c[0] != "nop"]
    slots = slot_map(params, static)
    names = [f"arg{i}" for i in range(len(params))]
    is_ctor = method.decl.split("(")[0].split()[-1].endswith(cls_short) and "(" in method.decl and " " + "void" not in method.decl.split("(")[0]
    stmts = []
    i = 0

    def fieldname(arg):
        m = re.search(r"// Field (?:[\w/$]+\.)?(\w+):", arg)
        return m.group(1) if m else None

    # constructor
    if method.is_ctor:
        while i < len(code):
            op, arg = code[i]
            if op == "aload_0" and i + 1 < len(code):
                # gather loads until invokespecial or putfield
                j = i + 1
                loads = []
                while j < len(code) and (load_index(code[j]) is not None or const_value(code[j]) is not None):
                    li = load_index(code[j])
                    loads.append(f"@@{slots[li]}@@" if li is not None and li in slots else const_value(code[j]))
                    j += 1
                if None in loads:
                    return None, names
                if j < len(code) and code[j][0] == "invokespecial" and "<init>" in code[j][1]:
                    callee = code[j][1].split("Method ")[1]
                    target = "this" if callee.startswith('"<init>"') or callee.startswith(method.owner + ".") else "super"
                    stmts.append(f"{target}({', '.join(loads)});")
                    i = j + 1
                    continue
                if j < len(code) and code[j][0] == "putfield" and len(loads) == 1:
                    f = fieldname(code[j][1])
                    if f:
                        li = load_index(code[j - 1])
                        if li is not None and li in slots and names[slots[li]].startswith("arg"):
                            names[slots[li]] = f
                        val = loads[0]
                        if field_types.get(f) == "boolean" and val in ("0", "1"):
                            val = "false" if val == "0" else "true"
                        stmts.append(f"this.{f} = {val};")
                        i = j + 1
                        continue
                return None, names
            if op == "return":
                i += 1
                continue
            return None, names
        stmts = [re.sub(r"@@(\d+)@@", lambda mm: names[int(mm.group(1))], st) for st in stmts]
        return stmts, names

    # getter / setter / delegate
    ops = [c[0] for c in code]
    if len(code) >= 3 and ops[0] == "aload_0" and ops[1] == "getfield" and ops[-1].endswith("return") and (len(code) == 3 or (len(code) == 4 and ops[2] == "checkcast")):
        f = fieldname(code[1][1])
        cast = ""
        if len(code) == 4:
            cast = "(" + src_type(code[2][1].split("// class ")[1].replace("/", ".")) + ") "
        return [f"return {cast}this.{f};"], names
    if len(code) == 4 and ops[0] == "aload_0" and load_index(code[1]) == 1 and ops[2] == "putfield" and ops[3] == "return":
        f = fieldname(code[2][1])
        names[0] = f
        return [f"this.{f} = {f};"], names
    if ops and ops[0] == "aload_0" and "invokespecial" in ops:
        j = ops.index("invokespecial")
        loads = code[1:j]
        if all(load_index(c) is not None for c in loads):
            m = re.search(r"Method ([\w/$]+)\.(\w+):", code[j][1]) or re.search(r"InterfaceMethod ([\w/$]+)\.(\w+):", code[j][1])
            if m:
                owner, name = m.groups()
                rest = ops[j + 1:]
                args = ", ".join(names[slots[load_index(c)]] for c in loads)
                qual = "super"
                if "InterfaceMethod" in code[j][1]:
                    qual = src_type(owner.replace("/", ".")) + ".super"
                if rest == ["return"]:
                    return [f"{qual}.{name}({args});"], names
                if rest and rest[-1].endswith("return") and (len(rest) == 1 or (len(rest) == 2 and rest[0] == "checkcast")):
                    cast = ""
                    if len(rest) == 2:
                        cast = "(" + src_type(code[j + 1][1].split("// class ")[1].replace("/", ".")) + ") "
                    return [f"return {cast}{qual}.{name}({args});"], names
    return None, names


def render_class(jar, fqcn, all_texts, indent, nested=False):
    block = all_texts[fqcn]
    header, cflags, members, inner = parse_class(block)
    short = fqcn.split(".")[-1].split("$")[-1]
    owner_internal = fqcn.replace(".", "/")
    is_enum = "ACC_ENUM" in cflags
    is_interface = "ACC_INTERFACE" in cflags
    is_record = "extends java.lang.Record" in header
    pad = "\t" * indent
    out = []

    # header
    h = header.rstrip(" {").strip()
    h = h.replace(fqcn, short)
    h = src_type(h)
    if nested and not is_interface and not is_enum and " static " not in f" {h} ":
        h = re.sub(r"^((?:public |protected |private )?)", r"\1static ", h, count=1)
    if is_enum:
        h = re.sub(r"\s*extends java\.lang\.Enum<[^>]*>", "", h).replace("final enum", "enum").replace("final class", "enum").replace(" class ", " enum ")
        h = re.sub(r"^((?:public |protected |private )?)(?:static )?(?:final )?(?:class|enum)", r"\1enum", h)
        if nested:
            h = h.replace("static ", "")
    if is_interface:
        h = h.replace("abstract interface", "interface")
    if is_record:
        comps = []
        for mm in members:
            dd = mm.decl.rstrip(";")
            if "(" not in dd and " static " not in f" {dd} " and not dd.startswith("static {}"):
                comps.append(src_type(" ".join(dd.split()[-2:])))
        h = re.sub(r"\s*extends java\.lang\.Record", "", h)
        h = re.sub(r"(?:final )?class " + re.escape(short) + r"(<[^{]*?>)?", lambda mm: "record " + short + (mm.group(1) or "") + "(" + ", ".join(comps) + ")", h, count=1)
        h = h.replace("static final record", "static record").replace("final record", "record")
    out.append(pad + h + " {")

    fields = []
    enum_consts = []
    methods = []
    for m in members:
        d = m.decl.rstrip(";")
        if d.startswith("static {}"):
            TODO.append(f"{fqcn}: static initializer")
            continue
        if "(" not in d:
            if is_enum and "ACC_ENUM" in m.flags:
                enum_consts.append(d.split()[-1])
            elif "ACC_SYNTHETIC" in m.flags:
                continue
            elif is_record and "ACC_STATIC" not in m.flags:
                continue
            else:
                fields.append(m)
        else:
            if "ACC_SYNTHETIC" in m.flags or "ACC_BRIDGE" in m.flags:
                continue
            methods.append(m)

    if is_enum:
        out.append(pad + "\t" + ", ".join(enum_consts) + ";")
        out.append("")

    field_names = []
    field_types = {}
    record_fields = [src_type(mm.decl.rstrip(";")).split()[-1] for mm in members if is_record and "(" not in mm.decl and "ACC_STATIC" not in mm.flags]
    for f in fields:
        d = src_type(f.decl.rstrip(";"))
        field_names.append(d.split()[-1])
        field_types[d.split()[-1]] = d.split()[-2]
        init = ""
        if " static " in f" {d} " and " final " in f" {d} ":
            t = d.split()[-2]
            if f.constant:
                kind, _, v = f.constant.partition(" ")
                if kind == "String":
                    v = '"' + v.replace("\\", "\\\\").replace('"', '\\"') + '"'
                elif kind == "long":
                    v += "L"
                elif kind == "float":
                    v += "f"
                elif t == "boolean":
                    v = "true" if v == "1" else "false"
                init = " = " + v
            else:
                init = " = " + ("false" if t == "boolean" else "0" if t in PRIMS.values() else "null") + " /* SteelWool: TODO */"
        out.append(pad + "\t" + d + init + ";")
    if fields:
        out.append("")

    for m in methods:
        d = m.decl.rstrip(";")
        name_part = d.split("(")[0].split()[-1]
        m.owner = owner_internal
        m.is_enum = is_enum
        sm = re.search(r"extends ([\w.$]+)", header)
        m.super_owner = sm.group(1).replace(".", "/") if sm else "java/lang/Object"
        m.is_ctor = name_part == fqcn or name_part == fqcn.replace("$", ".")
        if name_part == "static {}" or d.startswith("static {}"):
            continue
        static = " static " in f" {d.split('(')[0]} "
        if is_enum and name_part.split(".")[-1] in ("values", "valueOf") and static:
            continue
        params = [src_type(p) for p in param_types(d)]
        abstract = "ACC_ABSTRACT" in m.flags
        simple = name_part.split(".")[-1]
        if is_record and ((m.is_ctor and len(params) == len(record_fields)) or (simple in record_fields and not params) or simple in ("toString", "hashCode", "equals")):
            continue
        if is_enum and m.is_ctor and [c[0] for c in m.code] == ["aload_0", "aload_1", "iload_2", "invokespecial", "return"]:
            continue
        mods_ret = d.split("(")[0]
        if m.is_ctor:
            mods_ret = mods_ret.replace(name_part, short)
            if is_enum:
                mods_ret = re.sub(r"^(private |public |protected )", "", mods_ret)
        else:
            mods_ret = src_type(mods_ret)
        throws = ""
        if ") throws " in d:
            throws = " throws " + src_type(d.split(") throws ")[1])
        if is_interface:
            mods_ret = mods_ret.replace("public abstract ", "").replace("public ", "").replace("abstract ", "")
            if not abstract and not static and "default " not in mods_ret:
                mods_ret = "default " + mods_ret
        varargs = "ACC_VARARGS" in m.flags
        if abstract:
            names = [f"arg{i}" for i in range(len(params))]
            ps = ", ".join(f"{t} {n}" for t, n in zip(params, names))
            if varargs:
                ps = re.sub(r"\[\] (\w+)$", r"... \1", ps)
            out.append(pad + "\t" + f"{mods_ret}({ps}){throws};")
            out.append("")
            continue
        stmts, names = body_for(m, short, field_names, params, static, field_types)
        ps = ", ".join(f"{t} {n}" for t, n in zip(params, names))
        if varargs:
            ps = re.sub(r"\[\] (\w+)$", r"... \1", ps)
        if stmts is None:
            TODO.append(f"{fqcn}: {d}")
            stmts = (todo_ctor(m) if m.is_ctor else []) + ['throw new UnsupportedOperationException("SteelWool: TODO");']
        out.append(pad + "\t" + f"{mods_ret}({ps}){throws} {{")
        for s in stmts:
            out.append(pad + "\t\t" + s)
        out.append(pad + "\t}")
        out.append("")

    # nested classes
    prefix = fqcn + "$"
    for other in sorted(all_texts):
        if other.startswith(prefix) and "$" not in other[len(prefix):] and not re.match(r"^\d", other[len(prefix):]):
            out += render_class(jar, other, all_texts, indent + 1, nested=True)
            out.append("")
    while out and out[-1] == "":
        out.pop()
    out.append(pad + "}")
    return out


def main():
    jar, outdir, *classes = sys.argv[1:]
    with zipfile.ZipFile(jar) as zf:
        entries = [n[:-6].replace("/", ".") for n in zf.namelist() if n.endswith(".class")]
    for fqcn in classes:
        family = [e for e in entries if e == fqcn or e.startswith(fqcn + "$")]
        text = javap(jar, family)
        texts = {}
        for b in split_classes(text):
            for e in family:
                hdr = parse_class(b)[0]
                if hdr and re.search(r"(class|interface|enum|record) " + re.escape(e) + r"(\b|<|$)", hdr):
                    texts[e] = b
        if fqcn not in texts:
            print(f"!! could not read {fqcn}", file=sys.stderr)
            continue
        pkg = fqcn.rsplit(".", 1)[0]
        try:
            body = render_class(jar, fqcn, texts, 0)
        except Exception as e:
            print(f"!! failed {fqcn}: {e!r}", file=sys.stderr)
            continue
        path = os.path.join(outdir, *fqcn.split(".")) + ".java"
        os.makedirs(os.path.dirname(path), exist_ok=True)
        with open(path, "w") as f:
            f.write(f"package {pkg};\n\n" + "\n".join(body) + "\n")
        print(path)
    for t in TODO:
        print("TODO " + t, file=sys.stderr)


if __name__ == "__main__":
    main()
