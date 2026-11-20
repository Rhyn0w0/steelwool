package net.neoforged.neoforge.client.event;

import java.util.Map;
import java.util.function.Supplier;

import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.resources.model.sprite.MaterialBaker;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterFluidModelsEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class RegisterFluidModelsEvent extends Event implements IModBusEvent {
	private final Map<Fluid, FluidModel> models;
	private final MaterialBaker materials;

	public RegisterFluidModelsEvent(Map<Fluid, FluidModel> models, MaterialBaker materials) {
		super();
		this.models = models;
		this.materials = materials;
	}

	public void register(FluidModel.Unbaked arg0, Supplier<? extends Fluid> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterFluidModelsEvent.register yet");
	}

	public void register(FluidModel.Unbaked arg0, Fluid arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterFluidModelsEvent.register yet");
	}

	public void register(FluidModel.Unbaked arg0, Supplier<? extends Fluid> arg1, Supplier<? extends Fluid> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterFluidModelsEvent.register yet");
	}

	public void register(FluidModel.Unbaked arg0, Fluid arg1, Fluid arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterFluidModelsEvent.register yet");
	}

	private void register(Fluid arg0, FluidModel arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterFluidModelsEvent.register yet");
	}
}
