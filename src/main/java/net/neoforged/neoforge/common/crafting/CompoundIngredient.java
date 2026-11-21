package net.neoforged.neoforge.common.crafting;

import java.util.List;
import java.util.stream.Stream;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.display.SlotDisplay;

/**
 * SteelWool re-implementation of NeoForge's {@code CompoundIngredient}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record CompoundIngredient(List<Ingredient> children) implements ICustomIngredient {
	public static final MapCodec<net.neoforged.neoforge.common.crafting.CompoundIngredient> CODEC = null /* SteelWool: TODO */;

	public static Ingredient of(Ingredient... arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CompoundIngredient.of yet");
	}

	public Stream<Holder<Item>> items() {
		throw new UnsupportedOperationException("SteelWool does not implement CompoundIngredient.items yet");
	}

	public boolean test(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CompoundIngredient.test yet");
	}

	public boolean isSimple() {
		throw new UnsupportedOperationException("SteelWool does not implement CompoundIngredient.isSimple yet");
	}

	public IngredientType<?> getType() {
		throw new UnsupportedOperationException("SteelWool does not implement CompoundIngredient.getType yet");
	}

	public SlotDisplay display() {
		throw new UnsupportedOperationException("SteelWool does not implement CompoundIngredient.display yet");
	}
}
