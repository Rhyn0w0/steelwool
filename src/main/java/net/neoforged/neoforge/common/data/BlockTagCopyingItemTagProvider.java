package net.neoforged.neoforge.common.data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockItemTagId;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/**
 * SteelWool re-implementation of NeoForge's {@code BlockTagCopyingItemTagProvider}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class BlockTagCopyingItemTagProvider extends TagsProvider<Item> {
	private final CompletableFuture<TagsProvider.TagLookup<Block>> blockTags;
	private final Map<TagKey<Block>, TagKey<Item>> tagsToCopy;

	public BlockTagCopyingItemTagProvider(PackOutput arg0, CompletableFuture<HolderLookup.Provider> arg1, CompletableFuture<TagsProvider.TagLookup<Block>> arg2, String arg3) {
		super(arg0, Registries.ITEM, arg1);
		this.blockTags = arg2;
		this.tagsToCopy = new HashMap<>();
	}

	protected void copy(BlockItemTagId arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BlockTagCopyingItemTagProvider.copy yet");
	}

	protected void copy(TagKey<Block> arg0, TagKey<Item> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement BlockTagCopyingItemTagProvider.copy yet");
	}

	protected CompletableFuture<HolderLookup.Provider> createContentsProvider() {
		throw new UnsupportedOperationException("SteelWool does not implement BlockTagCopyingItemTagProvider.createContentsProvider yet");
	}
}
