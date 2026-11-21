package net.neoforged.neoforge.client.event;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ExtraCodecs;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterSpecialModelRendererEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterSpecialModelRendererEvent extends Event implements IModBusEvent {
	private final ExtraCodecs.LateBoundIdMapper<Identifier, MapCodec<? extends SpecialModelRenderer.Unbaked<?>>> idMapper;

	public RegisterSpecialModelRendererEvent(ExtraCodecs.LateBoundIdMapper<Identifier, MapCodec<? extends SpecialModelRenderer.Unbaked<?>>> idMapper) {
		super();
		this.idMapper = idMapper;
	}

	public void register(Identifier arg0, MapCodec<? extends SpecialModelRenderer.Unbaked<?>> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterSpecialModelRendererEvent.register yet");
	}
}
