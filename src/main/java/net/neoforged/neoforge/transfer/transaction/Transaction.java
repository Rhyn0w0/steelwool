package net.neoforged.neoforge.transfer.transaction;

import java.util.List;

/**
 * SteelWool re-implementation of NeoForge's {@code Transaction}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class Transaction implements AutoCloseable,TransactionContext {
	private static final StackWalker STACK_WALKER = null /* SteelWool: TODO */;
	final TransactionManager manager;
	private final int depth;
	boolean open;
	final List<SnapshotJournal<?>> journalsToClose;
	Class<?> callerClass;

	public static net.neoforged.neoforge.transfer.transaction.Transaction openRoot() {
		throw new UnsupportedOperationException("SteelWool does not implement Transaction.openRoot yet");
	}

	public static net.neoforged.neoforge.transfer.transaction.Transaction open(TransactionContext arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement Transaction.open yet");
	}

	public static net.neoforged.neoforge.transfer.transaction.Transaction.Lifecycle getLifecycle() {
		throw new UnsupportedOperationException("SteelWool does not implement Transaction.getLifecycle yet");
	}

	public static TransactionContext getCurrentOpenedTransaction() {
		throw new UnsupportedOperationException("SteelWool does not implement Transaction.getCurrentOpenedTransaction yet");
	}

	public void commit() {
		throw new UnsupportedOperationException("SteelWool does not implement Transaction.commit yet");
	}

	public void close() {
		throw new UnsupportedOperationException("SteelWool does not implement Transaction.close yet");
	}

	public int depth() {
		throw new UnsupportedOperationException("SteelWool does not implement Transaction.depth yet");
	}

	public String toString() {
		throw new UnsupportedOperationException("SteelWool does not implement Transaction.toString yet");
	}

	Transaction(TransactionManager arg0, int arg1, Class<?> arg2) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the Transaction constructor yet");
	}

	void validateOpen() {
		throw new UnsupportedOperationException("SteelWool does not implement Transaction.validateOpen yet");
	}

	String getDebugName() {
		throw new UnsupportedOperationException("SteelWool does not implement Transaction.getDebugName yet");
	}

	private void close(boolean arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement Transaction.close yet");
	}

	public enum Lifecycle {
		NONE, OPEN, CLOSING, ROOT_CLOSING;
	}
}
