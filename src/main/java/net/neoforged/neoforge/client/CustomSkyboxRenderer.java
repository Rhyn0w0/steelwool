package net.neoforged.neoforge.client;

import com.mojang.renderpearl.api.buffers.GpuBufferSlice;
import net.minecraft.client.renderer.state.level.LevelRenderState;
import net.minecraft.client.renderer.state.level.SkyRenderState;
import org.joml.Matrix4fc;

/**
 * SteelWool re-implementation of NeoForge's {@code CustomSkyboxRenderer}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface CustomSkyboxRenderer {
	default boolean renderSky(LevelRenderState arg0, SkyRenderState arg1, Matrix4fc arg2, GpuBufferSlice arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CustomSkyboxRenderer.renderSky yet");
	}
}
