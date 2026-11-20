package net.neoforged.neoforge.fluids;

import java.util.function.Predicate;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponentHolder;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

/**
 * SteelWool re-implementation of NeoForge's {@code SimpleFluidContent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class SimpleFluidContent implements DataComponentHolder {
	public static final net.neoforged.neoforge.fluids.SimpleFluidContent EMPTY = null /* SteelWool: TODO */;
	public static final Codec<net.neoforged.neoforge.fluids.SimpleFluidContent> CODEC = null /* SteelWool: TODO */;
	public static final StreamCodec<RegistryFriendlyByteBuf, net.neoforged.neoforge.fluids.SimpleFluidContent> STREAM_CODEC = null /* SteelWool: TODO */;
	private final FluidStack fluidStack;

	private SimpleFluidContent(FluidStack fluidStack) {
		super();
		this.fluidStack = fluidStack;
	}

	public static net.neoforged.neoforge.fluids.SimpleFluidContent copyOf(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidContent.copyOf yet");
	}

	public FluidStack copy() {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidContent.copy yet");
	}

	public boolean isEmpty() {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidContent.isEmpty yet");
	}

	public Fluid getFluid() {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidContent.getFluid yet");
	}

	public Holder<Fluid> getFluidHolder() {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidContent.getFluidHolder yet");
	}

	public boolean is(TagKey<Fluid> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidContent.is yet");
	}

	public boolean is(Fluid arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidContent.is yet");
	}

	public boolean is(Predicate<Holder<Fluid>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidContent.is yet");
	}

	public boolean is(Holder<Fluid> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidContent.is yet");
	}

	public boolean is(HolderSet<Fluid> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidContent.is yet");
	}

	public int getAmount() {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidContent.getAmount yet");
	}

	public FluidType getFluidType() {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidContent.getFluidType yet");
	}

	public boolean is(FluidType arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidContent.is yet");
	}

	public boolean matches(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidContent.matches yet");
	}

	public boolean isSameFluid(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidContent.isSameFluid yet");
	}

	public boolean isSameFluidSameComponents(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidContent.isSameFluidSameComponents yet");
	}

	public boolean isSameFluidSameComponents(net.neoforged.neoforge.fluids.SimpleFluidContent arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidContent.isSameFluidSameComponents yet");
	}

	public DataComponentMap getComponents() {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidContent.getComponents yet");
	}

	public boolean equals(Object arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidContent.equals yet");
	}

	public int hashCode() {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleFluidContent.hashCode yet");
	}
}
