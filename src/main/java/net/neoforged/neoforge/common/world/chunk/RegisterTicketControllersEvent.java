package net.neoforged.neoforge.common.world.chunk;

import java.util.function.Consumer;

import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterTicketControllersEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterTicketControllersEvent extends Event implements IModBusEvent {
	private final Consumer<TicketController> registrar;

	RegisterTicketControllersEvent(Consumer<TicketController> registrar) {
		super();
		this.registrar = registrar;
	}

	public void register(TicketController arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterTicketControllersEvent.register yet");
	}
}
