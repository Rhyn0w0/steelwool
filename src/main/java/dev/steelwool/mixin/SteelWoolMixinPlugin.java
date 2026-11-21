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
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.transformer.IMixinTransformer;
import org.spongepowered.asm.mixin.transformer.ext.Extensions;
import org.spongepowered.asm.mixin.transformer.ext.IExtension;
import org.spongepowered.asm.mixin.transformer.ext.ITargetClassContext;
import org.spongepowered.asm.mixin.transformer.ClassInfo;

/**
 * Adds the public <em>static</em> methods, constructors, restructured methods and changed calls NeoForge patches
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
 * <li>each call rewrite adds, after a call to a vanilla method inside one method of the target, the
 * call NeoForge's patched code makes there instead, so mods' mixins that target NeoForge's call
 * find it (see {@link CallRewrite}).
 * </ul>
 * Everything is added by a Mixin extension before any mixin for the class (including other mods')
 * is prepared, so other mods' mixins can shadow and target the new members, and method copies are
 * made from vanilla code. The extension only sees classes that have mixins, so each class SteelWool
 * edits has an (often empty) patch mixin.
 */
public final class SteelWoolMixinPlugin implements IMixinConfigPlugin {
	private static final String FORWARD_OWNER = "dev/steelwool/patch/StaticPatches";
	private static final String HOPPER = "net/minecraft/world/level/block/entity/HopperBlockEntity";
	private static final String CONTAINER_OR_HANDLER = "Lnet/neoforged/neoforge/transfer/item/ContainerOrHandler;";
	private static final String HOPPER_LOOKUP_3 = "(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Direction;)" + CONTAINER_OR_HANDLER;
	private static final String HOPPER_LOOKUP_7 = "(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;DDDLnet/minecraft/core/Direction;)" + CONTAINER_OR_HANDLER;
	private static final String HOPPER_SOURCE_LOOKUP = "(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/level/block/entity/Hopper;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)" + CONTAINER_OR_HANDLER;


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

	/**
	 * In {@code method}/{@code methodDescriptor}, adds a call to {@code owner.newName(newDescriptor)}
	 * after each call to {@code owner.name(descriptor)}, and uses its result instead. {@code order[i]}
	 * is the original argument passed as the new call's argument {@code i}, or {@code -1} for
	 * {@code adapter(this)}. The original call stays, since other mixins (Fabric API's) target it:
	 * its result goes to {@code stash} before the new call and the new call's result through
	 * {@code finish} after it (both in StaticPatches), so the new method can use it.
	 */
	record CallRewrite(String method, String methodDescriptor, String owner, String name, String descriptor,
			String newName, String newDescriptor, int[] order, String adapter, String stash, String finish) {
	}

	static final Map<String, List<CallRewrite>> CALL_REWRITES = Map.of(
			// NeoForge's pick-block handler calls IBlockStateExtension.getCloneItemStack, whose default
			// returns what vanilla's call (and Fabric API's pick-block event) produced.
			"net.minecraft.server.network.ServerGamePacketListenerImpl", List.of(
					new CallRewrite("handlePickItemFromBlock", "(Lnet/minecraft/network/protocol/game/ServerboundPickItemFromBlockPacket;)V",
							"net/minecraft/world/level/block/state/BlockState", "getCloneItemStack",
							"(Lnet/minecraft/world/level/LevelReader;Lnet/minecraft/core/BlockPos;Z)Lnet/minecraft/world/item/ItemStack;",
							"getCloneItemStack",
							"(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/LevelReader;ZLnet/minecraft/world/entity/player/Player;)Lnet/minecraft/world/item/ItemStack;",
							new int[] {1, 0, 2, -1}, "serverGamePacketListenerPlayer", "stashCloneItemStack", "finishCloneItemStack")));

	/** An edit to the code of {@code method}/{@code descriptor}, for NeoForge patches that add a call there. */
	record CodeEdit(String method, String descriptor, java.util.function.Consumer<MethodNode> edit) {
	}

	static final Map<String, List<CodeEdit>> CODE_EDITS = Map.of(
			// NeoForge's hoppers look up containers or item handlers with getContainerOrHandlerAt and
			// getSourceContainerOrHandler. SteelWool adds those methods and NeoForge's calls to them, so
			// mixins that target them apply, but the calls never run: vanilla's lookups, which Fabric
			// API's transfer API and mods hook, still do the work.
			"net.minecraft.world.level.block.entity.HopperBlockEntity", List.of(
					new CodeEdit("ejectItems", "(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;L" + HOPPER + ";)Z",
							m -> addUnusedCall(m, HOPPER, "getContainerOrHandlerAt", HOPPER_LOOKUP_3)),
					new CodeEdit("suckInItems", "(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/level/block/entity/Hopper;)Z",
							m -> addUnusedCall(m, HOPPER, "getSourceContainerOrHandler", HOPPER_SOURCE_LOOKUP))),
			"net.minecraft.server.level.ChunkMap", List.of(
					new CodeEdit("lambda$scheduleChunkLoad$3", "(Lnet/minecraft/world/level/ChunkPos;Ljava/util/Optional;)Lnet/minecraft/world/level/chunk/ChunkAccess;",
							SteelWoolMixinPlugin::postChunkDataLoad)));

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
					new StaticMethod("getContainerOrHandlerAt", HOPPER_LOOKUP_3, "hopperGetContainerOrHandlerAt"),
					new StaticMethod("getContainerOrHandlerAt", HOPPER_LOOKUP_7, "hopperGetContainerOrHandlerAt")),
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
		registerExtension();
	}

	/**
	 * Registers a Mixin extension that edits each target class before any mixin is prepared for it.
	 * This is earlier than {@link #preApply}: Mixin looks up other mixins' {@code @Shadow}s when it
	 * prepares them, so the members must exist by then.
	 */
	@SuppressWarnings("unchecked")
	private static void registerExtension() {
		IExtension extension = new IExtension() {
			@Override
			public boolean checkActive(MixinEnvironment environment) {
				return true;
			}

			@Override
			public void preApply(ITargetClassContext context) {
				edit(context.getClassInfo().getName().replace('/', '.'), context.getClassNode());
			}

			@Override
			public void postApply(ITargetClassContext context) {
			}

			@Override
			public void export(MixinEnvironment env, String name, boolean force, ClassNode classNode) {
			}
		};
		try {
			Object transformer = MixinEnvironment.getCurrentEnvironment().getActiveTransformer();
			Extensions extensions = (Extensions) ((IMixinTransformer) transformer).getExtensions();
			extensions.add(extension);
			java.lang.reflect.Field active = Extensions.class.getDeclaredField("activeExtensions");
			active.setAccessible(true);
			List<IExtension> current = (List<IExtension>) active.get(extensions);
			if (current != null) {
				List<IExtension> updated = new java.util.ArrayList<>(current);
				updated.add(extension);
				active.set(extensions, java.util.Collections.unmodifiableList(updated));
			}
		} catch (ReflectiveOperationException | ClassCastException e) {
			throw new IllegalStateException("SteelWool: could not register its Mixin extension", e);
		}
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

	/** Makes all of SteelWool's changes to {@code targetClass} (see the class comment). */
	static void edit(String targetClassName, ClassNode targetClass) {
		addMembers(targetClassName, targetClass);

		for (MethodCopy copy : METHOD_COPIES.getOrDefault(targetClassName, List.of())) {
			if (hasMethod(targetClass, copy.newName(), copy.newDescriptor())) {
				continue;
			}
			MethodNode source = targetClass.methods.stream()
					.filter(m -> m.name.equals(copy.name()) && m.desc.equals(copy.descriptor()))
					.findFirst()
					.orElseThrow(() -> new IllegalStateException("SteelWool: " + targetClassName + "." + copy.name() + copy.descriptor() + " not found"));
			add(targetClass, copyMethod(source, copy));
			if (copy.adapter() != null) {
				delegate(targetClass.name, source, copy);
			}
		}

		for (CodeEdit edit : CODE_EDITS.getOrDefault(targetClassName, List.of())) {
			targetClass.methods.stream()
					.filter(m -> m.name.equals(edit.method()) && m.desc.equals(edit.descriptor()))
					.forEach(edit.edit());
		}

		for (CallRewrite rewrite : CALL_REWRITES.getOrDefault(targetClassName, List.of())) {
			targetClass.methods.stream()
					.filter(m -> m.name.equals(rewrite.method()) && m.desc.equals(rewrite.methodDescriptor()))
					.forEach(m -> rewriteCalls(targetClass.name, m, rewrite));
		}
	}

	/**
	 * Adds a call to static {@code owner.name(descriptor)} at the start of {@code method}, in a branch
	 * that never runs, passing the method's first arguments where the types match and null or zero
	 * otherwise.
	 */
	static void addUnusedCall(MethodNode method, String owner, String name, String descriptor) {
		Type[] args = Type.getArgumentTypes(descriptor);
		Type[] available = Type.getArgumentTypes(method.desc);
		int firstSlot = (method.access & Opcodes.ACC_STATIC) != 0 ? 0 : 1;
		org.objectweb.asm.tree.LabelNode skip = new org.objectweb.asm.tree.LabelNode();
		InsnList code = new InsnList();
		code.add(new org.objectweb.asm.tree.FieldInsnNode(Opcodes.GETSTATIC, FORWARD_OWNER, "NEVER", "Z"));
		code.add(new org.objectweb.asm.tree.JumpInsnNode(Opcodes.IFEQ, skip));
		for (int i = 0; i < args.length; i++) {
			int slot = firstSlot;
			for (int j = 0; j < i && j < available.length; j++) {
				slot += available[j].getSize();
			}
			if (i < available.length && available[i].equals(args[i])) {
				code.add(new VarInsnNode(args[i].getOpcode(Opcodes.ILOAD), slot));
			} else {
				code.add(switch (args[i].getSort()) {
					case Type.LONG -> new InsnNode(Opcodes.LCONST_0);
					case Type.FLOAT -> new InsnNode(Opcodes.FCONST_0);
					case Type.DOUBLE -> new InsnNode(Opcodes.DCONST_0);
					case Type.OBJECT, Type.ARRAY -> new InsnNode(Opcodes.ACONST_NULL);
					default -> new InsnNode(Opcodes.ICONST_0);
				});
			}
		}
		code.add(new MethodInsnNode(Opcodes.INVOKESTATIC, owner, name, descriptor, false));
		code.add(new InsnNode(Type.getReturnType(descriptor).getSize() == 2 ? Opcodes.POP2 : Opcodes.POP));
		code.add(skip);
		code.add(new FrameNode(Opcodes.F_SAME, 0, null, 0, null));
		method.instructions.insert(code);
		method.maxStack += 10;
	}

	/**
	 * Like NeoForge, posts {@code ChunkDataEvent.Load} on {@code NeoForge.EVENT_BUS} when a chunk has
	 * been read from disk in {@code ChunkMap.scheduleChunkLoad}'s lambda (its second argument is the
	 * {@code Optional<SerializableChunkData>}).
	 */
	static void postChunkDataLoad(MethodNode method) {
		String event = "net/neoforged/neoforge/event/level/ChunkDataEvent$Load";
		String data = "net/minecraft/world/level/chunk/storage/SerializableChunkData";
		for (var insn : method.instructions.toArray()) {
			if (insn instanceof MethodInsnNode call && call.owner.equals(data) && call.name.equals("read")) {
				int chunk = method.maxLocals;
				InsnList code = new InsnList();
				code.add(new InsnNode(Opcodes.DUP));
				code.add(new VarInsnNode(Opcodes.ASTORE, chunk));
				code.add(new org.objectweb.asm.tree.FieldInsnNode(Opcodes.GETSTATIC, "net/neoforged/neoforge/common/NeoForge", "EVENT_BUS", "Lnet/neoforged/bus/api/IEventBus;"));
				code.add(new org.objectweb.asm.tree.TypeInsnNode(Opcodes.NEW, event));
				code.add(new InsnNode(Opcodes.DUP));
				code.add(new VarInsnNode(Opcodes.ALOAD, chunk));
				code.add(new VarInsnNode(Opcodes.ALOAD, 2));
				code.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/util/Optional", "get", "()Ljava/lang/Object;", false));
				code.add(new org.objectweb.asm.tree.TypeInsnNode(Opcodes.CHECKCAST, data));
				code.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, event, "<init>", "(Lnet/minecraft/world/level/chunk/ChunkAccess;L" + data + ";)V", false));
				code.add(new MethodInsnNode(Opcodes.INVOKEINTERFACE, "net/neoforged/bus/api/IEventBus", "post", "(Lnet/neoforged/bus/api/Event;)Lnet/neoforged/bus/api/Event;", true));
				code.add(new InsnNode(Opcodes.POP));
				method.instructions.insert(call, code);
				method.maxLocals = chunk + 1;
				method.maxStack += 6;
				return;
			}
		}
		throw new IllegalStateException("SteelWool: SerializableChunkData.read call not found in ChunkMap." + method.name);
	}

	/**
	 * Rewrites each matching call in {@code method}: stores the receiver and arguments in new local
	 * variables, makes the original call, stashes its result, then makes the new call with the
	 * arguments in the new order.
	 */
	static void rewriteCalls(String owner, MethodNode method, CallRewrite rewrite) {
		Type[] oldArgs = Type.getArgumentTypes(rewrite.descriptor());
		Type[] newArgs = Type.getArgumentTypes(rewrite.newDescriptor());
		String result = Type.getReturnType(rewrite.descriptor()).getDescriptor();
		for (var insn : method.instructions.toArray()) {
			if (!(insn instanceof MethodInsnNode call) || !call.owner.equals(rewrite.owner())
					|| !call.name.equals(rewrite.name()) || !call.desc.equals(rewrite.descriptor())) {
				continue;
			}
			int receiver = method.maxLocals;
			int[] slots = new int[oldArgs.length];
			int next = receiver + 1;
			for (int i = 0; i < oldArgs.length; i++) {
				slots[i] = next;
				next += oldArgs[i].getSize();
			}

			InsnList before = new InsnList();
			for (int i = oldArgs.length - 1; i >= 0; i--) {
				before.add(new VarInsnNode(oldArgs[i].getOpcode(Opcodes.ISTORE), slots[i]));
			}
			before.add(new VarInsnNode(Opcodes.ASTORE, receiver));
			before.add(new VarInsnNode(Opcodes.ALOAD, receiver));
			for (int i = 0; i < oldArgs.length; i++) {
				before.add(new VarInsnNode(oldArgs[i].getOpcode(Opcodes.ILOAD), slots[i]));
			}

			InsnList after = new InsnList();
			after.add(new MethodInsnNode(Opcodes.INVOKESTATIC, FORWARD_OWNER, rewrite.stash(), "(" + result + ")V", false));
			after.add(new VarInsnNode(Opcodes.ALOAD, receiver));
			for (int i = 0; i < rewrite.order().length; i++) {
				int from = rewrite.order()[i];
				if (from < 0) {
					after.add(new VarInsnNode(Opcodes.ALOAD, 0));
					after.add(new MethodInsnNode(Opcodes.INVOKESTATIC, FORWARD_OWNER, rewrite.adapter(),
							"(L" + owner + ";)" + newArgs[i].getDescriptor(), false));
				} else {
					after.add(new VarInsnNode(oldArgs[from].getOpcode(Opcodes.ILOAD), slots[from]));
				}
			}
			after.add(new MethodInsnNode(call.getOpcode(), call.owner, rewrite.newName(), rewrite.newDescriptor(), call.itf));
			after.add(new MethodInsnNode(Opcodes.INVOKESTATIC, FORWARD_OWNER, rewrite.finish(), "(" + result + ")" + result, false));

			method.instructions.insertBefore(call, before);
			method.instructions.insert(call, after);
			method.maxLocals = next;
			method.maxStack += newArgs.length + 2;
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
		if (targetClassName.equals("net.minecraft.world.level.block.entity.HopperBlockEntity")
				&& !hasMethod(targetClass, "getSourceContainerOrHandler", HOPPER_SOURCE_LOOKUP)) {
			add(targetClass, hopperSourceLookup());
		}

		for (StaticMethod method : STATIC_METHODS.getOrDefault(targetClassName, List.of())) {
			if (!hasMethod(targetClass, method.name(), method.descriptor())) {
				add(targetClass, forwarder(method));
			}
		}

		for (Constructor constructor : CONSTRUCTORS.getOrDefault(targetClassName, List.of())) {
			if (!hasMethod(targetClass, "<init>", constructor.descriptor())) {
				add(targetClass, constructor(targetClass.name, constructor));
			}
		}
	}

	/**
	 * NeoForge's {@code getSourceContainerOrHandler(level, hopper, pos, state)}: what is above the
	 * hopper, as {@code getContainerOrHandlerAt(level, pos, state, x, y + 1, z, DOWN)} (a call that
	 * mods' mixins target).
	 */
	private static MethodNode hopperSourceLookup() {
		MethodNode node = new MethodNode(Opcodes.ACC_PRIVATE | Opcodes.ACC_STATIC, "getSourceContainerOrHandler", HOPPER_SOURCE_LOOKUP, null, null);
		String hopper = "net/minecraft/world/level/block/entity/Hopper";
		node.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		node.instructions.add(new VarInsnNode(Opcodes.ALOAD, 2));
		node.instructions.add(new VarInsnNode(Opcodes.ALOAD, 3));
		node.instructions.add(new VarInsnNode(Opcodes.ALOAD, 1));
		node.instructions.add(new MethodInsnNode(Opcodes.INVOKEINTERFACE, hopper, "getLevelX", "()D", true));
		node.instructions.add(new VarInsnNode(Opcodes.ALOAD, 1));
		node.instructions.add(new MethodInsnNode(Opcodes.INVOKEINTERFACE, hopper, "getLevelY", "()D", true));
		node.instructions.add(new org.objectweb.asm.tree.LdcInsnNode(1.0));
		node.instructions.add(new InsnNode(Opcodes.DADD));
		node.instructions.add(new VarInsnNode(Opcodes.ALOAD, 1));
		node.instructions.add(new MethodInsnNode(Opcodes.INVOKEINTERFACE, hopper, "getLevelZ", "()D", true));
		node.instructions.add(new org.objectweb.asm.tree.FieldInsnNode(Opcodes.GETSTATIC, "net/minecraft/core/Direction", "DOWN", "Lnet/minecraft/core/Direction;"));
		node.instructions.add(new MethodInsnNode(Opcodes.INVOKESTATIC, HOPPER, "getContainerOrHandlerAt", HOPPER_LOOKUP_7, false));
		node.instructions.add(new InsnNode(Opcodes.ARETURN));
		node.maxLocals = 4;
		node.maxStack = 12;
		return node;
	}

	private static final java.lang.reflect.Method CLASS_INFO_ADD_METHOD;

	static {
		try {
			CLASS_INFO_ADD_METHOD = ClassInfo.class.getDeclaredMethod("addMethod", MethodNode.class);
			CLASS_INFO_ADD_METHOD.setAccessible(true);
		} catch (ReflectiveOperationException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	/**
	 * Adds {@code method} to the class and to Mixin's metadata for it, which is read from the original
	 * class: without that, other mixins' {@code @Shadow}s of the method would not find it.
	 */
	private static void add(ClassNode targetClass, MethodNode method) {
		targetClass.methods.add(method);
		try {
			CLASS_INFO_ADD_METHOD.invoke(ClassInfo.forName(targetClass.name), method);
		} catch (ReflectiveOperationException e) {
			throw new IllegalStateException("SteelWool: could not register " + targetClass.name + "." + method.name + method.desc + " with Mixin", e);
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
