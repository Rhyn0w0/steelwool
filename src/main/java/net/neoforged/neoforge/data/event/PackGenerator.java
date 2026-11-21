package net.neoforged.neoforge.data.event;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/**
 * SteelWool re-implementation of NeoForge's {@code PackGenerator}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class PackGenerator {
	private final GatherDataEvent owner;
	private final PackOutput output;
	private final DataGenerator.PackGenerator internalGenerator;
	CompletableFuture<HolderLookup.Provider> worldRegistriesWithModdedEntries;
	CompletableFuture<HolderLookup.Provider> reloadableRegistries;
	CompletableFuture<HolderLookup.Provider> reloadableRegistriesWithModdedEntries;

	PackGenerator(GatherDataEvent owner, PackOutput output, String arg2) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the PackGenerator constructor yet");
	}

	public PackOutput getPackOutput() {
		return this.output;
	}

	public CompletableFuture<HolderLookup.Provider> getWorldLookupProvider() {
		throw new UnsupportedOperationException("SteelWool does not implement PackGenerator.getWorldLookupProvider yet");
	}

	public CompletableFuture<HolderLookup.Provider> getReloadableLookupProvider() {
		throw new UnsupportedOperationException("SteelWool does not implement PackGenerator.getReloadableLookupProvider yet");
	}

	public <T extends DataProvider> T addProvider(T arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement PackGenerator.addProvider yet");
	}

	public <T extends DataProvider> T createProvider(net.neoforged.neoforge.data.event.PackGenerator.DataProviderFromOutput<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement PackGenerator.createProvider yet");
	}

	public <T extends DataProvider> T createProvider(net.neoforged.neoforge.data.event.PackGenerator.DataProviderFromOutputLookup<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement PackGenerator.createProvider yet");
	}

	public void createBlockAndItemTags(net.neoforged.neoforge.data.event.PackGenerator.DataProviderFromOutputLookup<TagsProvider<Block>> arg0, net.neoforged.neoforge.data.event.PackGenerator.ItemTagsProvider arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement PackGenerator.createBlockAndItemTags yet");
	}

	public void createWorldRegistryObjects(RegistrySetBuilder arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement PackGenerator.createWorldRegistryObjects yet");
	}

	public void createWorldRegistryObjects(RegistrySetBuilder arg0, Set<String> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement PackGenerator.createWorldRegistryObjects yet");
	}

	public void createWorldRegistryObjects(RegistrySetBuilder arg0, Set<String> arg1, String arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement PackGenerator.createWorldRegistryObjects yet");
	}

	public void createReloadableRegistryObjects(RegistrySetBuilder arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement PackGenerator.createReloadableRegistryObjects yet");
	}

	public void createReloadableRegistryObjects(RegistrySetBuilder arg0, Set<String> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement PackGenerator.createReloadableRegistryObjects yet");
	}

	public void createReloadableRegistryObjects(RegistrySetBuilder arg0, Set<String> arg1, String arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement PackGenerator.createReloadableRegistryObjects yet");
	}

	public interface DataProviderFromOutput<T extends DataProvider> {
		T create(PackOutput arg0);
	}

	public interface DataProviderFromOutputLookup<T extends DataProvider> {
		T create(PackOutput arg0, CompletableFuture<HolderLookup.Provider> arg1);
	}

	public interface ItemTagsProvider {
		TagsProvider<Item> create(PackOutput arg0, CompletableFuture<HolderLookup.Provider> arg1, CompletableFuture<TagsProvider.TagLookup<Block>> arg2);
	}
}
