package net.neoforged.neoforge.transfer.item;

import net.minecraft.core.Direction;
import net.minecraft.world.WorldlyContainer;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;

/**
 * SteelWool re-implementation of NeoForge's {@code WorldlyContainerWrapper}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class WorldlyContainerWrapper extends Object implements ResourceHandler<ItemResource> {
	private final WorldlyContainer container;
	private final VanillaContainerWrapper wrapper;
	private final Direction side;

	public WorldlyContainerWrapper(WorldlyContainer container, Direction arg1) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the WorldlyContainerWrapper constructor yet");
	}

	private int convertSlot(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement WorldlyContainerWrapper.convertSlot yet");
	}

	public int size() {
		throw new UnsupportedOperationException("SteelWool does not implement WorldlyContainerWrapper.size yet");
	}

	public ItemResource getResource(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement WorldlyContainerWrapper.getResource yet");
	}

	public long getAmountAsLong(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement WorldlyContainerWrapper.getAmountAsLong yet");
	}

	public long getCapacityAsLong(int arg0, ItemResource arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement WorldlyContainerWrapper.getCapacityAsLong yet");
	}

	public boolean isValid(int arg0, ItemResource arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement WorldlyContainerWrapper.isValid yet");
	}

	public int insert(int arg0, ItemResource arg1, int arg2, TransactionContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement WorldlyContainerWrapper.insert yet");
	}

	public int extract(int arg0, ItemResource arg1, int arg2, TransactionContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement WorldlyContainerWrapper.extract yet");
	}
}
