package net.neoforged.neoforge.common.data;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.item.Item;

/**
 * SteelWool re-implementation of NeoForge's {@code ItemTagsProvider}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class ItemTagsProvider extends TagsProvider<Item> {
	public ItemTagsProvider(PackOutput arg0, CompletableFuture<HolderLookup.Provider> arg1, String arg2) {
		// Vanilla has no mod id parameter; it is only used for the output folder in NeoForge.
		super(arg0, Registries.ITEM, arg1);
	}
}
