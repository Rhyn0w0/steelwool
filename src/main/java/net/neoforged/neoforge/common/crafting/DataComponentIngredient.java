package net.neoforged.neoforge.common.crafting;

import java.util.function.Supplier;
import java.util.stream.Stream;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.level.ItemLike;

/**
 * SteelWool re-implementation of NeoForge's {@code DataComponentIngredient}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class DataComponentIngredient implements ICustomIngredient {
	public static final MapCodec<net.neoforged.neoforge.common.crafting.DataComponentIngredient> CODEC = null /* SteelWool: TODO */;
	private final HolderSet<Item> items;
	private final DataComponentPatch components;
	private final boolean exhaustive;

	public DataComponentIngredient(HolderSet<Item> items, DataComponentPatch components, boolean exhaustive) {
		super();
		this.items = items;
		this.components = components;
		this.exhaustive = exhaustive;
	}

	public boolean test(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentIngredient.test yet");
	}

	private boolean testComponents(DataComponentGetter arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentIngredient.testComponents yet");
	}

	public Stream<Holder<Item>> items() {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentIngredient.items yet");
	}

	public boolean isSimple() {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentIngredient.isSimple yet");
	}

	public IngredientType<?> getType() {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentIngredient.getType yet");
	}

	public SlotDisplay display() {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentIngredient.display yet");
	}

	public HolderSet<Item> itemSet() {
		return this.items;
	}

	public DataComponentPatch components() {
		return this.components;
	}

	public boolean componentsExhaustive() {
		return this.exhaustive;
	}

	public static Ingredient of(boolean arg0, ItemStack arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentIngredient.of yet");
	}

	public static Ingredient of(boolean arg0, ItemStackTemplate arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentIngredient.of yet");
	}

	public static <T extends Object> Ingredient of(DataComponentType<? super T> arg0, T arg1, ItemLike... arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentIngredient.of yet");
	}

	public static <T extends Object> Ingredient of(boolean arg0, DataComponentType<? super T> arg1, T arg2, ItemLike... arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentIngredient.of yet");
	}

	public static <T extends Object> Ingredient of(boolean arg0, Supplier<? extends DataComponentType<? super T>> arg1, T arg2, ItemLike... arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentIngredient.of yet");
	}

	public static Ingredient of(boolean arg0, DataComponentMap arg1, ItemLike... arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentIngredient.of yet");
	}

	public static Ingredient of(boolean arg0, DataComponentMap arg1, Holder<Item>... arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentIngredient.of yet");
	}

	public static Ingredient of(boolean arg0, DataComponentMap arg1, HolderSet<Item> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentIngredient.of yet");
	}

	private static DataComponentPatch asPatch(DataComponentMap arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentIngredient.asPatch yet");
	}

	public static Ingredient of(boolean arg0, DataComponentPatch arg1, Holder<Item>... arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentIngredient.of yet");
	}

	public static Ingredient of(DataComponentPatch arg0, ItemLike... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentIngredient.of yet");
	}

	public static Ingredient of(boolean arg0, DataComponentPatch arg1, ItemLike... arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentIngredient.of yet");
	}

	public static Ingredient of(boolean arg0, DataComponentPatch arg1, HolderSet<Item> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentIngredient.of yet");
	}
}
