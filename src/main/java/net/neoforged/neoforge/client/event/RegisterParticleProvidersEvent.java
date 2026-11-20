package net.neoforged.neoforge.client.event;

import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleResources;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterParticleProvidersEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterParticleProvidersEvent extends Event implements IModBusEvent {
	private final ParticleResources particleResources;

	public RegisterParticleProvidersEvent(ParticleResources particleResources) {
		super();
		this.particleResources = particleResources;
	}

	public <T extends ParticleOptions> void registerSpecial(ParticleType<T> arg0, ParticleProvider<T> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterParticleProvidersEvent.registerSpecial yet");
	}

	public <T extends ParticleOptions> void registerSpriteSet(ParticleType<T> arg0, ParticleResources.SpriteParticleRegistration<T> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterParticleProvidersEvent.registerSpriteSet yet");
	}
}
