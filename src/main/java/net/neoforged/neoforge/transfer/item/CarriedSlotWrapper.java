package net.neoforged.neoforge.transfer.item;

import java.util.Map;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.transfer.ResourceHandler;

/**
 * SteelWool re-implementation of NeoForge's {@code CarriedSlotWrapper}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class CarriedSlotWrapper extends ItemStackResourceHandler {
	private static final Map<AbstractContainerMenu, net.neoforged.neoforge.transfer.item.CarriedSlotWrapper> wrappers = null /* SteelWool: TODO */;
	private final AbstractContainerMenu menu;

	public static ResourceHandler<ItemResource> of(AbstractContainerMenu arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CarriedSlotWrapper.of yet");
	}

	private CarriedSlotWrapper(AbstractContainerMenu menu) {
		super();
		this.menu = menu;
	}

	protected ItemStack getStack() {
		throw new UnsupportedOperationException("SteelWool does not implement CarriedSlotWrapper.getStack yet");
	}

	protected void setStack(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CarriedSlotWrapper.setStack yet");
	}

	public String toString() {
		throw new UnsupportedOperationException("SteelWool does not implement CarriedSlotWrapper.toString yet");
	}
}
