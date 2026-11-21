package net.neoforged.neoforge.event.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

/**
 * SteelWool re-implementation of NeoForge's {@code EntityLeaveLevelEvent}, with the same API.
 */
public class EntityLeaveLevelEvent extends EntityEvent {
	private final Level level;

	public EntityLeaveLevelEvent(Entity arg0, Level level) {
		super(arg0);
		this.level = level;
	}

	public Level getLevel() {
		return this.level;
	}
}
