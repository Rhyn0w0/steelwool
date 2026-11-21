package net.neoforged.neoforge.common.world;

import java.util.Optional;

import net.minecraft.world.level.biome.BiomeSpecialEffects;

/**
 * SteelWool re-implementation of NeoForge's {@code BiomeSpecialEffectsBuilder}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class BiomeSpecialEffectsBuilder extends BiomeSpecialEffects.Builder {
	public static net.neoforged.neoforge.common.world.BiomeSpecialEffectsBuilder copyOf(BiomeSpecialEffects arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BiomeSpecialEffectsBuilder.copyOf yet");
	}

	public static net.neoforged.neoforge.common.world.BiomeSpecialEffectsBuilder create(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BiomeSpecialEffectsBuilder.create yet");
	}

	protected BiomeSpecialEffectsBuilder(int arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the BiomeSpecialEffectsBuilder constructor yet");
	}

	public net.neoforged.neoforge.common.world.BiomeSpecialEffectsBuilder foliageColorOverride(Optional<Integer> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BiomeSpecialEffectsBuilder.foliageColorOverride yet");
	}

	public net.neoforged.neoforge.common.world.BiomeSpecialEffectsBuilder dryFoliageColorOverride(Optional<Integer> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BiomeSpecialEffectsBuilder.dryFoliageColorOverride yet");
	}

	public net.neoforged.neoforge.common.world.BiomeSpecialEffectsBuilder grassColorOverride(Optional<Integer> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BiomeSpecialEffectsBuilder.grassColorOverride yet");
	}

	public int waterColor() {
		throw new UnsupportedOperationException("SteelWool does not implement BiomeSpecialEffectsBuilder.waterColor yet");
	}

	public BiomeSpecialEffects.GrassColorModifier getGrassColorModifier() {
		return this.grassColorModifier;
	}

	public Optional<Integer> getFoliageColorOverride() {
		return this.foliageColorOverride;
	}

	public Optional<Integer> getDryFoliageColorOverride() {
		return this.dryFoliageColorOverride;
	}

	public Optional<Integer> getGrassColorOverride() {
		return this.grassColorOverride;
	}
}
