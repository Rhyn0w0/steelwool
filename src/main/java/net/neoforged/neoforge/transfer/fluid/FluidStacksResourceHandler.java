package net.neoforged.neoforge.transfer.fluid;

import com.mojang.serialization.Codec;
import net.minecraft.core.NonNullList;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.transfer.StacksResourceHandler;

/**
 * SteelWool re-implementation of NeoForge's {@code FluidStacksResourceHandler}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class FluidStacksResourceHandler extends StacksResourceHandler<FluidStack, FluidResource> {
	protected int capacity;

	public FluidStacksResourceHandler(int arg0, int arg1) {
		super((int) 0, null, (Codec) null);
		throw new UnsupportedOperationException("SteelWool does not implement the FluidStacksResourceHandler constructor yet");
	}

	public FluidStacksResourceHandler(NonNullList<FluidStack> arg0, int arg1) {
		super((NonNullList) null, null, (Codec) null);
		throw new UnsupportedOperationException("SteelWool does not implement the FluidStacksResourceHandler constructor yet");
	}

	public FluidResource getResourceFrom(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStacksResourceHandler.getResourceFrom yet");
	}

	public int getAmountFrom(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStacksResourceHandler.getAmountFrom yet");
	}

	protected FluidStack getStackFrom(FluidResource arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStacksResourceHandler.getStackFrom yet");
	}

	protected int getCapacity(int arg0, FluidResource arg1) {
		return this.capacity;
	}

	protected FluidStack copyOf(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStacksResourceHandler.copyOf yet");
	}

	public boolean matches(FluidStack arg0, FluidResource arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStacksResourceHandler.matches yet");
	}
}
