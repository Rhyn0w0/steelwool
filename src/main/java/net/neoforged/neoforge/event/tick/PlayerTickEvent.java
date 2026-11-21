package net.neoforged.neoforge.event.tick;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code PlayerTickEvent}, with the same API.
 */
public abstract class PlayerTickEvent extends PlayerEvent {
	protected PlayerTickEvent(Player arg0) {
		super(arg0);
	}

	public static class Post extends net.neoforged.neoforge.event.tick.PlayerTickEvent {
		public Post(Player arg0) {
			super(arg0);
		}
	}

	public static class Pre extends net.neoforged.neoforge.event.tick.PlayerTickEvent {
		public Pre(Player arg0) {
			super(arg0);
		}
	}
}
