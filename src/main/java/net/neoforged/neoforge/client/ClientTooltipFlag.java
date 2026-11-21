package net.neoforged.neoforge.client;

import net.minecraft.world.item.TooltipFlag;

/**
 * SteelWool re-implementation of NeoForge's {@code ClientTooltipFlag}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record ClientTooltipFlag(boolean advanced, boolean creative, boolean shiftDown, boolean controlDown, boolean altDown) implements TooltipFlag {
	public boolean isAdvanced() {
		return this.advanced;
	}

	public boolean isCreative() {
		return this.creative;
	}

	public boolean hasControlDown() {
		return this.controlDown;
	}

	public boolean hasShiftDown() {
		return this.shiftDown;
	}

	public boolean hasAltDown() {
		return this.altDown;
	}

	public static TooltipFlag of(TooltipFlag arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClientTooltipFlag.of yet");
	}
}
