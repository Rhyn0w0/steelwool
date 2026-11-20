package net.neoforged.neoforge.event.entity.living;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code MobEffectEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class MobEffectEvent extends LivingEvent {
	protected final MobEffectInstance effectInstance;

	protected MobEffectEvent(LivingEntity arg0, MobEffectInstance effectInstance) {
		super(arg0);
		this.effectInstance = effectInstance;
	}

	public MobEffectInstance getEffectInstance() {
		return this.effectInstance;
	}

	public static class Added extends net.neoforged.neoforge.event.entity.living.MobEffectEvent {
		private final MobEffectInstance oldEffectInstance;
		private final Entity source;

		public Added(LivingEntity arg0, MobEffectInstance oldEffectInstance, MobEffectInstance arg2, Entity source) {
			super(arg0, arg2);
			this.oldEffectInstance = oldEffectInstance;
			this.source = source;
		}

		public MobEffectInstance getEffectInstance() {
			return super.getEffectInstance();
		}

		public MobEffectInstance getOldEffectInstance() {
			return this.oldEffectInstance;
		}

		public Entity getEffectSource() {
			return this.source;
		}
	}

	public static class Applicable extends net.neoforged.neoforge.event.entity.living.MobEffectEvent {
		protected net.neoforged.neoforge.event.entity.living.MobEffectEvent.Applicable.Result result;
		private final Entity source;

		public Applicable(LivingEntity arg0, MobEffectInstance arg1, Entity arg2) {
			super((LivingEntity) null, (MobEffectInstance) null);
			throw new UnsupportedOperationException("SteelWool does not implement the MobEffectEvent.Applicable constructor yet");
		}

		public MobEffectInstance getEffectInstance() {
			return super.getEffectInstance();
		}

		public void setResult(net.neoforged.neoforge.event.entity.living.MobEffectEvent.Applicable.Result result) {
			this.result = result;
		}

		public net.neoforged.neoforge.event.entity.living.MobEffectEvent.Applicable.Result getResult() {
			return this.result;
		}

		public Entity getEffectSource() {
			return this.source;
		}

		public boolean getApplicationResult() {
			throw new UnsupportedOperationException("SteelWool does not implement MobEffectEvent.Applicable.getApplicationResult yet");
		}

		public enum Result {
			APPLY, DEFAULT, DO_NOT_APPLY;
		}
	}

	public static class Expired extends net.neoforged.neoforge.event.entity.living.MobEffectEvent implements ICancellableEvent {
		public Expired(LivingEntity arg0, MobEffectInstance arg1) {
			super(arg0, arg1);
		}
	}

	public static class Remove extends net.neoforged.neoforge.event.entity.living.MobEffectEvent implements ICancellableEvent {
		private final Holder<MobEffect> effect;

		public Remove(LivingEntity arg0, Holder<MobEffect> arg1) {
			super((LivingEntity) null, (MobEffectInstance) null);
			throw new UnsupportedOperationException("SteelWool does not implement the MobEffectEvent.Remove constructor yet");
		}

		public Remove(LivingEntity arg0, MobEffectInstance arg1) {
			super((LivingEntity) null, (MobEffectInstance) null);
			throw new UnsupportedOperationException("SteelWool does not implement the MobEffectEvent.Remove constructor yet");
		}

		public Holder<MobEffect> getEffect() {
			return this.effect;
		}

		public MobEffectInstance getEffectInstance() {
			return super.getEffectInstance();
		}
	}
}
