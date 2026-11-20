package net.neoforged.neoforge.transfer.fluid;

import net.neoforged.neoforge.transfer.ItemAccessResourceHandler;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.item.ItemResource;

/**
 * SteelWool re-implementation of NeoForge's {@code BucketResourceHandler}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class BucketResourceHandler extends ItemAccessResourceHandler<FluidResource> {
	public BucketResourceHandler(ItemAccess arg0) {
		super(arg0, 1);
	}

	protected FluidResource getResourceFrom(ItemResource arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement BucketResourceHandler.getResourceFrom yet");
	}

	protected int getAmountFrom(ItemResource arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement BucketResourceHandler.getAmountFrom yet");
	}

	protected ItemResource update(ItemResource arg0, int arg1, FluidResource arg2, int arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement BucketResourceHandler.update yet");
	}

	protected int getCapacity(int arg0, FluidResource arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement BucketResourceHandler.getCapacity yet");
	}
}
