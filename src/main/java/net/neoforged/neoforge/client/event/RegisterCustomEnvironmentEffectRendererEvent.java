package net.neoforged.neoforge.client.event;

import java.util.Map;

import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.client.CustomCloudsRenderer;
import net.neoforged.neoforge.client.CustomSkyboxRenderer;
import net.neoforged.neoforge.client.CustomWeatherEffectRenderer;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterCustomEnvironmentEffectRendererEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterCustomEnvironmentEffectRendererEvent extends Event implements IModBusEvent {
	private final Map<Identifier, CustomCloudsRenderer> cloudRenderers;
	private final Map<Identifier, CustomSkyboxRenderer> skyboxRenderers;
	private final Map<Identifier, CustomWeatherEffectRenderer> weatherEffectsRenderers;

	public RegisterCustomEnvironmentEffectRendererEvent(Map<Identifier, CustomCloudsRenderer> cloudRenderers, Map<Identifier, CustomSkyboxRenderer> skyboxRenderers, Map<Identifier, CustomWeatherEffectRenderer> weatherEffectsRenderers) {
		super();
		this.cloudRenderers = cloudRenderers;
		this.skyboxRenderers = skyboxRenderers;
		this.weatherEffectsRenderers = weatherEffectsRenderers;
	}

	public void registerCloudRenderer(Identifier arg0, CustomCloudsRenderer arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterCustomEnvironmentEffectRendererEvent.registerCloudRenderer yet");
	}

	public void registerSkyboxRenderer(Identifier arg0, CustomSkyboxRenderer arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterCustomEnvironmentEffectRendererEvent.registerSkyboxRenderer yet");
	}

	public void registerWeatherEffectRenderer(Identifier arg0, CustomWeatherEffectRenderer arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterCustomEnvironmentEffectRendererEvent.registerWeatherEffectRenderer yet");
	}
}
