package net.neoforged.neoforge.client.submit;

import java.util.function.Function;

import net.minecraft.client.renderer.SubmitNodeCollection;
import net.minecraft.client.renderer.feature.phase.FeatureRenderPhase;
import net.minecraft.client.renderer.feature.submit.SubmitNode;

/**
 * SteelWool re-implementation of NeoForge's {@code RenderPhaseKey}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class RenderPhaseKey<T extends SubmitNode> extends Object {
	private final Function<SubmitNodeCollection, FeatureRenderPhase<T>> phaseGetter;

	public RenderPhaseKey(Function<SubmitNodeCollection, FeatureRenderPhase<T>> phaseGetter) {
		super();
		this.phaseGetter = phaseGetter;
	}

	public FeatureRenderPhase<T> resolve(SubmitNodeCollection arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RenderPhaseKey.resolve yet");
	}
}
