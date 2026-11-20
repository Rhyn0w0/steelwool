package net.neoforged.neoforge.event.entity.living;

import net.minecraft.world.entity.monster.Enderman;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code EndermanAngerEvent}, with the same API.
 */
public class EndermanAngerEvent extends LivingEvent implements ICancellableEvent {
	private final Player player;

	public EndermanAngerEvent(Enderman arg0, Player player) {
		super(arg0);
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}

	public Enderman getEntity() {
		return (Enderman) super.getEntity();
	}
}
