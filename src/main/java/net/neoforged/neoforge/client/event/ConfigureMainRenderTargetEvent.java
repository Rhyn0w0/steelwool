package net.neoforged.neoforge.client.event;

import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code ConfigureMainRenderTargetEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ConfigureMainRenderTargetEvent extends Event implements IModBusEvent {
	private boolean enableStencil;

	public ConfigureMainRenderTargetEvent() {
		super();
	}

	public boolean isStencilEnabled() {
		return this.enableStencil;
	}

	public void enableStencil() {
		throw new UnsupportedOperationException("SteelWool does not implement ConfigureMainRenderTargetEvent.enableStencil yet");
	}
}
