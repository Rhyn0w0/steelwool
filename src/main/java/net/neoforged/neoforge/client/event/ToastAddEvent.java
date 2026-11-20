package net.neoforged.neoforge.client.event;

import net.minecraft.client.gui.components.toasts.Toast;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code ToastAddEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ToastAddEvent extends Event implements ICancellableEvent {
	private final Toast toast;

	public ToastAddEvent(Toast toast) {
		super();
		this.toast = toast;
	}

	public Toast getToast() {
		return this.toast;
	}
}
