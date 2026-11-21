package net.neoforged.neoforge.transfer.transaction;

/**
 * SteelWool re-implementation of NeoForge's {@code TransactionContext}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface TransactionContext {
	int depth();
}
