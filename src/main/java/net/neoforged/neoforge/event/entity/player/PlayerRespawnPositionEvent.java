package net.neoforged.neoforge.event.entity.player;

import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.TeleportTransition;

/**
 * SteelWool re-implementation of NeoForge's {@code PlayerRespawnPositionEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class PlayerRespawnPositionEvent extends PlayerEvent {
	private TeleportTransition teleportTransition;
	private final TeleportTransition originalTeleportTransition;
	private final boolean fromEndFight;
	private boolean copyOriginalSpawnPosition;

	public PlayerRespawnPositionEvent(ServerPlayer arg0, TeleportTransition teleportTransition, boolean fromEndFight) {
		super((Player) null);
		throw new UnsupportedOperationException("SteelWool does not implement the PlayerRespawnPositionEvent constructor yet");
	}

	public TeleportTransition getTeleportTransition() {
		return this.teleportTransition;
	}

	public void setTeleportTransition(TeleportTransition teleportTransition) {
		this.teleportTransition = teleportTransition;
	}

	public void setRespawnLevel(ResourceKey<Level> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement PlayerRespawnPositionEvent.setRespawnLevel yet");
	}

	public TeleportTransition getOriginalTeleportTransition() {
		return this.originalTeleportTransition;
	}

	public boolean copyOriginalSpawnPosition() {
		return this.copyOriginalSpawnPosition;
	}

	public void setCopyOriginalSpawnPosition(boolean copyOriginalSpawnPosition) {
		this.copyOriginalSpawnPosition = copyOriginalSpawnPosition;
	}

	public boolean isFromEndFight() {
		return this.fromEndFight;
	}
}
