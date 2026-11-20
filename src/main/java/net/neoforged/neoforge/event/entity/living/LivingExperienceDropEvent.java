package net.neoforged.neoforge.event.entity.living;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code LivingExperienceDropEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class LivingExperienceDropEvent extends LivingEvent implements ICancellableEvent {
	private final Player attackingPlayer;
	private final int originalExperiencePoints;
	private int droppedExperiencePoints;

	public LivingExperienceDropEvent(LivingEntity arg0, Player attackingPlayer, int arg2) {
		super((LivingEntity) null);
		throw new UnsupportedOperationException("SteelWool does not implement the LivingExperienceDropEvent constructor yet");
	}

	public int getDroppedExperience() {
		return this.droppedExperiencePoints;
	}

	public void setDroppedExperience(int droppedExperiencePoints) {
		this.droppedExperiencePoints = droppedExperiencePoints;
	}

	public Player getAttackingPlayer() {
		return this.attackingPlayer;
	}

	public int getOriginalExperience() {
		return this.originalExperiencePoints;
	}
}
