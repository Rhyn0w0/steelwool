package dev.steelwool.mixin;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

/**
 * Adds the public <em>static</em> methods NeoForge patches into Minecraft classes. Mixin cannot
 * add non-private static methods, so this plugin generates them after the (empty) patch mixin for
 * the class is applied. Each generated method forwards to a static method in
 * {@code dev.steelwool.patch.StaticPatches} with the same descriptor.
 */
public final class SteelWoolMixinPlugin implements IMixinConfigPlugin {
	private static final String FORWARD_OWNER = "dev/steelwool/patch/StaticPatches";

	/** A static method to add: {@code name}/{@code descriptor} on the target, forwarding to {@code forwardTo} in StaticPatches. */
	record StaticMethod(String name, String descriptor, String forwardTo) {
	}

	static final Map<String, List<StaticMethod>> STATIC_METHODS = Map.of(
			"net.minecraft.world.item.CreativeModeTab", List.of(
					new StaticMethod("builder", "()Lnet/minecraft/world/item/CreativeModeTab$Builder;", "creativeModeTabBuilder")));

	@Override
	public void onLoad(String mixinPackage) {
	}

	@Override
	public String getRefMapperConfig() {
		return null;
	}

	@Override
	public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
		return true;
	}

	@Override
	public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
	}

	@Override
	public List<String> getMixins() {
		return null;
	}

	@Override
	public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
	}

	@Override
	public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
		List<StaticMethod> methods = STATIC_METHODS.get(targetClassName);

		if (methods == null) {
			return;
		}

		for (StaticMethod method : methods) {
			boolean exists = targetClass.methods.stream().anyMatch(m -> m.name.equals(method.name()) && m.desc.equals(method.descriptor()));

			if (!exists) {
				targetClass.methods.add(forwarder(method));
			}
		}
	}

	static MethodNode forwarder(StaticMethod method) {
		MethodNode node = new MethodNode(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, method.name(), method.descriptor(), null, null);
		int slot = 0;

		for (Type arg : Type.getArgumentTypes(method.descriptor())) {
			node.instructions.add(new VarInsnNode(arg.getOpcode(Opcodes.ILOAD), slot));
			slot += arg.getSize();
		}

		node.instructions.add(new MethodInsnNode(Opcodes.INVOKESTATIC, FORWARD_OWNER, method.forwardTo(), method.descriptor(), false));
		node.instructions.add(new InsnNode(Type.getReturnType(method.descriptor()).getOpcode(Opcodes.IRETURN)));
		node.maxLocals = slot;
		node.maxStack = Math.max(slot, Type.getReturnType(method.descriptor()).getSize());
		return node;
	}
}
