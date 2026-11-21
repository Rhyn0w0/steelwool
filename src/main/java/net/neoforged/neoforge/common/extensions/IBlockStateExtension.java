package net.neoforged.neoforge.common.extensions;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Methods NeoForge adds to {@link BlockState}; each asks the block's {@link IBlockExtension} method.
 * SteelWool has only the ones listed here so far.
 */
public interface IBlockStateExtension {
	private BlockState self() {
		return (BlockState) this;
	}

	/** The item a player gets when picking this block; see {@link IBlockExtension#getCloneItemStack}. */
	default ItemStack getCloneItemStack(BlockPos pos, LevelReader level, boolean includeData, Player player) {
		return ((IBlockExtension) self().getBlock()).getCloneItemStack(level, pos, self(), includeData, player);
	}
}
