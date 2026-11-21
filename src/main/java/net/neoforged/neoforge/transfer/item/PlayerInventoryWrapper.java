package net.neoforged.neoforge.transfer.item;

import java.util.Deque;

import net.minecraft.util.Prediction;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.transaction.SnapshotJournal;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;

/**
 * SteelWool re-implementation of NeoForge's {@code PlayerInventoryWrapper}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class PlayerInventoryWrapper extends VanillaContainerWrapper {
	private final net.neoforged.neoforge.transfer.item.PlayerInventoryWrapper.DroppedItems droppedItems;
	private final Inventory inventory;

	public static net.neoforged.neoforge.transfer.item.PlayerInventoryWrapper of(Player arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.of yet");
	}

	public static net.neoforged.neoforge.transfer.item.PlayerInventoryWrapper of(Inventory arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.of yet");
	}

	PlayerInventoryWrapper(Inventory arg0) {
		super((Container) null);
		throw new UnsupportedOperationException("SteelWool does not implement the PlayerInventoryWrapper constructor yet");
	}

	void resize() {
		throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.resize yet");
	}

	void onRootCommit() {
		throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.onRootCommit yet");
	}

	public ResourceHandler<ItemResource> getSlot(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.getSlot yet");
	}

	public ResourceHandler<ItemResource> getMainHandSlot() {
		throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.getMainHandSlot yet");
	}

	public ResourceHandler<ItemResource> getHandSlot(InteractionHand arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.getHandSlot yet");
	}

	public ResourceHandler<ItemResource> getHandSlots() {
		throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.getHandSlots yet");
	}

	public ResourceHandler<ItemResource> getMainSlots() {
		throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.getMainSlots yet");
	}

	public ResourceHandler<ItemResource> getArmorSlot(EquipmentSlot arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.getArmorSlot yet");
	}

	public ResourceHandler<ItemResource> getArmorSlots() {
		throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.getArmorSlots yet");
	}

	public int insert(ItemResource arg0, int arg1, TransactionContext arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.insert yet");
	}

	public void placeItemBackInInventory(ItemResource arg0, int arg1, TransactionContext arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.placeItemBackInInventory yet");
	}

	public void drop(ItemResource arg0, int arg1, boolean arg2, boolean arg3, TransactionContext arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.drop yet");
	}

	public String toString() {
		throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.toString yet");
	}

	static class ArmorSlotWrapper extends VanillaContainerWrapper.SlotWrapper {
		private final EquipmentSlot slot;

		ArmorSlotWrapper(net.neoforged.neoforge.transfer.item.PlayerInventoryWrapper arg0, int arg1, EquipmentSlot arg2) {
			super((VanillaContainerWrapper) null, (int) 0);
			throw new UnsupportedOperationException("SteelWool does not implement the PlayerInventoryWrapper.ArmorSlotWrapper constructor yet");
		}

		protected boolean isValid(ItemResource arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.ArmorSlotWrapper.isValid yet");
		}

		protected int getCapacity(ItemResource arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.ArmorSlotWrapper.getCapacity yet");
		}

		public int extract(int arg0, ItemResource arg1, int arg2, TransactionContext arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.ArmorSlotWrapper.extract yet");
		}
	}

	static class DroppedItems extends SnapshotJournal<Integer> {
		final Deque<net.neoforged.neoforge.transfer.item.PlayerInventoryWrapper.DroppedItems.DropInfo> entries;

		private DroppedItems(net.neoforged.neoforge.transfer.item.PlayerInventoryWrapper arg0) {
			super();
			throw new UnsupportedOperationException("SteelWool does not implement the PlayerInventoryWrapper.DroppedItems constructor yet");
		}

		void addDrop(ItemResource arg0, int arg1, boolean arg2, Prediction arg3, TransactionContext arg4) {
			throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.DroppedItems.addDrop yet");
		}

		protected Integer createSnapshot() {
			throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.DroppedItems.createSnapshot yet");
		}

		protected void revertToSnapshot(Integer arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.DroppedItems.revertToSnapshot yet");
		}

		protected void onRootCommit(Integer arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement PlayerInventoryWrapper.DroppedItems.onRootCommit yet");
		}

		static record DropInfo(ItemResource resource, int amount, boolean dropAround, Prediction prediction) {
		}
	}
}
