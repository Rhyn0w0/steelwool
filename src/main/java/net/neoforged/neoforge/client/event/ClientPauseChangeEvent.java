package net.neoforged.neoforge.client.event;

import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code ClientPauseChangeEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class ClientPauseChangeEvent extends Event {
	private final boolean pause;

	public ClientPauseChangeEvent(boolean pause) {
		super();
		this.pause = pause;
	}

	public boolean isPaused() {
		return this.pause;
	}

	public static class Post extends net.neoforged.neoforge.client.event.ClientPauseChangeEvent {
		public Post(boolean arg0) {
			super(arg0);
		}
	}

	public static class Pre extends net.neoforged.neoforge.client.event.ClientPauseChangeEvent implements ICancellableEvent {
		public Pre(boolean arg0) {
			super(arg0);
		}
	}
}
