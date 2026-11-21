package net.neoforged.neoforge.event.entity.living;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

/**
 * SteelWool re-implementation of NeoForge's {@code LivingEquipmentChangeEvent}, with the same API.
 */
public class LivingEquipmentChangeEvent extends LivingEvent {
	private final EquipmentSlot slot;
	private final ItemStack from;
	private final ItemStack to;

	public LivingEquipmentChangeEvent(LivingEntity arg0, EquipmentSlot slot, ItemStack from, ItemStack to) {
		super(arg0);
		this.slot = slot;
		this.from = from;
		this.to = to;
	}

	public EquipmentSlot getSlot() {
		return this.slot;
	}

	public ItemStack getFrom() {
		return this.from;
	}

	public ItemStack getTo() {
		return this.to;
	}
}
