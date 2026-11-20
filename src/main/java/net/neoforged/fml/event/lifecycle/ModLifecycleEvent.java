package net.neoforged.fml.event.lifecycle;

import net.neoforged.bus.api.Event;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.IModBusEvent;

/**
 * Base class of FML's mod loading lifecycle events.
 */
public abstract class ModLifecycleEvent extends Event implements IModBusEvent {
	private final ModContainer container;

	public ModLifecycleEvent(ModContainer container) {
		this.container = container;
	}

	public ModContainer getContainer() {
		return this.container;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "{" + container.getModId() + "}";
	}
}
