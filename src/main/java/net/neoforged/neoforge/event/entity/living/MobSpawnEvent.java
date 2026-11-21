package net.neoforged.neoforge.event.entity.living;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.ServerLevelAccessor;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.event.entity.EntityEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code MobSpawnEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class MobSpawnEvent extends EntityEvent {
	private final ServerLevelAccessor level;
	private final double x;
	private final double y;
	private final double z;

	protected MobSpawnEvent(Mob arg0, ServerLevelAccessor level, double x, double y, double z) {
		super(arg0);
		this.level = level;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Mob getEntity() {
		return (Mob) super.getEntity();
	}

	public ServerLevelAccessor getLevel() {
		return this.level;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getZ() {
		return this.z;
	}

	public static class PositionCheck extends net.neoforged.neoforge.event.entity.living.MobSpawnEvent {
		private final BaseSpawner spawner;
		private final EntitySpawnReason spawnType;
		private net.neoforged.neoforge.event.entity.living.MobSpawnEvent.PositionCheck.Result result;

		public PositionCheck(Mob arg0, ServerLevelAccessor arg1, EntitySpawnReason arg2, BaseSpawner arg3) {
			super((Mob) null, (ServerLevelAccessor) null, (double) 0, (double) 0, (double) 0);
			throw new UnsupportedOperationException("SteelWool does not implement the MobSpawnEvent.PositionCheck constructor yet");
		}

		public BaseSpawner getSpawner() {
			return this.spawner;
		}

		public EntitySpawnReason getSpawnType() {
			return this.spawnType;
		}

		public void setResult(net.neoforged.neoforge.event.entity.living.MobSpawnEvent.PositionCheck.Result result) {
			this.result = result;
		}

		public net.neoforged.neoforge.event.entity.living.MobSpawnEvent.PositionCheck.Result getResult() {
			return this.result;
		}

		public enum Result {
			SUCCEED, DEFAULT, FAIL;
		}
	}

	public static class SpawnPlacementCheck extends Event {
		private final EntityType<?> entityType;
		private final ServerLevelAccessor level;
		private final EntitySpawnReason spawnType;
		private final BlockPos pos;
		private final RandomSource random;
		private final boolean defaultResult;
		private net.neoforged.neoforge.event.entity.living.MobSpawnEvent.SpawnPlacementCheck.Result result;

		public SpawnPlacementCheck(EntityType<?> arg0, ServerLevelAccessor arg1, EntitySpawnReason arg2, BlockPos arg3, RandomSource arg4, boolean arg5) {
			super();
			throw new UnsupportedOperationException("SteelWool does not implement the MobSpawnEvent.SpawnPlacementCheck constructor yet");
		}

		public EntityType<?> getEntityType() {
			return this.entityType;
		}

		public ServerLevelAccessor getLevel() {
			return this.level;
		}

		public EntitySpawnReason getSpawnType() {
			return this.spawnType;
		}

		public BlockPos getPos() {
			return this.pos;
		}

		public RandomSource getRandom() {
			return this.random;
		}

		public boolean getDefaultResult() {
			return this.defaultResult;
		}

		public void setResult(net.neoforged.neoforge.event.entity.living.MobSpawnEvent.SpawnPlacementCheck.Result result) {
			this.result = result;
		}

		public net.neoforged.neoforge.event.entity.living.MobSpawnEvent.SpawnPlacementCheck.Result getResult() {
			return this.result;
		}

		public boolean getPlacementCheckResult() {
			throw new UnsupportedOperationException("SteelWool does not implement MobSpawnEvent.SpawnPlacementCheck.getPlacementCheckResult yet");
		}

		public enum Result {
			SUCCEED, DEFAULT, FAIL;
		}
	}
}
