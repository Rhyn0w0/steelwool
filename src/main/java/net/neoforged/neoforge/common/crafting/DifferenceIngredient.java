package net.neoforged.neoforge.common.crafting;

import java.util.stream.Stream;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * SteelWool re-implementation of NeoForge's {@code DifferenceIngredient}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record DifferenceIngredient(Ingredient base, Ingredient subtracted) implements ICustomIngredient {
	public static final MapCodec<net.neoforged.neoforge.common.crafting.DifferenceIngredient> CODEC = null /* SteelWool: TODO */;

	public Stream<Holder<Item>> items() {
		throw new UnsupportedOperationException("SteelWool does not implement DifferenceIngredient.items yet");
	}

	public boolean test(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DifferenceIngredient.test yet");
	}

	public boolean isSimple() {
		throw new UnsupportedOperationException("SteelWool does not implement DifferenceIngredient.isSimple yet");
	}

	public IngredientType<?> getType() {
		throw new UnsupportedOperationException("SteelWool does not implement DifferenceIngredient.getType yet");
	}

	public static Ingredient of(Ingredient arg0, Ingredient arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DifferenceIngredient.of yet");
	}
}
