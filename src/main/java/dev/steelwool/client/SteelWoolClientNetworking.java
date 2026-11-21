package dev.steelwool.client;

import dev.steelwool.network.SteelWoolPayloadContext;
import net.fabricmc.fabric.api.client.networking.v1.ClientConfigurationNetworking;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.common.extensions.ICommonPacketListener;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import net.neoforged.neoforge.network.registration.NetworkRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Registers the client handlers of NeoForge mods' payloads as Fabric client receivers.
 */
public final class SteelWoolClientNetworking {
	private static final Logger LOGGER = LoggerFactory.getLogger("SteelWool/Network");

	private SteelWoolClientNetworking() {
	}

	public static <T extends CustomPacketPayload> void registerHandler(CustomPacketPayload.Type<T> type, IPayloadHandler<T> handler) {
		NetworkRegistry.steelwool$setClientHandler(type.id(), handler);
	}

	/** Called once client payload handlers are known (after {@code RegisterClientPayloadHandlersEvent}). */
	public static void registerReceivers() {
		for (NetworkRegistry.Registration<?> registration : NetworkRegistry.steelwool$registrations()) {
			if (registration.toClient()) {
				registerReceiver(registration);
			}
		}
	}

	private static <T extends CustomPacketPayload> void registerReceiver(NetworkRegistry.Registration<T> registration) {
		IPayloadHandler<T> handler = NetworkRegistry.steelwool$clientHandler(registration);

		if (handler == null) {
			LOGGER.warn("Payload {} has no client handler; it will be ignored on the client", registration.type().id());
			return;
		}

		Minecraft minecraft = Minecraft.getInstance();

		for (ConnectionProtocol protocol : registration.protocols()) {
			if (protocol == ConnectionProtocol.PLAY) {
				ClientPlayNetworking.registerGlobalReceiver(registration.type(), (payload, context) -> NetworkRegistry.handle(handler, payload,
						new SteelWoolPayloadContext((ICommonPacketListener) context.player().connection, context.player(), PacketFlow.CLIENTBOUND, minecraft, minecraft::isSameThread)));
			} else {
				ClientConfigurationNetworking.registerGlobalReceiver(registration.type(), (payload, context) -> NetworkRegistry.handle(handler, payload,
						new SteelWoolPayloadContext((ICommonPacketListener) context.packetListener(), null, PacketFlow.CLIENTBOUND, minecraft, minecraft::isSameThread)));
			}
		}
	}
}
