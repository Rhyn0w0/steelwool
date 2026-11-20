package net.neoforged.neoforge.event.entity.living;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.neoforge.common.damagesource.DamageContainer;
import net.neoforged.neoforge.common.damagesource.IReductionFunction;

/**
 * SteelWool re-implementation of NeoForge's {@code LivingIncomingDamageEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class LivingIncomingDamageEvent extends LivingEvent implements ICancellableEvent {
	private final DamageContainer container;

	public LivingIncomingDamageEvent(LivingEntity arg0, DamageContainer container) {
		super(arg0);
		this.container = container;
	}

	public DamageContainer getContainer() {
		return this.container;
	}

	public DamageSource getSource() {
		throw new UnsupportedOperationException("SteelWool does not implement LivingIncomingDamageEvent.getSource yet");
	}

	public float getAmount() {
		throw new UnsupportedOperationException("SteelWool does not implement LivingIncomingDamageEvent.getAmount yet");
	}

	public float getOriginalAmount() {
		throw new UnsupportedOperationException("SteelWool does not implement LivingIncomingDamageEvent.getOriginalAmount yet");
	}

	public void setAmount(float arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement LivingIncomingDamageEvent.setAmount yet");
	}

	public void addReductionModifier(DamageContainer.Reduction arg0, IReductionFunction arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LivingIncomingDamageEvent.addReductionModifier yet");
	}

	public void setInvulnerabilityTicks(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement LivingIncomingDamageEvent.setInvulnerabilityTicks yet");
	}
}
