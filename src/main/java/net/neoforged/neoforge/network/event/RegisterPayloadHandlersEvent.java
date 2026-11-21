package net.neoforged.neoforge.network.event;

import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterPayloadHandlersEvent}, fired on the mod bus
 * after common setup.
 */
public class RegisterPayloadHandlersEvent extends Event implements IModBusEvent {
	public RegisterPayloadHandlersEvent() {
	}

	public PayloadRegistrar registrar(String version) {
		return new PayloadRegistrar(version);
	}
}
