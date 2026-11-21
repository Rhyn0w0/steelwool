package net.neoforged.neoforge.fluids.crafting;

import java.util.stream.Stream;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;

/**
 * SteelWool re-implementation of NeoForge's {@code DifferenceFluidIngredient}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class DifferenceFluidIngredient extends FluidIngredient {
	public static final MapCodec<net.neoforged.neoforge.fluids.crafting.DifferenceFluidIngredient> CODEC = null /* SteelWool: TODO */;
	private final FluidIngredient base;
	private final FluidIngredient subtracted;

	public DifferenceFluidIngredient(FluidIngredient base, FluidIngredient subtracted) {
		super();
		this.base = base;
		this.subtracted = subtracted;
	}

	public Stream<Holder<Fluid>> generateFluids() {
		throw new UnsupportedOperationException("SteelWool does not implement DifferenceFluidIngredient.generateFluids yet");
	}

	public boolean test(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DifferenceFluidIngredient.test yet");
	}

	public boolean isSimple() {
		throw new UnsupportedOperationException("SteelWool does not implement DifferenceFluidIngredient.isSimple yet");
	}

	public FluidIngredientType<?> getType() {
		throw new UnsupportedOperationException("SteelWool does not implement DifferenceFluidIngredient.getType yet");
	}

	public static FluidIngredient of(FluidIngredient arg0, FluidIngredient arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DifferenceFluidIngredient.of yet");
	}

	public FluidIngredient base() {
		return this.base;
	}

	public FluidIngredient subtracted() {
		return this.subtracted;
	}

	public int hashCode() {
		throw new UnsupportedOperationException("SteelWool does not implement DifferenceFluidIngredient.hashCode yet");
	}

	public boolean equals(Object arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DifferenceFluidIngredient.equals yet");
	}
}
