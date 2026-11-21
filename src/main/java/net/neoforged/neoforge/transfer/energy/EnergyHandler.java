package net.neoforged.neoforge.transfer.energy;

import net.neoforged.neoforge.transfer.transaction.TransactionContext;

/**
 * SteelWool re-implementation of NeoForge's {@code EnergyHandler}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface EnergyHandler {
	long getAmountAsLong();

	default int getAmountAsInt() {
		throw new UnsupportedOperationException("SteelWool does not implement EnergyHandler.getAmountAsInt yet");
	}

	long getCapacityAsLong();

	default int getCapacityAsInt() {
		throw new UnsupportedOperationException("SteelWool does not implement EnergyHandler.getCapacityAsInt yet");
	}

	int insert(int arg0, TransactionContext arg1);

	int extract(int arg0, TransactionContext arg1);
}
