package net.neoforged.neoforge.event;

import net.minecraft.stats.Stat;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code StatAwardEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class StatAwardEvent extends PlayerEvent implements ICancellableEvent {
	private Stat<?> stat;
	private int value;

	public StatAwardEvent(Player arg0, Stat<?> stat, int value) {
		super(arg0);
		this.stat = stat;
		this.value = value;
	}

	public Stat<?> getStat() {
		return this.stat;
	}

	public void setStat(Stat<?> stat) {
		this.stat = stat;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
