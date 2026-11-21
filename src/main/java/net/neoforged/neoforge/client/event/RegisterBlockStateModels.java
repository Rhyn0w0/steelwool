package net.neoforged.neoforge.client.event;

import com.mojang.serialization.MapCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ExtraCodecs;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.client.model.block.CustomBlockModelDefinition;
import net.neoforged.neoforge.client.model.block.CustomUnbakedBlockStateModel;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterBlockStateModels}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterBlockStateModels extends Event implements IModBusEvent {
	private final ExtraCodecs.LateBoundIdMapper<Identifier, MapCodec<? extends CustomUnbakedBlockStateModel>> modelIdMapper;
	private final ExtraCodecs.LateBoundIdMapper<Identifier, MapCodec<? extends CustomBlockModelDefinition>> defintionIdMapper;

	public RegisterBlockStateModels(ExtraCodecs.LateBoundIdMapper<Identifier, MapCodec<? extends CustomUnbakedBlockStateModel>> modelIdMapper, ExtraCodecs.LateBoundIdMapper<Identifier, MapCodec<? extends CustomBlockModelDefinition>> defintionIdMapper) {
		super();
		this.modelIdMapper = modelIdMapper;
		this.defintionIdMapper = defintionIdMapper;
	}

	public void registerModel(Identifier arg0, MapCodec<? extends CustomUnbakedBlockStateModel> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterBlockStateModels.registerModel yet");
	}

	public void registerDefinition(Identifier arg0, MapCodec<? extends CustomBlockModelDefinition> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterBlockStateModels.registerDefinition yet");
	}
}
