package net.neoforged.neoforge.transfer.energy;

import net.neoforged.neoforge.transfer.transaction.TransactionContext;

/**
 * SteelWool re-implementation of NeoForge's {@code EmptyEnergyHandler}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class EmptyEnergyHandler implements EnergyHandler {
	public static final net.neoforged.neoforge.transfer.energy.EmptyEnergyHandler INSTANCE = null /* SteelWool: TODO */;

	private EmptyEnergyHandler() {
		super();
	}

	public long getAmountAsLong() {
		throw new UnsupportedOperationException("SteelWool does not implement EmptyEnergyHandler.getAmountAsLong yet");
	}

	public long getCapacityAsLong() {
		throw new UnsupportedOperationException("SteelWool does not implement EmptyEnergyHandler.getCapacityAsLong yet");
	}

	public int insert(int arg0, TransactionContext arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EmptyEnergyHandler.insert yet");
	}

	public int extract(int arg0, TransactionContext arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement EmptyEnergyHandler.extract yet");
	}
}
