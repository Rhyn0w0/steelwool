package net.neoforged.neoforge.client.event;

import java.util.List;
import java.util.function.Supplier;

import net.minecraft.client.gui.render.pip.PictureInPictureRenderer;
import net.minecraft.client.renderer.state.gui.pip.PictureInPictureRenderState;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.client.gui.PictureInPictureRendererRegistration;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterPictureInPictureRenderersEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class RegisterPictureInPictureRenderersEvent extends Event implements IModBusEvent {
	private final List<PictureInPictureRendererRegistration<?>> renderers;

	public RegisterPictureInPictureRenderersEvent(List<PictureInPictureRendererRegistration<?>> renderers) {
		super();
		this.renderers = renderers;
	}

	public <T extends PictureInPictureRenderState> void register(Class<T> arg0, Supplier<PictureInPictureRenderer<T>> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterPictureInPictureRenderersEvent.register yet");
	}
}
