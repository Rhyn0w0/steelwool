package net.neoforged.neoforge.event.server;

import net.minecraft.server.MinecraftServer;

/**
 * Fired before the server loads its worlds. (Fabric: SERVER_STARTING.)
 */
public class ServerAboutToStartEvent extends ServerLifecycleEvent {
	public ServerAboutToStartEvent(final MinecraftServer server) {
		super(server);
	}
}
