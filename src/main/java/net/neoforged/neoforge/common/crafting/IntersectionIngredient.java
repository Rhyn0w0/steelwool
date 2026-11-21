package net.neoforged.neoforge.common.crafting;

import java.util.List;
import java.util.stream.Stream;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * SteelWool re-implementation of NeoForge's {@code IntersectionIngredient}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record IntersectionIngredient(List<Ingredient> children) implements ICustomIngredient {
	public static final MapCodec<net.neoforged.neoforge.common.crafting.IntersectionIngredient> CODEC = null /* SteelWool: TODO */;

	public static Ingredient of(Ingredient... arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IntersectionIngredient.of yet");
	}

	public boolean test(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IntersectionIngredient.test yet");
	}

	public Stream<Holder<Item>> items() {
		throw new UnsupportedOperationException("SteelWool does not implement IntersectionIngredient.items yet");
	}

	public boolean isSimple() {
		throw new UnsupportedOperationException("SteelWool does not implement IntersectionIngredient.isSimple yet");
	}

	public IngredientType<?> getType() {
		throw new UnsupportedOperationException("SteelWool does not implement IntersectionIngredient.getType yet");
	}
}
