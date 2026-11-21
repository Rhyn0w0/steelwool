package net.neoforged.neoforge.event.entity.living;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code LivingSwapItemsEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class LivingSwapItemsEvent extends LivingEvent {
	public LivingSwapItemsEvent(LivingEntity arg0) {
		super(arg0);
	}

	public static class Hands extends net.neoforged.neoforge.event.entity.living.LivingSwapItemsEvent implements ICancellableEvent {
		private ItemStack toMainHand;
		private ItemStack toOffHand;

		public Hands(LivingEntity arg0) {
			super((LivingEntity) null);
			throw new UnsupportedOperationException("SteelWool does not implement the LivingSwapItemsEvent.Hands constructor yet");
		}

		public ItemStack getItemSwappedToMainHand() {
			return this.toMainHand;
		}

		public ItemStack getItemSwappedToOffHand() {
			return this.toOffHand;
		}

		public void setItemSwappedToMainHand(ItemStack toMainHand) {
			this.toMainHand = toMainHand;
		}

		public void setItemSwappedToOffHand(ItemStack toOffHand) {
			this.toOffHand = toOffHand;
		}
	}
}
