package net.neoforged.neoforge.client.event;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ExtraCodecs;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterItemModelsEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterItemModelsEvent extends Event implements IModBusEvent {
	private final ExtraCodecs.LateBoundIdMapper<Identifier, MapCodec<? extends ItemModel.Unbaked>> idMapper;

	public RegisterItemModelsEvent(ExtraCodecs.LateBoundIdMapper<Identifier, MapCodec<? extends ItemModel.Unbaked>> idMapper) {
		super();
		this.idMapper = idMapper;
	}

	public void register(Identifier arg0, MapCodec<? extends ItemModel.Unbaked> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterItemModelsEvent.register yet");
	}
}
