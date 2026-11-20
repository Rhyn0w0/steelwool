package net.neoforged.neoforge.transfer.item;

import java.util.Optional;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.neoforge.transfer.ItemAccessResourceHandler;
import net.neoforged.neoforge.transfer.access.ItemAccess;

/**
 * SteelWool re-implementation of NeoForge's {@code ItemAccessItemHandler}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ItemAccessItemHandler extends ItemAccessResourceHandler<ItemResource> {
	protected final Item validItem;
	protected final DataComponentType<ItemContainerContents> component;

	public ItemAccessItemHandler(ItemAccess arg0, DataComponentType<ItemContainerContents> arg1, int arg2) {
		super((ItemAccess) null, (int) 0);
		throw new UnsupportedOperationException("SteelWool does not implement the ItemAccessItemHandler constructor yet");
	}

	protected ItemContainerContents getContents(ItemResource arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccessItemHandler.getContents yet");
	}

	protected Optional<ItemStackTemplate> getTemplateFromContents(ItemContainerContents arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccessItemHandler.getTemplateFromContents yet");
	}

	protected ItemResource getResourceFrom(ItemResource arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccessItemHandler.getResourceFrom yet");
	}

	protected int getAmountFrom(ItemResource arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccessItemHandler.getAmountFrom yet");
	}

	protected ItemResource update(ItemResource arg0, int arg1, ItemResource arg2, int arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccessItemHandler.update yet");
	}

	public boolean isValid(int arg0, ItemResource arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccessItemHandler.isValid yet");
	}

	protected int getCapacity(int arg0, ItemResource arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAccessItemHandler.getCapacity yet");
	}
}
