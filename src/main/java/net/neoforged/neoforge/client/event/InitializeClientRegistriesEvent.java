package net.neoforged.neoforge.client.event;

import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code InitializeClientRegistriesEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class InitializeClientRegistriesEvent extends Event implements IModBusEvent {
	public InitializeClientRegistriesEvent() {
		super();
	}
}
