package net.neoforged.neoforge.client.event;

import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.Connection;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code ClientPlayerNetworkEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class ClientPlayerNetworkEvent extends Event {
	private final MultiPlayerGameMode multiPlayerGameMode;
	private final LocalPlayer player;
	private final Connection connection;

	protected ClientPlayerNetworkEvent(MultiPlayerGameMode multiPlayerGameMode, LocalPlayer player, Connection connection) {
		super();
		this.multiPlayerGameMode = multiPlayerGameMode;
		this.player = player;
		this.connection = connection;
	}

	public MultiPlayerGameMode getMultiPlayerGameMode() {
		return this.multiPlayerGameMode;
	}

	public LocalPlayer getPlayer() {
		return this.player;
	}

	public Connection getConnection() {
		return this.connection;
	}

	public static class Clone extends net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent {
		private final LocalPlayer oldPlayer;

		public Clone(MultiPlayerGameMode arg0, LocalPlayer oldPlayer, LocalPlayer arg2, Connection arg3) {
			super(arg0, arg2, arg3);
			this.oldPlayer = oldPlayer;
		}

		public LocalPlayer getOldPlayer() {
			return this.oldPlayer;
		}

		public LocalPlayer getNewPlayer() {
			return super.getPlayer();
		}

		public LocalPlayer getPlayer() {
			return super.getPlayer();
		}
	}

	public static class LoggingIn extends net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent {
		public LoggingIn(MultiPlayerGameMode arg0, LocalPlayer arg1, Connection arg2) {
			super(arg0, arg1, arg2);
		}
	}

	public static class LoggingOut extends net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent {
		public LoggingOut(MultiPlayerGameMode arg0, LocalPlayer arg1, Connection arg2) {
			super(arg0, arg1, arg2);
		}

		public MultiPlayerGameMode getMultiPlayerGameMode() {
			return super.getMultiPlayerGameMode();
		}

		public LocalPlayer getPlayer() {
			return super.getPlayer();
		}

		public Connection getConnection() {
			return super.getConnection();
		}
	}
}
