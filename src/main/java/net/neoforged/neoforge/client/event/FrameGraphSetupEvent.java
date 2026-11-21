package net.neoforged.neoforge.client.event;

import com.mojang.blaze3d.framegraph.FrameGraphBuilder;
import net.minecraft.client.renderer.LevelTargetBundle;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.util.profiling.ProfilerFiller;
import net.neoforged.bus.api.Event;
import org.joml.Matrix4fc;

/**
 * SteelWool re-implementation of NeoForge's {@code FrameGraphSetupEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class FrameGraphSetupEvent extends Event {
	private final FrameGraphBuilder builder;
	private final LevelTargetBundle targets;
	private final Frustum frustum;
	private final CameraRenderState cameraState;
	private final Matrix4fc modelViewMatrix;
	private final ProfilerFiller profiler;

	public FrameGraphSetupEvent(FrameGraphBuilder builder, LevelTargetBundle targets, CameraRenderState arg2, Matrix4fc arg3, ProfilerFiller arg4) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the FrameGraphSetupEvent constructor yet");
	}

	public FrameGraphBuilder getFrameGrapBuilder() {
		return this.builder;
	}

	public LevelTargetBundle getTargetBundle() {
		return this.targets;
	}

	public Frustum getFrustum() {
		return this.frustum;
	}

	public CameraRenderState getCameraState() {
		return this.cameraState;
	}

	public Matrix4fc getModelViewMatrix() {
		return this.modelViewMatrix;
	}

	public ProfilerFiller getProfiler() {
		return this.profiler;
	}
}
