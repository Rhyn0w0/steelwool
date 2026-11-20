package net.neoforged.neoforge.common.world;

import java.util.Set;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryAccess;
import net.minecraft.util.random.Weighted;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

/**
 * SteelWool re-implementation of NeoForge's {@code BiomeModifiers}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class BiomeModifiers {
	private BiomeModifiers() {
		super();
	}

	public static record AddCarversBiomeModifier(HolderSet<Biome> biomes, HolderSet<WorldCarver> carvers) implements BiomeModifier {
		public void modify(RegistryAccess arg0, Holder<Biome> arg1, BiomeModifier.Phase arg2, ModifiableBiomeInfo.BiomeInfo.Builder arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement BiomeModifiers.AddCarversBiomeModifier.modify yet");
		}

		public MapCodec<? extends BiomeModifier> codec() {
			throw new UnsupportedOperationException("SteelWool does not implement BiomeModifiers.AddCarversBiomeModifier.codec yet");
		}
	}

	public static record AddFeaturesBiomeModifier(HolderSet<Biome> biomes, HolderSet<PlacedFeature> features, GenerationStep.Decoration step) implements BiomeModifier {
		public void modify(RegistryAccess arg0, Holder<Biome> arg1, BiomeModifier.Phase arg2, ModifiableBiomeInfo.BiomeInfo.Builder arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement BiomeModifiers.AddFeaturesBiomeModifier.modify yet");
		}

		public MapCodec<? extends BiomeModifier> codec() {
			throw new UnsupportedOperationException("SteelWool does not implement BiomeModifiers.AddFeaturesBiomeModifier.codec yet");
		}
	}

	public static record AddSpawnCostsBiomeModifier(HolderSet<Biome> biomes, HolderSet<EntityType<?>> entityTypes, MobSpawnSettings.MobSpawnCost spawnCost) implements BiomeModifier {
		public void modify(RegistryAccess arg0, Holder<Biome> arg1, BiomeModifier.Phase arg2, ModifiableBiomeInfo.BiomeInfo.Builder arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement BiomeModifiers.AddSpawnCostsBiomeModifier.modify yet");
		}

		public MapCodec<? extends BiomeModifier> codec() {
			throw new UnsupportedOperationException("SteelWool does not implement BiomeModifiers.AddSpawnCostsBiomeModifier.codec yet");
		}
	}

	public static record AddSpawnsBiomeModifier(HolderSet<Biome> biomes, WeightedList<MobSpawnSettings.SpawnerData> spawners) implements BiomeModifier {
		public static net.neoforged.neoforge.common.world.BiomeModifiers.AddSpawnsBiomeModifier singleSpawn(HolderSet<Biome> arg0, Weighted<MobSpawnSettings.SpawnerData> arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement BiomeModifiers.AddSpawnsBiomeModifier.singleSpawn yet");
		}

		public void modify(RegistryAccess arg0, Holder<Biome> arg1, BiomeModifier.Phase arg2, ModifiableBiomeInfo.BiomeInfo.Builder arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement BiomeModifiers.AddSpawnsBiomeModifier.modify yet");
		}

		public MapCodec<? extends BiomeModifier> codec() {
			throw new UnsupportedOperationException("SteelWool does not implement BiomeModifiers.AddSpawnsBiomeModifier.codec yet");
		}
	}

	public static record RemoveCarversBiomeModifier(HolderSet<Biome> biomes, HolderSet<WorldCarver> carvers) implements BiomeModifier {
		public void modify(RegistryAccess arg0, Holder<Biome> arg1, BiomeModifier.Phase arg2, ModifiableBiomeInfo.BiomeInfo.Builder arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement BiomeModifiers.RemoveCarversBiomeModifier.modify yet");
		}

		public MapCodec<? extends BiomeModifier> codec() {
			throw new UnsupportedOperationException("SteelWool does not implement BiomeModifiers.RemoveCarversBiomeModifier.codec yet");
		}
	}

	public static record RemoveFeaturesBiomeModifier(HolderSet<Biome> biomes, HolderSet<PlacedFeature> features, Set<GenerationStep.Decoration> steps) implements BiomeModifier {
		public static net.neoforged.neoforge.common.world.BiomeModifiers.RemoveFeaturesBiomeModifier allSteps(HolderSet<Biome> arg0, HolderSet<PlacedFeature> arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement BiomeModifiers.RemoveFeaturesBiomeModifier.allSteps yet");
		}

		public void modify(RegistryAccess arg0, Holder<Biome> arg1, BiomeModifier.Phase arg2, ModifiableBiomeInfo.BiomeInfo.Builder arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement BiomeModifiers.RemoveFeaturesBiomeModifier.modify yet");
		}

		public MapCodec<? extends BiomeModifier> codec() {
			throw new UnsupportedOperationException("SteelWool does not implement BiomeModifiers.RemoveFeaturesBiomeModifier.codec yet");
		}
	}

	public static record RemoveSpawnCostsBiomeModifier(HolderSet<Biome> biomes, HolderSet<EntityType<?>> entityTypes) implements BiomeModifier {
		public void modify(RegistryAccess arg0, Holder<Biome> arg1, BiomeModifier.Phase arg2, ModifiableBiomeInfo.BiomeInfo.Builder arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement BiomeModifiers.RemoveSpawnCostsBiomeModifier.modify yet");
		}

		public MapCodec<? extends BiomeModifier> codec() {
			throw new UnsupportedOperationException("SteelWool does not implement BiomeModifiers.RemoveSpawnCostsBiomeModifier.codec yet");
		}
	}

	public static record RemoveSpawnsBiomeModifier(HolderSet<Biome> biomes, HolderSet<EntityType<?>> entityTypes) implements BiomeModifier {
		public void modify(RegistryAccess arg0, Holder<Biome> arg1, BiomeModifier.Phase arg2, ModifiableBiomeInfo.BiomeInfo.Builder arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement BiomeModifiers.RemoveSpawnsBiomeModifier.modify yet");
		}

		public MapCodec<? extends BiomeModifier> codec() {
			throw new UnsupportedOperationException("SteelWool does not implement BiomeModifiers.RemoveSpawnsBiomeModifier.codec yet");
		}
	}
}
