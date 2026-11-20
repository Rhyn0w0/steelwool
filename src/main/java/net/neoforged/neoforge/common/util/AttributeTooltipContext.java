package net.neoforged.neoforge.common.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

/**
 * SteelWool re-implementation of NeoForge's {@code AttributeTooltipContext}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface AttributeTooltipContext extends Item.TooltipContext {
	TooltipDisplay tooltipDisplay();

	TooltipFlag flag();

	static net.neoforged.neoforge.common.util.AttributeTooltipContext of(Player arg0, Item.TooltipContext arg1, TooltipDisplay arg2, TooltipFlag arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement AttributeTooltipContext.of yet");
	}
}
