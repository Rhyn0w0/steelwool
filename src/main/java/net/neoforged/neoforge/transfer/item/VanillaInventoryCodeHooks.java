package net.neoforged.neoforge.transfer.item;

import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.Hopper;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.neoforged.neoforge.transfer.ResourceHandler;

/**
 * SteelWool re-implementation of NeoForge's {@code VanillaInventoryCodeHooks}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class VanillaInventoryCodeHooks {
	public VanillaInventoryCodeHooks() {
		super();
	}

	public static boolean extractHook(Hopper arg0, ResourceHandler<ItemResource> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement VanillaInventoryCodeHooks.extractHook yet");
	}

	public static boolean insertHook(HopperBlockEntity arg0, ResourceHandler<ItemResource> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement VanillaInventoryCodeHooks.insertHook yet");
	}

	public static ContainerOrHandler getEntityContainerOrHandler(Level arg0, double arg1, double arg2, double arg3, Direction arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement VanillaInventoryCodeHooks.getEntityContainerOrHandler yet");
	}
}
