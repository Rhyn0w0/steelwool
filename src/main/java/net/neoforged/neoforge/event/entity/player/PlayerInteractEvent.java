package net.neoforged.neoforge.event.entity.player;

import java.util.Objects;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.util.TriState;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.fml.LogicalSide;

/**
 * SteelWool re-implementation of NeoForge's {@code PlayerInteractEvent}, with the same API.
 */
public abstract class PlayerInteractEvent extends PlayerEvent {
	private final InteractionHand hand;
	private final BlockPos pos;
	private final Direction face;

	protected PlayerInteractEvent(Player player, InteractionHand hand, BlockPos pos, Direction face) {
		super(Objects.requireNonNull(player, "Null player in PlayerInteractEvent"));
		this.hand = Objects.requireNonNull(hand, "Null hand in PlayerInteractEvent");
		this.pos = Objects.requireNonNull(pos, "Null position in PlayerInteractEvent");
		this.face = face;
	}

	public InteractionHand getHand() {
		return this.hand;
	}

	public ItemStack getItemStack() {
		return getEntity().getItemInHand(hand);
	}

	public BlockPos getPos() {
		return this.pos;
	}

	public Direction getFace() {
		return this.face;
	}

	public Level getLevel() {
		return getEntity().level();
	}

	public LogicalSide getSide() {
		return getLevel().isClientSide() ? LogicalSide.CLIENT : LogicalSide.SERVER;
	}

	public static class EntityInteract extends net.neoforged.neoforge.event.entity.player.PlayerInteractEvent implements ICancellableEvent {
		private InteractionResult cancellationResult;
		private final Entity target;
		private final Vec3 location;

		public EntityInteract(Player player, InteractionHand hand, Entity target, Vec3 location) {
			super(player, hand, target.blockPosition(), null);
			this.cancellationResult = InteractionResult.PASS;
			this.target = target;
			this.location = location;
		}

		public Entity getTarget() {
			return this.target;
		}

		public Vec3 getLocation() {
			return this.location;
		}

		public InteractionResult getCancellationResult() {
			return this.cancellationResult;
		}

		public void setCancellationResult(InteractionResult cancellationResult) {
			this.cancellationResult = cancellationResult;
		}
	}

	public static class LeftClickBlock extends net.neoforged.neoforge.event.entity.player.PlayerInteractEvent implements ICancellableEvent {
		private TriState useBlock;
		private TriState useItem;
		private final net.neoforged.neoforge.event.entity.player.PlayerInteractEvent.LeftClickBlock.Action action;

		public LeftClickBlock(Player player, BlockPos pos, Direction face, net.neoforged.neoforge.event.entity.player.PlayerInteractEvent.LeftClickBlock.Action action) {
			super(player, InteractionHand.MAIN_HAND, pos, face);
			this.useBlock = TriState.DEFAULT;
			this.useItem = TriState.DEFAULT;
			this.action = action;
		}

		public TriState getUseBlock() {
			return this.useBlock;
		}

		public TriState getUseItem() {
			return this.useItem;
		}

		public net.neoforged.neoforge.event.entity.player.PlayerInteractEvent.LeftClickBlock.Action getAction() {
			return this.action;
		}

		public void setUseBlock(TriState useBlock) {
			this.useBlock = useBlock;
		}

		public void setUseItem(TriState useItem) {
			this.useItem = useItem;
		}

		public void setCanceled(boolean canceled) {
			ICancellableEvent.super.setCanceled(canceled);
			
			if (canceled) {
				useBlock = TriState.FALSE;
				useItem = TriState.FALSE;
			}
		}

		public enum Action {
			START, STOP, ABORT, CLIENT_HOLD;

			public static net.neoforged.neoforge.event.entity.player.PlayerInteractEvent.LeftClickBlock.Action convert(ServerboundPlayerActionPacket.Action action) {
				return switch (action) {
					case STOP_DESTROY_BLOCK -> STOP;
					case ABORT_DESTROY_BLOCK -> ABORT;
					default -> START;
				};
			}
		}
	}

	public static class LeftClickEmpty extends net.neoforged.neoforge.event.entity.player.PlayerInteractEvent {
		public LeftClickEmpty(Player player) {
			super(player, InteractionHand.MAIN_HAND, player.blockPosition(), null);
		}
	}

	public static class RightClickBlock extends net.neoforged.neoforge.event.entity.player.PlayerInteractEvent implements ICancellableEvent {
		private InteractionResult cancellationResult;
		private TriState useBlock;
		private TriState useItem;
		private BlockHitResult hitVec;

		public RightClickBlock(Player player, InteractionHand hand, BlockPos pos, BlockHitResult hitVec) {
			super(player, hand, pos, hitVec.getDirection());
			this.cancellationResult = InteractionResult.PASS;
			this.useBlock = TriState.DEFAULT;
			this.useItem = TriState.DEFAULT;
			this.hitVec = hitVec;
		}

		public TriState getUseBlock() {
			return this.useBlock;
		}

		public TriState getUseItem() {
			return this.useItem;
		}

		public BlockHitResult getHitVec() {
			return this.hitVec;
		}

		public void setUseBlock(TriState useBlock) {
			this.useBlock = useBlock;
		}

		public void setUseItem(TriState useItem) {
			this.useItem = useItem;
		}

		public void setCanceled(boolean canceled) {
			ICancellableEvent.super.setCanceled(canceled);
			
			if (canceled) {
				useBlock = TriState.FALSE;
				useItem = TriState.FALSE;
			}
		}

		public InteractionResult getCancellationResult() {
			return this.cancellationResult;
		}

		public void setCancellationResult(InteractionResult cancellationResult) {
			this.cancellationResult = cancellationResult;
		}
	}

	public static class RightClickEmpty extends net.neoforged.neoforge.event.entity.player.PlayerInteractEvent {
		public RightClickEmpty(Player player, InteractionHand hand) {
			super(player, hand, player.blockPosition(), null);
		}
	}

	public static class RightClickItem extends net.neoforged.neoforge.event.entity.player.PlayerInteractEvent implements ICancellableEvent {
		private InteractionResult cancellationResult;

		public RightClickItem(Player player, InteractionHand hand) {
			super(player, hand, player.blockPosition(), null);
			this.cancellationResult = InteractionResult.PASS;
		}

		public InteractionResult getCancellationResult() {
			return this.cancellationResult;
		}

		public void setCancellationResult(InteractionResult cancellationResult) {
			this.cancellationResult = cancellationResult;
		}
	}
}
