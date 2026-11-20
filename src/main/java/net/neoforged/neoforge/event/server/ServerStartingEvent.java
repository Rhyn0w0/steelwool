package net.neoforged.neoforge.event.server;

import net.minecraft.server.MinecraftServer;

/**
 * Fired once the server has loaded its worlds, just before ServerStartedEvent. (Fabric: SERVER_STARTED.)
 */
public class ServerStartingEvent extends ServerLifecycleEvent {
	public ServerStartingEvent(final MinecraftServer server) {
		super(server);
	}
}
