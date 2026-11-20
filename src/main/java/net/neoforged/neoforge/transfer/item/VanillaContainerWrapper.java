package net.neoforged.neoforge.transfer.item;

import java.util.List;
import java.util.Map;

import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.transaction.RootCommitJournal;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;

/**
 * SteelWool re-implementation of NeoForge's {@code VanillaContainerWrapper}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class VanillaContainerWrapper extends Object implements ResourceHandler<ItemResource> {
	private static final Map<Container, net.neoforged.neoforge.transfer.item.VanillaContainerWrapper> wrappers = null /* SteelWool: TODO */;
	private final Container container;
	int size;
	final List<net.neoforged.neoforge.transfer.item.VanillaContainerWrapper.SlotWrapper> slotWrappers;
	private final RootCommitJournal setChangedJournal;

	public static ResourceHandler<ItemResource> of(Container arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.of yet");
	}

	public static ResourceHandler<ItemResource> ofUncached(Container arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.ofUncached yet");
	}

	static net.neoforged.neoforge.transfer.item.VanillaContainerWrapper internalOf(Container arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.internalOf yet");
	}

	private static net.neoforged.neoforge.transfer.item.VanillaContainerWrapper createWrapper(Container arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.createWrapper yet");
	}

	VanillaContainerWrapper(Container arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the VanillaContainerWrapper constructor yet");
	}

	void resize() {
		throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.resize yet");
	}

	net.neoforged.neoforge.transfer.item.VanillaContainerWrapper.SlotWrapper getSlotWrapper(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.getSlotWrapper yet");
	}

	void onRootCommit() {
		throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.onRootCommit yet");
	}

	public int size() {
		return this.size;
	}

	public int insert(int arg0, ItemResource arg1, int arg2, TransactionContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.insert yet");
	}

	public int extract(int arg0, ItemResource arg1, int arg2, TransactionContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.extract yet");
	}

	public ItemResource getResource(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.getResource yet");
	}

	public long getAmountAsLong(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.getAmountAsLong yet");
	}

	public long getCapacityAsLong(int arg0, ItemResource arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.getCapacityAsLong yet");
	}

	public boolean isValid(int arg0, ItemResource arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.isValid yet");
	}

	public String toString() {
		throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.toString yet");
	}

	static class SlotWrapper extends ItemStackResourceHandler {
		private final int index;

		SlotWrapper(net.neoforged.neoforge.transfer.item.VanillaContainerWrapper arg0, int arg1) {
			super();
			throw new UnsupportedOperationException("SteelWool does not implement the VanillaContainerWrapper.SlotWrapper constructor yet");
		}

		protected ItemStack getStack() {
			throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.SlotWrapper.getStack yet");
		}

		protected void setStack(ItemStack arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.SlotWrapper.setStack yet");
		}

		protected boolean isValid(ItemResource arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.SlotWrapper.isValid yet");
		}

		protected int getCapacity(ItemResource arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.SlotWrapper.getCapacity yet");
		}

		public int insert(int arg0, ItemResource arg1, int arg2, TransactionContext arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.SlotWrapper.insert yet");
		}

		public int extract(int arg0, ItemResource arg1, int arg2, TransactionContext arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.SlotWrapper.extract yet");
		}

		public void updateSnapshots(TransactionContext arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.SlotWrapper.updateSnapshots yet");
		}

		protected void onRootCommit(ItemStack arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.SlotWrapper.onRootCommit yet");
		}

		public String toString() {
			throw new UnsupportedOperationException("SteelWool does not implement VanillaContainerWrapper.SlotWrapper.toString yet");
		}
	}
}
