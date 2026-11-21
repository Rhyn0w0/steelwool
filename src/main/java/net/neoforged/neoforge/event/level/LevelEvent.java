package net.neoforged.neoforge.event.level;

import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.util.random.Weighted;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.storage.ServerLevelData;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code LevelEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class LevelEvent extends Event {
	private final LevelAccessor level;

	public LevelEvent(LevelAccessor level) {
		super();
		this.level = level;
	}

	public LevelAccessor getLevel() {
		return this.level;
	}

	public static class CreateSpawnPosition extends net.neoforged.neoforge.event.level.LevelEvent implements ICancellableEvent {
		private final ServerLevelData settings;

		public CreateSpawnPosition(LevelAccessor arg0, ServerLevelData settings) {
			super(arg0);
			this.settings = settings;
		}

		public ServerLevelData getSettings() {
			return this.settings;
		}
	}

	public static class Load extends net.neoforged.neoforge.event.level.LevelEvent {
		public Load(LevelAccessor arg0) {
			super(arg0);
		}
	}

	public static class PotentialSpawns extends net.neoforged.neoforge.event.level.LevelEvent implements ICancellableEvent {
		private final MobCategory mobcategory;
		private final BlockPos pos;
		private WeightedList.Builder<MobSpawnSettings.SpawnerData> list;
		private List<Weighted<MobSpawnSettings.SpawnerData>> view;

		public PotentialSpawns(LevelAccessor arg0, MobCategory mobcategory, BlockPos pos, WeightedList<MobSpawnSettings.SpawnerData> arg3) {
			super((LevelAccessor) null);
			throw new UnsupportedOperationException("SteelWool does not implement the LevelEvent.PotentialSpawns constructor yet");
		}

		public MobCategory getMobCategory() {
			return this.mobcategory;
		}

		public BlockPos getPos() {
			return this.pos;
		}

		public List<Weighted<MobSpawnSettings.SpawnerData>> getSpawnerDataList() {
			return this.view;
		}

		private void makeList() {
			throw new UnsupportedOperationException("SteelWool does not implement LevelEvent.PotentialSpawns.makeList yet");
		}

		public void addSpawnerData(Weighted<MobSpawnSettings.SpawnerData> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement LevelEvent.PotentialSpawns.addSpawnerData yet");
		}

		public void removeSpawnerData(Weighted<MobSpawnSettings.SpawnerData> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement LevelEvent.PotentialSpawns.removeSpawnerData yet");
		}
	}

	public static class Save extends net.neoforged.neoforge.event.level.LevelEvent {
		public Save(LevelAccessor arg0) {
			super(arg0);
		}
	}

	public static class Unload extends net.neoforged.neoforge.event.level.LevelEvent {
		public Unload(LevelAccessor arg0) {
			super(arg0);
		}
	}
}
