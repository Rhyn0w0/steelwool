package net.neoforged.neoforge.event.tick;

import java.util.function.BooleanSupplier;

import net.minecraft.world.level.Level;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code LevelTickEvent}, with the same API.
 */
public abstract class LevelTickEvent extends Event {
	private final BooleanSupplier hasTime;
	private final Level level;

	protected LevelTickEvent(BooleanSupplier hasTime, Level level) {
		super();
		this.hasTime = hasTime;
		this.level = level;
	}

	public boolean hasTime() {
		return this.hasTime.getAsBoolean();
	}

	public Level getLevel() {
		return this.level;
	}

	public static class Post extends net.neoforged.neoforge.event.tick.LevelTickEvent {
		public Post(BooleanSupplier arg0, Level arg1) {
			super(arg0, arg1);
		}
	}

	public static class Pre extends net.neoforged.neoforge.event.tick.LevelTickEvent {
		public Pre(BooleanSupplier arg0, Level arg1) {
			super(arg0, arg1);
		}
	}
}
