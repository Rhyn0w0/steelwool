package net.neoforged.neoforge.event.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code EntityMountEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class EntityMountEvent extends EntityEvent implements ICancellableEvent {
	private final Entity entityMounting;
	private final Entity entityBeingMounted;
	private final Level level;
	private final boolean isMounting;

	public EntityMountEvent(Entity entityMounting, Entity entityBeingMounted, Level level, boolean isMounting) {
		super(entityMounting);
		this.entityMounting = entityMounting;
		this.entityBeingMounted = entityBeingMounted;
		this.level = level;
		this.isMounting = isMounting;
	}

	public boolean isMounting() {
		return this.isMounting;
	}

	public boolean isDismounting() {
		throw new UnsupportedOperationException("SteelWool does not implement EntityMountEvent.isDismounting yet");
	}

	public Entity getEntityMounting() {
		return this.entityMounting;
	}

	public Entity getEntityBeingMounted() {
		return this.entityBeingMounted;
	}

	public Level getLevel() {
		return this.level;
	}
}
