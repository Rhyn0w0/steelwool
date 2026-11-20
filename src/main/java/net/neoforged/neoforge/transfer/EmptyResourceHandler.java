package net.neoforged.neoforge.transfer;

import net.neoforged.neoforge.transfer.resource.Resource;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;

/**
 * SteelWool re-implementation of NeoForge's {@code EmptyResourceHandler}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class EmptyResourceHandler<T extends Resource> extends Object implements ResourceHandler<T> {
	private static final net.neoforged.neoforge.transfer.EmptyResourceHandler<?> INSTANCE = null /* SteelWool: TODO */;

	public static <T extends Resource> net.neoforged.neoforge.transfer.EmptyResourceHandler<T> instance() {
		throw new UnsupportedOperationException("SteelWool does not implement EmptyResourceHandler.instance yet");
	}

	public int size() {
		throw new UnsupportedOperationException("SteelWool does not implement EmptyResourceHandler.size yet");
	}

	public int insert(int arg0, T arg1, int arg2, TransactionContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement EmptyResourceHandler.insert yet");
	}

	public int extract(int arg0, T arg1, int arg2, TransactionContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement EmptyResourceHandler.extract yet");
	}

	public T getResource(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement EmptyResourceHandler.getResource yet");
	}

	public long getAmountAsLong(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement EmptyResourceHandler.getAmountAsLong yet");
	}

	public long getCapacityAsLong(int arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EmptyResourceHandler.getCapacityAsLong yet");
	}

	public boolean isValid(int arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EmptyResourceHandler.isValid yet");
	}

	public String toString() {
		throw new UnsupportedOperationException("SteelWool does not implement EmptyResourceHandler.toString yet");
	}

	private EmptyResourceHandler() {
		super();
	}
}
