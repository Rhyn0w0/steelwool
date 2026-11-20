package net.neoforged.neoforge.common.extensions;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.ItemCapability;
import org.jspecify.annotations.Nullable;

/**
 * Methods NeoForge adds to {@link ItemStack}. SteelWool adds this interface to {@code ItemStack}
 * with a mixin; so far it has the capability lookups.
 */
public interface IItemStackExtension {
	private ItemStack self() {
		return (ItemStack) (Object) this;
	}

	default <T, C> @Nullable T getCapability(ItemCapability<T, C> capability, C context) {
		return capability.getCapability(self(), context);
	}

	default <T> @Nullable T getCapability(ItemCapability<T, Void> capability) {
		return capability.getCapability(self(), null);
	}
}
