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
	private static final Map<FluidType, List<net.neoforged.neoforge.fluids.FluidInteractionRegistry.InteractionInformation>> INTERACTIONS = new java.util.HashMap<>();

	public FluidInteractionRegistry() {
		super();
	}

	/**
	 * Records an interaction of a fluid with neighbouring blocks. SteelWool stores it but does not run
	 * interactions yet (vanilla's water/lava interactions still apply).
	 */
	public static synchronized void addInteraction(FluidType source, net.neoforged.neoforge.fluids.FluidInteractionRegistry.InteractionInformation interaction) {
		INTERACTIONS.computeIfAbsent(source, type -> new java.util.ArrayList<>()).add(interaction);
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
		/** Turns the source into {@code state} next to a fluid of type {@code type}. */
		public InteractionInformation(FluidType type, net.minecraft.world.level.block.state.BlockState state) {
			this(type, fluidState -> state);
		}

		public InteractionInformation(HasFluidInteraction predicate, net.minecraft.world.level.block.state.BlockState state) {
			this(predicate, fluidState -> state);
		}

		public InteractionInformation(FluidType type, java.util.function.Function<FluidState, net.minecraft.world.level.block.state.BlockState> getState) {
			this((level, currentPos, relativePos, currentState) -> {
				throw new UnsupportedOperationException("SteelWool does not know fluid types of fluids yet, so it cannot test fluid interactions");
			}, getState);
		}

		public InteractionInformation(HasFluidInteraction predicate, java.util.function.Function<FluidState, net.minecraft.world.level.block.state.BlockState> getState) {
			this(predicate, (level, currentPos, relativePos, currentState) -> {
				level.setBlockAndUpdate(currentPos, getState.apply(currentState));
				level.levelEvent(net.minecraft.world.level.block.LevelEvent.LAVA_FIZZ, currentPos, 0);
			});
		}
	}
}
