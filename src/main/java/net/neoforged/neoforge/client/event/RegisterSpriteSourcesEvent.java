package net.neoforged.neoforge.client.event;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ExtraCodecs;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterSpriteSourcesEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterSpriteSourcesEvent extends Event implements IModBusEvent {
	private final ExtraCodecs.LateBoundIdMapper<Identifier, MapCodec<? extends SpriteSource>> idMapper;

	public RegisterSpriteSourcesEvent(ExtraCodecs.LateBoundIdMapper<Identifier, MapCodec<? extends SpriteSource>> idMapper) {
		super();
		this.idMapper = idMapper;
	}

	public void register(Identifier arg0, MapCodec<? extends SpriteSource> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterSpriteSourcesEvent.register yet");
	}
}
