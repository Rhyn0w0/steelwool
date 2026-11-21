package net.neoforged.neoforge.event.entity.living;

import com.mojang.datafixers.util.Either;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code FinalizeSpawnEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class FinalizeSpawnEvent extends MobSpawnEvent implements ICancellableEvent {
	private final EntitySpawnReason spawnType;
	private final Either<BlockEntity, Entity> spawner;
	private DifficultyInstance difficulty;
	private SpawnGroupData spawnData;

	public FinalizeSpawnEvent(Mob arg0, ServerLevelAccessor arg1, double arg2, double arg3, double arg4, DifficultyInstance difficulty, EntitySpawnReason spawnType, SpawnGroupData spawnData, Either<BlockEntity, Entity> spawner) {
		super(arg0, arg1, arg2, arg3, arg4);
		this.difficulty = difficulty;
		this.spawnType = spawnType;
		this.spawnData = spawnData;
		this.spawner = spawner;
	}

	public DifficultyInstance getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(DifficultyInstance difficulty) {
		this.difficulty = difficulty;
	}

	public EntitySpawnReason getSpawnType() {
		return this.spawnType;
	}

	public SpawnGroupData getSpawnData() {
		return this.spawnData;
	}

	public void setSpawnData(SpawnGroupData spawnData) {
		this.spawnData = spawnData;
	}

	public Either<BlockEntity, Entity> getSpawner() {
		return this.spawner;
	}

	public void setSpawnCancelled(boolean arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FinalizeSpawnEvent.setSpawnCancelled yet");
	}

	public boolean isSpawnCancelled() {
		throw new UnsupportedOperationException("SteelWool does not implement FinalizeSpawnEvent.isSpawnCancelled yet");
	}
}
