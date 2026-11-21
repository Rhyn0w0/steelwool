package net.neoforged.neoforge.event.entity.living;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code LivingDeathEvent}, with the same API.
 */
public class LivingDeathEvent extends LivingEvent implements ICancellableEvent {
	private final DamageSource source;

	public LivingDeathEvent(LivingEntity arg0, DamageSource source) {
		super(arg0);
		this.source = source;
	}

	public DamageSource getSource() {
		return this.source;
	}
}
