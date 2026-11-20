package net.neoforged.neoforge.event;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code ServerChatEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ServerChatEvent extends Event implements ICancellableEvent {
	private final ServerPlayer player;
	private final String username;
	private final String rawText;
	private Component message;

	public ServerChatEvent(ServerPlayer player, String arg1, Component arg2) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the ServerChatEvent constructor yet");
	}

	public ServerPlayer getPlayer() {
		return this.player;
	}

	public String getUsername() {
		return this.username;
	}

	public String getRawText() {
		return this.rawText;
	}

	public void setMessage(Component arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ServerChatEvent.setMessage yet");
	}

	public Component getMessage() {
		return this.message;
	}
}
