package net.neoforged.neoforge.event.entity.player;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;

/**
 * SteelWool re-implementation of NeoForge's {@code PlayerContainerEvent}, with the same API.
 */
public class PlayerContainerEvent extends PlayerEvent {
	private final AbstractContainerMenu container;

	public PlayerContainerEvent(Player arg0, AbstractContainerMenu container) {
		super(arg0);
		this.container = container;
	}

	public AbstractContainerMenu getContainer() {
		return this.container;
	}

	public static class Close extends net.neoforged.neoforge.event.entity.player.PlayerContainerEvent {
		public Close(Player arg0, AbstractContainerMenu arg1) {
			super(arg0, arg1);
		}
	}

	public static class Open extends net.neoforged.neoforge.event.entity.player.PlayerContainerEvent {
		public Open(Player arg0, AbstractContainerMenu arg1) {
			super(arg0, arg1);
		}
	}
}
