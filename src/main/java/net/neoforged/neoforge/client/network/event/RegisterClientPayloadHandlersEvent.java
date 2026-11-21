package net.neoforged.neoforge.client.network.event;

import dev.steelwool.client.SteelWoolClientNetworking;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import net.neoforged.neoforge.network.handling.MainThreadPayloadHandler;
import net.neoforged.neoforge.network.registration.HandlerThread;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterClientPayloadHandlersEvent}: client handlers
 * for payloads registered without one. Fired on the mod bus during client setup.
 */
public class RegisterClientPayloadHandlersEvent extends Event implements IModBusEvent {
	public RegisterClientPayloadHandlersEvent() {
	}

	public <T extends CustomPacketPayload> void register(CustomPacketPayload.Type<T> type, IPayloadHandler<T> handler) {
		register(type, HandlerThread.MAIN, handler);
	}

	public <T extends CustomPacketPayload> void register(CustomPacketPayload.Type<T> type, HandlerThread thread, IPayloadHandler<T> handler) {
		SteelWoolClientNetworking.registerHandler(type, thread == HandlerThread.MAIN ? new MainThreadPayloadHandler<>(handler) : handler);
	}
}
