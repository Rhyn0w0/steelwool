package net.neoforged.neoforge.client.event;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.state.level.LevelRenderState;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.client.IRenderableSection;

/**
 * SteelWool re-implementation of NeoForge's {@code SubmitCustomGeometryEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class SubmitCustomGeometryEvent extends Event {
	private final LevelRenderState levelRenderState;
	private final SubmitNodeCollector submitNodeCollector;
	private final PoseStack poseStack;
	private final Iterable<? extends IRenderableSection> renderableSections;

	public SubmitCustomGeometryEvent(LevelRenderState levelRenderState, SubmitNodeCollector submitNodeCollector, PoseStack poseStack, Iterable<? extends IRenderableSection> renderableSections) {
		super();
		this.levelRenderState = levelRenderState;
		this.submitNodeCollector = submitNodeCollector;
		this.poseStack = poseStack;
		this.renderableSections = renderableSections;
	}

	public LevelRenderState getLevelRenderState() {
		return this.levelRenderState;
	}

	public SubmitNodeCollector getSubmitNodeCollector() {
		return this.submitNodeCollector;
	}

	public PoseStack getPoseStack() {
		return this.poseStack;
	}

	public Iterable<? extends IRenderableSection> getRenderableSections() {
		return this.renderableSections;
	}
}
