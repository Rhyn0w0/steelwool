package net.neoforged.neoforge.event.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

/**
 * SteelWool re-implementation of NeoForge's {@code EntityMobGriefingEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class EntityMobGriefingEvent extends EntityEvent {
	private final boolean isMobGriefingEnabled;
	private boolean canGrief;

	public EntityMobGriefingEvent(ServerLevel arg0, Entity arg1) {
		super((Entity) null);
		throw new UnsupportedOperationException("SteelWool does not implement the EntityMobGriefingEvent constructor yet");
	}

	public boolean isMobGriefingEnabled() {
		return this.isMobGriefingEnabled;
	}

	public void setCanGrief(boolean canGrief) {
		this.canGrief = canGrief;
	}

	public boolean canGrief() {
		return this.canGrief;
	}
}
