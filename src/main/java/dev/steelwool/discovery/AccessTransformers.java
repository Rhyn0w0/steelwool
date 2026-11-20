package dev.steelwool.discovery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Function;

import org.jspecify.annotations.Nullable;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Reads NeoForge access transformer files ({@code META-INF/accesstransformer.cfg}) and translates them
 * to Fabric access widener ({@code accessWidener v2}) lines.
 *
 * <p>Access widener has no "protected" and cannot narrow access, so {@code protected} becomes
 * {@code accessible}, and {@code private} / {@code default} entries and {@code +f} are ignored. Access
 * transformers name fields without their type, so field descriptors are read from the target class.
 */
public final class AccessTransformers {
	private AccessTransformers() {
	}

	/**
	 * One access transformer line.
	 *
	 * @param access       {@code public}, {@code protected}, {@code default} or {@code private}
	 * @param removeFinal  {@code true} for {@code -f}
	 * @param className    internal name (slashes)
	 * @param member       {@code null} for the class itself, a field name, {@code *} (all fields), a method name
	 *                     plus descriptor, or {@code *()} (all methods)
	 */
	public record Entry(String access, boolean removeFinal, String className, @Nullable String member) {
	}

	public static List<Entry> parse(Reader reader) throws IOException {
		List<Entry> entries = new ArrayList<>();
		BufferedReader lines = reader instanceof BufferedReader b ? b : new BufferedReader(reader);
		String line;

		while ((line = lines.readLine()) != null) {
			int comment = line.indexOf('#');

			if (comment >= 0) {
				line = line.substring(0, comment);
			}

			String[] parts = line.trim().split("\\s+");

			if (parts.length < 2 || parts[0].isEmpty()) {
				continue;
			}

			String modifier = parts[0].toLowerCase(Locale.ROOT);
			boolean removeFinal = modifier.endsWith("-f");
			String access = modifier.replaceAll("[-+]f$", "");
			String className = parts[1].replace('.', '/');
			String member = parts.length > 2 ? parts[2] : null;
			entries.add(new Entry(access, removeFinal, className, member));
		}

		return entries;
	}

	/**
	 * Translates entries to access widener lines (without the header).
	 *
	 * @param classBytes the class file for an internal name, or {@code null} if there is no such class
	 * @param problems   receives a message for each entry that could not be translated
	 */
	public static List<String> toAccessWidener(List<Entry> entries, Function<String, byte @Nullable []> classBytes, List<String> problems) {
		Set<String> lines = new LinkedHashSet<>();

		for (Entry entry : entries) {
			boolean widen = entry.access().equals("public") || entry.access().equals("protected");

			if (!widen && !entry.removeFinal()) {
				continue;
			}

			if (entry.member() == null) {
				if (widen) {
					lines.add("accessible class " + entry.className());
				}

				if (entry.removeFinal()) {
					lines.add("extendable class " + entry.className());
				}

				continue;
			}

			byte[] bytes = classBytes.apply(entry.className());

			if (bytes == null) {
				problems.add("class " + entry.className() + " not found");
				continue;
			}

			Members members = Members.read(bytes);
			String member = entry.member();
			int paren = member.indexOf('(');

			if (paren < 0) {
				List<String[]> fields = member.equals("*") ? members.fields : members.fields.stream().filter(f -> f[0].equals(member)).toList();

				if (fields.isEmpty()) {
					problems.add("field " + entry.className() + "." + member + " not found");
				}

				for (String[] field : fields) {
					String target = entry.className() + " " + field[0] + " " + field[1];

					if (widen) {
						lines.add("accessible field " + target);
					}

					if (entry.removeFinal()) {
						lines.add("mutable field " + target);
					}
				}
			} else {
				String name = member.substring(0, paren);
				String descriptor = member.substring(paren);
				List<String[]> methods = name.equals("*")
						? members.methods.stream().filter(m -> !m[0].equals("<clinit>")).toList()
						: members.methods.stream().filter(m -> m[0].equals(name) && m[1].equals(descriptor)).toList();

				if (methods.isEmpty()) {
					problems.add("method " + entry.className() + "." + member + " not found");
				}

				for (String[] method : methods) {
					String target = entry.className() + " " + method[0] + " " + method[1];

					if (widen) {
						lines.add("accessible method " + target);
					}

					// An access widener makes a private method it opens up final, but an access transformer
					// leaves it overridable, and NeoForge code overrides such methods.
					int access = Integer.parseInt(method[2]);
					boolean opensPrivate = widen && (access & (Opcodes.ACC_PRIVATE | Opcodes.ACC_STATIC)) == Opcodes.ACC_PRIVATE;

					if ((entry.removeFinal() || opensPrivate) && !method[0].equals("<init>")) {
						lines.add("extendable method " + target);
					}
				}
			}
		}

		return new ArrayList<>(lines);
	}

	/** Field and method names with descriptors, as {@code [name, descriptor]} pairs. */
	private record Members(List<String[]> fields, List<String[]> methods) {
		static Members read(byte[] bytes) {
			Members members = new Members(new ArrayList<>(), new ArrayList<>());
			new ClassReader(bytes).accept(new ClassVisitor(Opcodes.ASM9) {
				@Override
				public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
					members.fields.add(new String[] {name, descriptor});
					return null;
				}

				@Override
				public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
					members.methods.add(new String[] {name, descriptor, String.valueOf(access)});
					return null;
				}
			}, ClassReader.SKIP_CODE | ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
			return members;
		}
	}
}
