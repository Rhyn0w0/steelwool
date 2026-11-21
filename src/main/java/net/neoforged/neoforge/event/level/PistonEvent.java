package net.neoforged.neoforge.event.level;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.piston.PistonStructureResolver;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code PistonEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class PistonEvent extends BlockEvent {
	private final Direction direction;
	private final net.neoforged.neoforge.event.level.PistonEvent.PistonMoveType moveType;

	public PistonEvent(Level arg0, BlockPos arg1, Direction arg2, net.neoforged.neoforge.event.level.PistonEvent.PistonMoveType arg3) {
		super((LevelAccessor) null, (BlockPos) null, (BlockState) null);
		throw new UnsupportedOperationException("SteelWool does not implement the PistonEvent constructor yet");
	}

	public Direction getDirection() {
		return this.direction;
	}

	public BlockPos getFaceOffsetPos() {
		throw new UnsupportedOperationException("SteelWool does not implement PistonEvent.getFaceOffsetPos yet");
	}

	public net.neoforged.neoforge.event.level.PistonEvent.PistonMoveType getPistonMoveType() {
		return this.moveType;
	}

	public PistonStructureResolver getStructureHelper() {
		throw new UnsupportedOperationException("SteelWool does not implement PistonEvent.getStructureHelper yet");
	}

	public enum PistonMoveType {
		EXTEND(true), RETRACT(false);

		public final boolean isExtend;

		PistonMoveType(boolean isExtend) {
			this.isExtend = isExtend;
		}
	}

	public static class Post extends net.neoforged.neoforge.event.level.PistonEvent {
		public Post(Level arg0, BlockPos arg1, Direction arg2, net.neoforged.neoforge.event.level.PistonEvent.PistonMoveType arg3) {
			super(arg0, arg1, arg2, arg3);
		}
	}

	public static class Pre extends net.neoforged.neoforge.event.level.PistonEvent implements ICancellableEvent {
		public Pre(Level arg0, BlockPos arg1, Direction arg2, net.neoforged.neoforge.event.level.PistonEvent.PistonMoveType arg3) {
			super(arg0, arg1, arg2, arg3);
		}
	}
}
