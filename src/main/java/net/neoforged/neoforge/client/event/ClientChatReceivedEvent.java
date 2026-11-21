package net.neoforged.neoforge.client.event;

import java.util.UUID;

import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.PlayerChatMessage;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code ClientChatReceivedEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ClientChatReceivedEvent extends Event implements ICancellableEvent {
	private Component message;
	private final ChatType.Bound boundChatType;
	private final UUID sender;

	public ClientChatReceivedEvent(ChatType.Bound boundChatType, Component message, UUID sender) {
		super();
		this.boundChatType = boundChatType;
		this.message = message;
		this.sender = sender;
	}

	public Component getMessage() {
		return this.message;
	}

	public void setMessage(Component message) {
		this.message = message;
	}

	public ChatType.Bound getBoundChatType() {
		return this.boundChatType;
	}

	public UUID getSender() {
		return this.sender;
	}

	public boolean isSystem() {
		throw new UnsupportedOperationException("SteelWool does not implement ClientChatReceivedEvent.isSystem yet");
	}

	public static class Player extends net.neoforged.neoforge.client.event.ClientChatReceivedEvent {
		private final PlayerChatMessage playerChatMessage;

		public Player(ChatType.Bound arg0, Component arg1, PlayerChatMessage playerChatMessage, UUID arg3) {
			super(arg0, arg1, arg3);
			this.playerChatMessage = playerChatMessage;
		}

		public PlayerChatMessage getPlayerChatMessage() {
			return this.playerChatMessage;
		}
	}

	public static class System extends net.neoforged.neoforge.client.event.ClientChatReceivedEvent {
		private final boolean overlay;

		public System(Component arg0, boolean arg1) {
			super((ChatType.Bound) null, (Component) null, (UUID) null);
			throw new UnsupportedOperationException("SteelWool does not implement the ClientChatReceivedEvent.System constructor yet");
		}

		public boolean isOverlay() {
			return this.overlay;
		}
	}
}
