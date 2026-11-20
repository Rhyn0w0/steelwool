package net.neoforged.neoforge.fluids;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.level.material.Fluid;

/**
 * SteelWool re-implementation of NeoForge's {@code FluidStackTemplate}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record FluidStackTemplate(Holder<Fluid> fluid, int amount, DataComponentPatch components) implements FluidInstance {
	public static final MapCodec<net.neoforged.neoforge.fluids.FluidStackTemplate> MAP_CODEC = null /* SteelWool: TODO */;
	public static final Codec<net.neoforged.neoforge.fluids.FluidStackTemplate> CODEC = null /* SteelWool: TODO */;
	public static final StreamCodec<RegistryFriendlyByteBuf, net.neoforged.neoforge.fluids.FluidStackTemplate> STREAM_CODEC = null /* SteelWool: TODO */;

	public FluidStackTemplate(Holder<Fluid> arg0, int arg1) {
		this(arg0, arg1, DataComponentPatch.EMPTY);
	}

	public FluidStackTemplate(Fluid fluid, int amount, DataComponentPatch components) {
		this(fluid.builtInRegistryHolder(), amount, components);
	}

	public FluidStackTemplate(Fluid arg0, int arg1) {
		this(arg0.builtInRegistryHolder(), arg1, DataComponentPatch.EMPTY);
	}

	public static net.neoforged.neoforge.fluids.FluidStackTemplate fromNonEmptyStack(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStackTemplate.fromNonEmptyStack yet");
	}

	public net.neoforged.neoforge.fluids.FluidStackTemplate withAmount(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStackTemplate.withAmount yet");
	}

	public FluidStack create() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStackTemplate.create yet");
	}

	public FluidStack apply(DataComponentPatch arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStackTemplate.apply yet");
	}

	public FluidStack apply(int arg0, DataComponentPatch arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStackTemplate.apply yet");
	}

	public Holder<Fluid> typeHolder() {
		return this.fluid;
	}

	public <T extends Object> T get(DataComponentType<? extends T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStackTemplate.get yet");
	}

	public static Codec<net.neoforged.neoforge.fluids.FluidStackTemplate> fixedAmountCodec(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStackTemplate.fixedAmountCodec yet");
	}

	public static StreamCodec<RegistryFriendlyByteBuf, net.neoforged.neoforge.fluids.FluidStackTemplate> fixedAmountStreamCodec(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStackTemplate.fixedAmountStreamCodec yet");
	}
}
