package net.neoforged.neoforge.fluids.crafting;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
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
 * SteelWool re-implementation of NeoForge's {@code FluidIngredient}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class FluidIngredient extends Object implements Predicate<FluidStack> {
	public static final Codec<net.neoforged.neoforge.fluids.crafting.FluidIngredient> CODEC = null /* SteelWool: TODO */;
	public static final StreamCodec<RegistryFriendlyByteBuf, net.neoforged.neoforge.fluids.crafting.FluidIngredient> STREAM_CODEC = null /* SteelWool: TODO */;
	public static final StreamCodec<RegistryFriendlyByteBuf, Optional<net.neoforged.neoforge.fluids.crafting.FluidIngredient>> OPTIONAL_STREAM_CODEC = null /* SteelWool: TODO */;
	private List<Holder<Fluid>> fluids;

	public FluidIngredient() {
		super();
	}

	public final List<Holder<Fluid>> fluids() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidIngredient.fluids yet");
	}

	public abstract boolean test(FluidStack arg0);

	protected abstract Stream<Holder<Fluid>> generateFluids();

	public SlotDisplay display() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidIngredient.display yet");
	}

	public abstract boolean isSimple();

	public abstract FluidIngredientType<?> getType();

	public abstract int hashCode();

	public abstract boolean equals(Object arg0);

	public static SlotDisplay displayForSingleFluid(Holder<Fluid> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidIngredient.displayForSingleFluid yet");
	}

	public static net.neoforged.neoforge.fluids.crafting.FluidIngredient of(FluidStack... arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidIngredient.of yet");
	}

	public static net.neoforged.neoforge.fluids.crafting.FluidIngredient of(Fluid... arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidIngredient.of yet");
	}

	public static net.neoforged.neoforge.fluids.crafting.FluidIngredient of(Stream<Fluid> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidIngredient.of yet");
	}

	public static net.neoforged.neoforge.fluids.crafting.FluidIngredient of(HolderSet<Fluid> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidIngredient.of yet");
	}
}
