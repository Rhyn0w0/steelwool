package dev.steelwool.mixin;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FrameNode;
import org.objectweb.asm.tree.IincInsnNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

/**
 * Adds the public <em>static</em> methods, constructors and restructured methods NeoForge patches
 * into Minecraft classes, which Mixin cannot add itself:
 * <ul>
 * <li>each static method forwards to a static method in {@code dev.steelwool.patch.StaticPatches}
 * with the same descriptor;
 * <li>each constructor passes its first {@code kept} arguments to an existing constructor as they
 * are, and turns the rest (possibly none) into its last argument with an adapter method in
 * {@code StaticPatches};
 * <li>each method copy duplicates a vanilla method's code under the name and descriptor NeoForge's
 * patches give it (with extra parameters added at the end, which the copy ignores), so mods' mixins
 * that target NeoForge's method find the code they expect. With an {@code adapter}, the vanilla
 * method then just calls the copy, passing {@code adapter(this)} for each extra parameter, so the
 * copy is what runs.
 * </ul>
 * Everything is added when a patch mixin for the class is about to be applied, which is before any
 * injector (including other mods') runs, so other mods' mixins can target the new members. Method
 * copies must be made from vanilla code, so the patch mixin for such a class has the lowest priority.
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

	/** A copy of {@code name}/{@code descriptor} as {@code newName}/{@code newDescriptor}; see the class comment. */
	record MethodCopy(String name, String descriptor, String newName, String newDescriptor, int access, @Nullable String adapter) {
	}

	static final Map<String, List<MethodCopy>> METHOD_COPIES = Map.of(
			// NeoForge splits createResult into a final createResult calling createResultInternal. Fabric
			// API injects into createResult's code, so the vanilla method keeps running and the copy is
			// only there for mods' mixins (which therefore have no effect).
			"net.minecraft.world.inventory.AnvilMenu", List.of(
					new MethodCopy("createResult", "()V", "createResultInternal", "()V", Opcodes.ACC_PROTECTED, null)),
			"net.minecraft.core.component.BlockTransformer", List.of(
					new MethodCopy("transformBlock", "(Lnet/minecraft/world/item/context/UseOnContext;)Lnet/minecraft/world/InteractionResult;",
							"transformBlock", "(Lnet/minecraft/world/item/context/UseOnContext;Lnet/minecraft/core/Holder;)Lnet/minecraft/world/InteractionResult;",
							Opcodes.ACC_PUBLIC, "blockTransformerHolder")));

	static final Map<String, List<StaticMethod>> STATIC_METHODS = Map.of(
			"net.minecraft.world.item.CreativeModeTab", List.of(
					new StaticMethod("builder", "()Lnet/minecraft/world/item/CreativeModeTab$Builder;", "creativeModeTabBuilder")),
			"net.minecraft.world.level.block.entity.HopperBlockEntity", List.of(
					new StaticMethod("getContainerOrHandlerAt",
							"(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Direction;)Lnet/neoforged/neoforge/transfer/item/ContainerOrHandler;",
							"hopperGetContainerOrHandlerAt")),
			"net.minecraft.world.item.crafting.RecipeType", List.of(
					new StaticMethod("simple", "(Lnet/minecraft/resources/Identifier;)Lnet/minecraft/world/item/crafting/RecipeType;", "recipeTypeSimple")),
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
		addMembers(targetClassName, targetClass);

		for (MethodCopy copy : METHOD_COPIES.getOrDefault(targetClassName, List.of())) {
			if (hasMethod(targetClass, copy.newName(), copy.newDescriptor())) {
				continue;
			}
			MethodNode source = targetClass.methods.stream()
					.filter(m -> m.name.equals(copy.name()) && m.desc.equals(copy.descriptor()))
					.findFirst()
					.orElseThrow(() -> new IllegalStateException("SteelWool: " + targetClassName + "." + copy.name() + copy.descriptor() + " not found"));
			targetClass.methods.add(copyMethod(source, copy));
			if (copy.adapter() != null) {
				delegate(targetClass.name, source, copy);
			}
		}
	}

	/** A copy of {@code source} named as {@code copy} says, with its extra parameters' slots inserted after the original ones. */
	static MethodNode copyMethod(MethodNode source, MethodCopy copy) {
		MethodNode node = new MethodNode(copy.access(), copy.newName(), copy.newDescriptor(), null,
				source.exceptions == null ? null : source.exceptions.toArray(String[]::new));
		source.accept(node);
		node.access = copy.access() | (source.access & Opcodes.ACC_STATIC);

		boolean isStatic = (source.access & Opcodes.ACC_STATIC) != 0;
		Type[] oldArgs = Type.getArgumentTypes(source.desc);
		Type[] newArgs = Type.getArgumentTypes(copy.newDescriptor());
		int firstLocal = isStatic ? 0 : 1;
		for (Type arg : oldArgs) {
			firstLocal += arg.getSize();
		}
		int shift = 0;
		List<Object> extraFrameTypes = new java.util.ArrayList<>();
		for (int i = oldArgs.length; i < newArgs.length; i++) {
			shift += newArgs[i].getSize();
			extraFrameTypes.add(frameType(newArgs[i]));
		}
		int frameInsert = (isStatic ? 0 : 1) + oldArgs.length;

		if (shift > 0) {
			for (var insn : node.instructions) {
				if (insn instanceof VarInsnNode var && var.var >= firstLocal) {
					var.var += shift;
				} else if (insn instanceof IincInsnNode iinc && iinc.var >= firstLocal) {
					iinc.var += shift;
				} else if (insn instanceof FrameNode frame && frame.type == Opcodes.F_FULL && frame.local != null && frame.local.size() >= frameInsert) {
					frame.local.addAll(frameInsert, extraFrameTypes);
				}
			}
			if (node.localVariables != null) {
				for (var local : node.localVariables) {
					if (local.index >= firstLocal) {
						local.index += shift;
					}
				}
			}
			node.maxLocals += shift;
		}
		return node;
	}

	private static Object frameType(Type type) {
		return switch (type.getSort()) {
			case Type.BOOLEAN, Type.BYTE, Type.CHAR, Type.SHORT, Type.INT -> Opcodes.INTEGER;
			case Type.FLOAT -> Opcodes.FLOAT;
			case Type.LONG -> Opcodes.LONG;
			case Type.DOUBLE -> Opcodes.DOUBLE;
			default -> type.getInternalName();
		};
	}

	/** Replaces {@code source}'s code with a call to the copy, passing {@code adapter(this)} for each extra parameter. */
	private static void delegate(String owner, MethodNode source, MethodCopy copy) {
		source.instructions.clear();
		source.tryCatchBlocks.clear();
		if (source.localVariables != null) {
			source.localVariables.clear();
		}
		Type[] oldArgs = Type.getArgumentTypes(source.desc);
		Type[] newArgs = Type.getArgumentTypes(copy.newDescriptor());
		source.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		int slot = 1;
		for (Type arg : oldArgs) {
			source.instructions.add(new VarInsnNode(arg.getOpcode(Opcodes.ILOAD), slot));
			slot += arg.getSize();
		}
		for (int i = oldArgs.length; i < newArgs.length; i++) {
			source.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
			source.instructions.add(new MethodInsnNode(Opcodes.INVOKESTATIC, FORWARD_OWNER, copy.adapter(),
					"(L" + owner + ";)" + newArgs[i].getDescriptor(), false));
		}
		source.instructions.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, owner, copy.newName(), copy.newDescriptor(), false));
		source.instructions.add(new InsnNode(Type.getReturnType(source.desc).getOpcode(Opcodes.IRETURN)));
		source.maxLocals = slot;
		source.maxStack = slot + newArgs.length + 1;
	}

	@Override
	public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
	}

	/** Adds the static methods and constructors (before injectors run, so other mods' mixins can target them). */
	private static void addMembers(String targetClassName, ClassNode targetClass) {
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
