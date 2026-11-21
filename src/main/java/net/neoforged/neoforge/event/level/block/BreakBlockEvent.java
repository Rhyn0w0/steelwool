package net.neoforged.neoforge.event.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code BreakBlockEvent}, with the same API.
 */
public class BreakBlockEvent extends BlockEvent implements ICancellableEvent {
	private final Player player;
	private boolean notifyClient;

	public BreakBlockEvent(Level arg0, BlockPos arg1, BlockState arg2, Player player) {
		super(arg0, arg1, arg2);
		this.notifyClient = false;
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setCanceled(boolean arg0) {
		ICancellableEvent.super.setCanceled(arg0);
	}

	public boolean shouldNotifyClient() {
		return this.notifyClient;
	}

	public void setNotifyClient(boolean notifyClient) {
		this.notifyClient = notifyClient;
	}
}
