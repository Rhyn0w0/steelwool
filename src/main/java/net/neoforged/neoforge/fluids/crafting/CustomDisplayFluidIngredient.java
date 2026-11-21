package net.neoforged.neoforge.fluids.crafting;

import java.util.stream.Stream;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;

/**
 * SteelWool re-implementation of NeoForge's {@code CustomDisplayFluidIngredient}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class CustomDisplayFluidIngredient extends FluidIngredient {
	public static final MapCodec<net.neoforged.neoforge.fluids.crafting.CustomDisplayFluidIngredient> CODEC = null /* SteelWool: TODO */;
	public static final StreamCodec<RegistryFriendlyByteBuf, net.neoforged.neoforge.fluids.crafting.CustomDisplayFluidIngredient> STREAM_CODEC = null /* SteelWool: TODO */;
	private final FluidIngredient base;
	private final SlotDisplay display;

	public CustomDisplayFluidIngredient(FluidIngredient base, SlotDisplay display) {
		super();
		this.base = base;
		this.display = display;
	}

	public static FluidIngredient of(FluidIngredient arg0, SlotDisplay arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CustomDisplayFluidIngredient.of yet");
	}

	public boolean test(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CustomDisplayFluidIngredient.test yet");
	}

	public Stream<Holder<Fluid>> generateFluids() {
		throw new UnsupportedOperationException("SteelWool does not implement CustomDisplayFluidIngredient.generateFluids yet");
	}

	public boolean isSimple() {
		throw new UnsupportedOperationException("SteelWool does not implement CustomDisplayFluidIngredient.isSimple yet");
	}

	public FluidIngredientType<?> getType() {
		throw new UnsupportedOperationException("SteelWool does not implement CustomDisplayFluidIngredient.getType yet");
	}

	public FluidIngredient base() {
		return this.base;
	}

	public SlotDisplay display() {
		return this.display;
	}

	public boolean equals(Object arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CustomDisplayFluidIngredient.equals yet");
	}

	public int hashCode() {
		throw new UnsupportedOperationException("SteelWool does not implement CustomDisplayFluidIngredient.hashCode yet");
	}

	public String toString() {
		throw new UnsupportedOperationException("SteelWool does not implement CustomDisplayFluidIngredient.toString yet");
	}
}
