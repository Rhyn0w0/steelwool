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
	/** A menu type whose client-side menu is created with the extra data the server sent when opening it. */
	static <T extends AbstractContainerMenu> MenuType<T> create(IContainerFactory<T> factory) {
		return new MenuType<>(factory, net.minecraft.world.flag.FeatureFlags.DEFAULT_FLAGS);
	}

	T create(int arg0, Inventory arg1, RegistryFriendlyByteBuf arg2);
}
