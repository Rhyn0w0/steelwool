package net.neoforged.neoforge.transfer.transaction;

import java.util.List;
import java.util.Queue;

/**
 * SteelWool re-implementation of NeoForge's {@code TransactionManager}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
final class TransactionManager {
	private static final ThreadLocal<net.neoforged.neoforge.transfer.transaction.TransactionManager> MANAGERS = null /* SteelWool: TODO */;
	final Thread thread;
	final List<Transaction> stack;
	int currentDepth;
	final Queue<SnapshotJournal<?>> rootCommitQueue;
	boolean processingRootCommitQueue;

	static net.neoforged.neoforge.transfer.transaction.TransactionManager getManagerForThread() {
		throw new UnsupportedOperationException("SteelWool does not implement TransactionManager.getManagerForThread yet");
	}

	Transaction open(TransactionContext arg0, Class<?> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement TransactionManager.open yet");
	}

	Transaction getOpenTransaction(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement TransactionManager.getOpenTransaction yet");
	}

	void validateCurrentThread() {
		throw new UnsupportedOperationException("SteelWool does not implement TransactionManager.validateCurrentThread yet");
	}

	void validateCurrentTransaction(Transaction arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement TransactionManager.validateCurrentTransaction yet");
	}

	RuntimeException processRootCommitQueue(RuntimeException arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement TransactionManager.processRootCommitQueue yet");
	}

	private TransactionManager() {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the TransactionManager constructor yet");
	}
}
