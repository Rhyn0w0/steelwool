package dev.steelwool.discovery;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Finds {@code @Mod} and {@code @EventBusSubscriber} classes by reading class files with ASM,
 * without loading them (the same thing FML's scanner does).
 */
public final class AnnotationScanner {
	static final String MOD_DESC = "Lnet/neoforged/fml/common/Mod;";
	static final String EVENT_BUS_SUBSCRIBER_DESC = "Lnet/neoforged/fml/common/EventBusSubscriber;";

	private final List<AnnotationScanResult.ModClass> modClasses = new ArrayList<>();
	private final List<AnnotationScanResult.SubscriberClass> subscriberClasses = new ArrayList<>();

	public void scan(InputStream classFile) throws IOException {
		scan(classFile.readAllBytes());
	}

	public void scan(byte[] classFile) {
		new ClassReader(classFile).accept(new Visitor(), ClassReader.SKIP_CODE | ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
	}

	public AnnotationScanResult result() {
		return new AnnotationScanResult(modClasses, subscriberClasses);
	}

	private final class Visitor extends ClassVisitor {
		private String className = "";

		Visitor() {
			super(Opcodes.ASM9);
		}

		@Override
		public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
			className = name.replace('/', '.');
		}

		@Override
		public @Nullable AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
			return switch (descriptor) {
				case MOD_DESC -> new Collector(c -> {
					if (c.value == null) {
						throw new IllegalStateException("@Mod on " + className + " has no mod id");
					}

					modClasses.add(new AnnotationScanResult.ModClass(className, c.value, c.distsOrAll("dist")));
				});
				case EVENT_BUS_SUBSCRIBER_DESC -> new Collector(c ->
						subscriberClasses.add(new AnnotationScanResult.SubscriberClass(className, c.modid, c.distsOrAll("value"))));
				default -> null;
			};
		}
	}

	/** Collects the attributes of a {@code @Mod} or {@code @EventBusSubscriber} annotation. */
	private static final class Collector extends AnnotationVisitor {
		private final java.util.function.Consumer<Collector> onEnd;
		private @Nullable String value;
		private @Nullable String modid;
		/** Enum values per array attribute (only {@code Dist} arrays carry enums). */
		private final java.util.Map<String, Set<String>> enumArrays = new java.util.HashMap<>();

		Collector(java.util.function.Consumer<Collector> onEnd) {
			super(Opcodes.ASM9);
			this.onEnd = onEnd;
		}

		@Override
		public void visit(String name, Object value) {
			if ("value".equals(name) && value instanceof String s) {
				this.value = s;
			} else if ("modid".equals(name) && value instanceof String s) {
				this.modid = s.isEmpty() ? null : s;
			}
		}

		@Override
		public AnnotationVisitor visitArray(String name) {
			Set<String> values = new HashSet<>();
			enumArrays.put(name, values);
			return new AnnotationVisitor(Opcodes.ASM9) {
				@Override
				public void visitEnum(String unused, String descriptor, String value) {
					values.add(value);
				}
			};
		}

		Set<String> distsOrAll(String attribute) {
			Set<String> dists = enumArrays.get(attribute);
			return dists == null ? AnnotationScanResult.ALL_DISTS : Set.copyOf(dists);
		}

		@Override
		public void visitEnd() {
			onEnd.accept(this);
		}
	}
}
