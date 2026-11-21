package net.neoforged.neoforge.network.registration;

import java.util.List;
import java.util.Optional;

import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import net.neoforged.neoforge.network.handling.MainThreadPayloadHandler;
import org.jspecify.annotations.Nullable;

/**
 * SteelWool re-implementation of NeoForge's {@code PayloadRegistrar}: registers payload types and handlers
 * with Fabric's networking API. Versions and {@link #optional()} are accepted but not negotiated.
 */
public class PayloadRegistrar {
	private static final List<ConnectionProtocol> PLAY = List.of(ConnectionProtocol.PLAY);
	private static final List<ConnectionProtocol> CONFIGURATION = List.of(ConnectionProtocol.CONFIGURATION);
	private static final List<ConnectionProtocol> COMMON = List.of(ConnectionProtocol.PLAY, ConnectionProtocol.CONFIGURATION);

	private String version;
	private boolean optional;
	private HandlerThread thread = HandlerThread.MAIN;

	public PayloadRegistrar(String version) {
		this.version = version;
	}

	private PayloadRegistrar(PayloadRegistrar source) {
		this.version = source.version;
		this.optional = source.optional;
		this.thread = source.thread;
	}

	public <T extends CustomPacketPayload> PayloadRegistrar playToClient(CustomPacketPayload.Type<T> type, StreamCodec<? super RegistryFriendlyByteBuf, T> codec, IPayloadHandler<T> handler) {
		register(type, codec, null, handler, PLAY, Optional.of(PacketFlow.CLIENTBOUND));
		return this;
	}

	public <T extends CustomPacketPayload> PayloadRegistrar playToClient(CustomPacketPayload.Type<T> type, StreamCodec<? super RegistryFriendlyByteBuf, T> codec) {
		register(type, codec, null, null, PLAY, Optional.of(PacketFlow.CLIENTBOUND));
		return this;
	}

	public <T extends CustomPacketPayload> PayloadRegistrar playToServer(CustomPacketPayload.Type<T> type, StreamCodec<? super RegistryFriendlyByteBuf, T> codec, IPayloadHandler<T> handler) {
		register(type, codec, handler, null, PLAY, Optional.of(PacketFlow.SERVERBOUND));
		return this;
	}

	public <T extends CustomPacketPayload> PayloadRegistrar playBidirectional(CustomPacketPayload.Type<T> type, StreamCodec<? super RegistryFriendlyByteBuf, T> codec, IPayloadHandler<T> serverHandler, @Nullable IPayloadHandler<T> clientHandler) {
		register(type, codec, serverHandler, clientHandler, PLAY, Optional.empty());
		return this;
	}

	public <T extends CustomPacketPayload> PayloadRegistrar playBidirectional(CustomPacketPayload.Type<T> type, StreamCodec<? super RegistryFriendlyByteBuf, T> codec, IPayloadHandler<T> serverHandler) {
		return playBidirectional(type, codec, serverHandler, null);
	}

	public <T extends CustomPacketPayload> PayloadRegistrar configurationToClient(CustomPacketPayload.Type<T> type, StreamCodec<? super FriendlyByteBuf, T> codec, IPayloadHandler<T> handler) {
		register(type, codec, null, handler, CONFIGURATION, Optional.of(PacketFlow.CLIENTBOUND));
		return this;
	}

	public <T extends CustomPacketPayload> PayloadRegistrar configurationToClient(CustomPacketPayload.Type<T> type, StreamCodec<? super FriendlyByteBuf, T> codec) {
		register(type, codec, null, null, CONFIGURATION, Optional.of(PacketFlow.CLIENTBOUND));
		return this;
	}

	public <T extends CustomPacketPayload> PayloadRegistrar configurationToServer(CustomPacketPayload.Type<T> type, StreamCodec<? super FriendlyByteBuf, T> codec, IPayloadHandler<T> handler) {
		register(type, codec, handler, null, CONFIGURATION, Optional.of(PacketFlow.SERVERBOUND));
		return this;
	}

	public <T extends CustomPacketPayload> PayloadRegistrar configurationBidirectional(CustomPacketPayload.Type<T> type, StreamCodec<? super FriendlyByteBuf, T> codec, IPayloadHandler<T> serverHandler, @Nullable IPayloadHandler<T> clientHandler) {
		register(type, codec, serverHandler, clientHandler, CONFIGURATION, Optional.empty());
		return this;
	}

	public <T extends CustomPacketPayload> PayloadRegistrar configurationBidirectional(CustomPacketPayload.Type<T> type, StreamCodec<? super FriendlyByteBuf, T> codec, IPayloadHandler<T> serverHandler) {
		return configurationBidirectional(type, codec, serverHandler, null);
	}

	public <T extends CustomPacketPayload> PayloadRegistrar commonToClient(CustomPacketPayload.Type<T> type, StreamCodec<? super FriendlyByteBuf, T> codec, IPayloadHandler<T> handler) {
		register(type, codec, null, handler, COMMON, Optional.of(PacketFlow.CLIENTBOUND));
		return this;
	}

	public <T extends CustomPacketPayload> PayloadRegistrar commonToClient(CustomPacketPayload.Type<T> type, StreamCodec<? super FriendlyByteBuf, T> codec) {
		register(type, codec, null, null, COMMON, Optional.of(PacketFlow.CLIENTBOUND));
		return this;
	}

	public <T extends CustomPacketPayload> PayloadRegistrar commonToServer(CustomPacketPayload.Type<T> type, StreamCodec<? super FriendlyByteBuf, T> codec, IPayloadHandler<T> handler) {
		register(type, codec, handler, null, COMMON, Optional.of(PacketFlow.SERVERBOUND));
		return this;
	}

	public <T extends CustomPacketPayload> PayloadRegistrar commonBidirectional(CustomPacketPayload.Type<T> type, StreamCodec<? super FriendlyByteBuf, T> codec, IPayloadHandler<T> serverHandler, @Nullable IPayloadHandler<T> clientHandler) {
		register(type, codec, serverHandler, clientHandler, COMMON, Optional.empty());
		return this;
	}

	public <T extends CustomPacketPayload> PayloadRegistrar commonBidirectional(CustomPacketPayload.Type<T> type, StreamCodec<? super FriendlyByteBuf, T> codec, IPayloadHandler<T> serverHandler) {
		return commonBidirectional(type, codec, serverHandler, null);
	}

	public PayloadRegistrar executesOn(HandlerThread thread) {
		PayloadRegistrar clone = new PayloadRegistrar(this);
		clone.thread = thread;
		return clone;
	}

	public PayloadRegistrar versioned(String version) {
		PayloadRegistrar clone = new PayloadRegistrar(this);
		clone.version = version;
		return clone;
	}

	public PayloadRegistrar optional() {
		PayloadRegistrar clone = new PayloadRegistrar(this);
		clone.optional = true;
		return clone;
	}

	private <T extends CustomPacketPayload> void register(CustomPacketPayload.Type<T> type, StreamCodec<?, T> codec,
			@Nullable IPayloadHandler<T> serverHandler, @Nullable IPayloadHandler<T> clientHandler,
			List<ConnectionProtocol> protocols, Optional<PacketFlow> flow) {
		if (thread == HandlerThread.MAIN) {
			if (serverHandler != null) {
				serverHandler = new MainThreadPayloadHandler<>(serverHandler);
			}

			if (clientHandler != null) {
				clientHandler = new MainThreadPayloadHandler<>(clientHandler);
			}
		}

		NetworkRegistry.register(type, codec, serverHandler, clientHandler, protocols, flow, version, optional);
	}
}
