package net.neoforged.neoforge.transfer.transaction;

import java.util.ArrayList;

/**
 * SteelWool re-implementation of NeoForge's {@code SnapshotJournal}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class SnapshotJournal<T extends Object> extends Object {
	private static final Object NO_SNAPSHOT = null /* SteelWool: TODO */;
	private final ArrayList<T> snapshots;
	private int snapshotCount;
	private T originalState;

	public SnapshotJournal() {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the SnapshotJournal constructor yet");
	}

	protected abstract T createSnapshot();

	protected abstract void revertToSnapshot(T arg0);

	protected void releaseSnapshot(T arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SnapshotJournal.releaseSnapshot yet");
	}

	protected void onRootCommit(T arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SnapshotJournal.onRootCommit yet");
	}

	public final boolean isInTransaction() {
		throw new UnsupportedOperationException("SteelWool does not implement SnapshotJournal.isInTransaction yet");
	}

	public void updateSnapshots(TransactionContext arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SnapshotJournal.updateSnapshots yet");
	}

	void onClose(Transaction arg0, boolean arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement SnapshotJournal.onClose yet");
	}

	void callOnRootCommit() {
		throw new UnsupportedOperationException("SteelWool does not implement SnapshotJournal.callOnRootCommit yet");
	}
}
