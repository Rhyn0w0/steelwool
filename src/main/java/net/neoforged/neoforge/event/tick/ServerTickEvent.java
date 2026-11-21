package net.neoforged.neoforge.event.tick;

import java.util.function.BooleanSupplier;

import net.minecraft.server.MinecraftServer;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code ServerTickEvent}, with the same API.
 */
public abstract class ServerTickEvent extends Event {
	private final BooleanSupplier hasTime;
	private final MinecraftServer server;

	protected ServerTickEvent(BooleanSupplier hasTime, MinecraftServer server) {
		super();
		this.hasTime = hasTime;
		this.server = server;
	}

	public boolean hasTime() {
		return this.hasTime.getAsBoolean();
	}

	public MinecraftServer getServer() {
		return this.server;
	}

	public static class Post extends net.neoforged.neoforge.event.tick.ServerTickEvent {
		public Post(BooleanSupplier arg0, MinecraftServer arg1) {
			super(arg0, arg1);
		}
	}

	public static class Pre extends net.neoforged.neoforge.event.tick.ServerTickEvent {
		public Pre(BooleanSupplier arg0, MinecraftServer arg1) {
			super(arg0, arg1);
		}
	}
}
