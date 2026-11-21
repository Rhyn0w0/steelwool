package net.neoforged.neoforge.event.entity.living;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

/**
 * SteelWool re-implementation of NeoForge's {@code LivingGetProjectileEvent}, with the same API.
 */
public class LivingGetProjectileEvent extends LivingEvent {
	private final ItemStack projectileWeaponItemStack;
	private ItemStack projectileItemStack;

	public LivingGetProjectileEvent(LivingEntity arg0, ItemStack projectileWeaponItemStack, ItemStack projectileItemStack) {
		super(arg0);
		this.projectileWeaponItemStack = projectileWeaponItemStack;
		this.projectileItemStack = projectileItemStack;
	}

	public ItemStack getProjectileWeaponItemStack() {
		return this.projectileWeaponItemStack;
	}

	public ItemStack getProjectileItemStack() {
		return this.projectileItemStack;
	}

	public void setProjectileItemStack(ItemStack projectileItemStack) {
		this.projectileItemStack = projectileItemStack;
	}
}
