package net.neoforged.neoforge.common.extensions;

import net.minecraft.network.Connection;
import net.minecraft.network.PacketListener;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.network.connection.ConnectionType;

/**
 * SteelWool re-implementation of NeoForge's {@code ICommonPacketListener}, which NeoForge adds to the
 * vanilla client and server packet listeners. SteelWool adds it with mixins.
 *
 * <p>Not supported: {@code getPacketProcessor()}.
 */
public interface ICommonPacketListener extends PacketListener {
	void send(Packet<?> packet);

	void send(CustomPacketPayload payload);

	void disconnect(Component reason);

	Connection getConnection();

	boolean hasChannel(Identifier payloadId);

	default boolean hasChannel(CustomPacketPayload.Type<?> type) {
		return hasChannel(type.id());
	}

	default boolean hasChannel(CustomPacketPayload payload) {
		return hasChannel(payload.type());
	}

	/** Always {@link ConnectionType#OTHER}: SteelWool does not speak NeoForge's channel negotiation. */
	ConnectionType getConnectionType();
}
