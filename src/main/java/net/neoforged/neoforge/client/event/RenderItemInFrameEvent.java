package net.neoforged.neoforge.client.event;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.ItemFrameRenderer;
import net.minecraft.client.renderer.entity.state.ItemFrameRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RenderItemInFrameEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RenderItemInFrameEvent extends Event implements ICancellableEvent {
	private final ItemStackRenderState itemStack;
	private final ItemFrameRenderState frameRenderState;
	private final ItemFrameRenderer<?> renderer;
	private final PoseStack poseStack;
	private final SubmitNodeCollector submitNodeCollector;

	public RenderItemInFrameEvent(ItemFrameRenderState arg0, ItemFrameRenderer<?> arg1, PoseStack arg2, SubmitNodeCollector arg3) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the RenderItemInFrameEvent constructor yet");
	}

	public ItemStackRenderState getItemStackRenderState() {
		return this.itemStack;
	}

	public ItemFrameRenderState getItemFrameRenderState() {
		return this.frameRenderState;
	}

	public ItemFrameRenderer<?> getRenderer() {
		return this.renderer;
	}

	public PoseStack getPoseStack() {
		return this.poseStack;
	}

	public SubmitNodeCollector getSubmitNodeCollector() {
		return this.submitNodeCollector;
	}
}
