package net.neoforged.neoforge.event;

import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code ItemStackedOnOtherEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ItemStackedOnOtherEvent extends Event implements ICancellableEvent {
	private final ItemStack carriedItem;
	private final ItemStack stackedOnItem;
	private final Slot slot;
	private final ClickAction action;
	private final Player player;
	private final SlotAccess carriedSlotAccess;
	private boolean cancelResult;

	public ItemStackedOnOtherEvent(ItemStack carriedItem, ItemStack stackedOnItem, Slot slot, ClickAction action, Player player, SlotAccess carriedSlotAccess) {
		super();
		this.cancelResult = true;
		this.carriedItem = carriedItem;
		this.stackedOnItem = stackedOnItem;
		this.slot = slot;
		this.action = action;
		this.player = player;
		this.carriedSlotAccess = carriedSlotAccess;
	}

	public ItemStack getCarriedItem() {
		return this.carriedItem;
	}

	public ItemStack getStackedOnItem() {
		return this.stackedOnItem;
	}

	public Slot getSlot() {
		return this.slot;
	}

	public ClickAction getClickAction() {
		return this.action;
	}

	public Player getPlayer() {
		return this.player;
	}

	public SlotAccess getCarriedSlotAccess() {
		return this.carriedSlotAccess;
	}

	public void setCancellationResult(boolean cancelResult) {
		this.cancelResult = cancelResult;
	}

	public boolean getCancellationResult() {
		return this.cancelResult;
	}

	public void cancelWithResult(boolean arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemStackedOnOtherEvent.cancelWithResult yet");
	}
}
