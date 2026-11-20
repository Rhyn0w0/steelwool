package net.neoforged.neoforge.event.server;

import net.minecraft.server.MinecraftServer;

/**
 * Fired once the server has started. (Fabric: SERVER_STARTED.)
 */
public class ServerStartedEvent extends ServerLifecycleEvent {
	public ServerStartedEvent(final MinecraftServer server) {
		super(server);
	}
}
