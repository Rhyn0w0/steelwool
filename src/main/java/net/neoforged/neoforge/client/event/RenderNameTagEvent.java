package net.neoforged.neoforge.client.event;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.network.chat.Component;
import net.minecraft.util.TriState;
import net.minecraft.world.entity.Entity;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RenderNameTagEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class RenderNameTagEvent extends Event {
	private final EntityRenderState renderState;
	private final EntityRenderer<?, ?> entityRenderer;
	private final float partialTick;

	public RenderNameTagEvent(EntityRenderState renderState, EntityRenderer<?, ?> entityRenderer, float partialTick) {
		super();
		this.renderState = renderState;
		this.entityRenderer = entityRenderer;
		this.partialTick = partialTick;
	}

	public EntityRenderState getEntityRenderState() {
		return this.renderState;
	}

	public EntityRenderer<?, ?> getEntityRenderer() {
		return this.entityRenderer;
	}

	public float getPartialTick() {
		return this.partialTick;
	}

	public static class CanRender extends net.neoforged.neoforge.client.event.RenderNameTagEvent {
		private final Entity entity;
		private final Component originalContent;
		private Component content;
		private TriState canRender;

		public CanRender(Entity arg0, EntityRenderState arg1, Component arg2, EntityRenderer<?, ?> arg3, float arg4) {
			super((EntityRenderState) null, (EntityRenderer) null, (float) 0);
			throw new UnsupportedOperationException("SteelWool does not implement the RenderNameTagEvent.CanRender constructor yet");
		}

		public Entity getEntity() {
			return this.entity;
		}

		public Component getOriginalContent() {
			return this.originalContent;
		}

		public void setCanRender(TriState canRender) {
			this.canRender = canRender;
		}

		public TriState canRender() {
			return this.canRender;
		}

		public void setContent(Component content) {
			this.content = content;
		}

		public Component getContent() {
			return this.content;
		}
	}

	public static class DoRender extends net.neoforged.neoforge.client.event.RenderNameTagEvent implements ICancellableEvent {
		private final Component content;
		private final PoseStack poseStack;
		private final SubmitNodeCollector submitNodeCollector;
		private final CameraRenderState cameraRenderState;

		public DoRender(EntityRenderState arg0, Component content, EntityRenderer<?, ?> arg2, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState, float arg6) {
			super(arg0, arg2, arg6);
			this.content = content;
			this.poseStack = poseStack;
			this.submitNodeCollector = submitNodeCollector;
			this.cameraRenderState = cameraRenderState;
		}

		public Component getContent() {
			return this.content;
		}

		public PoseStack getPoseStack() {
			return this.poseStack;
		}

		public SubmitNodeCollector getSubmitNodeCollector() {
			return this.submitNodeCollector;
		}

		public CameraRenderState getCameraRenderState() {
			return this.cameraRenderState;
		}
	}
}
