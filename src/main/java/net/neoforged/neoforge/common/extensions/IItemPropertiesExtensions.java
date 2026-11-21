package net.neoforged.neoforge.common.extensions;

import java.util.function.Supplier;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.item.Item;

/** Methods NeoForge adds to {@link Item.Properties}; SteelWool adds this interface with a mixin. */
public interface IItemPropertiesExtensions {
	/** Sets a default component, with the type given as a supplier (such as a {@code DeferredHolder}). */
	default <T> Item.Properties component(Supplier<? extends DataComponentType<T>> type, T value) {
		return ((Item.Properties) this).component(type.get(), value);
	}
}
