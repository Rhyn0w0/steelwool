package net.neoforged.neoforge.client.data;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;

/**
 * SteelWool re-implementation of NeoForge's {@code ParticleDescriptionProvider}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class ParticleDescriptionProvider implements DataProvider {
	private final PackOutput.PathProvider particlesPath;
	protected final Map<Identifier, List<String>> descriptions;

	protected ParticleDescriptionProvider(PackOutput arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the ParticleDescriptionProvider constructor yet");
	}

	protected abstract void addDescriptions();

	protected void spriteSet(ParticleType<?> arg0, Identifier arg1, int arg2, boolean arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ParticleDescriptionProvider.spriteSet yet");
	}

	protected void spriteSet(ParticleType<?> arg0, Identifier arg1, Identifier... arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ParticleDescriptionProvider.spriteSet yet");
	}

	protected void spriteSet(ParticleType<?> arg0, Iterable<Identifier> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ParticleDescriptionProvider.spriteSet yet");
	}

	public CompletableFuture<?> run(CachedOutput arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ParticleDescriptionProvider.run yet");
	}

	public String getName() {
		throw new UnsupportedOperationException("SteelWool does not implement ParticleDescriptionProvider.getName yet");
	}
}
