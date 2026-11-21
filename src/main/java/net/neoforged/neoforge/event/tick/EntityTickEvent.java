package net.neoforged.neoforge.event.tick;

import net.minecraft.world.entity.Entity;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.neoforge.event.entity.EntityEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code EntityTickEvent}, with the same API.
 */
public abstract class EntityTickEvent extends EntityEvent {
	protected EntityTickEvent(Entity arg0) {
		super(arg0);
	}

	public static class Post extends net.neoforged.neoforge.event.tick.EntityTickEvent {
		public Post(Entity arg0) {
			super(arg0);
		}
	}

	public static class Pre extends net.neoforged.neoforge.event.tick.EntityTickEvent implements ICancellableEvent {
		public Pre(Entity arg0) {
			super(arg0);
		}

		public void setCanceled(boolean arg0) {
			ICancellableEvent.super.setCanceled(arg0);
		}
	}
}
