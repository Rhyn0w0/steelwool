package net.neoforged.neoforge.fluids;

import java.util.List;
import java.util.Map;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;

/**
 * SteelWool re-implementation of NeoForge's {@code FluidInteractionRegistry}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class FluidInteractionRegistry {
	private static final Map<FluidType, List<net.neoforged.neoforge.fluids.FluidInteractionRegistry.InteractionInformation>> INTERACTIONS = null /* SteelWool: TODO */;

	public FluidInteractionRegistry() {
		super();
	}

	public static synchronized void addInteraction(FluidType arg0, net.neoforged.neoforge.fluids.FluidInteractionRegistry.InteractionInformation arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidInteractionRegistry.addInteraction yet");
	}

	public static boolean canInteract(Level arg0, BlockPos arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidInteractionRegistry.canInteract yet");
	}

	public interface FluidInteraction {
		void interact(Level arg0, BlockPos arg1, BlockPos arg2, FluidState arg3);
	}

	public interface HasFluidInteraction {
		boolean test(Level arg0, BlockPos arg1, BlockPos arg2, FluidState arg3);
	}

	public static record InteractionInformation(net.neoforged.neoforge.fluids.FluidInteractionRegistry.HasFluidInteraction predicate, net.neoforged.neoforge.fluids.FluidInteractionRegistry.FluidInteraction interaction) {
	}
}
