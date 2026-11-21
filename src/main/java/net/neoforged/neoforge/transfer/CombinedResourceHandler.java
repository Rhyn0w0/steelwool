package net.neoforged.neoforge.transfer;

import java.util.SequencedCollection;

import net.neoforged.neoforge.transfer.resource.Resource;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;

/**
 * SteelWool re-implementation of NeoForge's {@code CombinedResourceHandler}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class CombinedResourceHandler<T extends Resource> extends Object implements ResourceHandler<T> {
	private final ResourceHandler<T>[] handlers;
	private final int[] baseIndex;
	private final int sizeCache;

	public CombinedResourceHandler(SequencedCollection<? extends ResourceHandler<T>> arg0) {
		this((ResourceHandler[]) null);
		throw new UnsupportedOperationException("SteelWool does not implement the CombinedResourceHandler constructor yet");
	}

	public CombinedResourceHandler(ResourceHandler<T>... handlers) {
		throw new UnsupportedOperationException("SteelWool does not implement the CombinedResourceHandler constructor yet");
	}

	protected int getHandlerIndex(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CombinedResourceHandler.getHandlerIndex yet");
	}

	protected ResourceHandler<T> getHandlerFromIndex(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CombinedResourceHandler.getHandlerFromIndex yet");
	}

	protected int getSlotFromIndex(int arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CombinedResourceHandler.getSlotFromIndex yet");
	}

	public final int size() {
		return this.sizeCache;
	}

	public T getResource(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CombinedResourceHandler.getResource yet");
	}

	public long getAmountAsLong(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CombinedResourceHandler.getAmountAsLong yet");
	}

	public long getCapacityAsLong(int arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CombinedResourceHandler.getCapacityAsLong yet");
	}

	public boolean isValid(int arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CombinedResourceHandler.isValid yet");
	}

	public int insert(int arg0, T arg1, int arg2, TransactionContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CombinedResourceHandler.insert yet");
	}

	public int insert(T arg0, int arg1, TransactionContext arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CombinedResourceHandler.insert yet");
	}

	public int extract(int arg0, T arg1, int arg2, TransactionContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement CombinedResourceHandler.extract yet");
	}

	public int extract(T arg0, int arg1, TransactionContext arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement CombinedResourceHandler.extract yet");
	}
}
