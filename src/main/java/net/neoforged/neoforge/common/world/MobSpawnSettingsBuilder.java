package net.neoforged.neoforge.common.world;

import java.util.Set;
import java.util.function.Predicate;

import net.minecraft.util.random.Weighted;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;

/**
 * SteelWool re-implementation of NeoForge's {@code MobSpawnSettingsBuilder}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class MobSpawnSettingsBuilder extends MobSpawnSettings.Builder {
	private final Set<MobCategory> typesView;
	private final Set<EntityType<?>> costView;

	public MobSpawnSettingsBuilder(MobSpawnSettings arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the MobSpawnSettingsBuilder constructor yet");
	}

	public Set<MobCategory> getSpawnerTypes() {
		return this.typesView;
	}

	public WeightedList.Builder<MobSpawnSettings.SpawnerData> getSpawner(MobCategory arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MobSpawnSettingsBuilder.getSpawner yet");
	}

	public Set<EntityType<?>> getEntityTypes() {
		return this.costView;
	}

	public MobSpawnSettings.MobSpawnCost getCost(EntityType<?> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MobSpawnSettingsBuilder.getCost yet");
	}

	public net.neoforged.neoforge.common.world.MobSpawnSettingsBuilder disablePlayerSpawn() {
		throw new UnsupportedOperationException("SteelWool does not implement MobSpawnSettingsBuilder.disablePlayerSpawn yet");
	}

	public net.neoforged.neoforge.common.world.MobSpawnSettingsBuilder removeSpawns(Predicate<Weighted<MobSpawnSettings.SpawnerData>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MobSpawnSettingsBuilder.removeSpawns yet");
	}

	public net.neoforged.neoforge.common.world.MobSpawnSettingsBuilder removeSpawnCost(EntityType<?>... arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MobSpawnSettingsBuilder.removeSpawnCost yet");
	}
}
