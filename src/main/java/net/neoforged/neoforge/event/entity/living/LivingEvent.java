package net.neoforged.neoforge.event.entity.living;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.EntityEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code LivingEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class LivingEvent extends EntityEvent {
	private final LivingEntity livingEntity;

	public LivingEvent(LivingEntity livingEntity) {
		super(livingEntity);
		this.livingEntity = livingEntity;
	}

	public LivingEntity getEntity() {
		return this.livingEntity;
	}

	public static class LivingJumpEvent extends net.neoforged.neoforge.event.entity.living.LivingEvent {
		public LivingJumpEvent(LivingEntity arg0) {
			super(arg0);
		}
	}

	public static class LivingVisibilityEvent extends net.neoforged.neoforge.event.entity.living.LivingEvent {
		private double visibilityModifier;
		private final Entity lookingEntity;

		public LivingVisibilityEvent(LivingEntity arg0, Entity lookingEntity, double visibilityModifier) {
			super(arg0);
			this.visibilityModifier = visibilityModifier;
			this.lookingEntity = lookingEntity;
		}

		public void modifyVisibility(double arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement LivingEvent.LivingVisibilityEvent.modifyVisibility yet");
		}

		public double getVisibilityModifier() {
			return this.visibilityModifier;
		}

		public Entity getLookingEntity() {
			return this.lookingEntity;
		}
	}
}
