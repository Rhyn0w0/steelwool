package net.neoforged.neoforge.client.event;

import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.extract.LevelExtractor;
import net.minecraft.client.renderer.state.OptionsRenderState;
import net.minecraft.client.renderer.state.level.LevelRenderState;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code ExtractLevelRenderStateEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class ExtractLevelRenderStateEvent extends Event {
	private final LevelExtractor levelExtractor;
	private final LevelRenderState renderState;
	private final OptionsRenderState optionsRenderState;
	private final ClientLevel level;
	private final Camera camera;
	private final Frustum frustum;
	private final DeltaTracker deltaTracker;

	public ExtractLevelRenderStateEvent(LevelExtractor levelExtractor, LevelRenderState renderState, OptionsRenderState optionsRenderState, ClientLevel level, Camera camera, Frustum frustum, DeltaTracker deltaTracker) {
		super();
		this.levelExtractor = levelExtractor;
		this.renderState = renderState;
		this.optionsRenderState = optionsRenderState;
		this.level = level;
		this.camera = camera;
		this.frustum = frustum;
		this.deltaTracker = deltaTracker;
	}

	public LevelExtractor getLevelExtractor() {
		return this.levelExtractor;
	}

	public LevelRenderState getRenderState() {
		return this.renderState;
	}

	public OptionsRenderState getOptionsRenderState() {
		return this.optionsRenderState;
	}

	public ClientLevel getLevel() {
		return this.level;
	}

	public Camera getCamera() {
		return this.camera;
	}

	public Frustum getFrustum() {
		return this.frustum;
	}

	public DeltaTracker getDeltaTracker() {
		return this.deltaTracker;
	}
}
