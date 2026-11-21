package net.neoforged.neoforge.event.entity.player;

import net.minecraft.world.entity.player.Player;

/**
 * SteelWool re-implementation of NeoForge's {@code PlayerWakeUpEvent}, with the same API.
 */
public class PlayerWakeUpEvent extends PlayerEvent {
	private final boolean wakeImmediately;
	private final boolean updateLevel;

	public PlayerWakeUpEvent(Player arg0, boolean wakeImmediately, boolean updateLevel) {
		super(arg0);
		this.wakeImmediately = wakeImmediately;
		this.updateLevel = updateLevel;
	}

	public boolean wakeImmediately() {
		return this.wakeImmediately;
	}

	public boolean updateLevel() {
		return this.updateLevel;
	}
}
