package net.neoforged.neoforge.event.entity.player;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BonemealSource;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code BonemealEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class BonemealEvent extends Event implements ICancellableEvent {
	private final Player player;
	private final Level level;
	private final BlockPos pos;
	private final BlockState state;
	private final BonemealSource source;
	private final ItemStack stack;
	private final boolean isValidBonemealTarget;
	private boolean isSuccess;

	public BonemealEvent(Player player, Level level, BlockPos pos, BlockState state, BonemealSource source, ItemStack stack) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the BonemealEvent constructor yet");
	}

	public Player getPlayer() {
		return this.player;
	}

	public Level getLevel() {
		return this.level;
	}

	public BlockPos getPos() {
		return this.pos;
	}

	public BlockState getState() {
		return this.state;
	}

	public BonemealSource getSource() {
		return this.source;
	}

	public ItemStack getStack() {
		return this.stack;
	}

	public boolean isValidBonemealTarget() {
		return this.isValidBonemealTarget;
	}

	public void setSuccessful(boolean arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BonemealEvent.setSuccessful yet");
	}

	public boolean isSuccessful() {
		return this.isSuccess;
	}

	public void setCanceled(boolean arg0) {
		ICancellableEvent.super.setCanceled(arg0);
	}
}
