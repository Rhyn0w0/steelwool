package net.neoforged.neoforge.common.damagesource;

import java.util.EnumMap;
import java.util.List;

import net.minecraft.world.damagesource.DamageSource;
import net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code DamageContainer}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class DamageContainer {
	private final EnumMap<net.neoforged.neoforge.common.damagesource.DamageContainer.Reduction, List<IReductionFunction>> reductionFunctions;
	private final float originalDamage;
	private final DamageSource source;
	private float newDamage;
	private final EnumMap<net.neoforged.neoforge.common.damagesource.DamageContainer.Reduction, Float> reductions;
	private float blockedDamage;
	private float shieldDamage;
	private int invulnerabilityTicksAfterAttack;
	private boolean damageSideEffects;
	private float inflictedDamage;

	public DamageContainer(DamageSource arg0, float arg1) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the DamageContainer constructor yet");
	}

	public float getOriginalDamage() {
		return this.originalDamage;
	}

	public DamageSource getSource() {
		return this.source;
	}

	public void setNewDamage(float arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DamageContainer.setNewDamage yet");
	}

	public float getNewDamage() {
		return this.newDamage;
	}

	public void addModifier(net.neoforged.neoforge.common.damagesource.DamageContainer.Reduction arg0, IReductionFunction arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DamageContainer.addModifier yet");
	}

	public float getBlockedDamage() {
		return this.blockedDamage;
	}

	public float getShieldDamage() {
		return this.shieldDamage;
	}

	public void setPostAttackInvulnerabilityTicks(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DamageContainer.setPostAttackInvulnerabilityTicks yet");
	}

	public int getPostAttackInvulnerabilityTicks() {
		return this.invulnerabilityTicksAfterAttack;
	}

	public void setShouldCauseSideEffects(boolean damageSideEffects) {
		this.damageSideEffects = damageSideEffects;
	}

	public boolean shouldCauseSideEffects() {
		return this.damageSideEffects;
	}

	public float getReduction(net.neoforged.neoforge.common.damagesource.DamageContainer.Reduction arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DamageContainer.getReduction yet");
	}

	public void setBlockedDamage(LivingShieldBlockEvent arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DamageContainer.setBlockedDamage yet");
	}

	public void setReduction(net.neoforged.neoforge.common.damagesource.DamageContainer.Reduction arg0, float arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DamageContainer.setReduction yet");
	}

	public void captureInflictedDamage() {
		throw new UnsupportedOperationException("SteelWool does not implement DamageContainer.captureInflictedDamage yet");
	}

	public float getInflictedDamage() {
		return this.inflictedDamage;
	}

	private float modifyReduction(net.neoforged.neoforge.common.damagesource.DamageContainer.Reduction arg0, float arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DamageContainer.modifyReduction yet");
	}

	public enum Reduction {
		INVULNERABILITY, ARMOR, ENCHANTMENTS, MOB_EFFECTS, ABSORPTION, INNATE_RESISTANCE;
	}
}
