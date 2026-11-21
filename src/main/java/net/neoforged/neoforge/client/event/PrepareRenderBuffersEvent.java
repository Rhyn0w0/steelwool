package net.neoforged.neoforge.client.event;

import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.state.OptionsRenderState;
import net.minecraft.client.renderer.state.level.LevelRenderState;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code PrepareRenderBuffersEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class PrepareRenderBuffersEvent extends Event {
	private final LevelRenderer levelRenderer;
	private final LevelRenderState levelRenderState;
	private final OptionsRenderState optionsRenderState;

	public PrepareRenderBuffersEvent(LevelRenderer levelRenderer, LevelRenderState levelRenderState, OptionsRenderState optionsRenderState) {
		super();
		this.levelRenderer = levelRenderer;
		this.levelRenderState = levelRenderState;
		this.optionsRenderState = optionsRenderState;
	}

	public LevelRenderer getLevelRenderer() {
		return this.levelRenderer;
	}

	public LevelRenderState getLevelRenderState() {
		return this.levelRenderState;
	}

	public OptionsRenderState getOptionsRenderState() {
		return this.optionsRenderState;
	}
}
