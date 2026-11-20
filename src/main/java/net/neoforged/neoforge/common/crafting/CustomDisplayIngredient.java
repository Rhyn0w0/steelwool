package net.neoforged.neoforge.common.crafting;

import java.util.stream.Stream;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.display.SlotDisplay;

/**
 * SteelWool re-implementation of NeoForge's {@code CustomDisplayIngredient}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record CustomDisplayIngredient(Ingredient base, SlotDisplay display) implements ICustomIngredient {
	public static final MapCodec<net.neoforged.neoforge.common.crafting.CustomDisplayIngredient> CODEC = null /* SteelWool: TODO */;

	public static Ingredient of(Ingredient arg0, SlotDisplay arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CustomDisplayIngredient.of yet");
	}

	public boolean test(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CustomDisplayIngredient.test yet");
	}

	public Stream<Holder<Item>> items() {
		throw new UnsupportedOperationException("SteelWool does not implement CustomDisplayIngredient.items yet");
	}

	public boolean isSimple() {
		throw new UnsupportedOperationException("SteelWool does not implement CustomDisplayIngredient.isSimple yet");
	}

	public IngredientType<?> getType() {
		throw new UnsupportedOperationException("SteelWool does not implement CustomDisplayIngredient.getType yet");
	}
}
