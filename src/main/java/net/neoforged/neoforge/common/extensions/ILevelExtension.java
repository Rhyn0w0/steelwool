package net.neoforged.neoforge.common.extensions;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.BlockCapability;
import org.jspecify.annotations.Nullable;

/**
 * Methods NeoForge adds to {@link Level}. SteelWool adds this interface to {@code Level} with a
 * mixin; so far it has the capability lookups.
 */
public interface ILevelExtension {
	String TRANSLATION_PREFIX = "dimension";

	private Level self() {
		return (Level) this;
	}

	default <T, C> @Nullable T getCapability(BlockCapability<T, C> capability, BlockPos pos, C context) {
		return capability.getCapability(self(), pos, null, null, context);
	}

	default <T, C> @Nullable T getCapability(BlockCapability<T, C> capability, BlockPos pos, @Nullable BlockState state, @Nullable BlockEntity blockEntity, C context) {
		return capability.getCapability(self(), pos, state, blockEntity, context);
	}

	default <T> @Nullable T getCapability(BlockCapability<T, Void> capability, BlockPos pos) {
		return capability.getCapability(self(), pos, null, null, null);
	}

	default <T> @Nullable T getCapability(BlockCapability<T, Void> capability, BlockPos pos, @Nullable BlockState state, @Nullable BlockEntity blockEntity) {
		return capability.getCapability(self(), pos, state, blockEntity, null);
	}

	/** SteelWool does not cache capabilities, so there is nothing to invalidate. */
	default void invalidateCapabilities(BlockPos pos) {
	}

	/** SteelWool does not cache capabilities, so there is nothing to invalidate. */
	default void invalidateCapabilities(ChunkPos pos) {
	}
}
