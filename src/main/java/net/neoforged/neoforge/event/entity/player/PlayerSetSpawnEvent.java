package net.neoforged.neoforge.event.entity.player;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code PlayerSetSpawnEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class PlayerSetSpawnEvent extends PlayerEvent implements ICancellableEvent {
	private final ResourceKey<Level> spawnLevel;
	private final boolean forced;
	private final BlockPos newSpawn;

	public PlayerSetSpawnEvent(Player arg0, ServerPlayer.RespawnConfig arg1) {
		super((Player) null);
		throw new UnsupportedOperationException("SteelWool does not implement the PlayerSetSpawnEvent constructor yet");
	}

	public boolean isForced() {
		return this.forced;
	}

	public BlockPos getNewSpawn() {
		return this.newSpawn;
	}

	public ResourceKey<Level> getSpawnLevel() {
		return this.spawnLevel;
	}
}
