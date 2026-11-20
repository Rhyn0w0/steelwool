package net.neoforged.neoforge.event.entity.player;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code PermissionsChangedEvent}, with the same API.
 */
public class PermissionsChangedEvent extends PlayerEvent implements ICancellableEvent {
	private final LevelBasedPermissionSet newLevel;
	private final LevelBasedPermissionSet oldLevel;

	public PermissionsChangedEvent(ServerPlayer arg0, LevelBasedPermissionSet newLevel, LevelBasedPermissionSet oldLevel) {
		super(arg0);
		this.oldLevel = oldLevel;
		this.newLevel = newLevel;
	}

	public LevelBasedPermissionSet getNewLevel() {
		return this.newLevel;
	}

	public LevelBasedPermissionSet getOldLevel() {
		return this.oldLevel;
	}
}
