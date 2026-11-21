package net.neoforged.neoforge.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.state.level.BlockOutlineRenderState;
import net.minecraft.client.renderer.state.level.LevelRenderState;

/**
 * SteelWool re-implementation of NeoForge's {@code CustomBlockOutlineRenderer}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface CustomBlockOutlineRenderer {
	boolean render(BlockOutlineRenderState arg0, SubmitNodeCollector arg1, PoseStack arg2, LevelRenderState arg3);
}
