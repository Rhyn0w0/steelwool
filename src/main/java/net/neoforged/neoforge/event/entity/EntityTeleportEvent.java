package net.neoforged.neoforge.event.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownEnderpearl;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code EntityTeleportEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class EntityTeleportEvent extends EntityEvent implements ICancellableEvent {
	protected final ServerLevel targetLevel;
	protected double targetX;
	protected double targetY;
	protected double targetZ;

	public EntityTeleportEvent(Entity arg0, ServerLevel targetLevel, double targetX, double targetY, double targetZ) {
		super(arg0);
		this.targetLevel = targetLevel;
		this.targetX = targetX;
		this.targetY = targetY;
		this.targetZ = targetZ;
	}

	public ServerLevel getTargetLevel() {
		return this.targetLevel;
	}

	public double getTargetX() {
		return this.targetX;
	}

	public void setTargetX(double targetX) {
		this.targetX = targetX;
	}

	public double getTargetY() {
		return this.targetY;
	}

	public void setTargetY(double targetY) {
		this.targetY = targetY;
	}

	public double getTargetZ() {
		return this.targetZ;
	}

	public void setTargetZ(double targetZ) {
		this.targetZ = targetZ;
	}

	public Vec3 getTarget() {
		throw new UnsupportedOperationException("SteelWool does not implement EntityTeleportEvent.getTarget yet");
	}

	public double getPrevX() {
		throw new UnsupportedOperationException("SteelWool does not implement EntityTeleportEvent.getPrevX yet");
	}

	public double getPrevY() {
		throw new UnsupportedOperationException("SteelWool does not implement EntityTeleportEvent.getPrevY yet");
	}

	public double getPrevZ() {
		throw new UnsupportedOperationException("SteelWool does not implement EntityTeleportEvent.getPrevZ yet");
	}

	public Vec3 getPrev() {
		throw new UnsupportedOperationException("SteelWool does not implement EntityTeleportEvent.getPrev yet");
	}

	public static class EnderEntity extends net.neoforged.neoforge.event.entity.EntityTeleportEvent implements ICancellableEvent {
		private final LivingEntity entityLiving;

		public EnderEntity(LivingEntity arg0, double arg1, double arg2, double arg3) {
			super((Entity) null, (ServerLevel) null, (double) 0, (double) 0, (double) 0);
			throw new UnsupportedOperationException("SteelWool does not implement the EntityTeleportEvent.EnderEntity constructor yet");
		}

		public LivingEntity getEntityLiving() {
			return this.entityLiving;
		}
	}

	public static class EnderPearl extends net.neoforged.neoforge.event.entity.EntityTeleportEvent implements ICancellableEvent {
		private final ServerPlayer player;
		private final ThrownEnderpearl pearlEntity;
		private float attackDamage;
		private final HitResult hitResult;

		public EnderPearl(ServerPlayer arg0, double arg1, double arg2, double arg3, ThrownEnderpearl arg4, float arg5, HitResult arg6) {
			super((Entity) null, (ServerLevel) null, (double) 0, (double) 0, (double) 0);
			throw new UnsupportedOperationException("SteelWool does not implement the EntityTeleportEvent.EnderPearl constructor yet");
		}

		public ThrownEnderpearl getPearlEntity() {
			return this.pearlEntity;
		}

		public ServerPlayer getPlayer() {
			return this.player;
		}

		public HitResult getHitResult() {
			return this.hitResult;
		}

		public float getAttackDamage() {
			return this.attackDamage;
		}

		public void setAttackDamage(float attackDamage) {
			this.attackDamage = attackDamage;
		}
	}

	public static class ItemConsumption extends net.neoforged.neoforge.event.entity.EntityTeleportEvent implements ICancellableEvent {
		private final LivingEntity entityLiving;
		private final ItemStack itemStack;

		public ItemConsumption(LivingEntity arg0, ItemStack arg1, double arg2, double arg3, double arg4) {
			super((Entity) null, (ServerLevel) null, (double) 0, (double) 0, (double) 0);
			throw new UnsupportedOperationException("SteelWool does not implement the EntityTeleportEvent.ItemConsumption constructor yet");
		}

		public LivingEntity getEntityLiving() {
			return this.entityLiving;
		}

		public ItemStack getConsumedItem() {
			return this.itemStack;
		}
	}

	public static class SpreadPlayersCommand extends net.neoforged.neoforge.event.entity.EntityTeleportEvent implements ICancellableEvent {
		public SpreadPlayersCommand(Entity arg0, ServerLevel arg1, double arg2, double arg3, double arg4) {
			super(arg0, arg1, arg2, arg3, arg4);
		}
	}

	public static class TeleportCommand extends net.neoforged.neoforge.event.entity.EntityTeleportEvent implements ICancellableEvent {
		public TeleportCommand(Entity arg0, ServerLevel arg1, double arg2, double arg3, double arg4) {
			super(arg0, arg1, arg2, arg3, arg4);
		}
	}
}
