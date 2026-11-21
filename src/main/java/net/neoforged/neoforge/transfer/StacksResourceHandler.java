package net.neoforged.neoforge.transfer;

import java.util.ArrayList;
import java.util.Collection;

import com.mojang.serialization.Codec;
import net.minecraft.core.NonNullList;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.common.util.ValueIOSerializable;
import net.neoforged.neoforge.transfer.resource.Resource;
import net.neoforged.neoforge.transfer.transaction.SnapshotJournal;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;

/**
 * SteelWool re-implementation of NeoForge's {@code StacksResourceHandler}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class StacksResourceHandler<S extends Object, T extends Resource> extends Object implements ResourceHandler<T>, ValueIOSerializable {
	public static final String VALUE_IO_KEY = "stacks";
	protected final S emptyStack;
	protected NonNullList<S> stacks;
	protected final Codec<NonNullList<S>> codec;
	private final ArrayList<StackJournal> snapshotJournals;

	protected StacksResourceHandler(int arg0, S arg1, Codec<S> arg2) {
		this((NonNullList) null, null, (Codec) null);
		throw new UnsupportedOperationException("SteelWool does not implement the StacksResourceHandler constructor yet");
	}

	protected StacksResourceHandler(NonNullList<S> arg0, S emptyStack, Codec<S> arg2) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the StacksResourceHandler constructor yet");
	}

	private NonNullList<S> mutableCopyOf(Collection<S> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement StacksResourceHandler.mutableCopyOf yet");
	}

	protected void setStacks(NonNullList<S> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement StacksResourceHandler.setStacks yet");
	}

	private void updateStacksSize() {
		throw new UnsupportedOperationException("SteelWool does not implement StacksResourceHandler.updateStacksSize yet");
	}

	public void serialize(ValueOutput arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement StacksResourceHandler.serialize yet");
	}

	public void deserialize(ValueInput arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement StacksResourceHandler.deserialize yet");
	}

	public void set(int arg0, T arg1, int arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement StacksResourceHandler.set yet");
	}

	protected abstract T getResourceFrom(S arg0);

	protected abstract int getAmountFrom(S arg0);

	protected abstract S getStackFrom(T arg0, int arg1);

	protected abstract S copyOf(S arg0);

	protected boolean matches(S arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement StacksResourceHandler.matches yet");
	}

	public boolean isValid(int arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement StacksResourceHandler.isValid yet");
	}

	protected abstract int getCapacity(int arg0, T arg1);

	protected void onContentsChanged(int arg0, S arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement StacksResourceHandler.onContentsChanged yet");
	}

	public NonNullList<S> copyToList() {
		throw new UnsupportedOperationException("SteelWool does not implement StacksResourceHandler.copyToList yet");
	}

	public int size() {
		throw new UnsupportedOperationException("SteelWool does not implement StacksResourceHandler.size yet");
	}

	public T getResource(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement StacksResourceHandler.getResource yet");
	}

	public long getAmountAsLong(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement StacksResourceHandler.getAmountAsLong yet");
	}

	public long getCapacityAsLong(int arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement StacksResourceHandler.getCapacityAsLong yet");
	}

	public int insert(int arg0, T arg1, int arg2, TransactionContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement StacksResourceHandler.insert yet");
	}

	public int extract(int arg0, T arg1, int arg2, TransactionContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement StacksResourceHandler.extract yet");
	}

	private class StackJournal extends SnapshotJournal<S> {
		private final int index;

		private StackJournal(int index) {
			this.index = index;
		}

		protected S createSnapshot() {
			throw new UnsupportedOperationException("SteelWool does not implement StacksResourceHandler.StackJournal.createSnapshot yet");
		}

		protected void revertToSnapshot(S arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement StacksResourceHandler.StackJournal.revertToSnapshot yet");
		}

		protected void onRootCommit(S arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement StacksResourceHandler.StackJournal.onRootCommit yet");
		}
	}
}
