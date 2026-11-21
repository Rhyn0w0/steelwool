package net.neoforged.neoforge.client.model;

import java.util.List;

import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.client.renderer.block.dispatch.BlockStateModelPart;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;

/**
 * SteelWool re-implementation of NeoForge's {@code DynamicBlockStateModel}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface DynamicBlockStateModel extends BlockStateModel {
	default void collectParts(RandomSource arg0, List<BlockStateModelPart> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DynamicBlockStateModel.collectParts yet");
	}

	void collectParts(BlockAndTintGetter arg0, BlockPos arg1, BlockState arg2, RandomSource arg3, List<BlockStateModelPart> arg4);
}
