package dev.steelwool.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

class AnnotationScannerTest {
	private static final String DIST = "Lnet/neoforged/api/distmarker/Dist;";

	/** Builds a class file carrying a @Mod / @EventBusSubscriber annotation. */
	static byte[] annotatedClass(String name, String annotationDesc, String value, String modid, String distAttribute, String... dists) {
		ClassWriter writer = new ClassWriter(0);
		writer.visit(Opcodes.V21, Opcodes.ACC_PUBLIC, name, null, "java/lang/Object", null);
		AnnotationVisitor av = writer.visitAnnotation(annotationDesc, true);

		if (value != null) {
			av.visit("value", value);
		}

		if (modid != null) {
			av.visit("modid", modid);
		}

		if (distAttribute != null) {
			AnnotationVisitor array = av.visitArray(distAttribute);

			for (String dist : dists) {
				array.visitEnum(null, DIST, dist);
			}

			array.visitEnd();
		}

		av.visitEnd();
		writer.visitEnd();
		return writer.toByteArray();
	}

	@Test
	void findsModClassWithDefaultDists() {
		AnnotationScanner scanner = new AnnotationScanner();
		scanner.scan(annotatedClass("com/example/ExampleMod", AnnotationScanner.MOD_DESC, "examplemod", null, null));

		AnnotationScanResult.ModClass mod = scanner.result().modClasses().getFirst();
		assertEquals("com.example.ExampleMod", mod.className());
		assertEquals("examplemod", mod.modId());
		assertEquals(Set.of("CLIENT", "DEDICATED_SERVER"), mod.dists());
	}

	@Test
	void findsClientOnlyModClass() {
		AnnotationScanner scanner = new AnnotationScanner();
		scanner.scan(annotatedClass("com/example/ExampleModClient", AnnotationScanner.MOD_DESC, "examplemod", null, "dist", "CLIENT"));

		assertEquals(Set.of("CLIENT"), scanner.result().modClasses().getFirst().dists());
	}

	@Test
	void keepsDistWhenDependsArrayFollows() {
		ClassWriter writer = new ClassWriter(0);
		writer.visit(Opcodes.V21, Opcodes.ACC_PUBLIC, "com/example/ClientMod", null, "java/lang/Object", null);
		AnnotationVisitor av = writer.visitAnnotation(AnnotationScanner.MOD_DESC, true);
		av.visit("value", "examplemod");
		AnnotationVisitor dist = av.visitArray("dist");
		dist.visitEnum(null, DIST, "CLIENT");
		dist.visitEnd();
		AnnotationVisitor depends = av.visitArray("depends");
		depends.visit(null, "othermod");
		depends.visitEnd();
		av.visitEnd();
		writer.visitEnd();

		AnnotationScanner scanner = new AnnotationScanner();
		scanner.scan(writer.toByteArray());

		assertEquals(Set.of("CLIENT"), scanner.result().modClasses().getFirst().dists());
	}

	@Test
	void findsEventBusSubscriber() {
		AnnotationScanner scanner = new AnnotationScanner();
		scanner.scan(annotatedClass("com/example/Events", AnnotationScanner.EVENT_BUS_SUBSCRIBER_DESC, null, "examplemod", "value", "DEDICATED_SERVER"));
		scanner.scan(annotatedClass("com/example/Other", AnnotationScanner.EVENT_BUS_SUBSCRIBER_DESC, null, null, null));

		var subscribers = scanner.result().subscriberClasses();
		assertEquals("examplemod", subscribers.get(0).modId());
		assertEquals(Set.of("DEDICATED_SERVER"), subscribers.get(0).dists());
		assertNull(subscribers.get(1).modId());
		assertEquals(AnnotationScanResult.ALL_DISTS, subscribers.get(1).dists());
	}

	@Test
	void ignoresOtherAnnotations() {
		AnnotationScanner scanner = new AnnotationScanner();
		scanner.scan(annotatedClass("com/example/Plain", "Ljava/lang/Deprecated;", null, null, null));

		assertEquals(0, scanner.result().modClasses().size());
		assertEquals(0, scanner.result().subscriberClasses().size());
	}
}
