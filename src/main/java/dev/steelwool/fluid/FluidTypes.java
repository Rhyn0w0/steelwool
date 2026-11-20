package dev.steelwool.fluid;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;

/**
 * The {@link FluidType} of a fluid, which NeoForge patches into {@code Fluid.getFluidType()}:
 * vanilla's water and lava, NeoForge's {@link BaseFlowingFluid}s, and the empty type for the rest.
 */
public final class FluidTypes {
	private FluidTypes() {
	}

	public static FluidType of(Fluid fluid) {
		if (fluid instanceof BaseFlowingFluid flowing) {
			return flowing.getFluidType();
		}
		if (fluid == Fluids.WATER || fluid == Fluids.FLOWING_WATER) {
			return NeoForgeMod.WATER_TYPE.value();
		}
		if (fluid == Fluids.LAVA || fluid == Fluids.FLOWING_LAVA) {
			return NeoForgeMod.LAVA_TYPE.value();
		}
		return NeoForgeMod.EMPTY_TYPE.value();
	}
}
