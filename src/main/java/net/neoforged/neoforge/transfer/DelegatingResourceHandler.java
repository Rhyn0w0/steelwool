package net.neoforged.neoforge.transfer;

import java.util.function.Supplier;

import net.neoforged.neoforge.transfer.resource.Resource;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;

/**
 * SteelWool re-implementation of NeoForge's {@code DelegatingResourceHandler}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class DelegatingResourceHandler<T extends Resource> extends Object implements ResourceHandler<T> {
	protected final Supplier<ResourceHandler<T>> delegate;

	public DelegatingResourceHandler(ResourceHandler<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement the DelegatingResourceHandler constructor yet");
	}

	public DelegatingResourceHandler(Supplier<ResourceHandler<T>> delegate) {
		super();
		this.delegate = delegate;
	}

	public int size() {
		throw new UnsupportedOperationException("SteelWool does not implement DelegatingResourceHandler.size yet");
	}

	protected int convertIndex(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DelegatingResourceHandler.convertIndex yet");
	}

	public T getResource(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DelegatingResourceHandler.getResource yet");
	}

	public long getAmountAsLong(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DelegatingResourceHandler.getAmountAsLong yet");
	}

	public long getCapacityAsLong(int arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DelegatingResourceHandler.getCapacityAsLong yet");
	}

	public boolean isValid(int arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DelegatingResourceHandler.isValid yet");
	}

	public int insert(int arg0, T arg1, int arg2, TransactionContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement DelegatingResourceHandler.insert yet");
	}

	public int insert(T arg0, int arg1, TransactionContext arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement DelegatingResourceHandler.insert yet");
	}

	public int extract(int arg0, T arg1, int arg2, TransactionContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement DelegatingResourceHandler.extract yet");
	}

	public int extract(T arg0, int arg1, TransactionContext arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement DelegatingResourceHandler.extract yet");
	}

	public ResourceHandler<T> getDelegate() {
		throw new UnsupportedOperationException("SteelWool does not implement DelegatingResourceHandler.getDelegate yet");
	}
}
