package net.neoforged.neoforge.client.event;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.ParticleGroup;
import net.minecraft.client.particle.ParticleRenderType;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterParticleGroupsEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterParticleGroupsEvent extends Event implements IModBusEvent {
	private final Map<ParticleRenderType, Function<ParticleEngine, ParticleGroup<?>>> particleGroupFactories;
	private final List<ParticleRenderType> particleRenderOrder;

	public RegisterParticleGroupsEvent(Map<ParticleRenderType, Function<ParticleEngine, ParticleGroup<?>>> particleGroupFactories, List<ParticleRenderType> particleRenderOrder) {
		super();
		this.particleGroupFactories = particleGroupFactories;
		this.particleRenderOrder = particleRenderOrder;
	}

	public void register(ParticleRenderType arg0, Function<ParticleEngine, ParticleGroup<?>> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterParticleGroupsEvent.register yet");
	}
}
