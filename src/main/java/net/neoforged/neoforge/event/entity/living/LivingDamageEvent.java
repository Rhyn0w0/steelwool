package net.neoforged.neoforge.event.entity.living;

import java.util.EnumMap;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.common.damagesource.DamageContainer;

/**
 * SteelWool re-implementation of NeoForge's {@code LivingDamageEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class LivingDamageEvent extends LivingEvent {
	private LivingDamageEvent(LivingEntity arg0) {
		super(arg0);
	}

	public static class Post extends net.neoforged.neoforge.event.entity.living.LivingDamageEvent {
		private final float originalDamage;
		private final DamageSource source;
		private final float inflictedDamage;
		private final float healthDamage;
		private final float blockedDamage;
		private final float shieldDamage;
		private final int postAttackInvulnerabilityTicks;
		private final boolean performSideEffects;
		private final EnumMap<DamageContainer.Reduction, Float> reductions;

		public Post(LivingEntity arg0, DamageContainer arg1) {
			super((LivingEntity) null);
			throw new UnsupportedOperationException("SteelWool does not implement the LivingDamageEvent.Post constructor yet");
		}

		public boolean shouldCauseSideEffects() {
			return this.performSideEffects;
		}

		public float getOriginalDamage() {
			return this.originalDamage;
		}

		public DamageSource getSource() {
			return this.source;
		}

		public float getInflictedDamage() {
			return this.inflictedDamage;
		}

		public float getHealthDamage() {
			return this.healthDamage;
		}

		public float getBlockedDamage() {
			return this.blockedDamage;
		}

		public float getShieldDamage() {
			return this.shieldDamage;
		}

		public int getPostAttackInvulnerabilityTicks() {
			return this.postAttackInvulnerabilityTicks;
		}

		public float getReduction(DamageContainer.Reduction arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement LivingDamageEvent.Post.getReduction yet");
		}
	}

	public static class Pre extends net.neoforged.neoforge.event.entity.living.LivingDamageEvent {
		private final DamageContainer container;

		public Pre(LivingEntity arg0, DamageContainer container) {
			super(arg0);
			this.container = container;
		}

		public DamageContainer getContainer() {
			return this.container;
		}

		public DamageSource getSource() {
			throw new UnsupportedOperationException("SteelWool does not implement LivingDamageEvent.Pre.getSource yet");
		}

		public float getNewDamage() {
			throw new UnsupportedOperationException("SteelWool does not implement LivingDamageEvent.Pre.getNewDamage yet");
		}

		public float getOriginalDamage() {
			throw new UnsupportedOperationException("SteelWool does not implement LivingDamageEvent.Pre.getOriginalDamage yet");
		}

		public void setNewDamage(float arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement LivingDamageEvent.Pre.setNewDamage yet");
		}
	}
}
