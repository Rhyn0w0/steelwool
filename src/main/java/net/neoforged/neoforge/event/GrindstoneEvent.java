package net.neoforged.neoforge.event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code GrindstoneEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class GrindstoneEvent extends Event {
	private final ItemStack top;
	private final ItemStack bottom;
	private int xp;

	protected GrindstoneEvent(ItemStack top, ItemStack bottom, int xp) {
		super();
		this.top = top;
		this.bottom = bottom;
		this.xp = xp;
	}

	public ItemStack getTopItem() {
		return this.top;
	}

	public ItemStack getBottomItem() {
		return this.bottom;
	}

	public int getXp() {
		return this.xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public static class OnPlaceItem extends net.neoforged.neoforge.event.GrindstoneEvent implements ICancellableEvent {
		private ItemStack output;

		public OnPlaceItem(ItemStack arg0, ItemStack arg1, int arg2) {
			super((ItemStack) null, (ItemStack) null, (int) 0);
			throw new UnsupportedOperationException("SteelWool does not implement the GrindstoneEvent.OnPlaceItem constructor yet");
		}

		public ItemStack getOutput() {
			return this.output;
		}

		public void setOutput(ItemStack output) {
			this.output = output;
		}
	}

	public static class OnTakeItem extends net.neoforged.neoforge.event.GrindstoneEvent implements ICancellableEvent {
		private ItemStack newTop;
		private ItemStack newBottom;
		private final ContainerLevelAccess access;
		private final Player player;

		public OnTakeItem(ContainerLevelAccess arg0, Player arg1, ItemStack arg2, ItemStack arg3, int arg4) {
			super((ItemStack) null, (ItemStack) null, (int) 0);
			throw new UnsupportedOperationException("SteelWool does not implement the GrindstoneEvent.OnTakeItem constructor yet");
		}

		public ItemStack getNewTopItem() {
			return this.newTop;
		}

		public ItemStack getNewBottomItem() {
			return this.newBottom;
		}

		public void setNewTopItem(ItemStack newTop) {
			this.newTop = newTop;
		}

		public void setNewBottomItem(ItemStack newBottom) {
			this.newBottom = newBottom;
		}

		public int getXp() {
			return super.getXp();
		}

		public ContainerLevelAccess getContainerAccess() {
			return this.access;
		}

		public Player getPlayer() {
			return this.player;
		}
	}
}
