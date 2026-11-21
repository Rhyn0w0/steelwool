package net.neoforged.neoforge.event.entity.player;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code SweepAttackEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class SweepAttackEvent extends PlayerEvent implements ICancellableEvent {
	private final Entity target;
	private final boolean isVanillaSweep;
	private boolean isSweeping;

	public SweepAttackEvent(Player arg0, Entity target, boolean arg2) {
		super((Player) null);
		throw new UnsupportedOperationException("SteelWool does not implement the SweepAttackEvent constructor yet");
	}

	public Entity getTarget() {
		return this.target;
	}

	public boolean isVanillaSweep() {
		return this.isVanillaSweep;
	}

	public boolean isSweeping() {
		return this.isSweeping;
	}

	public void setSweeping(boolean isSweeping) {
		this.isSweeping = isSweeping;
	}

	public void setCanceled(boolean arg0) {
		ICancellableEvent.super.setCanceled(arg0);
	}
}
