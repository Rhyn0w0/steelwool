package net.neoforged.neoforge.common;

import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * SteelWool re-implementation of NeoForge's {@code IShearable}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IShearable {
	default boolean isShearable(Player arg0, ItemStack arg1, Level arg2, BlockPos arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement IShearable.isShearable yet");
	}

	default List<ItemStack> onSheared(Player arg0, ItemStack arg1, Level arg2, BlockPos arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement IShearable.onSheared yet");
	}

	default void spawnShearedDrop(ServerLevel arg0, BlockPos arg1, ItemStack arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement IShearable.spawnShearedDrop yet");
	}
}
