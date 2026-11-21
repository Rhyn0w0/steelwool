package net.neoforged.neoforge.client.event;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.renderer.item.properties.conditional.ConditionalItemModelProperty;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ExtraCodecs;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterConditionalItemModelPropertyEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterConditionalItemModelPropertyEvent extends Event implements IModBusEvent {
	private final ExtraCodecs.LateBoundIdMapper<Identifier, MapCodec<? extends ConditionalItemModelProperty>> idMapper;

	public RegisterConditionalItemModelPropertyEvent(ExtraCodecs.LateBoundIdMapper<Identifier, MapCodec<? extends ConditionalItemModelProperty>> idMapper) {
		super();
		this.idMapper = idMapper;
	}

	public void register(Identifier arg0, MapCodec<? extends ConditionalItemModelProperty> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterConditionalItemModelPropertyEvent.register yet");
	}
}
