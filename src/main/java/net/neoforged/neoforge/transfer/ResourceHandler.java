package net.neoforged.neoforge.transfer;

import net.neoforged.neoforge.transfer.resource.Resource;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;

/**
 * SteelWool re-implementation of NeoForge's {@code ResourceHandler}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface ResourceHandler<T extends Resource> {
	int size();

	T getResource(int arg0);

	long getAmountAsLong(int arg0);

	default int getAmountAsInt(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandler.getAmountAsInt yet");
	}

	long getCapacityAsLong(int arg0, T arg1);

	default int getCapacityAsInt(int arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandler.getCapacityAsInt yet");
	}

	boolean isValid(int arg0, T arg1);

	int insert(int arg0, T arg1, int arg2, TransactionContext arg3);

	default int insert(T arg0, int arg1, TransactionContext arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandler.insert yet");
	}

	int extract(int arg0, T arg1, int arg2, TransactionContext arg3);

	default int extract(T arg0, int arg1, TransactionContext arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandler.extract yet");
	}

	static <T extends Resource> Class<net.neoforged.neoforge.transfer.ResourceHandler<T>> asClass() {
		return (Class) net.neoforged.neoforge.transfer.ResourceHandler.class;
	}
}
