package net.neoforged.neoforge.transfer.item;

import net.minecraft.world.Container;
import net.neoforged.neoforge.transfer.ResourceHandler;

/**
 * SteelWool re-implementation of NeoForge's {@code ContainerOrHandler}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record ContainerOrHandler(Container container, ResourceHandler<ItemResource> itemHandler) {
	public static final net.neoforged.neoforge.transfer.item.ContainerOrHandler EMPTY = new ContainerOrHandler(null, null);

	public boolean isEmpty() {
		return container == null && itemHandler == null;
	}
}
