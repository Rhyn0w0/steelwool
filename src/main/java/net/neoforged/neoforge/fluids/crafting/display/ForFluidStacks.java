package net.neoforged.neoforge.fluids.crafting.display;

import net.minecraft.core.Holder;
import net.minecraft.world.item.crafting.display.DisplayContentsFactory;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;

/**
 * SteelWool re-implementation of NeoForge's {@code ForFluidStacks}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface ForFluidStacks<T extends Object> extends DisplayContentsFactory<T> {
	default T forStack(Holder<Fluid> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ForFluidStacks.forStack yet");
	}

	default T forStack(Fluid arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ForFluidStacks.forStack yet");
	}

	T forStack(FluidStack arg0);
}
