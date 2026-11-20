package dev.steelwool.discovery;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import org.jspecify.annotations.Nullable;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

/**
 * Reads class files with ASM, without loading them (the same thing FML's scanner does). It finds
 * {@code @Mod} and {@code @EventBusSubscriber} classes and records every class, method and field
 * annotation, which mods read back through {@code ModList.getAllScanData()} to find their plugins.
 */
public final class AnnotationScanner {
	static final String MOD_DESC = "Lnet/neoforged/fml/common/Mod;";
	static final String EVENT_BUS_SUBSCRIBER_DESC = "Lnet/neoforged/fml/common/EventBusSubscriber;";

	private final List<AnnotationScanResult.ModClass> modClasses = new ArrayList<>();
	private final List<AnnotationScanResult.SubscriberClass> subscriberClasses = new ArrayList<>();
	private final List<AnnotationScanResult.ClassInfo> classes = new ArrayList<>();
	private final List<AnnotationScanResult.Annotation> annotations = new ArrayList<>();

	public void scan(InputStream classFile) throws IOException {
		scan(classFile.readAllBytes());
	}

	public void scan(byte[] classFile) {
		new ClassReader(classFile).accept(new Visitor(), ClassReader.SKIP_CODE | ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
	}

	public AnnotationScanResult result() {
		return new AnnotationScanResult(modClasses, subscriberClasses, classes, annotations);
	}

	private final class Visitor extends ClassVisitor {
		private String internalName = "";
		private String className = "";

		Visitor() {
			super(Opcodes.ASM9);
		}

		@Override
		public void visit(int version, int access, String name, String signature, @Nullable String superName, String @Nullable [] interfaces) {
			internalName = name;
			className = name.replace('/', '.');
			classes.add(new AnnotationScanResult.ClassInfo(name, superName, interfaces == null ? List.of() : List.of(interfaces)));
		}

		@Override
		public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
			return new Collector(c -> {
				annotations.add(new AnnotationScanResult.Annotation(descriptor, "TYPE", internalName, className, c.values));

				switch (descriptor) {
					case MOD_DESC -> {
						if (!(c.values.get("value") instanceof String modId)) {
							throw new IllegalStateException("@Mod on " + className + " has no mod id");
						}

						modClasses.add(new AnnotationScanResult.ModClass(className, modId, c.distsOrAll("dist")));
					}
					case EVENT_BUS_SUBSCRIBER_DESC -> {
						String modid = c.values.get("modid") instanceof String s && !s.isEmpty() ? s : null;
						subscriberClasses.add(new AnnotationScanResult.SubscriberClass(className, modid, c.distsOrAll("value")));
					}
					default -> {
					}
				}
			});
		}

		@Override
		public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
			return new FieldVisitor(Opcodes.ASM9) {
				@Override
				public AnnotationVisitor visitAnnotation(String annotation, boolean visible) {
					return new Collector(c -> annotations.add(new AnnotationScanResult.Annotation(annotation, "FIELD", internalName, name, c.values)));
				}
			};
		}

		@Override
		public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
			return new MethodVisitor(Opcodes.ASM9) {
				@Override
				public AnnotationVisitor visitAnnotation(String annotation, boolean visible) {
					return new Collector(c -> annotations.add(new AnnotationScanResult.Annotation(annotation, "METHOD", internalName, name + descriptor, c.values)));
				}
			};
		}
	}

	/**
	 * Collects an annotation's attributes the way FML does: enums as {@link AnnotationScanResult.EnumValue},
	 * classes as ASM {@link Type}s, arrays as lists and nested annotations as maps.
	 */
	private static final class Collector extends AnnotationVisitor {
		private final Consumer<Collector> onEnd;
		final Map<String, Object> values = new LinkedHashMap<>();

		Collector(Consumer<Collector> onEnd) {
			super(Opcodes.ASM9);
			this.onEnd = onEnd;
		}

		@Override
		public void visit(String name, Object value) {
			values.put(name, value);
		}

		@Override
		public void visitEnum(String name, String descriptor, String value) {
			values.put(name, new AnnotationScanResult.EnumValue(descriptor, value));
		}

		@Override
		public AnnotationVisitor visitAnnotation(String name, String descriptor) {
			return new Collector(c -> values.put(name, c.values));
		}

		@Override
		public AnnotationVisitor visitArray(String name) {
			List<Object> list = new ArrayList<>();
			values.put(name, list);
			return new AnnotationVisitor(Opcodes.ASM9) {
				@Override
				public void visit(String unused, Object value) {
					list.add(value);
				}

				@Override
				public void visitEnum(String unused, String descriptor, String value) {
					list.add(new AnnotationScanResult.EnumValue(descriptor, value));
				}

				@Override
				public AnnotationVisitor visitAnnotation(String unused, String descriptor) {
					return new Collector(c -> list.add(c.values));
				}
			};
		}

		/** The {@code Dist} names in an enum array attribute, or all of them if it is absent. */
		Set<String> distsOrAll(String attribute) {
			if (!(values.get(attribute) instanceof List<?> list)) {
				return AnnotationScanResult.ALL_DISTS;
			}

			return Set.copyOf(list.stream()
					.filter(AnnotationScanResult.EnumValue.class::isInstance)
					.map(e -> ((AnnotationScanResult.EnumValue) e).value())
					.toList());
		}

		@Override
		public void visitEnd() {
			onEnd.accept(this);
		}
	}
}
