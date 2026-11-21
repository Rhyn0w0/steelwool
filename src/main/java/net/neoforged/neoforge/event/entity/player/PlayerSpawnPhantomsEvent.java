package net.neoforged.neoforge.event.entity.player;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;

/**
 * SteelWool re-implementation of NeoForge's {@code PlayerSpawnPhantomsEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class PlayerSpawnPhantomsEvent extends PlayerEvent {
	private int phantomsToSpawn;
	private net.neoforged.neoforge.event.entity.player.PlayerSpawnPhantomsEvent.Result result;

	public PlayerSpawnPhantomsEvent(Player arg0, int arg1) {
		super((Player) null);
		throw new UnsupportedOperationException("SteelWool does not implement the PlayerSpawnPhantomsEvent constructor yet");
	}

	public int getPhantomsToSpawn() {
		return this.phantomsToSpawn;
	}

	public void setPhantomsToSpawn(int phantomsToSpawn) {
		this.phantomsToSpawn = phantomsToSpawn;
	}

	public void setResult(net.neoforged.neoforge.event.entity.player.PlayerSpawnPhantomsEvent.Result result) {
		this.result = result;
	}

	public net.neoforged.neoforge.event.entity.player.PlayerSpawnPhantomsEvent.Result getResult() {
		return this.result;
	}

	public boolean shouldSpawnPhantoms(ServerLevel arg0, BlockPos arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement PlayerSpawnPhantomsEvent.shouldSpawnPhantoms yet");
	}

	public enum Result {
		ALLOW, DEFAULT, DENY;
	}
}
