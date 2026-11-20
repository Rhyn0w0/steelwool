package net.neoforged.neoforge.client.event;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.state.level.PlayerRenderState;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RenderHandEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RenderHandEvent extends Event implements ICancellableEvent {
	private final InteractionHand hand;
	private final PoseStack poseStack;
	private final SubmitNodeCollector submitNodeCollector;
	private final PlayerRenderState playerState;
	private final float partialTick;
	private final float interpolatedPitch;
	private final float swingProgress;
	private final float equipProgress;
	private final ItemStack stack;

	public RenderHandEvent(InteractionHand hand, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, PlayerRenderState playerState, float partialTick, float interpolatedPitch, float swingProgress, float equipProgress, ItemStack stack) {
		super();
		this.hand = hand;
		this.poseStack = poseStack;
		this.submitNodeCollector = submitNodeCollector;
		this.playerState = playerState;
		this.partialTick = partialTick;
		this.interpolatedPitch = interpolatedPitch;
		this.swingProgress = swingProgress;
		this.equipProgress = equipProgress;
		this.stack = stack;
	}

	public InteractionHand getHand() {
		return this.hand;
	}

	public PoseStack getPoseStack() {
		return this.poseStack;
	}

	public SubmitNodeCollector getSubmitNodeCollector() {
		return this.submitNodeCollector;
	}

	public PlayerRenderState getPlayerState() {
		return this.playerState;
	}

	public int getPackedLight() {
		throw new UnsupportedOperationException("SteelWool does not implement RenderHandEvent.getPackedLight yet");
	}

	public float getPartialTick() {
		return this.partialTick;
	}

	public float getInterpolatedPitch() {
		return this.interpolatedPitch;
	}

	public float getSwingProgress() {
		return this.swingProgress;
	}

	public float getEquipProgress() {
		return this.equipProgress;
	}

	public ItemStack getItemStack() {
		return this.stack;
	}
}
