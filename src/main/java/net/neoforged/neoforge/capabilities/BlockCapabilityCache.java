package net.neoforged.neoforge.capabilities;

import java.util.function.BooleanSupplier;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import org.jspecify.annotations.Nullable;

/**
 * Looks up a block capability at a fixed position. NeoForge caches the result until the capability
 * is invalidated; SteelWool does not track invalidation yet, so it looks the capability up on every
 * call (same result, slower). The invalidation listener is called on every lookup while it is valid.
 */
public final class BlockCapabilityCache<T, C> {
	private final BlockCapability<T, C> capability;
	private final ServerLevel level;
	private final BlockPos pos;
	private final C context;
	private final BooleanSupplier isValid;
	private final Runnable invalidationListener;

	public static <T, C> BlockCapabilityCache<T, C> create(BlockCapability<T, C> capability, ServerLevel level, BlockPos pos, C context) {
		return create(capability, level, pos, context, () -> true, () -> {});
	}

	public static <T, C> BlockCapabilityCache<T, C> create(BlockCapability<T, C> capability, ServerLevel level, BlockPos pos, C context, BooleanSupplier isValid, Runnable invalidationListener) {
		return new BlockCapabilityCache<>(capability, level, pos, context, isValid, invalidationListener);
	}

	private BlockCapabilityCache(BlockCapability<T, C> capability, ServerLevel level, BlockPos pos, C context, BooleanSupplier isValid, Runnable invalidationListener) {
		this.capability = capability;
		this.level = level;
		this.pos = pos.immutable();
		this.context = context;
		this.isValid = isValid;
		this.invalidationListener = invalidationListener;
	}

	public ServerLevel level() {
		return level;
	}

	public BlockPos pos() {
		return pos;
	}

	public C context() {
		return context;
	}

	public @Nullable T getCapability() {
		if (!isValid.getAsBoolean() || !level.isLoaded(pos)) {
			return null;
		}
		return capability.getCapability(level, pos, null, null, context);
	}
}
