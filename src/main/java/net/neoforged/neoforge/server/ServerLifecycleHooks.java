package net.neoforged.neoforge.server;

import org.jspecify.annotations.Nullable;

import net.minecraft.server.MinecraftServer;

/**
 * SteelWool subset of NeoForge's {@code ServerLifecycleHooks}: the running server.
 */
public class ServerLifecycleHooks {
	private static volatile @Nullable MinecraftServer currentServer;

	private ServerLifecycleHooks() {
	}

	public static @Nullable MinecraftServer getCurrentServer() {
		return currentServer;
	}

	/** Called by SteelWool's event bridge; not part of the NeoForge API. */
	public static void steelwool$setCurrentServer(@Nullable MinecraftServer server) {
		currentServer = server;
	}
}
