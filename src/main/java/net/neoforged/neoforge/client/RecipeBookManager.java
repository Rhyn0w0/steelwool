package net.neoforged.neoforge.client;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import net.minecraft.client.gui.screens.recipebook.RecipeCollection;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.Identifier;
import net.minecraft.util.context.ContextMap;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.ExtendedRecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.display.RecipeDisplayEntry;
import net.neoforged.neoforge.client.recipebook.RecipeDisplayResultIdExtractor;
import net.neoforged.neoforge.client.recipebook.RecipeDisplayResultTooltipExtractor;

/**
 * SteelWool re-implementation of NeoForge's {@code RecipeBookManager}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class RecipeBookManager {
	private static Map<ExtendedRecipeBookCategory, List<RecipeBookCategory>> searchCategories;
	private static List<net.neoforged.neoforge.client.RecipeBookManager.RecipeDisplayResultInfo> recipeDisplaySearchInfo;

	public RecipeBookManager() {
		super();
	}

	public static Map<ExtendedRecipeBookCategory, List<RecipeBookCategory>> getSearchCategories() {
		throw new UnsupportedOperationException("SteelWool does not implement RecipeBookManager.getSearchCategories yet");
	}

	public static void init() {
		throw new UnsupportedOperationException("SteelWool does not implement RecipeBookManager.init yet");
	}

	public static Stream<String> getTooltipLines(RecipeCollection arg0, ContextMap arg1, Item.TooltipContext arg2, TooltipFlag arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement RecipeBookManager.getTooltipLines yet");
	}

	public static Stream<Identifier> getResultIds(RecipeDisplayEntry arg0, RegistryAccess arg1, Registry<Item> arg2, ContextMap arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement RecipeBookManager.getResultIds yet");
	}

	public static record RecipeDisplayResultInfo(RecipeDisplayResultTooltipExtractor tooltipExtractor, RecipeDisplayResultIdExtractor idExtractor) {
	}
}
