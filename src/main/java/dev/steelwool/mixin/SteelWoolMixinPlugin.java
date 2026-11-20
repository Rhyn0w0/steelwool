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
 * Adds the public <em>static</em> methods and the constructors NeoForge patches into Minecraft
 * classes. Mixin cannot add either, so this plugin generates them after a patch mixin for the class
 * is applied:
 * <ul>
 * <li>each static method forwards to a static method in {@code dev.steelwool.patch.StaticPatches}
 * with the same descriptor;
 * <li>each constructor passes its first {@code kept} arguments to an existing constructor as they
 * are, and turns the rest into one more argument with an adapter method in {@code StaticPatches}.
 * </ul>
 */
public final class SteelWoolMixinPlugin implements IMixinConfigPlugin {
	private static final String FORWARD_OWNER = "dev/steelwool/patch/StaticPatches";

	/** A static method to add: {@code name}/{@code descriptor} on the target, forwarding to {@code forwardTo} in StaticPatches. */
	record StaticMethod(String name, String descriptor, String forwardTo) {
	}

	/**
	 * A constructor to add: {@code descriptor} calls the existing constructor {@code target} with its
	 * first {@code kept} arguments plus {@code adapter(remaining arguments)} from StaticPatches.
	 */
	record Constructor(String descriptor, int kept, String adapter, String target) {
	}

	static final Map<String, List<StaticMethod>> STATIC_METHODS = Map.of(
			"net.minecraft.world.item.CreativeModeTab", List.of(
					new StaticMethod("builder", "()Lnet/minecraft/world/item/CreativeModeTab$Builder;", "creativeModeTabBuilder")),
			"net.minecraft.commands.synchronization.ArgumentTypeInfos", List.of(
					new StaticMethod("registerByClass", "(Ljava/lang/Class;Lnet/minecraft/commands/synchronization/ArgumentTypeInfo;)Lnet/minecraft/commands/synchronization/ArgumentTypeInfo;", "argumentTypeInfosRegisterByClass")));

	private static final String BLOCK_ENTITY_SUPPLIER = "Lnet/minecraft/world/level/block/entity/BlockEntityType$BlockEntitySupplier;";

	static final Map<String, List<Constructor>> CONSTRUCTORS = Map.of(
			"net.minecraft.world.level.block.entity.BlockEntityType", List.of(
					new Constructor("(" + BLOCK_ENTITY_SUPPLIER + "[Lnet/minecraft/world/level/block/Block;)V", 1, "blockEntityTypeBlocks", "(" + BLOCK_ENTITY_SUPPLIER + "Ljava/util/Set;)V"),
					new Constructor("(" + BLOCK_ENTITY_SUPPLIER + "Z[Lnet/minecraft/world/level/block/Block;)V", 1, "blockEntityTypeBlocks", "(" + BLOCK_ENTITY_SUPPLIER + "Ljava/util/Set;)V"),
					new Constructor("(" + BLOCK_ENTITY_SUPPLIER + "Ljava/util/Set;Z)V", 1, "blockEntityTypeBlocks", "(" + BLOCK_ENTITY_SUPPLIER + "Ljava/util/Set;)V")),
			"net.minecraft.world.level.saveddata.SavedDataType", List.of(
					new Constructor("(Lnet/minecraft/resources/Identifier;Ljava/util/function/Supplier;Lcom/mojang/serialization/Codec;)V", 3, "noDataFixType",
							"(Lnet/minecraft/resources/Identifier;Ljava/util/function/Supplier;Lcom/mojang/serialization/Codec;Lnet/minecraft/util/datafix/DataFixTypes;)V")));

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
		for (StaticMethod method : STATIC_METHODS.getOrDefault(targetClassName, List.of())) {
			if (!hasMethod(targetClass, method.name(), method.descriptor())) {
				targetClass.methods.add(forwarder(method));
			}
		}

		for (Constructor constructor : CONSTRUCTORS.getOrDefault(targetClassName, List.of())) {
			if (!hasMethod(targetClass, "<init>", constructor.descriptor())) {
				targetClass.methods.add(constructor(targetClass.name, constructor));
			}
		}
	}

	private static boolean hasMethod(ClassNode targetClass, String name, String descriptor) {
		return targetClass.methods.stream().anyMatch(m -> m.name.equals(name) && m.desc.equals(descriptor));
	}

	static MethodNode constructor(String owner, Constructor constructor) {
		MethodNode node = new MethodNode(Opcodes.ACC_PUBLIC, "<init>", constructor.descriptor(), null, null);
		Type[] args = Type.getArgumentTypes(constructor.descriptor());
		node.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		int slot = 1;
		StringBuilder adapterArgs = new StringBuilder("(");

		for (int i = 0; i < args.length; i++) {
			node.instructions.add(new VarInsnNode(args[i].getOpcode(Opcodes.ILOAD), slot));
			slot += args[i].getSize();

			if (i >= constructor.kept()) {
				adapterArgs.append(args[i].getDescriptor());
			}
		}

		// The adapter turns the arguments after the kept ones (possibly none) into the target's last argument.
		Type[] targetArgs = Type.getArgumentTypes(constructor.target());
		String adapterDescriptor = adapterArgs + ")" + targetArgs[targetArgs.length - 1].getDescriptor();
		node.instructions.add(new MethodInsnNode(Opcodes.INVOKESTATIC, FORWARD_OWNER, constructor.adapter(), adapterDescriptor, false));
		node.instructions.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, owner, "<init>", constructor.target(), false));
		node.instructions.add(new InsnNode(Opcodes.RETURN));
		node.maxLocals = slot;
		node.maxStack = slot + 1;
		return node;
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
