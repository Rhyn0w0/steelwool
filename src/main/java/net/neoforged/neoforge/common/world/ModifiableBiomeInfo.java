package net.neoforged.neoforge.common.world;

import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.attribute.EnvironmentAttributeMap;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import org.slf4j.Logger;

/**
 * SteelWool re-implementation of NeoForge's {@code ModifiableBiomeInfo}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ModifiableBiomeInfo {
	private static final Logger LOGGER = null /* SteelWool: TODO */;
	private final net.neoforged.neoforge.common.world.ModifiableBiomeInfo.BiomeInfo originalBiomeInfo;
	private net.neoforged.neoforge.common.world.ModifiableBiomeInfo.BiomeInfo modifiedBiomeInfo;

	public ModifiableBiomeInfo(net.neoforged.neoforge.common.world.ModifiableBiomeInfo.BiomeInfo originalBiomeInfo) {
		super();
		this.modifiedBiomeInfo = null;
		this.originalBiomeInfo = originalBiomeInfo;
	}

	public net.neoforged.neoforge.common.world.ModifiableBiomeInfo.BiomeInfo get() {
		throw new UnsupportedOperationException("SteelWool does not implement ModifiableBiomeInfo.get yet");
	}

	public net.neoforged.neoforge.common.world.ModifiableBiomeInfo.BiomeInfo getOriginalBiomeInfo() {
		return this.originalBiomeInfo;
	}

	public net.neoforged.neoforge.common.world.ModifiableBiomeInfo.BiomeInfo getModifiedBiomeInfo() {
		return this.modifiedBiomeInfo;
	}

	public boolean applyBiomeModifiers(Holder.Reference<Biome> arg0, List<BiomeModifier> arg1, RegistryAccess arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ModifiableBiomeInfo.applyBiomeModifiers yet");
	}

	public static record BiomeInfo(Biome.ClimateSettings climateSettings, EnvironmentAttributeMap attributes, BiomeSpecialEffects effects, BiomeGenerationSettings generationSettings) {
		public static class Builder {
			private final ClimateSettingsBuilder climateSettings;
			private final EnvironmentAttributeMapBuilder attributes;
			private final boolean canModifySpawnSettings;
			private final MobSpawnSettingsBuilder mobSpawnSettings;
			private final BiomeSpecialEffectsBuilder effects;
			private final BiomeGenerationSettingsBuilder generationSettings;

			public static net.neoforged.neoforge.common.world.ModifiableBiomeInfo.BiomeInfo.Builder copyOf(ResourceKey<Biome> arg0, net.neoforged.neoforge.common.world.ModifiableBiomeInfo.BiomeInfo arg1) {
				throw new UnsupportedOperationException("SteelWool does not implement ModifiableBiomeInfo.BiomeInfo.Builder.copyOf yet");
			}

			private Builder(ResourceKey<Biome> arg0, ClimateSettingsBuilder climateSettings, EnvironmentAttributeMapBuilder attributes, BiomeSpecialEffectsBuilder arg3, BiomeGenerationSettingsBuilder arg4) {
				super();
				throw new UnsupportedOperationException("SteelWool does not implement the ModifiableBiomeInfo.BiomeInfo.Builder constructor yet");
			}

			public net.neoforged.neoforge.common.world.ModifiableBiomeInfo.BiomeInfo build() {
				throw new UnsupportedOperationException("SteelWool does not implement ModifiableBiomeInfo.BiomeInfo.Builder.build yet");
			}

			public ClimateSettingsBuilder getClimateSettings() {
				return this.climateSettings;
			}

			public EnvironmentAttributeMapBuilder getAttributes() {
				return this.attributes;
			}

			public BiomeSpecialEffectsBuilder getSpecialEffects() {
				return this.effects;
			}

			public BiomeGenerationSettingsBuilder getGenerationSettings() {
				return this.generationSettings;
			}

			public MobSpawnSettingsBuilder getMobSpawnSettings() {
				return this.mobSpawnSettings;
			}
		}
	}
}
