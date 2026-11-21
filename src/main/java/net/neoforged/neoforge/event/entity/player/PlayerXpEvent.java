package net.neoforged.neoforge.event.entity.player;

import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code PlayerXpEvent}, with the same API.
 */
public abstract class PlayerXpEvent extends PlayerEvent {
	public PlayerXpEvent(Player arg0) {
		super(arg0);
	}

	public static class LevelChange extends net.neoforged.neoforge.event.entity.player.PlayerXpEvent implements ICancellableEvent {
		private int levels;

		public LevelChange(Player arg0, int levels) {
			super(arg0);
			this.levels = levels;
		}

		public int getLevels() {
			return this.levels;
		}

		public void setLevels(int levels) {
			this.levels = levels;
		}
	}

	public static class PickupXp extends net.neoforged.neoforge.event.entity.player.PlayerXpEvent implements ICancellableEvent {
		private final ExperienceOrb orb;

		public PickupXp(Player arg0, ExperienceOrb orb) {
			super(arg0);
			this.orb = orb;
		}

		public ExperienceOrb getOrb() {
			return this.orb;
		}
	}

	public static class XpChange extends net.neoforged.neoforge.event.entity.player.PlayerXpEvent implements ICancellableEvent {
		private int amount;

		public XpChange(Player arg0, int amount) {
			super(arg0);
			this.amount = amount;
		}

		public int getAmount() {
			return this.amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}
	}
}
