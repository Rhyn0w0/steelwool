package net.neoforged.neoforge.client.network;

import java.util.Objects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.protocol.common.ServerboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

/**
 * SteelWool re-implementation of NeoForge's {@code ClientPacketDistributor}.
 */
public final class ClientPacketDistributor {
	private ClientPacketDistributor() {
	}

	public static void sendToServer(CustomPacketPayload payload, CustomPacketPayload... payloads) {
		ClientPacketListener listener = Objects.requireNonNull(Minecraft.getInstance().getConnection());
		listener.send(new ServerboundCustomPayloadPacket(Objects.requireNonNull(payload, "Cannot send null payload")));

		for (CustomPacketPayload other : payloads) {
			listener.send(new ServerboundCustomPayloadPacket(Objects.requireNonNull(other, "Cannot send null payload")));
		}
	}
}
