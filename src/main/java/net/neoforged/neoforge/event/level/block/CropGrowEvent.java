package net.neoforged.neoforge.event.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.event.level.BlockEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code CropGrowEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class CropGrowEvent extends BlockEvent {
	public CropGrowEvent(Level arg0, BlockPos arg1, BlockState arg2) {
		super(arg0, arg1, arg2);
	}

	public static class Post extends net.neoforged.neoforge.event.level.block.CropGrowEvent {
		private final BlockState originalState;

		public Post(Level arg0, BlockPos arg1, BlockState originalState, BlockState arg3) {
			super(arg0, arg1, arg3);
			this.originalState = originalState;
		}

		public BlockState getOriginalState() {
			return this.originalState;
		}

		public BlockState getState() {
			return super.getState();
		}
	}

	public static class Pre extends net.neoforged.neoforge.event.level.block.CropGrowEvent {
		private net.neoforged.neoforge.event.level.block.CropGrowEvent.Pre.Result result;

		public Pre(Level arg0, BlockPos arg1, BlockState arg2) {
			super((Level) null, (BlockPos) null, (BlockState) null);
			throw new UnsupportedOperationException("SteelWool does not implement the CropGrowEvent.Pre constructor yet");
		}

		public void setResult(net.neoforged.neoforge.event.level.block.CropGrowEvent.Pre.Result result) {
			this.result = result;
		}

		public net.neoforged.neoforge.event.level.block.CropGrowEvent.Pre.Result getResult() {
			return this.result;
		}

		public enum Result {
			GROW, DEFAULT, DO_NOT_GROW;
		}
	}
}
