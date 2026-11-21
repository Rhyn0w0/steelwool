package net.neoforged.neoforge.network.handling;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

/**
 * SteelWool re-implementation of NeoForge's {@code IPayloadHandler}.
 */
@FunctionalInterface
public interface IPayloadHandler<T extends CustomPacketPayload> {
	void handle(T payload, IPayloadContext context);
}
