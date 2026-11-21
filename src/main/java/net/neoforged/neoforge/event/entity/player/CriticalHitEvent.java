package net.neoforged.neoforge.event.entity.player;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

/**
 * SteelWool re-implementation of NeoForge's {@code CriticalHitEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class CriticalHitEvent extends PlayerEvent {
	private final Entity target;
	private final float vanillaDmgMultiplier;
	private final boolean isVanillaCritical;
	private float dmgMultiplier;
	private boolean isCriticalHit;
	private boolean disableSweep;

	public CriticalHitEvent(Player arg0, Entity target, float arg2, boolean arg3) {
		super((Player) null);
		throw new UnsupportedOperationException("SteelWool does not implement the CriticalHitEvent constructor yet");
	}

	public Entity getTarget() {
		return this.target;
	}

	public float getDamageMultiplier() {
		return this.dmgMultiplier;
	}

	public void setDamageMultiplier(float arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CriticalHitEvent.setDamageMultiplier yet");
	}

	public boolean isCriticalHit() {
		return this.isCriticalHit;
	}

	public void setCriticalHit(boolean isCriticalHit) {
		this.isCriticalHit = isCriticalHit;
	}

	public float getVanillaMultiplier() {
		return this.vanillaDmgMultiplier;
	}

	public boolean isVanillaCritical() {
		return this.isVanillaCritical;
	}

	public void setDisableSweep(boolean disableSweep) {
		this.disableSweep = disableSweep;
	}

	public boolean disableSweep() {
		return this.disableSweep;
	}
}
