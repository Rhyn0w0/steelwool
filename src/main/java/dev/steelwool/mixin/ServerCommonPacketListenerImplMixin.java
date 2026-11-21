package dev.steelwool.mixin;

import net.minecraft.network.Connection;
import net.minecraft.network.protocol.common.ClientboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.network.ServerCommonPacketListenerImpl;
import net.neoforged.neoforge.common.extensions.ICommonPacketListener;
import net.neoforged.neoforge.network.connection.ConnectionType;
import net.neoforged.neoforge.network.registration.NetworkRegistry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * Adds NeoForge's {@link ICommonPacketListener} to server packet listeners ({@code send(Packet)} and
 * {@code disconnect(Component)} are vanilla methods).
 */
@Mixin(ServerCommonPacketListenerImpl.class)
public abstract class ServerCommonPacketListenerImplMixin implements ICommonPacketListener {
	@Shadow
	@Final
	protected Connection connection;

	@Override
	public void send(CustomPacketPayload payload) {
		send(new ClientboundCustomPayloadPacket(payload));
	}

	@Override
	public Connection getConnection() {
		return connection;
	}

	@Override
	public boolean hasChannel(Identifier payloadId) {
		return NetworkRegistry.steelwool$serverHasChannel(this, payloadId);
	}

	@Override
	public ConnectionType getConnectionType() {
		return ConnectionType.OTHER;
	}
}
