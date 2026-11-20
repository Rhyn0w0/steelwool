package net.neoforged.neoforge.client.event;

import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code ClientResourceLoadFinishedEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ClientResourceLoadFinishedEvent extends Event {
	private final boolean initial;

	public ClientResourceLoadFinishedEvent(boolean initial) {
		super();
		this.initial = initial;
	}

	public boolean isInitial() {
		return this.initial;
	}
}
