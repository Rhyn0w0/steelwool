package net.neoforged.fml;

import net.neoforged.bus.api.IEventBus;

/**
 * SteelWool re-implementation of FML's {@code IBindingsProvider}: how FML reaches NeoForge's game bus.
 */
public interface IBindingsProvider {
	IEventBus getGameBus();
}
