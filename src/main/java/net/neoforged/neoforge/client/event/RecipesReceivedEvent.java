package net.neoforged.neoforge.client.event;

import java.util.Set;

import net.minecraft.world.item.crafting.RecipeMap;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code RecipesReceivedEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RecipesReceivedEvent extends Event {
	private final Set<RecipeType<?>> recipeTypes;
	private final RecipeMap recipeMap;

	public RecipesReceivedEvent(Set<RecipeType<?>> arg0, RecipeMap arg1) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the RecipesReceivedEvent constructor yet");
	}

	public Set<RecipeType<?>> getRecipeTypes() {
		return this.recipeTypes;
	}

	public RecipeMap getRecipeMap() {
		return this.recipeMap;
	}
}
