package net.neoforged.neoforge.event.entity.player;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * SteelWool re-implementation of NeoForge's {@code PlayerDestroyItemEvent}, with the same API.
 */
public class PlayerDestroyItemEvent extends PlayerEvent {
	private final ItemStack original;
	private final InteractionHand hand;

	public PlayerDestroyItemEvent(Player arg0, ItemStack original, InteractionHand hand) {
		super(arg0);
		this.original = original;
		this.hand = hand;
	}

	public ItemStack getOriginal() {
		return this.original;
	}

	public InteractionHand getHand() {
		return this.hand;
	}
}
