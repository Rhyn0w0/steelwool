package net.neoforged.neoforge.transfer.transaction;

/**
 * SteelWool re-implementation of NeoForge's {@code RootCommitJournal}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class RootCommitJournal extends SnapshotJournal<Void> {
	private final Runnable rootCommitCallback;

	public RootCommitJournal(Runnable rootCommitCallback) {
		super();
		this.rootCommitCallback = rootCommitCallback;
	}

	protected Void createSnapshot() {
		throw new UnsupportedOperationException("SteelWool does not implement RootCommitJournal.createSnapshot yet");
	}

	protected void revertToSnapshot(Void arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RootCommitJournal.revertToSnapshot yet");
	}

	protected void onRootCommit(Void arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RootCommitJournal.onRootCommit yet");
	}
}
