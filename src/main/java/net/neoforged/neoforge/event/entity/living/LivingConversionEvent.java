package net.neoforged.neoforge.event.entity.living;

import java.util.function.Consumer;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code LivingConversionEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class LivingConversionEvent extends LivingEvent {
	public LivingConversionEvent(LivingEntity arg0) {
		super(arg0);
	}

	public static class Post extends net.neoforged.neoforge.event.entity.living.LivingConversionEvent {
		private final LivingEntity outcome;

		public Post(LivingEntity arg0, LivingEntity outcome) {
			super(arg0);
			this.outcome = outcome;
		}

		public LivingEntity getOutcome() {
			return this.outcome;
		}
	}

	public static class Pre extends net.neoforged.neoforge.event.entity.living.LivingConversionEvent implements ICancellableEvent {
		private final EntityType<? extends LivingEntity> outcome;
		private final Consumer<Integer> timer;

		public Pre(LivingEntity arg0, EntityType<? extends LivingEntity> outcome, Consumer<Integer> timer) {
			super(arg0);
			this.outcome = outcome;
			this.timer = timer;
		}

		public EntityType<? extends LivingEntity> getOutcome() {
			return this.outcome;
		}

		public void setConversionTimer(int arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement LivingConversionEvent.Pre.setConversionTimer yet");
		}
	}
}
