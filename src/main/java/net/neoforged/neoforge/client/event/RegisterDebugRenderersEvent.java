package net.neoforged.neoforge.client.event;

import java.util.function.Consumer;
import java.util.function.Function;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.debug.DebugRenderer;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterDebugRenderersEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class RegisterDebugRenderersEvent extends Event implements IModBusEvent {
	private final Consumer<Function<Minecraft, DebugRenderer.SimpleDebugRenderer>> registrar;

	public RegisterDebugRenderersEvent(Consumer<Function<Minecraft, DebugRenderer.SimpleDebugRenderer>> registrar) {
		super();
		this.registrar = registrar;
	}

	public void register(Function<Minecraft, DebugRenderer.SimpleDebugRenderer> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterDebugRenderersEvent.register yet");
	}

	public void register(DebugRenderer.SimpleDebugRenderer arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterDebugRenderersEvent.register yet");
	}
}
