package net.neoforged.neoforge.event.level;

import java.util.EnumSet;
import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.PortalShape;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.util.BlockSnapshot;

/**
 * SteelWool re-implementation of NeoForge's {@code BlockEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class BlockEvent extends Event {
	private static final boolean DEBUG = false /* SteelWool: TODO */;
	private final LevelAccessor level;
	private final BlockPos pos;
	private final BlockState state;

	public BlockEvent(LevelAccessor level, BlockPos pos, BlockState state) {
		super();
		this.pos = pos;
		this.level = level;
		this.state = state;
	}

	public LevelAccessor getLevel() {
		return this.level;
	}

	public BlockPos getPos() {
		return this.pos;
	}

	public BlockState getState() {
		return this.state;
	}

	public static class BlockToolModificationEvent extends net.neoforged.neoforge.event.level.BlockEvent implements ICancellableEvent {
		private final UseOnContext context;
		private final ItemAbility itemAbility;
		private final boolean simulate;
		private BlockState state;

		public BlockToolModificationEvent(BlockState arg0, UseOnContext arg1, ItemAbility arg2, boolean arg3) {
			super((LevelAccessor) null, (BlockPos) null, (BlockState) null);
			throw new UnsupportedOperationException("SteelWool does not implement the BlockEvent.BlockToolModificationEvent constructor yet");
		}

		public Player getPlayer() {
			throw new UnsupportedOperationException("SteelWool does not implement BlockEvent.BlockToolModificationEvent.getPlayer yet");
		}

		public ItemStack getHeldItemStack() {
			throw new UnsupportedOperationException("SteelWool does not implement BlockEvent.BlockToolModificationEvent.getHeldItemStack yet");
		}

		public ItemAbility getItemAbility() {
			return this.itemAbility;
		}

		public boolean isSimulated() {
			return this.simulate;
		}

		public UseOnContext getContext() {
			return this.context;
		}

		public void setFinalState(BlockState state) {
			this.state = state;
		}

		public BlockState getFinalState() {
			return this.state;
		}
	}

	public static class EntityMultiPlaceEvent extends net.neoforged.neoforge.event.level.BlockEvent.EntityPlaceEvent implements ICancellableEvent {
		private final List<BlockSnapshot> blockSnapshots;

		public EntityMultiPlaceEvent(List<BlockSnapshot> arg0, BlockState arg1, Entity arg2) {
			super((BlockSnapshot) null, (BlockState) null, (Entity) null);
			throw new UnsupportedOperationException("SteelWool does not implement the BlockEvent.EntityMultiPlaceEvent constructor yet");
		}

		public List<BlockSnapshot> getReplacedBlockSnapshots() {
			return this.blockSnapshots;
		}
	}

	public static class EntityPlaceEvent extends net.neoforged.neoforge.event.level.BlockEvent implements ICancellableEvent {
		private final Entity entity;
		private final BlockSnapshot blockSnapshot;
		private final BlockState placedBlock;
		private final BlockState placedAgainst;

		public EntityPlaceEvent(BlockSnapshot arg0, BlockState arg1, Entity arg2) {
			super((LevelAccessor) null, (BlockPos) null, (BlockState) null);
			throw new UnsupportedOperationException("SteelWool does not implement the BlockEvent.EntityPlaceEvent constructor yet");
		}

		public Entity getEntity() {
			return this.entity;
		}

		public BlockSnapshot getBlockSnapshot() {
			return this.blockSnapshot;
		}

		public BlockState getPlacedBlock() {
			return this.placedBlock;
		}

		public BlockState getPlacedAgainst() {
			return this.placedAgainst;
		}
	}

	public static class FarmlandTrampleEvent extends net.neoforged.neoforge.event.level.BlockEvent implements ICancellableEvent {
		private final Entity entity;
		private final double fallDistance;

		public FarmlandTrampleEvent(Level arg0, BlockPos arg1, BlockState arg2, double fallDistance, Entity entity) {
			super(arg0, arg1, arg2);
			this.entity = entity;
			this.fallDistance = fallDistance;
		}

		public Entity getEntity() {
			return this.entity;
		}

		public double getFallDistance() {
			return this.fallDistance;
		}
	}

	public static class FluidPlaceBlockEvent extends net.neoforged.neoforge.event.level.BlockEvent implements ICancellableEvent {
		private final BlockPos liquidPos;
		private BlockState newState;
		private BlockState origState;

		public FluidPlaceBlockEvent(LevelAccessor arg0, BlockPos arg1, BlockPos liquidPos, BlockState newState) {
			super((LevelAccessor) null, (BlockPos) null, (BlockState) null);
			throw new UnsupportedOperationException("SteelWool does not implement the BlockEvent.FluidPlaceBlockEvent constructor yet");
		}

		public BlockPos getLiquidPos() {
			return this.liquidPos;
		}

		public BlockState getNewState() {
			return this.newState;
		}

		public void setNewState(BlockState newState) {
			this.newState = newState;
		}

		public BlockState getOriginalState() {
			return this.origState;
		}
	}

	public static class NeighborNotifyEvent extends net.neoforged.neoforge.event.level.BlockEvent implements ICancellableEvent {
		private final EnumSet<Direction> notifiedSides;
		private final boolean forceRedstoneUpdate;

		public NeighborNotifyEvent(Level arg0, BlockPos arg1, BlockState arg2, EnumSet<Direction> notifiedSides, boolean forceRedstoneUpdate) {
			super(arg0, arg1, arg2);
			this.notifiedSides = notifiedSides;
			this.forceRedstoneUpdate = forceRedstoneUpdate;
		}

		public EnumSet<Direction> getNotifiedSides() {
			return this.notifiedSides;
		}

		public boolean getForceRedstoneUpdate() {
			return this.forceRedstoneUpdate;
		}
	}

	public static class PortalSpawnEvent extends net.neoforged.neoforge.event.level.BlockEvent implements ICancellableEvent {
		private final PortalShape size;

		public PortalSpawnEvent(LevelAccessor arg0, BlockPos arg1, BlockState arg2, PortalShape size) {
			super(arg0, arg1, arg2);
			this.size = size;
		}

		public PortalShape getPortalSize() {
			return this.size;
		}
	}
}
