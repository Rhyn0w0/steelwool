package net.neoforged.neoforge.event.entity.player;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code ArrowLooseEvent}, with the same API.
 */
public class ArrowLooseEvent extends PlayerEvent implements ICancellableEvent {
	private final ItemStack bow;
	private final Level level;
	private final boolean hasAmmo;
	private int charge;

	public ArrowLooseEvent(Player arg0, ItemStack bow, Level level, int charge) {
		super(arg0);
		this.bow = bow;
		this.level = level;
		this.charge = charge;
		this.hasAmmo = true;
	}

	public ArrowLooseEvent(Player arg0, ItemStack bow, Level level, int charge, boolean hasAmmo) {
		super(arg0);
		this.bow = bow;
		this.level = level;
		this.charge = charge;
		this.hasAmmo = hasAmmo;
	}

	public ItemStack getBow() {
		return this.bow;
	}

	public Level getLevel() {
		return this.level;
	}

	public boolean hasAmmo() {
		return this.hasAmmo;
	}

	public int getCharge() {
		return this.charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}
}
