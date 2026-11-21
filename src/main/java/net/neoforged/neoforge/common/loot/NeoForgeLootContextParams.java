package net.neoforged.neoforge.common.loot;

import net.minecraft.util.context.ContextKey;
import net.minecraft.world.item.ItemInstance;
import net.neoforged.neoforge.event.RegisterLootContextParamsEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code NeoForgeLootContextParams}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class NeoForgeLootContextParams {
	public static final ContextKey<ItemInstance> QUERIED_STACK = null /* SteelWool: TODO */;

	private NeoForgeLootContextParams() {
		super();
	}

	public static void registerParams(RegisterLootContextParamsEvent arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement NeoForgeLootContextParams.registerParams yet");
	}
}
