package net.neoforged.neoforge.event.entity.player;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code AttackEntityEvent}, with the same API.
 */
public class AttackEntityEvent extends PlayerEvent implements ICancellableEvent {
	private final Entity target;

	public AttackEntityEvent(Player arg0, Entity target) {
		super(arg0);
		this.target = target;
	}

	public Entity getTarget() {
		return this.target;
	}
}
