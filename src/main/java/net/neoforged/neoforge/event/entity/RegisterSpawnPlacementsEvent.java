package net.neoforged.neoforge.event.entity;

import java.util.List;
import java.util.Map;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacementType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterSpawnPlacementsEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterSpawnPlacementsEvent extends Event implements IModBusEvent {
	private final Map<EntityType<?>, net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent.MergedSpawnPredicate<?>> map;

	public RegisterSpawnPlacementsEvent(Map<EntityType<?>, net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent.MergedSpawnPredicate<?>> map) {
		super();
		this.map = map;
	}

	public <T extends Entity> void register(EntityType<T> arg0, SpawnPlacements.SpawnPredicate<T> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterSpawnPlacementsEvent.register yet");
	}

	public <T extends Entity> void register(EntityType<T> arg0, SpawnPlacements.SpawnPredicate<T> arg1, net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent.Operation arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterSpawnPlacementsEvent.register yet");
	}

	public <T extends Entity> void register(EntityType<T> arg0, SpawnPlacementType arg1, Heightmap.Types arg2, SpawnPlacements.SpawnPredicate<T> arg3, net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent.Operation arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterSpawnPlacementsEvent.register yet");
	}

	public static class MergedSpawnPredicate<T extends Entity> extends Object {
		private final SpawnPlacements.SpawnPredicate<T> originalPredicate;
		private final List<SpawnPlacements.SpawnPredicate<T>> orPredicates;
		private final List<SpawnPlacements.SpawnPredicate<T>> andPredicates;
		private SpawnPlacements.SpawnPredicate<T> replacementPredicate;
		private SpawnPlacementType spawnType;
		private Heightmap.Types heightmapType;

		public MergedSpawnPredicate(SpawnPlacements.SpawnPredicate<T> originalPredicate, SpawnPlacementType arg1, Heightmap.Types arg2) {
			throw new UnsupportedOperationException("SteelWool does not implement the RegisterSpawnPlacementsEvent.MergedSpawnPredicate constructor yet");
		}

		public SpawnPlacementType getSpawnType() {
			return this.spawnType;
		}

		public Heightmap.Types getHeightmapType() {
			return this.heightmapType;
		}

		private void merge(net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent.Operation arg0, SpawnPlacements.SpawnPredicate<T> arg1, SpawnPlacementType arg2, Heightmap.Types arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement RegisterSpawnPlacementsEvent.MergedSpawnPredicate.merge yet");
		}

		public SpawnPlacements.SpawnPredicate<T> build() {
			throw new UnsupportedOperationException("SteelWool does not implement RegisterSpawnPlacementsEvent.MergedSpawnPredicate.build yet");
		}
	}

	public enum Operation {
		AND, OR, REPLACE;
	}
}
