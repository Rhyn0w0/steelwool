package net.neoforged.neoforge.common.extensions;

import dev.steelwool.patch.StaticPatches;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Methods NeoForge adds to {@link net.minecraft.world.level.block.Block}, which blocks can override.
 * SteelWool has only the ones listed here so far.
 */
public interface IBlockExtension {
	/**
	 * The item a player gets when picking this block (middle click in creative). By default the
	 * same as vanilla's {@code BlockState.getCloneItemStack(level, pos, includeData)}. In the server's
	 * pick-block handler, SteelWool has already made that call (so Fabric API's pick-block event ran)
	 * and returns its result.
	 */
	default ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData, Player player) {
		ItemStack stashed = StaticPatches.stashedCloneItemStack();
		return stashed != null ? stashed : state.getCloneItemStack(level, pos, includeData);
	}
}
