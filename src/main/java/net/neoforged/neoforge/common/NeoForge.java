package net.neoforged.neoforge.common;

import net.neoforged.bus.api.BusBuilder;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of {@code NeoForge}: holds the game event bus. SteelWool posts
 * game events to it from Fabric API callbacks (see {@code dev.steelwool.bridge}).
 */
public class NeoForge {
	public static final IEventBus EVENT_BUS = BusBuilder.builder().startShutdown().classChecker(eventType -> {
		if (IModBusEvent.class.isAssignableFrom(eventType)) {
			throw new IllegalArgumentException("IModBusEvent events are not allowed on the common NeoForge bus! Use a mod bus instead.");
		}
	}).build();
}
