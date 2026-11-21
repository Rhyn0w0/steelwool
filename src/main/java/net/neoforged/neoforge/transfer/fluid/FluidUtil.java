package net.neoforged.neoforge.transfer.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.resource.ResourceStack;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;
import org.slf4j.Logger;

/**
 * SteelWool re-implementation of NeoForge's {@code FluidUtil}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class FluidUtil {
	private static final Logger LOGGER = null /* SteelWool: TODO */;

	private FluidUtil() {
		super();
	}

	public static FluidStack getStack(ResourceHandler<FluidResource> arg0, int arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidUtil.getStack yet");
	}

	public static FluidStack getFirstStackContained(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidUtil.getFirstStackContained yet");
	}

	public static boolean interactWithFluidHandler(Player arg0, InteractionHand arg1, Level arg2, BlockPos arg3, Direction arg4, TransactionContext arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidUtil.interactWithFluidHandler yet");
	}

	public static boolean interactWithFluidHandler(Player arg0, InteractionHand arg1, BlockPos arg2, ResourceHandler<FluidResource> arg3, TransactionContext arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidUtil.interactWithFluidHandler yet");
	}

	private static ResourceStack<FluidResource> moveWithSound(ResourceHandler<FluidResource> arg0, ResourceHandler<FluidResource> arg1, Level arg2, BlockPos arg3, Player arg4, TransactionContext arg5, boolean arg6) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidUtil.moveWithSound yet");
	}

	private static void playSoundAndGameEvent(FluidResource arg0, Level arg1, BlockPos arg2, Player arg3, TransactionContext arg4, boolean arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidUtil.playSoundAndGameEvent yet");
	}

	public static void triggerSoundAndGameEvent(FluidResource arg0, Level arg1, Vec3 arg2, Player arg3, boolean arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidUtil.triggerSoundAndGameEvent yet");
	}

	public static FluidStack tryPickupFluid(ResourceHandler<FluidResource> arg0, Player arg1, Level arg2, BlockPos arg3, Direction arg4, TransactionContext arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidUtil.tryPickupFluid yet");
	}

	public static FluidStack tryPickupFluid(ResourceHandler<FluidResource> arg0, Player arg1, Level arg2, BlockPos arg3, TransactionContext arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidUtil.tryPickupFluid yet");
	}

	private static FluidStack tryPickupFluid(ResourceHandler<FluidResource> arg0, Player arg1, Level arg2, BlockPos arg3, BucketPickup arg4, TransactionContext arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidUtil.tryPickupFluid yet");
	}

	public static FluidStack tryPlaceFluid(ResourceHandler<FluidResource> arg0, Player arg1, Level arg2, BlockPos arg3, boolean arg4, TransactionContext arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidUtil.tryPlaceFluid yet");
	}

	public static boolean tryPlaceFluid(FluidResource arg0, Player arg1, Level arg2, BlockPos arg3, boolean arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidUtil.tryPlaceFluid yet");
	}

	private static boolean tryPlaceFluid(FluidResource arg0, Player arg1, Level arg2, BlockPos arg3, boolean arg4, TransactionContext arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidUtil.tryPlaceFluid yet");
	}
}
