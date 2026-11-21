package net.neoforged.neoforge.event.entity.item;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code ItemTossEvent}, with the same API.
 */
public class ItemTossEvent extends ItemEvent implements ICancellableEvent {
	private final Player player;

	public ItemTossEvent(ItemEntity arg0, Player player) {
		super(arg0);
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}
}
