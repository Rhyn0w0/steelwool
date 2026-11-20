package net.neoforged.neoforge.client.gui;

import java.util.function.Supplier;

import net.minecraft.client.gui.render.pip.PictureInPictureRenderer;
import net.minecraft.client.renderer.state.gui.pip.PictureInPictureRenderState;

/**
 * SteelWool re-implementation of NeoForge's {@code PictureInPictureRendererRegistration}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record PictureInPictureRendererRegistration<T extends PictureInPictureRenderState>(Class<T> stateClass, Supplier<PictureInPictureRenderer<T>> factory) {
}
