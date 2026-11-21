package net.neoforged.neoforge.client.event;

import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.world.level.GameType;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code ClientPlayerChangeGameTypeEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ClientPlayerChangeGameTypeEvent extends Event {
	private final PlayerInfo info;
	private final GameType currentGameType;
	private final GameType newGameType;

	public ClientPlayerChangeGameTypeEvent(PlayerInfo info, GameType currentGameType, GameType newGameType) {
		super();
		this.info = info;
		this.currentGameType = currentGameType;
		this.newGameType = newGameType;
	}

	public PlayerInfo getInfo() {
		return this.info;
	}

	public GameType getCurrentGameType() {
		return this.currentGameType;
	}

	public GameType getNewGameType() {
		return this.newGameType;
	}
}
