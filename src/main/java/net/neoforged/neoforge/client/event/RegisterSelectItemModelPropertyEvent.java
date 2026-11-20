package net.neoforged.neoforge.client.event;

import net.minecraft.client.renderer.item.properties.select.SelectItemModelProperty;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ExtraCodecs;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterSelectItemModelPropertyEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterSelectItemModelPropertyEvent extends Event implements IModBusEvent {
	private final ExtraCodecs.LateBoundIdMapper<Identifier, SelectItemModelProperty.Type<?, ?>> idMapper;

	public RegisterSelectItemModelPropertyEvent(ExtraCodecs.LateBoundIdMapper<Identifier, SelectItemModelProperty.Type<?, ?>> idMapper) {
		super();
		this.idMapper = idMapper;
	}

	public void register(Identifier arg0, SelectItemModelProperty.Type<?, ?> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterSelectItemModelPropertyEvent.register yet");
	}
}
