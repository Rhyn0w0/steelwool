package dev.steelwool.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

class AccessTransformersTest {
	private static byte[] targetClass() {
		ClassWriter writer = new ClassWriter(0);
		writer.visit(Opcodes.V21, Opcodes.ACC_FINAL, "a/Target", null, "java/lang/Object", null);
		writer.visitField(Opcodes.ACC_PRIVATE | Opcodes.ACC_FINAL | Opcodes.ACC_STATIC, "SIN", "[F", null, null).visitEnd();
		writer.visitField(Opcodes.ACC_PRIVATE, "count", "I", null, null).visitEnd();
		writer.visitMethod(Opcodes.ACC_PRIVATE, "<init>", "(I)V", null, null).visitEnd();
		writer.visitMethod(Opcodes.ACC_PROTECTED, "run", "()V", null, null).visitEnd();
		writer.visitEnd();
		return writer.toByteArray();
	}

	private static List<String> translate(String at, List<String> problems) throws IOException {
		Map<String, byte[]> classes = Map.of("a/Target", targetClass());
		return AccessTransformers.toAccessWidener(AccessTransformers.parse(new StringReader(at)), classes::get, problems);
	}

	@Test
	void parsesLinesAndComments() throws IOException {
		List<AccessTransformers.Entry> entries = AccessTransformers.parse(new StringReader("""
				# a comment
				public-f a.Target$Inner # trailing comment

				protected a.Target run()V
				"""));

		assertEquals(List.of(
				new AccessTransformers.Entry("public", true, "a/Target$Inner", null),
				new AccessTransformers.Entry("protected", false, "a/Target", "run()V")), entries);
	}

	@Test
	void translatesClassesFieldsAndMethods() throws IOException {
		List<String> problems = new ArrayList<>();
		List<String> lines = translate("""
				public-f a.Target
				public-f a.Target SIN
				public a.Target <init>(I)V
				public a.Target run()V
				private a.Target count
				""", problems);

		assertEquals(List.of(
				"accessible class a/Target",
				"extendable class a/Target",
				"accessible field a/Target SIN [F",
				"mutable field a/Target SIN [F",
				"accessible method a/Target <init> (I)V",
				"accessible method a/Target run ()V"), lines);
		assertEquals(List.of(), problems);
	}

	@Test
	void expandsWildcards() throws IOException {
		List<String> lines = translate("public a.Target *\npublic a.Target *()\n", new ArrayList<>());

		assertEquals(List.of(
				"accessible field a/Target SIN [F",
				"accessible field a/Target count I",
				"accessible method a/Target <init> (I)V",
				"accessible method a/Target run ()V"), lines);
	}

	@Test
	void reportsMissingTargets() throws IOException {
		List<String> problems = new ArrayList<>();
		List<String> lines = translate("public a.Missing field\npublic a.Target nope\npublic a.Target nope()V\n", problems);

		assertEquals(List.of(), lines);
		assertEquals(3, problems.size());
	}
}
