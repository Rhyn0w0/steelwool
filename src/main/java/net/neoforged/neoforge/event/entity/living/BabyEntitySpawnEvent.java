package net.neoforged.neoforge.event.entity.living;

import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code BabyEntitySpawnEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class BabyEntitySpawnEvent extends Event implements ICancellableEvent {
	private final Mob parentA;
	private final Mob parentB;
	private final Player causedByPlayer;
	private AgeableMob child;

	public BabyEntitySpawnEvent(Mob arg0, Mob arg1, AgeableMob arg2) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the BabyEntitySpawnEvent constructor yet");
	}

	public Mob getParentA() {
		return this.parentA;
	}

	public Mob getParentB() {
		return this.parentB;
	}

	public Player getCausedByPlayer() {
		return this.causedByPlayer;
	}

	public AgeableMob getChild() {
		return this.child;
	}

	public void setChild(AgeableMob child) {
		this.child = child;
	}
}
