package net.neoforged.neoforge.network.handling;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

/**
 * SteelWool re-implementation of NeoForge's {@code MainThreadPayloadHandler}: runs a handler on the main thread.
 */
public record MainThreadPayloadHandler<T extends CustomPacketPayload>(IPayloadHandler<T> handler) implements IPayloadHandler<T> {
	@Override
	public void handle(T payload, IPayloadContext context) {
		context.enqueueWork(() -> handler.handle(payload, context));
	}
}
