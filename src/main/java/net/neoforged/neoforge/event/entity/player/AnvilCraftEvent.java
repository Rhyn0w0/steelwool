package net.neoforged.neoforge.event.entity.player;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code AnvilCraftEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class AnvilCraftEvent extends PlayerEvent {
	private final AnvilMenu menu;
	private final ItemStack left;
	private final ItemStack right;
	private final ItemStack output;

	public AnvilCraftEvent(AnvilMenu menu, Player arg1, ItemStack left, ItemStack right, ItemStack output) {
		super(arg1);
		this.menu = menu;
		this.output = output;
		this.left = left;
		this.right = right;
	}

	public AnvilMenu getMenu() {
		return this.menu;
	}

	public ItemStack getOutput() {
		throw new UnsupportedOperationException("SteelWool does not implement AnvilCraftEvent.getOutput yet");
	}

	public ItemStack getLeft() {
		throw new UnsupportedOperationException("SteelWool does not implement AnvilCraftEvent.getLeft yet");
	}

	public ItemStack getRight() {
		throw new UnsupportedOperationException("SteelWool does not implement AnvilCraftEvent.getRight yet");
	}

	public static class Post extends net.neoforged.neoforge.event.entity.player.AnvilCraftEvent {
		public Post(AnvilMenu arg0, Player arg1, ItemStack arg2, ItemStack arg3, ItemStack arg4) {
			super(arg0, arg1, arg2, arg3, arg4);
		}
	}

	public static class Pre extends net.neoforged.neoforge.event.entity.player.AnvilCraftEvent implements ICancellableEvent {
		public Pre(AnvilMenu arg0, Player arg1, ItemStack arg2, ItemStack arg3, ItemStack arg4) {
			super(arg0, arg1, arg2, arg3, arg4);
		}

		public void setCanceled(boolean arg0) {
			ICancellableEvent.super.setCanceled(arg0);
		}
	}
}
