package net.neoforged.neoforge.fluids.crafting.display;

import net.neoforged.neoforge.fluids.FluidStack;

/**
 * SteelWool re-implementation of NeoForge's {@code FluidStackContentsFactory}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class FluidStackContentsFactory extends Object implements ForFluidStacks<FluidStack> {
	public static final net.neoforged.neoforge.fluids.crafting.display.FluidStackContentsFactory INSTANCE = null /* SteelWool: TODO */;

	public FluidStackContentsFactory() {
		super();
	}

	public FluidStack forStack(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidStackContentsFactory.forStack yet");
	}
}
