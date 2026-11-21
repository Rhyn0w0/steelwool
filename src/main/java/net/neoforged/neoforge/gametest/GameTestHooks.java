package net.neoforged.neoforge.gametest;

/**
 * SteelWool re-implementation of NeoForge's {@code GameTestHooks}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class GameTestHooks {
	public GameTestHooks() {
		super();
	}

	public static boolean isGametestEnabled() {
		throw new UnsupportedOperationException("SteelWool does not implement GameTestHooks.isGametestEnabled yet");
	}
}
