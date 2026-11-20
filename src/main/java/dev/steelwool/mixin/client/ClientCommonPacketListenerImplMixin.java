package dev.steelwool.mixin.client;

import net.fabricmc.fabric.api.client.networking.v1.ClientConfigurationNetworking;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.multiplayer.ClientCommonPacketListenerImpl;
import net.minecraft.network.Connection;
import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.ServerboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.common.extensions.ICommonPacketListener;
import net.neoforged.neoforge.network.connection.ConnectionType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * Adds NeoForge's {@link ICommonPacketListener} to client packet listeners ({@code send(Packet)} is vanilla).
 */
@Mixin(ClientCommonPacketListenerImpl.class)
public abstract class ClientCommonPacketListenerImplMixin implements ICommonPacketListener {
	@Shadow
	@Final
	protected Connection connection;

	@Override
	public void send(CustomPacketPayload payload) {
		send(new ServerboundCustomPayloadPacket(payload));
	}

	@Override
	public void disconnect(Component reason) {
		connection.disconnect(reason);
	}

	@Override
	public Connection getConnection() {
		return connection;
	}

	@Override
	public boolean hasChannel(Identifier payloadId) {
		return protocol() == ConnectionProtocol.PLAY ? ClientPlayNetworking.canSend(payloadId) : ClientConfigurationNetworking.canSend(payloadId);
	}

	@Override
	public ConnectionType getConnectionType() {
		return ConnectionType.OTHER;
	}
}
