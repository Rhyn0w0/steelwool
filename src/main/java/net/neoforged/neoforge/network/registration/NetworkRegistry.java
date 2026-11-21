package net.neoforged.neoforge.network.registration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerConfigurationNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.network.ServerConfigurationPacketListenerImpl;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import dev.steelwool.network.SteelWoolPayloadContext;
import net.neoforged.neoforge.common.extensions.ICommonPacketListener;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SteelWool re-implementation of NeoForge's {@code NetworkRegistry}. Payload types are registered with
 * Fabric's {@link PayloadTypeRegistry} and their server handlers as Fabric global receivers; client
 * handlers are registered by SteelWool's client entrypoint.
 */
public class NetworkRegistry {
	private static final Logger LOGGER = LoggerFactory.getLogger("SteelWool/Network");
	private static final List<Registration<?>> REGISTRATIONS = new ArrayList<>();
	private static final Map<Identifier, Registration<?>> BY_ID = new ConcurrentHashMap<>();
	private static final Map<Identifier, IPayloadHandler<?>> CLIENT_HANDLERS = new ConcurrentHashMap<>();

	protected NetworkRegistry() {
	}

	/**
	 * A registered payload.
	 *
	 * @param flow empty for bidirectional payloads
	 */
	public record Registration<T extends CustomPacketPayload>(
			CustomPacketPayload.Type<T> type,
			StreamCodec<?, T> codec,
			@Nullable IPayloadHandler<T> serverHandler,
			@Nullable IPayloadHandler<T> clientHandler,
			List<ConnectionProtocol> protocols,
			Optional<PacketFlow> flow,
			String version,
			boolean optional) {
		public boolean toClient() {
			return flow.isEmpty() || flow.get() == PacketFlow.CLIENTBOUND;
		}

		public boolean toServer() {
			return flow.isEmpty() || flow.get() == PacketFlow.SERVERBOUND;
		}
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public static <T extends CustomPacketPayload> void register(CustomPacketPayload.Type<T> type, StreamCodec<?, T> codec,
			@Nullable IPayloadHandler<T> serverHandler, @Nullable IPayloadHandler<T> clientHandler,
			List<ConnectionProtocol> protocols, Optional<PacketFlow> flow, String version, boolean optional) {
		Registration<T> registration = new Registration<>(type, codec, serverHandler, clientHandler, protocols, flow, version, optional);

		if (BY_ID.putIfAbsent(type.id(), registration) != null) {
			throw new IllegalStateException("Payload " + type.id() + " is already registered");
		}

		REGISTRATIONS.add(registration);

		for (ConnectionProtocol protocol : protocols) {
			boolean play = protocol == ConnectionProtocol.PLAY;

			if (registration.toClient()) {
				PayloadTypeRegistry registry = play ? PayloadTypeRegistry.clientboundPlay() : PayloadTypeRegistry.clientboundConfiguration();
				registry.register(type, (StreamCodec) codec);
			}

			if (registration.toServer()) {
				PayloadTypeRegistry registry = play ? PayloadTypeRegistry.serverboundPlay() : PayloadTypeRegistry.serverboundConfiguration();
				registry.register(type, (StreamCodec) codec);

				if (serverHandler != null) {
					if (play) {
						ServerPlayNetworking.registerGlobalReceiver(type, (payload, context) -> handle(serverHandler, payload,
								SteelWoolPayloadContext.server((ICommonPacketListener) context.player().connection, context.player(), context.server())));
					} else {
						ServerConfigurationNetworking.registerGlobalReceiver(type, (payload, context) -> handle(serverHandler, payload,
								SteelWoolPayloadContext.server((ICommonPacketListener) context.packetListener(), null, context.server())));
					}
				}
			}
		}
	}

	/** Every payload registered so far, in registration order; not part of the NeoForge API. */
	public static List<Registration<?>> steelwool$registrations() {
		return List.copyOf(REGISTRATIONS);
	}

	/** Runs a handler, logging (instead of disconnecting on) exceptions. */
	public static <T extends CustomPacketPayload> void handle(IPayloadHandler<T> handler, T payload, IPayloadContext context) {
		try {
			handler.handle(payload, context);
		} catch (RuntimeException e) {
			LOGGER.error("Failed to handle payload {}", payload.type().id(), e);
		}
	}

	/** Dispatches a payload to the handler registered for its type on the receiving side of {@code context}. */
	@SuppressWarnings("unchecked")
	public static <T extends CustomPacketPayload> void handlePayload(CustomPacketPayload payload, IPayloadContext context) {
		Registration<T> registration = (Registration<T>) BY_ID.get(payload.type().id());

		if (registration == null) {
			throw new IllegalArgumentException("Payload " + payload.type().id() + " is not registered");
		}

		IPayloadHandler<T> handler = context.flow() == PacketFlow.SERVERBOUND ? registration.serverHandler() : steelwool$clientHandler(registration);

		if (handler != null) {
			handle(handler, (T) payload, context);
		}
	}

	/** Sets the client handler of a payload registered without one; not part of the NeoForge API. */
	public static void steelwool$setClientHandler(Identifier id, IPayloadHandler<?> handler) {
		CLIENT_HANDLERS.put(id, handler);
	}

	/** The client handler of a payload: the registered one, else one from {@code RegisterClientPayloadHandlersEvent}. */
	@SuppressWarnings("unchecked")
	public static <T extends CustomPacketPayload> @Nullable IPayloadHandler<T> steelwool$clientHandler(Registration<T> registration) {
		return registration.clientHandler() != null ? registration.clientHandler() : (IPayloadHandler<T>) CLIENT_HANDLERS.get(registration.type().id());
	}

	public static boolean hasChannel(ICommonPacketListener listener, Identifier payloadId) {
		return listener.hasChannel(payloadId);
	}

	/** Server-side check used by the packet listener mixin; not part of the NeoForge API. */
	public static boolean steelwool$serverHasChannel(Object listener, Identifier payloadId) {
		if (listener instanceof ServerGamePacketListenerImpl game) {
			return ServerPlayNetworking.canSend(game, payloadId);
		}

		if (listener instanceof ServerConfigurationPacketListenerImpl configuration) {
			return ServerConfigurationNetworking.canSend(configuration, payloadId);
		}

		return false;
	}
}
