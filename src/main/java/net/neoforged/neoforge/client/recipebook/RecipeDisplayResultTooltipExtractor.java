package net.neoforged.neoforge.client.recipebook;

import java.util.List;
import java.util.stream.Stream;

import com.mojang.datafixers.util.Function4;
import net.minecraft.network.chat.Component;
import net.minecraft.util.context.ContextMap;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.display.DisplayContentsFactory;
import net.minecraft.world.item.crafting.display.SlotDisplay;

/**
 * SteelWool re-implementation of NeoForge's {@code RecipeDisplayResultTooltipExtractor}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface RecipeDisplayResultTooltipExtractor {
	Stream<Component> extract(SlotDisplay arg0, ContextMap arg1, Item.TooltipContext arg2, TooltipFlag arg3);

	static <STACK extends Object> net.neoforged.neoforge.client.recipebook.RecipeDisplayResultTooltipExtractor forStack(DisplayContentsFactory<STACK> arg0, Function4<STACK, Item.TooltipContext, Player, TooltipFlag, List<Component>> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RecipeDisplayResultTooltipExtractor.forStack yet");
	}
}
