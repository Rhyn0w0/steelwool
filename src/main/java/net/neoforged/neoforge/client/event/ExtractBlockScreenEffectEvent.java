package net.neoforged.neoforge.client.event;

import net.minecraft.client.Camera;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.state.level.PlayerRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.neoforge.client.CustomBlockScreenEffectRenderer;

/**
 * SteelWool re-implementation of NeoForge's {@code ExtractBlockScreenEffectEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ExtractBlockScreenEffectEvent extends Event implements ICancellableEvent {
	private final LocalPlayer player;
	private final PlayerRenderState playerRenderState;
	private final BlockPos pos;
	private final BlockState state;
	private final Camera camera;
	private final float worldPartialTick;
	private final float playerPartialTick;
	private final net.neoforged.neoforge.client.event.ExtractBlockScreenEffectEvent.OverlayType overlayType;

	public ExtractBlockScreenEffectEvent(LocalPlayer player, PlayerRenderState playerRenderState, BlockPos pos, BlockState state, Camera camera, float worldPartialTick, float playerPartialTick, net.neoforged.neoforge.client.event.ExtractBlockScreenEffectEvent.OverlayType overlayType) {
		super();
		this.player = player;
		this.playerRenderState = playerRenderState;
		this.pos = pos;
		this.state = state;
		this.camera = camera;
		this.worldPartialTick = worldPartialTick;
		this.playerPartialTick = playerPartialTick;
		this.overlayType = overlayType;
	}

	public LocalPlayer getPlayer() {
		return this.player;
	}

	public PlayerRenderState getPlayerRenderState() {
		return this.playerRenderState;
	}

	public BlockPos getPos() {
		return this.pos;
	}

	public BlockState getState() {
		return this.state;
	}

	public Camera getCamera() {
		return this.camera;
	}

	public float getWorldPartialTick() {
		return this.worldPartialTick;
	}

	public float getPlayerPartialTick() {
		return this.playerPartialTick;
	}

	public net.neoforged.neoforge.client.event.ExtractBlockScreenEffectEvent.OverlayType getOverlayType() {
		return this.overlayType;
	}

	public void setCustomRenderer(CustomBlockScreenEffectRenderer arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ExtractBlockScreenEffectEvent.setCustomRenderer yet");
	}

	public void setCanceled(boolean arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ExtractBlockScreenEffectEvent.setCanceled yet");
	}

	public enum OverlayType {
		FIRE, BLOCK, WATER;
	}
}
