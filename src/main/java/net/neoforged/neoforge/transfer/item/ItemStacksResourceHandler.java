package net.neoforged.neoforge.transfer.item;

import com.mojang.serialization.Codec;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.transfer.StacksResourceHandler;

/**
 * SteelWool re-implementation of NeoForge's {@code ItemStacksResourceHandler}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ItemStacksResourceHandler extends StacksResourceHandler<ItemStack, ItemResource> {
	public ItemStacksResourceHandler(int arg0) {
		super((int) 0, null, (Codec) null);
		throw new UnsupportedOperationException("SteelWool does not implement the ItemStacksResourceHandler constructor yet");
	}

	public ItemStacksResourceHandler(NonNullList<ItemStack> arg0) {
		super((NonNullList) null, null, (Codec) null);
		throw new UnsupportedOperationException("SteelWool does not implement the ItemStacksResourceHandler constructor yet");
	}

	public ItemResource getResourceFrom(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemStacksResourceHandler.getResourceFrom yet");
	}

	public int getAmountFrom(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemStacksResourceHandler.getAmountFrom yet");
	}

	protected ItemStack getStackFrom(ItemResource arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemStacksResourceHandler.getStackFrom yet");
	}

	protected int getCapacity(int arg0, ItemResource arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemStacksResourceHandler.getCapacity yet");
	}

	protected ItemStack copyOf(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemStacksResourceHandler.copyOf yet");
	}

	public boolean matches(ItemStack arg0, ItemResource arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemStacksResourceHandler.matches yet");
	}
}
