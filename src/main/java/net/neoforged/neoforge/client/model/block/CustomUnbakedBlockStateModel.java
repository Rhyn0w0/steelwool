package net.neoforged.neoforge.client.model.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;

/**
 * SteelWool re-implementation of NeoForge's {@code CustomUnbakedBlockStateModel}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface CustomUnbakedBlockStateModel extends BlockStateModel.Unbaked {
	MapCodec<? extends net.neoforged.neoforge.client.model.block.CustomUnbakedBlockStateModel> codec();
}
