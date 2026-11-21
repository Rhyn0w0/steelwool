package net.neoforged.neoforge.network.handling;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import net.minecraft.network.Connection;
import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.network.ConfigurationTask;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.extensions.ICommonPacketListener;

/**
 * SteelWool re-implementation of NeoForge's {@code IPayloadContext}: the context a payload handler runs in.
 *
 * <p>Not supported: {@code handle(Packet)} and {@code channelHandlerContext()}.
 */
public interface IPayloadContext {
	ICommonPacketListener listener();

	default Connection connection() {
		return listener().getConnection();
	}

	Player player();

	default void reply(CustomPacketPayload payload) {
		listener().send(payload);
	}

	default void disconnect(Component reason) {
		listener().disconnect(reason);
	}

	CompletableFuture<Void> enqueueWork(Runnable task);

	<T> CompletableFuture<T> enqueueWork(Supplier<T> task);

	PacketFlow flow();

	default ConnectionProtocol protocol() {
		return listener().protocol();
	}

	void handle(CustomPacketPayload payload);

	void finishCurrentTask(ConfigurationTask.Type type);
}
