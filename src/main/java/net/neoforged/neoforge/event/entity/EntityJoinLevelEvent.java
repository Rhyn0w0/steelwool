package net.neoforged.neoforge.event.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code EntityJoinLevelEvent}, with the same API.
 */
public class EntityJoinLevelEvent extends EntityEvent implements ICancellableEvent {
	private final Level level;
	private final boolean loadedFromDisk;

	public EntityJoinLevelEvent(Entity arg0, Level arg1) {
		this(arg0, arg1, false);
	}

	public EntityJoinLevelEvent(Entity arg0, Level level, boolean loadedFromDisk) {
		super(arg0);
		this.level = level;
		this.loadedFromDisk = loadedFromDisk;
	}

	public Level getLevel() {
		return this.level;
	}

	public boolean loadedFromDisk() {
		return this.loadedFromDisk;
	}
}
