package net.neoforged.neoforge.event.entity.living;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.common.damagesource.DamageContainer;

/**
 * SteelWool re-implementation of NeoForge's {@code LivingShieldBlockEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class LivingShieldBlockEvent extends LivingEvent {
	private final DamageContainer container;
	private float dmgBlocked;
	private final float originalDmgBlocked;
	private int shieldDamage;
	private final boolean originalBlocked;
	private boolean newBlocked;

	public LivingShieldBlockEvent(LivingEntity arg0, DamageContainer container, float dmgBlocked, boolean arg3) {
		super((LivingEntity) null);
		throw new UnsupportedOperationException("SteelWool does not implement the LivingShieldBlockEvent constructor yet");
	}

	public DamageContainer getDamageContainer() {
		return this.container;
	}

	public DamageSource getDamageSource() {
		throw new UnsupportedOperationException("SteelWool does not implement LivingShieldBlockEvent.getDamageSource yet");
	}

	public float getOriginalBlockedDamage() {
		return this.originalDmgBlocked;
	}

	public float getBlockedDamage() {
		throw new UnsupportedOperationException("SteelWool does not implement LivingShieldBlockEvent.getBlockedDamage yet");
	}

	public int shieldDamage() {
		throw new UnsupportedOperationException("SteelWool does not implement LivingShieldBlockEvent.shieldDamage yet");
	}

	public void setBlockedDamage(float arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement LivingShieldBlockEvent.setBlockedDamage yet");
	}

	public void setShieldDamage(int shieldDamage) {
		this.shieldDamage = shieldDamage;
	}

	public boolean getOriginalBlock() {
		return this.originalBlocked;
	}

	public boolean getBlocked() {
		return this.newBlocked;
	}

	public void setBlocked(boolean newBlocked) {
		this.newBlocked = newBlocked;
	}
}
