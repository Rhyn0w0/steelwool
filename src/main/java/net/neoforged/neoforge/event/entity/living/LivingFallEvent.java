package net.neoforged.neoforge.event.entity.living;

import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code LivingFallEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class LivingFallEvent extends LivingEvent implements ICancellableEvent {
	private double distance;
	private float damageMultiplier;

	public LivingFallEvent(LivingEntity arg0, double arg1, float arg2) {
		super((LivingEntity) null);
		throw new UnsupportedOperationException("SteelWool does not implement the LivingFallEvent constructor yet");
	}

	public double getDistance() {
		return this.distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public float getDamageMultiplier() {
		return this.damageMultiplier;
	}

	public void setDamageMultiplier(float damageMultiplier) {
		this.damageMultiplier = damageMultiplier;
	}
}
