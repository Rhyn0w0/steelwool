package net.neoforged.neoforge.client.event;

import net.minecraft.client.gui.Hud;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code PlayerHeartTypeEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class PlayerHeartTypeEvent extends PlayerEvent {
	private final Hud.HeartType originalType;
	private Hud.HeartType type;

	public PlayerHeartTypeEvent(Player arg0, Hud.HeartType type) {
		super(arg0);
		this.type = type;
		this.originalType = type;
	}

	public Hud.HeartType getOriginalType() {
		return this.originalType;
	}

	public Hud.HeartType getType() {
		return this.type;
	}

	public void setType(Hud.HeartType type) {
		this.type = type;
	}
}
