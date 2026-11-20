package net.neoforged.neoforge.fluids.crafting;

import java.util.List;
import java.util.stream.Stream;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;

/**
 * SteelWool re-implementation of NeoForge's {@code IntersectionFluidIngredient}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class IntersectionFluidIngredient extends FluidIngredient {
	public static final MapCodec<net.neoforged.neoforge.fluids.crafting.IntersectionFluidIngredient> CODEC = null /* SteelWool: TODO */;
	private final List<FluidIngredient> children;

	public IntersectionFluidIngredient(List<FluidIngredient> arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the IntersectionFluidIngredient constructor yet");
	}

	public static FluidIngredient of(FluidIngredient... arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IntersectionFluidIngredient.of yet");
	}

	public boolean test(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IntersectionFluidIngredient.test yet");
	}

	public Stream<Holder<Fluid>> generateFluids() {
		throw new UnsupportedOperationException("SteelWool does not implement IntersectionFluidIngredient.generateFluids yet");
	}

	public boolean isSimple() {
		throw new UnsupportedOperationException("SteelWool does not implement IntersectionFluidIngredient.isSimple yet");
	}

	public FluidIngredientType<?> getType() {
		throw new UnsupportedOperationException("SteelWool does not implement IntersectionFluidIngredient.getType yet");
	}

	public List<FluidIngredient> children() {
		return this.children;
	}

	public int hashCode() {
		throw new UnsupportedOperationException("SteelWool does not implement IntersectionFluidIngredient.hashCode yet");
	}

	public boolean equals(Object arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IntersectionFluidIngredient.equals yet");
	}
}
