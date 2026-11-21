package net.neoforged.neoforge.client.event;

import net.minecraft.client.renderer.feature.FeatureRenderer;
import net.minecraft.client.renderer.feature.FeatureRendererMap;
import net.minecraft.client.renderer.feature.FeatureRendererType;
import net.minecraft.client.renderer.feature.submit.SubmitNode;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterFeatureRenderersEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class RegisterFeatureRenderersEvent extends Event {
	private final FeatureRendererMap featureRenderers;

	public RegisterFeatureRenderersEvent(FeatureRendererMap featureRenderers) {
		super();
		this.featureRenderers = featureRenderers;
	}

	public <S extends SubmitNode> void register(FeatureRendererType<S> arg0, FeatureRenderer<S> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterFeatureRenderersEvent.register yet");
	}
}
