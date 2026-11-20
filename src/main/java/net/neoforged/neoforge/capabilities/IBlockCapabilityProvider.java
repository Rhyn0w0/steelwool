package net.neoforged.neoforge.capabilities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/**
 * SteelWool re-implementation of NeoForge's {@code IBlockCapabilityProvider}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IBlockCapabilityProvider<T extends Object, C extends Object> {
	T getCapability(Level arg0, BlockPos arg1, BlockState arg2, BlockEntity arg3, C arg4);
}
