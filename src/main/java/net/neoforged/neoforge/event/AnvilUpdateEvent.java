package net.neoforged.neoforge.event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code AnvilUpdateEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class AnvilUpdateEvent extends Event implements ICancellableEvent {
	private final ItemStack left;
	private final ItemStack right;
	private final String name;
	private final net.neoforged.neoforge.event.AnvilUpdateEvent.VanillaResult vanillaResult;
	private final Player player;
	private ItemStack output;
	private int xpCost;
	private int materialCost;

	public AnvilUpdateEvent(ItemStack left, ItemStack right, String name, ItemStack arg3, int arg4, int arg5, Player arg6) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the AnvilUpdateEvent constructor yet");
	}

	public ItemStack getLeft() {
		throw new UnsupportedOperationException("SteelWool does not implement AnvilUpdateEvent.getLeft yet");
	}

	public ItemStack getRight() {
		throw new UnsupportedOperationException("SteelWool does not implement AnvilUpdateEvent.getRight yet");
	}

	public String getName() {
		return this.name;
	}

	public net.neoforged.neoforge.event.AnvilUpdateEvent.VanillaResult getVanillaResult() {
		return this.vanillaResult;
	}

	public ItemStack getOutput() {
		return this.output;
	}

	public void setOutput(ItemStack output) {
		this.output = output;
	}

	public int getXpCost() {
		return this.xpCost;
	}

	public void setXpCost(int xpCost) {
		this.xpCost = xpCost;
	}

	public int getMaterialCost() {
		return this.materialCost;
	}

	public void setMaterialCost(int materialCost) {
		this.materialCost = materialCost;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setCanceled(boolean arg0) {
		ICancellableEvent.super.setCanceled(arg0);
	}

	public static record VanillaResult(ItemStack output, int xpCost, int materialCost) {
	}
}
