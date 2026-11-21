package net.neoforged.neoforge.client.model.block;

import java.util.Map;
import java.util.function.Supplier;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

/**
 * SteelWool re-implementation of NeoForge's {@code CustomBlockModelDefinition}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface CustomBlockModelDefinition {
	Map<BlockState, BlockStateModel.UnbakedRoot> instantiate(StateDefinition<Block, BlockState> arg0, Supplier<String> arg1);

	MapCodec<? extends net.neoforged.neoforge.client.model.block.CustomBlockModelDefinition> codec();
}
