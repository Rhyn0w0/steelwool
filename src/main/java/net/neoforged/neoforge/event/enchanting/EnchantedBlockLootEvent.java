package net.neoforged.neoforge.event.enchanting;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.event.level.BlockEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code EnchantedBlockLootEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class EnchantedBlockLootEvent extends BlockEvent {
	private final ItemInstance tool;
	private final Holder<Enchantment> enchantment;
	private int enchantmentLevel;
	private final Entity entity;

	public EnchantedBlockLootEvent(ServerLevel arg0, BlockPos arg1, BlockState arg2, ItemInstance tool, Holder<Enchantment> enchantment, int enchantmentLevel, Entity entity) {
		super(arg0, arg1, arg2);
		this.tool = tool;
		this.enchantment = enchantment;
		this.enchantmentLevel = enchantmentLevel;
		this.entity = entity;
	}

	public ItemInstance getTool() {
		return this.tool;
	}

	public Holder<Enchantment> getEnchantment() {
		return this.enchantment;
	}

	public int getEnchantmentLevel() {
		return this.enchantmentLevel;
	}

	public void setEnchantmentLevel(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement EnchantedBlockLootEvent.setEnchantmentLevel yet");
	}

	public Entity getEntity() {
		return this.entity;
	}
}
