package net.neoforged.neoforge.transfer.access;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.ItemCapability;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;

/**
 * SteelWool re-implementation of NeoForge's {@code ItemAccess}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface ItemAccess {
	static net.neoforged.neoforge.transfer.access.ItemAccess forPlayerInteraction(Player arg0, InteractionHand arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccess.forPlayerInteraction yet");
	}

	static net.neoforged.neoforge.transfer.access.ItemAccess forInfiniteMaterials(Player arg0, ItemStack arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccess.forInfiniteMaterials yet");
	}

	static net.neoforged.neoforge.transfer.access.ItemAccess forPlayerCursor(Player arg0, AbstractContainerMenu arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccess.forPlayerCursor yet");
	}

	static net.neoforged.neoforge.transfer.access.ItemAccess forPlayerSlot(Player arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccess.forPlayerSlot yet");
	}

	static net.neoforged.neoforge.transfer.access.ItemAccess forHandlerIndex(ResourceHandler<ItemResource> arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccess.forHandlerIndex yet");
	}

	static net.neoforged.neoforge.transfer.access.ItemAccess forHandlerIndexStrict(ResourceHandler<ItemResource> arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccess.forHandlerIndexStrict yet");
	}

	static net.neoforged.neoforge.transfer.access.ItemAccess forStack(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccess.forStack yet");
	}

	default net.neoforged.neoforge.transfer.access.ItemAccess oneByOne() {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccess.oneByOne yet");
	}

	default <T extends Object> T getCapability(ItemCapability<T, net.neoforged.neoforge.transfer.access.ItemAccess> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccess.getCapability yet");
	}

	ItemResource getResource();

	int getAmount();

	int insert(ItemResource arg0, int arg1, TransactionContext arg2);

	int extract(ItemResource arg0, int arg1, TransactionContext arg2);

	default int exchange(ItemResource arg0, int arg1, TransactionContext arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccess.exchange yet");
	}
}
