package net.neoforged.neoforge.transfer.fluid;

import java.util.function.Predicate;
import java.util.function.Supplier;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidStackTemplate;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.transfer.resource.DataComponentHolderResource;

/**
 * SteelWool re-implementation of NeoForge's {@code FluidResource}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class FluidResource extends Object implements DataComponentHolderResource<Fluid> {
	public static final net.neoforged.neoforge.transfer.fluid.FluidResource EMPTY = null /* SteelWool: TODO */;
	public static final Codec<net.neoforged.neoforge.transfer.fluid.FluidResource> CODEC = null /* SteelWool: TODO */;
	public static final Codec<net.neoforged.neoforge.transfer.fluid.FluidResource> OPTIONAL_CODEC = null /* SteelWool: TODO */;
	public static final StreamCodec<RegistryFriendlyByteBuf, net.neoforged.neoforge.transfer.fluid.FluidResource> STREAM_CODEC = null /* SteelWool: TODO */;
	private final FluidStack innerStack;

	public static net.neoforged.neoforge.transfer.fluid.FluidResource of(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.of yet");
	}

	public static net.neoforged.neoforge.transfer.fluid.FluidResource of(FluidStackTemplate arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.of yet");
	}

	public static net.neoforged.neoforge.transfer.fluid.FluidResource of(Fluid arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.of yet");
	}

	public static net.neoforged.neoforge.transfer.fluid.FluidResource of(Fluid arg0, DataComponentPatch arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.of yet");
	}

	public static net.neoforged.neoforge.transfer.fluid.FluidResource of(Holder<Fluid> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.of yet");
	}

	public static net.neoforged.neoforge.transfer.fluid.FluidResource of(Holder<Fluid> arg0, DataComponentPatch arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.of yet");
	}

	private FluidResource(FluidStack innerStack) {
		super();
		this.innerStack = innerStack;
	}

	public Fluid value() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.value yet");
	}

	public Fluid getFluid() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.getFluid yet");
	}

	public Holder<Fluid> typeHolder() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.typeHolder yet");
	}

	public FluidType getFluidType() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.getFluidType yet");
	}

	public boolean isEmpty() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.isEmpty yet");
	}

	public net.neoforged.neoforge.transfer.fluid.FluidResource withMergedPatch(DataComponentPatch arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.withMergedPatch yet");
	}

	public <D extends Object> net.neoforged.neoforge.transfer.fluid.FluidResource with(DataComponentType<D> arg0, D arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.with yet");
	}

	public <D extends Object> net.neoforged.neoforge.transfer.fluid.FluidResource with(Supplier<? extends DataComponentType<D>> arg0, D arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.with yet");
	}

	public net.neoforged.neoforge.transfer.fluid.FluidResource without(DataComponentType<?> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.without yet");
	}

	public net.neoforged.neoforge.transfer.fluid.FluidResource without(Supplier<? extends DataComponentType<?>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.without yet");
	}

	public DataComponentMap getComponents() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.getComponents yet");
	}

	public DataComponentPatch getComponentsPatch() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.getComponentsPatch yet");
	}

	public FluidStack toStack(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.toStack yet");
	}

	public boolean isComponentsPatchEmpty() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.isComponentsPatchEmpty yet");
	}

	public boolean is(FluidType arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.is yet");
	}

	public boolean matches(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.matches yet");
	}

	public boolean matches(FluidStackTemplate arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.matches yet");
	}

	public boolean test(Predicate<FluidStack> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.test yet");
	}

	public Component getHoverName() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.getHoverName yet");
	}

	public boolean equals(Object arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.equals yet");
	}

	public int hashCode() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.hashCode yet");
	}

	public String toString() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidResource.toString yet");
	}
}
