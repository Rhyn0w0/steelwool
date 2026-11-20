package net.neoforged.neoforge.common.extensions;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.network.IContainerFactory;

/**
 * SteelWool re-implementation of NeoForge's {@code IMenuTypeExtension}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IMenuTypeExtension<T extends Object> {
	static <T extends AbstractContainerMenu> MenuType<T> create(IContainerFactory<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IMenuTypeExtension.create yet");
	}

	T create(int arg0, Inventory arg1, RegistryFriendlyByteBuf arg2);
}
