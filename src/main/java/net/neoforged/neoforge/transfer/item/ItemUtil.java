package net.neoforged.neoforge.transfer.item;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;

/**
 * SteelWool re-implementation of NeoForge's {@code ItemUtil}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class ItemUtil {
	private ItemUtil() {
		super();
	}

	public static ItemStack getStack(ResourceHandler<ItemResource> arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemUtil.getStack yet");
	}

	public static ItemStack insertItemReturnRemaining(ResourceHandler<ItemResource> arg0, ItemStack arg1, boolean arg2, TransactionContext arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemUtil.insertItemReturnRemaining yet");
	}

	public static ItemStack insertItemReturnRemaining(ResourceHandler<ItemResource> arg0, int arg1, ItemStack arg2, boolean arg3, TransactionContext arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemUtil.insertItemReturnRemaining yet");
	}
}
