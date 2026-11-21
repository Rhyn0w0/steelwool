package net.neoforged.neoforge.client.event.lifecycle;

import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code ClientLifecycleEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class ClientLifecycleEvent extends Event {
	protected final Minecraft client;

	public ClientLifecycleEvent(Minecraft client) {
		super();
		this.client = client;
	}

	public Minecraft getClient() {
		return this.client;
	}
}
