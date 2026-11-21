package net.neoforged.neoforge.client.event;

import java.util.List;
import java.util.Map;

import net.minecraft.world.item.crafting.ExtendedRecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.client.RecipeBookManager;
import net.neoforged.neoforge.client.recipebook.RecipeDisplayResultIdExtractor;
import net.neoforged.neoforge.client.recipebook.RecipeDisplayResultTooltipExtractor;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterRecipeBookSearchCategoriesEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterRecipeBookSearchCategoriesEvent extends Event implements IModBusEvent {
	private final Map<ExtendedRecipeBookCategory, List<RecipeBookCategory>> categories;
	private final List<RecipeBookManager.RecipeDisplayResultInfo> recipeDisplaySearchInfo;

	public RegisterRecipeBookSearchCategoriesEvent(Map<ExtendedRecipeBookCategory, List<RecipeBookCategory>> categories, List<RecipeBookManager.RecipeDisplayResultInfo> recipeDisplaySearchInfo) {
		super();
		this.categories = categories;
		this.recipeDisplaySearchInfo = recipeDisplaySearchInfo;
	}

	public void register(ExtendedRecipeBookCategory arg0, RecipeBookCategory... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterRecipeBookSearchCategoriesEvent.register yet");
	}

	public void registerResultIndexer(RecipeDisplayResultTooltipExtractor arg0, RecipeDisplayResultIdExtractor arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterRecipeBookSearchCategoriesEvent.registerResultIndexer yet");
	}
}
