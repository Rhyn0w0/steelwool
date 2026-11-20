package net.neoforged.neoforge.event.server;

import net.minecraft.server.MinecraftServer;

/**
 * Fired when the server begins shutting down. (Fabric: SERVER_STOPPING.)
 */
public class ServerStoppingEvent extends ServerLifecycleEvent {
	public ServerStoppingEvent(final MinecraftServer server) {
		super(server);
	}
}
