package net.neoforged.neoforge.world.inventory;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/**
 * SteelWool re-implementation of NeoForge's {@code StackCopySlot}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class StackCopySlot extends Slot {
	private static final Container emptyInventory = null /* SteelWool: TODO */;
	private ItemStack cachedReturnedStack;

	public StackCopySlot(int arg0, int arg1, int arg2) {
		super((Container) null, (int) 0, (int) 0, (int) 0);
		throw new UnsupportedOperationException("SteelWool does not implement the StackCopySlot constructor yet");
	}

	protected abstract ItemStack getStackCopy();

	protected abstract void setStackCopy(ItemStack arg0);

	public final ItemStack getItem() {
		throw new UnsupportedOperationException("SteelWool does not implement StackCopySlot.getItem yet");
	}

	public final void set(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement StackCopySlot.set yet");
	}

	public final void setChanged() {
		throw new UnsupportedOperationException("SteelWool does not implement StackCopySlot.setChanged yet");
	}

	public ItemStack remove(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement StackCopySlot.remove yet");
	}

	protected void clearCachedReturnStack() {
		throw new UnsupportedOperationException("SteelWool does not implement StackCopySlot.clearCachedReturnStack yet");
	}
}
