package net.neoforged.neoforge.event.server;

import net.minecraft.server.MinecraftServer;

/**
 * Fired after the server has shut down. (Fabric: SERVER_STOPPED.)
 */
public class ServerStoppedEvent extends ServerLifecycleEvent {
	public ServerStoppedEvent(final MinecraftServer server) {
		super(server);
	}
}
