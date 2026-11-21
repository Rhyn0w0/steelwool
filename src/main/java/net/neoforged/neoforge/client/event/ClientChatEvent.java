package net.neoforged.neoforge.client.event;

import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code ClientChatEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ClientChatEvent extends Event implements ICancellableEvent {
	private String message;
	private final String originalMessage;

	public ClientChatEvent(String arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the ClientChatEvent constructor yet");
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientChatEvent.setMessage yet");
	}

	public String getOriginalMessage() {
		return this.originalMessage;
	}
}
