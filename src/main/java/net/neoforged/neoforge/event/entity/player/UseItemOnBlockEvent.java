package net.neoforged.neoforge.event.entity.player;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.fml.LogicalSide;

/**
 * SteelWool re-implementation of NeoForge's {@code UseItemOnBlockEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class UseItemOnBlockEvent extends Event implements ICancellableEvent {
	private final Level level;
	private final Player player;
	private final InteractionHand hand;
	private final ItemStack heldItem;
	private final BlockPos pos;
	private final Direction face;
	private final UseOnContext context;
	private final net.neoforged.neoforge.event.entity.player.UseItemOnBlockEvent.UsePhase usePhase;
	private InteractionResult cancellationResult;

	public UseItemOnBlockEvent(UseOnContext arg0, net.neoforged.neoforge.event.entity.player.UseItemOnBlockEvent.UsePhase arg1) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the UseItemOnBlockEvent constructor yet");
	}

	public Player getPlayer() {
		return this.player;
	}

	public InteractionHand getHand() {
		return this.hand;
	}

	public ItemStack getItemStack() {
		return this.heldItem;
	}

	public BlockPos getPos() {
		return this.pos;
	}

	public Direction getFace() {
		return this.face;
	}

	public Level getLevel() {
		return this.level;
	}

	public UseOnContext getUseOnContext() {
		return this.context;
	}

	public net.neoforged.neoforge.event.entity.player.UseItemOnBlockEvent.UsePhase getUsePhase() {
		return this.usePhase;
	}

	public LogicalSide getSide() {
		throw new UnsupportedOperationException("SteelWool does not implement UseItemOnBlockEvent.getSide yet");
	}

	public void cancelWithResult(InteractionResult arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement UseItemOnBlockEvent.cancelWithResult yet");
	}

	public InteractionResult getCancellationResult() {
		return this.cancellationResult;
	}

	public void setCancellationResult(InteractionResult cancellationResult) {
		this.cancellationResult = cancellationResult;
	}

	public enum UsePhase {
		ITEM_BEFORE_BLOCK, BLOCK, ITEM_AFTER_BLOCK;
	}
}
