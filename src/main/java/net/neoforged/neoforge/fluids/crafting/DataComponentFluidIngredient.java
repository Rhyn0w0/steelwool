package net.neoforged.neoforge.fluids.crafting;

import java.util.function.Supplier;
import java.util.stream.Stream;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponentExactPredicate;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidStackTemplate;

/**
 * SteelWool re-implementation of NeoForge's {@code DataComponentFluidIngredient}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class DataComponentFluidIngredient extends FluidIngredient {
	public static final MapCodec<net.neoforged.neoforge.fluids.crafting.DataComponentFluidIngredient> CODEC = null /* SteelWool: TODO */;
	private final HolderSet<Fluid> fluids;
	private final DataComponentExactPredicate components;
	private final boolean strict;
	private final FluidStackTemplate[] templates;

	public DataComponentFluidIngredient(HolderSet<Fluid> fluids, DataComponentExactPredicate components, boolean strict) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the DataComponentFluidIngredient constructor yet");
	}

	public boolean test(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentFluidIngredient.test yet");
	}

	public Stream<Holder<Fluid>> generateFluids() {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentFluidIngredient.generateFluids yet");
	}

	public SlotDisplay display() {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentFluidIngredient.display yet");
	}

	public boolean isSimple() {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentFluidIngredient.isSimple yet");
	}

	public FluidIngredientType<?> getType() {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentFluidIngredient.getType yet");
	}

	public int hashCode() {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentFluidIngredient.hashCode yet");
	}

	public boolean equals(Object arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentFluidIngredient.equals yet");
	}

	public HolderSet<Fluid> fluidSet() {
		return this.fluids;
	}

	public DataComponentExactPredicate components() {
		return this.components;
	}

	public boolean isStrict() {
		return this.strict;
	}

	public static FluidIngredient of(boolean arg0, FluidStack arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentFluidIngredient.of yet");
	}

	public static <T extends Object> FluidIngredient of(boolean arg0, DataComponentType<? super T> arg1, T arg2, Fluid... arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentFluidIngredient.of yet");
	}

	public static <T extends Object> FluidIngredient of(boolean arg0, Supplier<? extends DataComponentType<? super T>> arg1, T arg2, Fluid... arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentFluidIngredient.of yet");
	}

	public static FluidIngredient of(boolean arg0, DataComponentMap arg1, Fluid... arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentFluidIngredient.of yet");
	}

	public static FluidIngredient of(boolean arg0, DataComponentMap arg1, Holder<Fluid>... arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentFluidIngredient.of yet");
	}

	public static FluidIngredient of(boolean arg0, DataComponentMap arg1, HolderSet<Fluid> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentFluidIngredient.of yet");
	}

	public static FluidIngredient of(boolean arg0, DataComponentExactPredicate arg1, Holder<Fluid>... arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentFluidIngredient.of yet");
	}

	public static FluidIngredient of(boolean arg0, DataComponentExactPredicate arg1, Fluid... arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentFluidIngredient.of yet");
	}

	public static FluidIngredient of(boolean arg0, DataComponentExactPredicate arg1, HolderSet<Fluid> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentFluidIngredient.of yet");
	}
}
