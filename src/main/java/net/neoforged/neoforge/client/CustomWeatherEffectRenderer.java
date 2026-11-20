package net.neoforged.neoforge.client;

import com.mojang.renderpearl.api.commands.RenderPass;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.oit.OitStage;
import net.minecraft.client.renderer.state.level.LevelRenderState;
import net.minecraft.client.renderer.state.level.WeatherRenderState;
import net.minecraft.world.phys.Vec3;

/**
 * SteelWool re-implementation of NeoForge's {@code CustomWeatherEffectRenderer}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface CustomWeatherEffectRenderer {
	default void prepare(LevelRenderState arg0, WeatherRenderState arg1, Vec3 arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CustomWeatherEffectRenderer.prepare yet");
	}

	default boolean renderSnowAndRain(LevelRenderState arg0, WeatherRenderState arg1, Vec3 arg2, RenderPass arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CustomWeatherEffectRenderer.renderSnowAndRain yet");
	}

	default boolean renderSnowAndRainOit(LevelRenderState arg0, WeatherRenderState arg1, Vec3 arg2, OitStage arg3, RenderPass arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement CustomWeatherEffectRenderer.renderSnowAndRainOit yet");
	}

	default boolean tickRain(ClientLevel arg0, long arg1, Camera arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CustomWeatherEffectRenderer.tickRain yet");
	}
}
