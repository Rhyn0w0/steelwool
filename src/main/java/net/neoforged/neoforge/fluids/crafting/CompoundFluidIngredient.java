package net.neoforged.neoforge.fluids.crafting;

import java.util.List;
import java.util.stream.Stream;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;

/**
 * SteelWool re-implementation of NeoForge's {@code CompoundFluidIngredient}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class CompoundFluidIngredient extends FluidIngredient {
	public static final MapCodec<net.neoforged.neoforge.fluids.crafting.CompoundFluidIngredient> CODEC = null /* SteelWool: TODO */;
	private final List<FluidIngredient> children;

	public CompoundFluidIngredient(List<? extends FluidIngredient> arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the CompoundFluidIngredient constructor yet");
	}

	public static FluidIngredient of(FluidIngredient... arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CompoundFluidIngredient.of yet");
	}

	public static FluidIngredient of(List<FluidIngredient> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CompoundFluidIngredient.of yet");
	}

	public Stream<Holder<Fluid>> generateFluids() {
		throw new UnsupportedOperationException("SteelWool does not implement CompoundFluidIngredient.generateFluids yet");
	}

	public boolean test(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CompoundFluidIngredient.test yet");
	}

	public boolean isSimple() {
		throw new UnsupportedOperationException("SteelWool does not implement CompoundFluidIngredient.isSimple yet");
	}

	public FluidIngredientType<?> getType() {
		throw new UnsupportedOperationException("SteelWool does not implement CompoundFluidIngredient.getType yet");
	}

	public int hashCode() {
		throw new UnsupportedOperationException("SteelWool does not implement CompoundFluidIngredient.hashCode yet");
	}

	public boolean equals(Object arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CompoundFluidIngredient.equals yet");
	}

	public List<FluidIngredient> children() {
		return this.children;
	}
}
