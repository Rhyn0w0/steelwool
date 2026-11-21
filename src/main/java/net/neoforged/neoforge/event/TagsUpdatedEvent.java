package net.neoforged.neoforge.event;

import net.minecraft.core.RegistryAccess;
import net.minecraft.server.ReloadableServerResources;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code TagsUpdatedEvent}, with the same API.
 */
public class TagsUpdatedEvent extends Event {
	private final RegistryAccess registries;

	protected TagsUpdatedEvent(RegistryAccess registries) {
		super();
		this.registries = registries;
	}

	public RegistryAccess getRegistries() {
		return this.registries;
	}

	public boolean shouldUpdateStaticData() {
		return true;
	}

	public static final class ClientPacketReceived extends net.neoforged.neoforge.event.TagsUpdatedEvent {
		private final boolean integratedServer;

		public ClientPacketReceived(RegistryAccess arg0, boolean integratedServer) {
			super(arg0);
			this.integratedServer = integratedServer;
		}

		public boolean shouldUpdateStaticData() {
			return !integratedServer;
		}
	}

	public static final class ServerDataLoad extends net.neoforged.neoforge.event.TagsUpdatedEvent {
		private final ReloadableServerResources serverResources;

		public ServerDataLoad(ReloadableServerResources serverResources, RegistryAccess arg1) {
			super(arg1);
			this.serverResources = serverResources;
		}

		public ReloadableServerResources getServerResources() {
			return this.serverResources;
		}
	}
}
