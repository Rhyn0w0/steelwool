package dev.steelwool.mixin.patch;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.FullChunkStatus;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * NeoForge's split of {@link Level#setBlock(BlockPos, BlockState, int, int)}: once the chunk has the
 * new state, the updates and notifications happen in {@code markAndNotifyBlock}, which mods inject
 * into. The code is vanilla's, moved. Applied before other mods' mixins so the method exists for them.
 */
@Mixin(value = Level.class, priority = 500)
public abstract class LevelSetBlockMixin {
	@Inject(method = "setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;II)Z",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;getBlockState(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState;", ordinal = 0),
			cancellable = true)
	private void steelwool$markAndNotify(BlockPos pos, BlockState state, int flags, int recursionLeft, CallbackInfoReturnable<Boolean> cir,
			@Local LevelChunk chunk, @Local(ordinal = 1) BlockState oldState) {
		Level level = (Level) (Object) this;
		if (level.getBlockState(pos) == state) {
			markAndNotifyBlock(pos, chunk, oldState, state, flags, recursionLeft);
		}
		cir.setReturnValue(true);
	}

	/** Everything {@code setBlock} does after the chunk has the new state ({@code newState}). */
	public void markAndNotifyBlock(BlockPos pos, @Nullable LevelChunk chunk, BlockState oldState, BlockState newState, int flags, int recursionLeft) {
		Level level = (Level) (Object) this;
		Block block = newState.getBlock();

		if (oldState != newState) {
			level.setBlocksDirty(pos, oldState, newState);
		}

		if ((flags & Block.UPDATE_CLIENTS) != 0
				&& (!level.isClientSide() || (flags & Block.UPDATE_INVISIBLE) == 0)
				&& (level.isClientSide() || chunk != null && chunk.getFullStatus() != null && chunk.getFullStatus().isOrAfter(FullChunkStatus.BLOCK_TICKING))) {
			level.sendBlockUpdated(pos, oldState, newState, flags);
		}

		if ((flags & Block.UPDATE_NEIGHBORS) != 0) {
			level.updateNeighborsAt(pos, oldState.getBlock());
			if (!level.isClientSide() && newState.hasAnalogOutputSignal()) {
				level.updateNeighbourForOutputSignal(pos, block);
			}
		}

		if ((flags & Block.UPDATE_KNOWN_SHAPE) == 0 && recursionLeft > 0) {
			int neighbourFlags = flags & ~(Block.UPDATE_NEIGHBORS | Block.UPDATE_SUPPRESS_DROPS);
			oldState.updateIndirectNeighbourShapes(level, pos, neighbourFlags, recursionLeft - 1);
			newState.updateNeighbourShapes(level, pos, neighbourFlags, recursionLeft - 1);
			newState.updateIndirectNeighbourShapes(level, pos, neighbourFlags, recursionLeft - 1);
		}

		level.updatePOIOnBlockStateChange(pos, oldState, newState);
	}
}
