package net.neoforged.neoforge.client;

import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import net.minecraft.client.CloudStatus;
import net.minecraft.client.renderer.oit.OitRenderPassProvider;
import net.minecraft.client.renderer.oit.OitStage;
import net.minecraft.client.renderer.state.level.LevelRenderState;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4fc;

/**
 * SteelWool re-implementation of NeoForge's {@code CustomCloudsRenderer}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface CustomCloudsRenderer {
	default void prepare(LevelRenderState arg0, Vec3 arg1, CloudStatus arg2, int arg3, float arg4, int arg5, Matrix4fc arg6) {
		throw new UnsupportedOperationException("SteelWool does not implement CustomCloudsRenderer.prepare yet");
	}

	default boolean renderClouds(LevelRenderState arg0, CloudStatus arg1, Matrix4fc arg2, RenderPass arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CustomCloudsRenderer.renderClouds yet");
	}

	default boolean renderCloudsOit(LevelRenderState arg0, CloudStatus arg1, Matrix4fc arg2, OitStage arg3, GpuTextureView arg4, OitRenderPassProvider.Parameters arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement CustomCloudsRenderer.renderCloudsOit yet");
	}
}
