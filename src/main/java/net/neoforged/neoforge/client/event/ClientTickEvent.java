package net.neoforged.neoforge.client.event;

import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code ClientTickEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class ClientTickEvent extends Event {
	public ClientTickEvent() {
		super();
	}

	public static class Post extends net.neoforged.neoforge.client.event.ClientTickEvent {
		public Post() {
			super();
		}
	}

	public static class Pre extends net.neoforged.neoforge.client.event.ClientTickEvent {
		public Pre() {
			super();
		}
	}
}
