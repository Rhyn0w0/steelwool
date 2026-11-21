package net.neoforged.neoforge.data.event;

import java.nio.file.Path;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code GatherDataEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class GatherDataEvent extends Event implements IModBusEvent {
	private final DataGenerator dataGenerator;
	private final DataGeneratorConfig config;
	private final ModContainer modContainer;
	private final PackGenerator defaultPackGenerator;
	private final DatapackRegistrySets<CompletableFuture<HolderLookup.Provider>> registries;
	private int packCounter;

	public GatherDataEvent(ModContainer modContainer, DataGenerator dataGenerator, DataGeneratorConfig config, DatapackRegistrySets<CompletableFuture<HolderLookup.Provider>> registries) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the GatherDataEvent constructor yet");
	}

	public ModContainer getModContainer() {
		return this.modContainer;
	}

	public ResourceManager getResourceManager(PackType arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement GatherDataEvent.getResourceManager yet");
	}

	public Collection<Path> getInputs() {
		throw new UnsupportedOperationException("SteelWool does not implement GatherDataEvent.getInputs yet");
	}

	public DataGenerator getGenerator() {
		return this.dataGenerator;
	}

	public PackGenerator getDefaultPackGenerator() {
		return this.defaultPackGenerator;
	}

	public PackGenerator getPackGenerator(PackOutput arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement GatherDataEvent.getPackGenerator yet");
	}

	public CompletableFuture<HolderLookup.Provider> getWorldLookupProvider() {
		throw new UnsupportedOperationException("SteelWool does not implement GatherDataEvent.getWorldLookupProvider yet");
	}

	public CompletableFuture<HolderLookup.Provider> getReloadableLookupProvider() {
		throw new UnsupportedOperationException("SteelWool does not implement GatherDataEvent.getReloadableLookupProvider yet");
	}

	public boolean includeDev() {
		throw new UnsupportedOperationException("SteelWool does not implement GatherDataEvent.includeDev yet");
	}

	public boolean includeReports() {
		throw new UnsupportedOperationException("SteelWool does not implement GatherDataEvent.includeReports yet");
	}

	public boolean validate() {
		throw new UnsupportedOperationException("SteelWool does not implement GatherDataEvent.validate yet");
	}

	public <T extends DataProvider> T addProvider(T arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement GatherDataEvent.addProvider yet");
	}

	public <T extends DataProvider> T createProvider(PackGenerator.DataProviderFromOutput<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement GatherDataEvent.createProvider yet");
	}

	public <T extends DataProvider> T createProvider(PackGenerator.DataProviderFromOutputLookup<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement GatherDataEvent.createProvider yet");
	}

	public void createBlockAndItemTags(PackGenerator.DataProviderFromOutputLookup<TagsProvider<Block>> arg0, PackGenerator.ItemTagsProvider arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement GatherDataEvent.createBlockAndItemTags yet");
	}

	public static final class Client extends net.neoforged.neoforge.data.event.GatherDataEvent {
		public Client(ModContainer arg0, DataGenerator arg1, DataGeneratorConfig arg2, DatapackRegistrySets<CompletableFuture<HolderLookup.Provider>> arg3) {
			super(arg0, arg1, arg2, arg3);
		}
	}

	public interface GatherDataEventGenerator {
		net.neoforged.neoforge.data.event.GatherDataEvent create(ModContainer arg0, DataGenerator arg1, DataGeneratorConfig arg2, DatapackRegistrySets<CompletableFuture<HolderLookup.Provider>> arg3);
	}

	public static final class Server extends net.neoforged.neoforge.data.event.GatherDataEvent {
		public Server(ModContainer arg0, DataGenerator arg1, DataGeneratorConfig arg2, DatapackRegistrySets<CompletableFuture<HolderLookup.Provider>> arg3) {
			super(arg0, arg1, arg2, arg3);
		}
	}
}
