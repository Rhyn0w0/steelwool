package net.neoforged.neoforge.client.fluid;

import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.block.FluidRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

/**
 * SteelWool re-implementation of NeoForge's {@code CustomFluidRenderer}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface CustomFluidRenderer {
	boolean renderFluid(FluidRenderer arg0, FluidState arg1, BlockAndTintGetter arg2, BlockPos arg3, FluidRenderer.Output arg4, BlockState arg5);
}
