package net.neoforged.neoforge.client.recipebook;

import java.util.stream.Stream;

import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.TypedInstance;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.context.ContextMap;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.display.DisplayContentsFactory;
import net.minecraft.world.item.crafting.display.SlotDisplay;

/**
 * SteelWool re-implementation of NeoForge's {@code RecipeDisplayResultIdExtractor}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface RecipeDisplayResultIdExtractor {
	Stream<Identifier> extract(SlotDisplay arg0, RegistryAccess arg1, Registry<Item> arg2, ContextMap arg3);

	static <TYPE extends Object> net.neoforged.neoforge.client.recipebook.RecipeDisplayResultIdExtractor forRegisteredType(DisplayContentsFactory<? extends TypedInstance<TYPE>> arg0, ResourceKey<? extends Registry<TYPE>> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RecipeDisplayResultIdExtractor.forRegisteredType yet");
	}
}
