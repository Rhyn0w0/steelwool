package net.neoforged.neoforge.common.world;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import net.minecraft.core.HolderSet;
import net.minecraft.util.random.Weighted;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * SteelWool re-implementation of NeoForge's {@code StructureSettingsBuilder}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class StructureSettingsBuilder {
	private HolderSet<Biome> biomes;
	private final Map<MobCategory, net.neoforged.neoforge.common.world.StructureSettingsBuilder.StructureSpawnOverrideBuilder> spawnOverrides;
	private GenerationStep.Decoration step;
	private TerrainAdjustment terrainAdaptation;

	public static net.neoforged.neoforge.common.world.StructureSettingsBuilder copyOf(Structure.StructureSettings arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement StructureSettingsBuilder.copyOf yet");
	}

	private StructureSettingsBuilder(HolderSet<Biome> biomes, Map<MobCategory, StructureSpawnOverride> arg1, GenerationStep.Decoration arg2, TerrainAdjustment arg3) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the StructureSettingsBuilder constructor yet");
	}

	public Structure.StructureSettings build() {
		throw new UnsupportedOperationException("SteelWool does not implement StructureSettingsBuilder.build yet");
	}

	public HolderSet<Biome> getBiomes() {
		return this.biomes;
	}

	public void setBiomes(HolderSet<Biome> biomes) {
		this.biomes = biomes;
	}

	public net.neoforged.neoforge.common.world.StructureSettingsBuilder.StructureSpawnOverrideBuilder getSpawnOverrides(MobCategory arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement StructureSettingsBuilder.getSpawnOverrides yet");
	}

	public net.neoforged.neoforge.common.world.StructureSettingsBuilder.StructureSpawnOverrideBuilder getOrAddSpawnOverrides(MobCategory arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement StructureSettingsBuilder.getOrAddSpawnOverrides yet");
	}

	public void removeSpawnOverrides(MobCategory arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement StructureSettingsBuilder.removeSpawnOverrides yet");
	}

	public GenerationStep.Decoration getDecorationStep() {
		return this.step;
	}

	public void setDecorationStep(GenerationStep.Decoration step) {
		this.step = step;
	}

	public TerrainAdjustment getTerrainAdaptation() {
		return this.terrainAdaptation;
	}

	public void setTerrainAdaptation(TerrainAdjustment terrainAdaptation) {
		this.terrainAdaptation = terrainAdaptation;
	}

	public static class StructureSpawnOverrideBuilder {
		private StructureSpawnOverride.BoundingBoxType boundingBox;
		private final WeightedList.Builder<MobSpawnSettings.SpawnerData> spawns;
		private final List<Weighted<MobSpawnSettings.SpawnerData>> spawnsView;

		public static net.neoforged.neoforge.common.world.StructureSettingsBuilder.StructureSpawnOverrideBuilder copyOf(StructureSpawnOverride arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement StructureSettingsBuilder.StructureSpawnOverrideBuilder.copyOf yet");
		}

		private StructureSpawnOverrideBuilder(StructureSpawnOverride.BoundingBoxType arg0, WeightedList<MobSpawnSettings.SpawnerData> arg1) {
			super();
			throw new UnsupportedOperationException("SteelWool does not implement the StructureSettingsBuilder.StructureSpawnOverrideBuilder constructor yet");
		}

		public StructureSpawnOverride.BoundingBoxType getBoundingBox() {
			return this.boundingBox;
		}

		public void setBoundingBox(StructureSpawnOverride.BoundingBoxType boundingBox) {
			this.boundingBox = boundingBox;
		}

		public List<Weighted<MobSpawnSettings.SpawnerData>> getSpawns() {
			return this.spawnsView;
		}

		public void addSpawn(Weighted<MobSpawnSettings.SpawnerData> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement StructureSettingsBuilder.StructureSpawnOverrideBuilder.addSpawn yet");
		}

		public void addSpawn(MobSpawnSettings.SpawnerData arg0, int arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement StructureSettingsBuilder.StructureSpawnOverrideBuilder.addSpawn yet");
		}

		public void removeSpawn(Weighted<MobSpawnSettings.SpawnerData> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement StructureSettingsBuilder.StructureSpawnOverrideBuilder.removeSpawn yet");
		}

		public void removeSpawn(MobSpawnSettings.SpawnerData arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement StructureSettingsBuilder.StructureSpawnOverrideBuilder.removeSpawn yet");
		}

		public void removeSpawns(Predicate<Weighted<MobSpawnSettings.SpawnerData>> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement StructureSettingsBuilder.StructureSpawnOverrideBuilder.removeSpawns yet");
		}

		public StructureSpawnOverride build() {
			throw new UnsupportedOperationException("SteelWool does not implement StructureSettingsBuilder.StructureSpawnOverrideBuilder.build yet");
		}
	}
}
