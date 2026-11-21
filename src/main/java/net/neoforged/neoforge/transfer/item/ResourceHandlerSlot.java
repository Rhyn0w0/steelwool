package net.neoforged.neoforge.transfer.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.transfer.IndexModifier;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.world.inventory.StackCopySlot;

/**
 * SteelWool re-implementation of NeoForge's {@code ResourceHandlerSlot}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ResourceHandlerSlot extends StackCopySlot {
	private final ResourceHandler<ItemResource> handler;
	private final IndexModifier<ItemResource> slotModifier;

	public ResourceHandlerSlot(ResourceHandler<ItemResource> handler, IndexModifier<ItemResource> slotModifier, int arg2, int arg3, int arg4) {
		super(arg2, arg3, arg4);
		this.handler = handler;
		this.slotModifier = slotModifier;
	}

	public boolean mayPlace(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerSlot.mayPlace yet");
	}

	protected ItemStack getStackCopy() {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerSlot.getStackCopy yet");
	}

	protected void setStackCopy(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerSlot.setStackCopy yet");
	}

	public void onQuickCraft(ItemStack arg0, ItemStack arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerSlot.onQuickCraft yet");
	}

	public int getMaxStackSize() {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerSlot.getMaxStackSize yet");
	}

	public int getMaxStackSize(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerSlot.getMaxStackSize yet");
	}

	public boolean mayPickup(Player arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerSlot.mayPickup yet");
	}

	public ResourceHandler<ItemResource> getResourceHandler() {
		return this.handler;
	}

	public boolean isSameInventory(Slot arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourceHandlerSlot.isSameInventory yet");
	}
}
