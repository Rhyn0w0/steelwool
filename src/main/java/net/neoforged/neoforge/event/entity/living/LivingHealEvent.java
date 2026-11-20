package net.neoforged.neoforge.event.entity.living;

import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code LivingHealEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class LivingHealEvent extends LivingEvent implements ICancellableEvent {
	private float amount;

	public LivingHealEvent(LivingEntity arg0, float arg1) {
		super((LivingEntity) null);
		throw new UnsupportedOperationException("SteelWool does not implement the LivingHealEvent constructor yet");
	}

	public float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
}
