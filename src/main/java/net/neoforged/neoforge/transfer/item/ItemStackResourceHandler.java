package net.neoforged.neoforge.transfer.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.common.util.ValueIOSerializable;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.transaction.SnapshotJournal;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;

/**
 * SteelWool re-implementation of NeoForge's {@code ItemStackResourceHandler}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class ItemStackResourceHandler extends SnapshotJournal<ItemStack> implements ResourceHandler<ItemResource>, ValueIOSerializable {
	public static final String VALUE_IO_KEY = "stack";

	public ItemStackResourceHandler() {
		super();
	}

	protected abstract ItemStack getStack();

	protected abstract void setStack(ItemStack arg0);

	protected boolean isValid(ItemResource arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemStackResourceHandler.isValid yet");
	}

	protected int getCapacity(ItemResource arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemStackResourceHandler.getCapacity yet");
	}

	public final int size() {
		throw new UnsupportedOperationException("SteelWool does not implement ItemStackResourceHandler.size yet");
	}

	public int insert(int arg0, ItemResource arg1, int arg2, TransactionContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemStackResourceHandler.insert yet");
	}

	public int extract(int arg0, ItemResource arg1, int arg2, TransactionContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemStackResourceHandler.extract yet");
	}

	public ItemResource getResource(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemStackResourceHandler.getResource yet");
	}

	public long getAmountAsLong(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemStackResourceHandler.getAmountAsLong yet");
	}

	public long getCapacityAsLong(int arg0, ItemResource arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemStackResourceHandler.getCapacityAsLong yet");
	}

	public boolean isValid(int arg0, ItemResource arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemStackResourceHandler.isValid yet");
	}

	protected ItemStack createSnapshot() {
		throw new UnsupportedOperationException("SteelWool does not implement ItemStackResourceHandler.createSnapshot yet");
	}

	protected void revertToSnapshot(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemStackResourceHandler.revertToSnapshot yet");
	}

	public void serialize(ValueOutput arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemStackResourceHandler.serialize yet");
	}

	public void deserialize(ValueInput arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemStackResourceHandler.deserialize yet");
	}

	public String toString() {
		throw new UnsupportedOperationException("SteelWool does not implement ItemStackResourceHandler.toString yet");
	}
}
