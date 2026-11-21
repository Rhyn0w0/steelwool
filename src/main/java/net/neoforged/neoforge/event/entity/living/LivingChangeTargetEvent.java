package net.neoforged.neoforge.event.entity.living;

import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code LivingChangeTargetEvent}, with the same API.
 */
public class LivingChangeTargetEvent extends LivingEvent implements ICancellableEvent {
	private final net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent.ILivingTargetType targetType;
	private final LivingEntity originalAboutToBeSetTarget;
	private LivingEntity newAboutToBeSetTarget;

	public LivingChangeTargetEvent(LivingEntity arg0, LivingEntity originalAboutToBeSetTarget, net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent.ILivingTargetType targetType) {
		super(arg0);
		this.originalAboutToBeSetTarget = originalAboutToBeSetTarget;
		this.newAboutToBeSetTarget = originalAboutToBeSetTarget;
		this.targetType = targetType;
	}

	public LivingEntity getNewAboutToBeSetTarget() {
		return this.newAboutToBeSetTarget;
	}

	public void setNewAboutToBeSetTarget(LivingEntity newAboutToBeSetTarget) {
		this.newAboutToBeSetTarget = newAboutToBeSetTarget;
	}

	public net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent.ILivingTargetType getTargetType() {
		return this.targetType;
	}

	public LivingEntity getOriginalAboutToBeSetTarget() {
		return this.originalAboutToBeSetTarget;
	}

	public interface ILivingTargetType {
	}

	public enum LivingTargetType implements net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent.ILivingTargetType {
		MOB_TARGET, BEHAVIOR_TARGET;
	}
}
