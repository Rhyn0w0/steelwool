package net.neoforged.neoforge.common.extensions;

import java.util.List;
import java.util.function.Consumer;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.common.ItemAbility;

/**
 * SteelWool re-implementation of NeoForge's {@code IItemExtension}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IItemExtension {
	private Item self() {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.self yet");
	}

	default ItemAttributeModifiers getDefaultAttributeModifiers(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.getDefaultAttributeModifiers yet");
	}

	default boolean onDroppedByPlayer(ItemStack arg0, Player arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.onDroppedByPlayer yet");
	}

	default Component getHighlightTip(ItemStack arg0, Component arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.getHighlightTip yet");
	}

	default InteractionResult onItemUseFirst(ItemStack arg0, UseOnContext arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.onItemUseFirst yet");
	}

	default boolean isPiglinCurrency(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.isPiglinCurrency yet");
	}

	default boolean makesPiglinsNeutral(ItemStack arg0, LivingEntity arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.makesPiglinsNeutral yet");
	}

	boolean isCombineRepairable(ItemStack arg0);

	default float getXpRepairRatio(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.getXpRepairRatio yet");
	}

	default void onStopUsing(ItemStack arg0, LivingEntity arg1, int arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.onStopUsing yet");
	}

	default boolean onLeftClickEntity(ItemStack arg0, Player arg1, Entity arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.onLeftClickEntity yet");
	}

	default void clientInventoryTick(ItemStack arg0, Level arg1, Entity arg2, EquipmentSlot arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.clientInventoryTick yet");
	}

	default ItemStackTemplate getCraftingRemainder(ItemInstance arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.getCraftingRemainder yet");
	}

	default int getEntityLifespan(ItemStack arg0, Level arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.getEntityLifespan yet");
	}

	default boolean hasCustomEntity(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.hasCustomEntity yet");
	}

	default Entity createEntity(Level arg0, Entity arg1, ItemStack arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.createEntity yet");
	}

	default boolean onEntityItemUpdate(ItemStack arg0, ItemEntity arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.onEntityItemUpdate yet");
	}

	default boolean doesSneakBypassUse(ItemStack arg0, LevelReader arg1, BlockPos arg2, Player arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.doesSneakBypassUse yet");
	}

	default boolean canEquip(ItemStack arg0, EquipmentSlot arg1, LivingEntity arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.canEquip yet");
	}

	default EquipmentSlot getEquipmentSlot(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.getEquipmentSlot yet");
	}

	default boolean onEntitySwing(ItemStack arg0, LivingEntity arg1, InteractionHand arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.onEntitySwing yet");
	}

	default int getDamage(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.getDamage yet");
	}

	default int getMaxDamage(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.getMaxDamage yet");
	}

	default boolean isDamaged(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.isDamaged yet");
	}

	default void setDamage(ItemStack arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.setDamage yet");
	}

	default boolean canPerformAction(ItemInstance arg0, ItemAbility arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.canPerformAction yet");
	}

	default int getMaxStackSize(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.getMaxStackSize yet");
	}

	default boolean isPrimaryItemFor(ItemStack arg0, Holder<Enchantment> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.isPrimaryItemFor yet");
	}

	default boolean supportsEnchantment(ItemStack arg0, Holder<Enchantment> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.supportsEnchantment yet");
	}

	default int getEnchantmentLevel(ItemInstance arg0, Holder<Enchantment> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.getEnchantmentLevel yet");
	}

	default ItemEnchantments getAllEnchantments(ItemStack arg0, HolderLookup.RegistryLookup<Enchantment> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.getAllEnchantments yet");
	}

	default boolean shouldCauseReequipAnimation(ItemStack arg0, ItemStack arg1, boolean arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.shouldCauseReequipAnimation yet");
	}

	default boolean shouldCauseBlockBreakReset(ItemStack arg0, ItemStack arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.shouldCauseBlockBreakReset yet");
	}

	default boolean canContinueUsing(ItemStack arg0, ItemStack arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.canContinueUsing yet");
	}

	default String getCreatorModId(HolderLookup.Provider arg0, ItemStack arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.getCreatorModId yet");
	}

	default void onAnimalArmorTick(ItemStack arg0, Level arg1, Mob arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.onAnimalArmorTick yet");
	}

	default <T extends LivingEntity> int damageItem(ItemStack arg0, int arg1, T arg2, Consumer<ItemStack> arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.damageItem yet");
	}

	default void onDestroyed(ItemEntity arg0, DamageSource arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.onDestroyed yet");
	}

	default boolean isGazeDisguise(ItemStack arg0, Player arg1, LivingEntity arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.isGazeDisguise yet");
	}

	default boolean canWalkOnPowderedSnow(ItemStack arg0, LivingEntity arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.canWalkOnPowderedSnow yet");
	}

	default boolean isDamageable(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.isDamageable yet");
	}

	default AABB getSweepHitBox(ItemStack arg0, Player arg1, Entity arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.getSweepHitBox yet");
	}

	default boolean isNotReplaceableByPickAction(ItemStack arg0, Player arg1, int arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.isNotReplaceableByPickAction yet");
	}

	default boolean canGrindstoneRepair(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.canGrindstoneRepair yet");
	}

	default boolean canBeHurtBy(ItemStack arg0, DamageSource arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.canBeHurtBy yet");
	}

	default ItemStack applyEnchantments(ItemStack arg0, List<EnchantmentInstance> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.applyEnchantments yet");
	}

	default boolean canFitInsideContainerItems(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.canFitInsideContainerItems yet");
	}

	default void onGlideDamage(ItemStack arg0, LivingEntity arg1, EquipmentSlot arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement IItemExtension.onGlideDamage yet");
	}
}
