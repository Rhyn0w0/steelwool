package net.neoforged.neoforge.client.fluid;

import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.FluidStack;

/**
 * SteelWool re-implementation of NeoForge's {@code FluidTintSource}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface FluidTintSource extends BlockTintSource {
	int color(FluidState arg0);

	default int colorInWorld(FluidState arg0, BlockState arg1, BlockAndTintGetter arg2, BlockPos arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidTintSource.colorInWorld yet");
	}

	default int colorAsStack(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidTintSource.colorAsStack yet");
	}

	default int color(BlockState arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidTintSource.color yet");
	}

	default int colorInWorld(BlockState arg0, BlockAndTintGetter arg1, BlockPos arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidTintSource.colorInWorld yet");
	}
}
