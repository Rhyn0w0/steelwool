package dev.steelwool.mixin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.util.List;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Test;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;
import org.objectweb.asm.tree.analysis.Analyzer;
import org.objectweb.asm.tree.analysis.AnalyzerException;
import org.objectweb.asm.tree.analysis.BasicVerifier;

class SteelWoolMixinPluginTest {
	private static final String OWNER = "test/Target";
	private static final String STATE = "test/State";

	/** {@code void handle(State state, Object level, Object pos) { state.clone(level, pos, true); }} */
	private static MethodNode handler() {
		MethodNode method = new MethodNode(Opcodes.ACC_PUBLIC, "handle", "(L" + STATE + ";Ljava/lang/Object;Ljava/lang/Object;)V", null, null);
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 1));
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 2));
		method.instructions.add(new VarInsnNode(Opcodes.ALOAD, 3));
		method.instructions.add(new InsnNode(Opcodes.ICONST_1));
		method.instructions.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, STATE, "clone", "(Ljava/lang/Object;Ljava/lang/Object;Z)Ljava/lang/Object;", false));
		method.instructions.add(new InsnNode(Opcodes.POP));
		method.instructions.add(new InsnNode(Opcodes.RETURN));
		method.maxLocals = 4;
		method.maxStack = 4;
		return method;
	}

	private static List<MethodInsnNode> calls(MethodNode method) {
		return StreamSupport.stream(method.instructions.spliterator(), false)
				.filter(MethodInsnNode.class::isInstance)
				.map(MethodInsnNode.class::cast)
				.toList();
	}

	private static void verify(MethodNode method) throws AnalyzerException {
		new Analyzer<>(new BasicVerifier()).analyze(OWNER, method);
	}

	@Test
	void callRewriteKeepsTheOriginalCallAndAddsTheNewOne() throws AnalyzerException {
		MethodNode method = handler();
		var rewrite = new SteelWoolMixinPlugin.CallRewrite("handle", method.desc, STATE, "clone",
				"(Ljava/lang/Object;Ljava/lang/Object;Z)Ljava/lang/Object;", "clone",
				"(Ljava/lang/Object;Ljava/lang/Object;ZLjava/lang/String;)Ljava/lang/Object;",
				new int[] {1, 0, 2, -1}, "player", "stash", "finish");

		SteelWoolMixinPlugin.rewriteCalls(OWNER, method, rewrite);

		List<String> called = calls(method).stream().map(call -> call.name + call.desc).toList();
		assertEquals(List.of(
				"clone(Ljava/lang/Object;Ljava/lang/Object;Z)Ljava/lang/Object;",
				"stash(Ljava/lang/Object;)V",
				"player(L" + OWNER + ";)Ljava/lang/String;",
				"clone(Ljava/lang/Object;Ljava/lang/Object;ZLjava/lang/String;)Ljava/lang/Object;",
				"finish(Ljava/lang/Object;)Ljava/lang/Object;"), called);
		verify(method);

		// The arguments are kept in new locals 4 (receiver), 5 (level), 6 (pos) and 7 (flag), then
		// loaded for the new call as receiver, pos, level, flag and `this` for the adapter.
		List<Integer> loads = new java.util.ArrayList<>();
		for (AbstractInsnNode insn = calls(method).get(1).getNext(); insn != calls(method).get(2); insn = insn.getNext()) {
			loads.add(((VarInsnNode) insn).var);
		}
		assertEquals(List.of(4, 6, 5, 7, 0), loads);
	}

	@Test
	void unusedCallIsGuardedAndVerifies() throws AnalyzerException {
		MethodNode method = new MethodNode(Opcodes.ACC_PRIVATE | Opcodes.ACC_STATIC, "eject", "(Ljava/lang/Object;Ljava/lang/Object;I)Z", null, null);
		method.instructions.add(new InsnNode(Opcodes.ICONST_0));
		method.instructions.add(new InsnNode(Opcodes.IRETURN));
		method.maxLocals = 3;
		method.maxStack = 1;

		SteelWoolMixinPlugin.addUnusedCall(method, OWNER, "lookup", "(Ljava/lang/Object;Ljava/lang/Object;DLjava/lang/String;)Ljava/lang/Object;");

		assertInstanceOf(JumpInsnNode.class, method.instructions.get(1));
		MethodInsnNode call = calls(method).get(0);
		assertEquals("lookup", call.name);
		verify(method);
	}
}
