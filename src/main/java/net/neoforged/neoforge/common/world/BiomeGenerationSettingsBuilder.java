package net.neoforged.neoforge.common.world;

import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

/**
 * SteelWool re-implementation of NeoForge's {@code BiomeGenerationSettingsBuilder}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class BiomeGenerationSettingsBuilder extends BiomeGenerationSettings.PlainBuilder {
	public BiomeGenerationSettingsBuilder(BiomeGenerationSettings arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the BiomeGenerationSettingsBuilder constructor yet");
	}

	public List<Holder<PlacedFeature>> getFeatures(GenerationStep.Decoration arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BiomeGenerationSettingsBuilder.getFeatures yet");
	}

	public List<Holder<WorldCarver>> getCarvers() {
		return this.carvers;
	}
}
