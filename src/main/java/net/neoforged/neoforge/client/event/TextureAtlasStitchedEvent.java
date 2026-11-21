package net.neoforged.neoforge.client.event;

import net.minecraft.client.renderer.texture.TextureAtlas;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code TextureAtlasStitchedEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class TextureAtlasStitchedEvent extends Event implements IModBusEvent {
	private final TextureAtlas atlas;

	public TextureAtlasStitchedEvent(TextureAtlas atlas) {
		super();
		this.atlas = atlas;
	}

	public TextureAtlas getAtlas() {
		return this.atlas;
	}
}
