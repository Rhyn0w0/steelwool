package net.neoforged.neoforge.event.entity.living;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code LivingEntityUseItemEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class LivingEntityUseItemEvent extends LivingEvent {
	private final ItemStack item;
	private final InteractionHand hand;
	private int duration;

	private LivingEntityUseItemEvent(LivingEntity arg0, ItemStack arg1, int arg2) {
		this((LivingEntity) null, (ItemStack) null, (InteractionHand) null, (int) 0);
		throw new UnsupportedOperationException("SteelWool does not implement the LivingEntityUseItemEvent constructor yet");
	}

	private LivingEntityUseItemEvent(LivingEntity arg0, ItemStack item, InteractionHand hand, int arg3) {
		super((LivingEntity) null);
		throw new UnsupportedOperationException("SteelWool does not implement the LivingEntityUseItemEvent constructor yet");
	}

	public ItemStack getItem() {
		return this.item;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public InteractionHand getHand() {
		return this.hand;
	}

	public static class Finish extends net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent {
		private ItemStack result;

		public Finish(LivingEntity arg0, ItemStack arg1, int arg2, ItemStack arg3) {
			super((LivingEntity) null, (ItemStack) null, (int) 0);
			throw new UnsupportedOperationException("SteelWool does not implement the LivingEntityUseItemEvent.Finish constructor yet");
		}

		public ItemStack getResultStack() {
			return this.result;
		}

		public void setResultStack(ItemStack result) {
			this.result = result;
		}
	}

	public static class Start extends net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent implements ICancellableEvent {
		public Start(LivingEntity arg0, ItemStack arg1, InteractionHand arg2, int arg3) {
			super(arg0, arg1, arg2, arg3);
		}
	}

	public static class Stop extends net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent implements ICancellableEvent {
		public Stop(LivingEntity arg0, ItemStack arg1, int arg2) {
			super(arg0, arg1, arg2);
		}
	}

	public static class Tick extends net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent implements ICancellableEvent {
		public Tick(LivingEntity arg0, ItemStack arg1, int arg2) {
			super(arg0, arg1, arg2);
		}
	}
}
