package net.neoforged.neoforge.event.entity.living;

import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code LivingKnockBackEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class LivingKnockBackEvent extends LivingEvent implements ICancellableEvent {
	protected float strength;
	protected double ratioX;
	protected double ratioZ;
	protected final float originalStrength;
	protected final double originalRatioX;
	protected final double originalRatioZ;

	public LivingKnockBackEvent(LivingEntity arg0, float arg1, double arg2, double arg3) {
		super((LivingEntity) null);
		throw new UnsupportedOperationException("SteelWool does not implement the LivingKnockBackEvent constructor yet");
	}

	public float getStrength() {
		return this.strength;
	}

	public double getRatioX() {
		return this.ratioX;
	}

	public double getRatioZ() {
		return this.ratioZ;
	}

	public float getOriginalStrength() {
		return this.originalStrength;
	}

	public double getOriginalRatioX() {
		return this.originalRatioX;
	}

	public double getOriginalRatioZ() {
		return this.originalRatioZ;
	}

	public void setStrength(float strength) {
		this.strength = strength;
	}

	public void setRatioX(double ratioX) {
		this.ratioX = ratioX;
	}

	public void setRatioZ(double ratioZ) {
		this.ratioZ = ratioZ;
	}
}
