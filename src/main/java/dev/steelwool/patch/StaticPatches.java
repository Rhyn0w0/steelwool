package dev.steelwool.patch;

import dev.steelwool.mixin.patch.ArgumentTypeInfosMixin;
import java.util.Set;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.commands.synchronization.ArgumentTypeInfo;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;

/**
 * Implementations of the static methods NeoForge patches into Minecraft classes, and adapters for
 * the constructors it adds. {@code SteelWoolMixinPlugin} adds the methods and constructors to the
 * Minecraft classes, and they call these.
 */
public final class StaticPatches {
	private StaticPatches() {
	}

	/**
	 * {@code CreativeModeTab.builder()}: NeoForge's builder for mod tabs, which are placed and paged
	 * automatically. Fabric API's {@link FabricCreativeModeTab#builder()} does the same.
	 */
	public static CreativeModeTab.Builder creativeModeTabBuilder() {
		return FabricCreativeModeTab.builder();
	}

	/** {@code ArgumentTypeInfos.registerByClass}: makes the argument type serializable without registering it under a name. */
	public static ArgumentTypeInfo<?, ?> argumentTypeInfosRegisterByClass(Class<?> argumentClass, ArgumentTypeInfo<?, ?> info) {
		ArgumentTypeInfosMixin.steelwool$byClass().put(argumentClass, info);
		return info;
	}

	/** Valid blocks for NeoForge's {@code BlockEntityType(supplier, Block...)} constructor. */
	public static Set<Block> blockEntityTypeBlocks(Block[] blocks) {
		return Set.of(blocks);
	}

	/** Valid blocks for {@code BlockEntityType(supplier, onlyOpCanSetNbt, Block...)}; the flag is ignored. */
	public static Set<Block> blockEntityTypeBlocks(boolean onlyOpCanSetNbt, Block[] blocks) {
		return Set.of(blocks);
	}

	/** Valid blocks for {@code BlockEntityType(supplier, Set, onlyOpCanSetNbt)}; the flag is ignored. */
	public static Set<Block> blockEntityTypeBlocks(Set<Block> blocks, boolean onlyOpCanSetNbt) {
		return blocks;
	}

	/**
	 * The data fixer for NeoForge's {@code SavedDataType(id, constructor, codec)}: none, so the data is
	 * not upgraded ({@code SavedDataStorageMixin} skips fixing).
	 */
	public static net.minecraft.util.datafix.@org.jspecify.annotations.Nullable DataFixTypes noDataFixType() {
		return null;
	}

	/** The holder NeoForge passes to {@code BlockTransformer.transformBlock(context, holder)}: the transformer itself. */
	public static net.minecraft.core.Holder<net.minecraft.core.component.BlockTransformer> blockTransformerHolder(net.minecraft.core.component.BlockTransformer transformer) {
		return net.minecraft.core.Holder.direct(transformer);
	}

	/**
	 * {@code HopperBlockEntity.getContainerOrHandlerAt(level, pos, side)}: the vanilla container at
	 * {@code pos}; SteelWool does not look up item handler capabilities here.
	 */
	public static net.neoforged.neoforge.transfer.item.ContainerOrHandler hopperGetContainerOrHandlerAt(net.minecraft.world.level.Level level, net.minecraft.core.BlockPos pos, net.minecraft.core.Direction side) {
		net.minecraft.world.Container container = net.minecraft.world.level.block.entity.HopperBlockEntity.getContainerAt(level, pos);
		return container != null ? new net.neoforged.neoforge.transfer.item.ContainerOrHandler(container, null) : net.neoforged.neoforge.transfer.item.ContainerOrHandler.EMPTY;
	}

	/** {@code RecipeType.simple(id)}: a recipe type that prints as its id, for registering. */
	public static net.minecraft.world.item.crafting.RecipeType<?> recipeTypeSimple(net.minecraft.resources.Identifier id) {
		String name = id.toString();
		return new net.minecraft.world.item.crafting.RecipeType<>() {
			@Override
			public String toString() {
				return name;
			}
		};
	}
}
