package dev.steelwool.network;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import net.fabricmc.fabric.api.networking.v1.FabricServerConfigurationPacketListenerImpl;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ConfigurationTask;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.extensions.ICommonPacketListener;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.registration.NetworkRegistry;
import org.jspecify.annotations.Nullable;

/**
 * {@link IPayloadContext} for a payload received through Fabric's networking API.
 *
 * @param player       the sending or receiving player, or {@code null} in the configuration phase
 * @param executor     the receiving side's main thread
 * @param onMainThread whether the caller is on that thread
 */
public record SteelWoolPayloadContext(ICommonPacketListener listener, @Nullable Player player, PacketFlow flow,
		Executor executor, BooleanSupplier onMainThread) implements IPayloadContext {
	public static SteelWoolPayloadContext server(ICommonPacketListener listener, @Nullable Player player, MinecraftServer server) {
		return new SteelWoolPayloadContext(listener, player, PacketFlow.SERVERBOUND, server, server::isSameThread);
	}

	@Override
	public Player player() {
		if (player == null) {
			throw new UnsupportedOperationException("There is no player in the configuration phase");
		}

		return player;
	}

	@Override
	public CompletableFuture<Void> enqueueWork(Runnable task) {
		if (onMainThread.getAsBoolean()) {
			task.run();
			return CompletableFuture.completedFuture(null);
		}

		return CompletableFuture.runAsync(task, executor);
	}

	@Override
	public <T> CompletableFuture<T> enqueueWork(Supplier<T> task) {
		if (onMainThread.getAsBoolean()) {
			return CompletableFuture.completedFuture(task.get());
		}

		return CompletableFuture.supplyAsync(task, executor);
	}

	@Override
	public void handle(CustomPacketPayload payload) {
		NetworkRegistry.handlePayload(payload, this);
	}

	@Override
	public void finishCurrentTask(ConfigurationTask.Type type) {
		if (flow == PacketFlow.SERVERBOUND && listener instanceof FabricServerConfigurationPacketListenerImpl configuration) {
			configuration.completeTask(type);
		} else {
			throw new UnsupportedOperationException("finishCurrentTask is only available on the server during the configuration phase");
		}
	}
}
