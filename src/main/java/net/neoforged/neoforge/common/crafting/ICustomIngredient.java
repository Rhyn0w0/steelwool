package net.neoforged.neoforge.common.crafting;

import java.util.stream.Stream;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.display.SlotDisplay;

/**
 * SteelWool re-implementation of NeoForge's {@code ICustomIngredient}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface ICustomIngredient {
	boolean test(ItemStack arg0);

	Stream<Holder<Item>> items();

	boolean isSimple();

	IngredientType<?> getType();

	default SlotDisplay display() {
		throw new UnsupportedOperationException("SteelWool does not implement ICustomIngredient.display yet");
	}

	default Ingredient toVanilla() {
		throw new UnsupportedOperationException("SteelWool does not implement ICustomIngredient.toVanilla yet");
	}
}
