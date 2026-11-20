package net.neoforged.neoforge.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

/**
 * SteelWool re-implementation of NeoForge's {@code IContainerFactory}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IContainerFactory<T extends AbstractContainerMenu> extends MenuType.MenuSupplier<T> {
	T create(int arg0, Inventory arg1, RegistryFriendlyByteBuf arg2);

	default T create(int arg0, Inventory arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IContainerFactory.create yet");
	}
}
