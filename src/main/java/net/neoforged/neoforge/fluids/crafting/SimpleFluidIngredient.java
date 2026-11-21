package net.neoforged.neoforge.fluids.crafting;

import java.util.stream.Stream;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;

/**
 * SteelWool re-implementation of NeoForge's {@code SimpleFluidIngredient}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class SimpleFluidIngredient extends FluidIngredient {
	private static final Codec<HolderSet<Fluid>> HOLDER_SET_NO_EMPTY_FLUID = null /* SteelWool: TODO */;
	static final Codec<net.neoforged.neoforge.fluids.crafting.SimpleFluidIngredient> CODEC = null /* SteelWool: TODO */;
	static final StreamCodec<RegistryFriendlyByteBuf, net.neoforged.neoforge.fluids.crafting.SimpleFluidIngredient> CONTENTS_STREAM_CODEC = null /* SteelWool: TODO */;
	private final HolderSet<Fluid> values;

	public SimpleFluidIngredient(HolderSet<Fluid> arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the SimpleFluidIngredient constructor yet");
	}

	public boolean test(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidIngredient.test yet");
	}

	protected Stream<Holder<Fluid>> generateFluids() {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidIngredient.generateFluids yet");
	}

	public boolean isSimple() {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidIngredient.isSimple yet");
	}

	public FluidIngredientType<?> getType() {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidIngredient.getType yet");
	}

	public SlotDisplay display() {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidIngredient.display yet");
	}

	public int hashCode() {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidIngredient.hashCode yet");
	}

	public boolean equals(Object arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidIngredient.equals yet");
	}

	public HolderSet<Fluid> fluidSet() {
		return this.values;
	}
}
