package net.neoforged.neoforge.event.entity.player;

import net.minecraft.util.TriState;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code ItemEntityPickupEvent}, with the same API.
 */
public abstract class ItemEntityPickupEvent extends Event {
	private final Player player;
	private final ItemEntity item;

	public ItemEntityPickupEvent(Player player, ItemEntity item) {
		super();
		this.player = player;
		this.item = item;
	}

	public Player getPlayer() {
		return this.player;
	}

	public ItemEntity getItemEntity() {
		return this.item;
	}

	public static class Post extends net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent {
		private final ItemStack originalStack;

		public Post(Player arg0, ItemEntity arg1, ItemStack originalStack) {
			super(arg0, arg1);
			this.originalStack = originalStack;
		}

		public ItemStack getOriginalStack() {
			return originalStack.copy();
		}

		public ItemStack getCurrentStack() {
			return getItemEntity().getItem();
		}
	}

	public static class Pre extends net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent {
		private TriState canPickup;

		public Pre(Player player, ItemEntity item) {
			super(player, item);
			this.canPickup = TriState.DEFAULT;
		}

		public void setCanPickup(TriState canPickup) {
			this.canPickup = canPickup;
		}

		public TriState canPickup() {
			return this.canPickup;
		}
	}
}
