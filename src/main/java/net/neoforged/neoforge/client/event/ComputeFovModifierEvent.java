package net.neoforged.neoforge.client.event;

import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code ComputeFovModifierEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ComputeFovModifierEvent extends Event {
	private final Player player;
	private final float fovModifier;
	private final float fovScale;
	private float newFovModifier;

	public ComputeFovModifierEvent(Player player, float fovModifier, float fovScale) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the ComputeFovModifierEvent constructor yet");
	}

	public Player getPlayer() {
		return this.player;
	}

	public float getFovModifier() {
		return this.fovModifier;
	}

	public float getFovScale() {
		return this.fovScale;
	}

	public float getNewFovModifier() {
		return this.newFovModifier;
	}

	public void setNewFovModifier(float newFovModifier) {
		this.newFovModifier = newFovModifier;
	}
}
