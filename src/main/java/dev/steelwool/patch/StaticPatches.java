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
}
