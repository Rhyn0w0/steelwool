package net.neoforged.neoforge.event.level;

import java.util.function.Consumer;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRules;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code GameRuleChangedEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class GameRuleChangedEvent extends Event {
	private final MinecraftServer server;
	private final GameRule<?> gameRule;
	private final Object newValue;

	public <T extends Object> GameRuleChangedEvent(MinecraftServer server, GameRule<T> gameRule, T newValue) {
		super();
		this.server = server;
		this.gameRule = gameRule;
		this.newValue = newValue;
	}

	public MinecraftServer getServer() {
		return this.server;
	}

	public GameRules getGameRules() {
		throw new UnsupportedOperationException("SteelWool does not implement GameRuleChangedEvent.getGameRules yet");
	}

	public GameRule<?> getGameRule() {
		return this.gameRule;
	}

	public Object getNewValue() {
		return this.newValue;
	}

	public <T extends Object> void runIfMatching(GameRule<T> arg0, Consumer<T> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement GameRuleChangedEvent.runIfMatching yet");
	}
}
