package dev.steelwool.mixin.patch;

import net.minecraft.core.HolderSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.crafting.ICustomIngredient;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * NeoForge's custom-ingredient queries on {@link Ingredient}. SteelWool does not support custom
 * ingredients yet, so every ingredient is a simple (vanilla) one.
 */
@Mixin(Ingredient.class)
public abstract class IngredientMixin {
	@Shadow
	@Final
	private HolderSet<Item> values;

	public boolean isCustom() {
		return false;
	}

	public boolean isSimple() {
		return true;
	}

	public HolderSet<Item> getValues() {
		return values;
	}

	public @Nullable ICustomIngredient getCustomIngredient() {
		return null;
	}
}
