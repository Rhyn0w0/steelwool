package net.neoforged.neoforge.transfer;

import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.resource.Resource;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;

/**
 * SteelWool re-implementation of NeoForge's {@code ItemAccessResourceHandler}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class ItemAccessResourceHandler<T extends Resource> extends Object implements ResourceHandler<T> {
	protected final ItemAccess itemAccess;
	protected final int size;

	protected ItemAccessResourceHandler(ItemAccess itemAccess, int size) {
		super();
		this.itemAccess = itemAccess;
		this.size = size;
	}

	protected abstract T getResourceFrom(ItemResource arg0, int arg1);

	protected abstract int getAmountFrom(ItemResource arg0, int arg1);

	protected abstract ItemResource update(ItemResource arg0, int arg1, T arg2, int arg3);

	public boolean isValid(int arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccessResourceHandler.isValid yet");
	}

	protected abstract int getCapacity(int arg0, T arg1);

	public int size() {
		return this.size;
	}

	public T getResource(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccessResourceHandler.getResource yet");
	}

	public long getAmountAsLong(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccessResourceHandler.getAmountAsLong yet");
	}

	public long getCapacityAsLong(int arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccessResourceHandler.getCapacityAsLong yet");
	}

	public int insert(int arg0, T arg1, int arg2, TransactionContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccessResourceHandler.insert yet");
	}

	public int extract(int arg0, T arg1, int arg2, TransactionContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccessResourceHandler.extract yet");
	}
}
