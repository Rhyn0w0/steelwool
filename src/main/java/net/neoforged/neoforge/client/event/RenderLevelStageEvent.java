package net.neoforged.neoforge.client.event;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.renderpearl.api.commands.RenderPass;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.oit.OitStage;
import net.minecraft.client.renderer.state.level.LevelRenderState;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.client.IRenderableSection;
import org.joml.Matrix4fc;

/**
 * SteelWool re-implementation of NeoForge's {@code RenderLevelStageEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class RenderLevelStageEvent extends Event {
	private final LevelRenderer levelRenderer;
	private final LevelRenderState levelRenderState;
	private final PoseStack poseStack;
	private final Matrix4fc modelViewMatrix;
	private final Iterable<? extends IRenderableSection> renderableSections;
	private final RenderPass renderPass;

	public RenderLevelStageEvent(LevelRenderer levelRenderer, LevelRenderState levelRenderState, PoseStack arg2, Matrix4fc arg3, Iterable<? extends IRenderableSection> arg4, RenderPass arg5) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the RenderLevelStageEvent constructor yet");
	}

	public LevelRenderer getLevelRenderer() {
		return this.levelRenderer;
	}

	public LevelRenderState getLevelRenderState() {
		return this.levelRenderState;
	}

	public PoseStack getPoseStack() {
		return this.poseStack;
	}

	public Matrix4fc getModelViewMatrix() {
		return this.modelViewMatrix;
	}

	public Iterable<? extends IRenderableSection> getRenderableSections() {
		return this.renderableSections;
	}

	protected RenderPass getRenderPass() {
		throw new UnsupportedOperationException("SteelWool does not implement RenderLevelStageEvent.getRenderPass yet");
	}

	public static class AfterLevel extends net.neoforged.neoforge.client.event.RenderLevelStageEvent {
		public AfterLevel(LevelRenderer arg0, LevelRenderState arg1, PoseStack arg2, Matrix4fc arg3, Iterable<? extends IRenderableSection> arg4) {
			super(arg0, arg1, arg2, arg3, arg4, null);
		}
	}

	public static class AfterOpaqueBlocks extends net.neoforged.neoforge.client.event.RenderLevelStageEvent {
		public AfterOpaqueBlocks(LevelRenderer arg0, LevelRenderState arg1, PoseStack arg2, Matrix4fc arg3, Iterable<? extends IRenderableSection> arg4, RenderPass arg5) {
			super(arg0, arg1, arg2, arg3, arg4, arg5);
		}

		public RenderPass getRenderPass() {
			return super.getRenderPass();
		}
	}

	public static class AfterOpaqueFeatures extends net.neoforged.neoforge.client.event.RenderLevelStageEvent {
		public AfterOpaqueFeatures(LevelRenderer arg0, LevelRenderState arg1, PoseStack arg2, Matrix4fc arg3, Iterable<? extends IRenderableSection> arg4, RenderPass arg5) {
			super(arg0, arg1, arg2, arg3, arg4, arg5);
		}

		public RenderPass getRenderPass() {
			return super.getRenderPass();
		}
	}

	public static class AfterSky extends net.neoforged.neoforge.client.event.RenderLevelStageEvent {
		public AfterSky(LevelRenderer arg0, LevelRenderState arg1, PoseStack arg2, Matrix4fc arg3, Iterable<? extends IRenderableSection> arg4) {
			super(arg0, arg1, arg2, arg3, arg4, null);
		}
	}

	public static class AfterTranslucentBlocks extends net.neoforged.neoforge.client.event.RenderLevelStageEvent {
		public AfterTranslucentBlocks(LevelRenderer arg0, LevelRenderState arg1, PoseStack arg2, Matrix4fc arg3, Iterable<? extends IRenderableSection> arg4, RenderPass arg5) {
			super(arg0, arg1, arg2, arg3, arg4, arg5);
		}

		public RenderPass getRenderPass() {
			return super.getRenderPass();
		}
	}

	public static class AfterTranslucentFeatures extends net.neoforged.neoforge.client.event.RenderLevelStageEvent {
		public AfterTranslucentFeatures(LevelRenderer arg0, LevelRenderState arg1, PoseStack arg2, Matrix4fc arg3, Iterable<? extends IRenderableSection> arg4, RenderPass arg5) {
			super(arg0, arg1, arg2, arg3, arg4, arg5);
		}

		public RenderPass getRenderPass() {
			return super.getRenderPass();
		}
	}

	public static class AfterTranslucentParticles extends net.neoforged.neoforge.client.event.RenderLevelStageEvent {
		public AfterTranslucentParticles(LevelRenderer arg0, LevelRenderState arg1, PoseStack arg2, Matrix4fc arg3, Iterable<? extends IRenderableSection> arg4, RenderPass arg5) {
			super(arg0, arg1, arg2, arg3, arg4, arg5);
		}

		public RenderPass getRenderPass() {
			return super.getRenderPass();
		}
	}

	public static class AfterWeather extends net.neoforged.neoforge.client.event.RenderLevelStageEvent {
		public AfterWeather(LevelRenderer arg0, LevelRenderState arg1, PoseStack arg2, Matrix4fc arg3, Iterable<? extends IRenderableSection> arg4, RenderPass arg5) {
			super(arg0, arg1, arg2, arg3, arg4, arg5);
		}

		public RenderPass getRenderPass() {
			return super.getRenderPass();
		}
	}

	public static class OitTranslucent extends net.neoforged.neoforge.client.event.RenderLevelStageEvent {
		private final OitStage oitStage;

		public OitTranslucent(LevelRenderer arg0, LevelRenderState arg1, OitStage oitStage, PoseStack arg3, Matrix4fc arg4, Iterable<? extends IRenderableSection> arg5, RenderPass arg6) {
			super(arg0, arg1, arg3, arg4, arg5, arg6);
			this.oitStage = oitStage;
		}

		public OitStage getOitStage() {
			return this.oitStage;
		}

		public RenderPass getRenderPass() {
			return super.getRenderPass();
		}
	}
}
