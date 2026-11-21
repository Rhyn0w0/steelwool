package net.neoforged.neoforge.client.event;

import com.mojang.blaze3d.platform.Window;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code WindowResizeEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class WindowResizeEvent extends Event {
	private final Window window;

	public WindowResizeEvent(Window window) {
		super();
		this.window = window;
	}

	public Window getWindow() {
		return this.window;
	}
}
