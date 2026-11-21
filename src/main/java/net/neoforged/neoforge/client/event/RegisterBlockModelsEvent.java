package net.neoforged.neoforge.client.event;

import net.minecraft.client.renderer.block.BuiltInBlockModels;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterBlockModelsEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class RegisterBlockModelsEvent extends Event implements IModBusEvent {
	private final BuiltInBlockModels.Builder builder;

	public RegisterBlockModelsEvent(BuiltInBlockModels.Builder builder) {
		super();
		this.builder = builder;
	}

	public void register(BlockModel.Unbaked arg0, Block arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterBlockModelsEvent.register yet");
	}

	public void register(BuiltInBlockModels.ModelFactory arg0, Block arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterBlockModelsEvent.register yet");
	}

	public void register(BuiltInBlockModels.ModelFactory arg0, Block arg1, Block arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterBlockModelsEvent.register yet");
	}

	public BuiltInBlockModels.Builder getBuilder() {
		return this.builder;
	}
}
