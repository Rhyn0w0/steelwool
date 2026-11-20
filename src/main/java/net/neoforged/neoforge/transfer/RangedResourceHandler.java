package net.neoforged.neoforge.transfer;

import java.util.function.Supplier;

import net.neoforged.neoforge.transfer.resource.Resource;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;

/**
 * SteelWool re-implementation of NeoForge's {@code RangedResourceHandler}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RangedResourceHandler<T extends Resource> extends DelegatingResourceHandler<T> {
	protected int start;
	protected int end;

	public static <T extends Resource> net.neoforged.neoforge.transfer.RangedResourceHandler<T> of(ResourceHandler<T> arg0, int arg1, int arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement RangedResourceHandler.of yet");
	}

	public static <T extends Resource> net.neoforged.neoforge.transfer.RangedResourceHandler<T> of(Supplier<ResourceHandler<T>> arg0, int arg1, int arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement RangedResourceHandler.of yet");
	}

	public static <T extends Resource> net.neoforged.neoforge.transfer.RangedResourceHandler<T> ofSingleIndex(ResourceHandler<T> arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RangedResourceHandler.ofSingleIndex yet");
	}

	public static <T extends Resource> net.neoforged.neoforge.transfer.RangedResourceHandler<T> ofSingleIndex(Supplier<ResourceHandler<T>> arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RangedResourceHandler.ofSingleIndex yet");
	}

	protected RangedResourceHandler(ResourceHandler<T> arg0, int arg1, int arg2) {
		this(() -> arg0, arg1, arg2);
	}

	protected RangedResourceHandler(Supplier<ResourceHandler<T>> arg0, int arg1, int arg2) {
		super(arg0);
		int size = arg0.get().size();
		if (arg1 < 0 || arg1 >= arg2 || arg2 > size) {
			throw new IndexOutOfBoundsException("Invalid range " + arg1 + ".." + arg2 + " for a handler of size " + size);
		}
		this.start = arg1;
		this.end = arg2;
	}

	public int size() {
		throw new UnsupportedOperationException("SteelWool does not implement RangedResourceHandler.size yet");
	}

	protected int convertIndex(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RangedResourceHandler.convertIndex yet");
	}

	public int extract(T arg0, int arg1, TransactionContext arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement RangedResourceHandler.extract yet");
	}

	public int insert(T arg0, int arg1, TransactionContext arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement RangedResourceHandler.insert yet");
	}
}
