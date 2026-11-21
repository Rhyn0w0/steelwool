package net.neoforged.neoforge.event.enchanting;

import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.event.entity.living.LivingEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code EnchantedEntityLootEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class EnchantedEntityLootEvent extends LivingEvent {
	private final DamageSource damageSource;
	private final Holder<Enchantment> enchantment;
	private int enchantmentLevel;

	public EnchantedEntityLootEvent(LivingEntity arg0, DamageSource damageSource, Holder<Enchantment> enchantment, int enchantmentLevel) {
		super(arg0);
		this.damageSource = damageSource;
		this.enchantment = enchantment;
		this.enchantmentLevel = enchantmentLevel;
	}

	public LivingEntity getEntity() {
		return super.getEntity();
	}

	public DamageSource getDamageSource() {
		return this.damageSource;
	}

	public Holder<Enchantment> getEnchantment() {
		return this.enchantment;
	}

	public int getEnchantmentLevel() {
		return this.enchantmentLevel;
	}

	public void setEnchantmentLevel(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement EnchantedEntityLootEvent.setEnchantmentLevel yet");
	}

	public Entity getAttacker() {
		throw new UnsupportedOperationException("SteelWool does not implement EnchantedEntityLootEvent.getAttacker yet");
	}
}
