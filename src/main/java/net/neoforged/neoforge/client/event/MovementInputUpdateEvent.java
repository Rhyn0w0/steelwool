package net.neoforged.neoforge.client.event;

import net.minecraft.client.player.ClientInput;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code MovementInputUpdateEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class MovementInputUpdateEvent extends PlayerEvent {
	private final ClientInput input;

	public MovementInputUpdateEvent(Player arg0, ClientInput input) {
		super(arg0);
		this.input = input;
	}

	public ClientInput getInput() {
		return this.input;
	}
}
