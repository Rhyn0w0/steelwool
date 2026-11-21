package net.neoforged.neoforge.transfer.energy;

import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.common.util.ValueIOSerializable;
import net.neoforged.neoforge.transfer.transaction.SnapshotJournal;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;

/**
 * SteelWool re-implementation of NeoForge's {@code SimpleEnergyHandler}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class SimpleEnergyHandler implements EnergyHandler,ValueIOSerializable {
	protected int energy;
	protected int capacity;
	protected int maxInsert;
	protected int maxExtract;
	private final net.neoforged.neoforge.transfer.energy.SimpleEnergyHandler.EnergyJournal energyJournal;

	public SimpleEnergyHandler(int arg0) {
		this(arg0, arg0);
	}

	public SimpleEnergyHandler(int arg0, int arg1) {
		this(arg0, arg1, arg1);
	}

	public SimpleEnergyHandler(int arg0, int arg1, int arg2) {
		this(arg0, arg1, arg2, 0);
	}

	public SimpleEnergyHandler(int arg0, int arg1, int arg2, int arg3) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the SimpleEnergyHandler constructor yet");
	}

	public void serialize(ValueOutput arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleEnergyHandler.serialize yet");
	}

	public void deserialize(ValueInput arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleEnergyHandler.deserialize yet");
	}

	public void set(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleEnergyHandler.set yet");
	}

	protected void onEnergyChanged(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleEnergyHandler.onEnergyChanged yet");
	}

	public long getAmountAsLong() {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleEnergyHandler.getAmountAsLong yet");
	}

	public long getCapacityAsLong() {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleEnergyHandler.getCapacityAsLong yet");
	}

	public int insert(int arg0, TransactionContext arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleEnergyHandler.insert yet");
	}

	public int extract(int arg0, TransactionContext arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement SimpleEnergyHandler.extract yet");
	}

	static class EnergyJournal extends SnapshotJournal<Integer> {
		private EnergyJournal(net.neoforged.neoforge.transfer.energy.SimpleEnergyHandler arg0) {
			super();
			throw new UnsupportedOperationException("SteelWool does not implement the SimpleEnergyHandler.EnergyJournal constructor yet");
		}

		protected Integer createSnapshot() {
			throw new UnsupportedOperationException("SteelWool does not implement SimpleEnergyHandler.EnergyJournal.createSnapshot yet");
		}

		protected void revertToSnapshot(Integer arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement SimpleEnergyHandler.EnergyJournal.revertToSnapshot yet");
		}

		protected void onRootCommit(Integer arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement SimpleEnergyHandler.EnergyJournal.onRootCommit yet");
		}
	}
}
