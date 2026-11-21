package net.neoforged.neoforge.event.entity.player;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.world.entity.player.Player;

/**
 * SteelWool re-implementation of NeoForge's {@code AdvancementEvent}, with the same API.
 */
public abstract class AdvancementEvent extends PlayerEvent {
	private final AdvancementHolder advancement;

	public AdvancementEvent(Player arg0, AdvancementHolder advancement) {
		super(arg0);
		this.advancement = advancement;
	}

	public AdvancementHolder getAdvancement() {
		return this.advancement;
	}

	public static class AdvancementEarnEvent extends net.neoforged.neoforge.event.entity.player.AdvancementEvent {
		public AdvancementEarnEvent(Player arg0, AdvancementHolder arg1) {
			super(arg0, arg1);
		}
	}

	public static class AdvancementProgressEvent extends net.neoforged.neoforge.event.entity.player.AdvancementEvent {
		private final AdvancementProgress advancementProgress;
		private final String criterionName;
		private final net.neoforged.neoforge.event.entity.player.AdvancementEvent.AdvancementProgressEvent.ProgressType progressType;

		public AdvancementProgressEvent(Player arg0, AdvancementHolder arg1, AdvancementProgress advancementProgress, String criterionName, net.neoforged.neoforge.event.entity.player.AdvancementEvent.AdvancementProgressEvent.ProgressType progressType) {
			super(arg0, arg1);
			this.advancementProgress = advancementProgress;
			this.criterionName = criterionName;
			this.progressType = progressType;
		}

		public AdvancementProgress getAdvancementProgress() {
			return this.advancementProgress;
		}

		public String getCriterionName() {
			return this.criterionName;
		}

		public net.neoforged.neoforge.event.entity.player.AdvancementEvent.AdvancementProgressEvent.ProgressType getProgressType() {
			return this.progressType;
		}

		public enum ProgressType {
			GRANT, REVOKE;
		}
	}
}
