package net.neoforged.neoforge.data.event;

import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;

/**
 * SteelWool re-implementation of NeoForge's {@code DataGeneratorConfig}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class DataGeneratorConfig {
	private final Set<String> mods;
	private final Path path;
	private final Collection<Path> inputs;
	final CompletableFuture<HolderLookup.Provider> worldLookupProvider;
	final boolean dev;
	final boolean reports;
	final boolean validate;
	private final boolean flat;
	private final List<DataGenerator> generators;
	final ResourceManager clientResourceManager;
	final ResourceManager serverResourceManager;

	public DataGeneratorConfig(Set<String> arg0, Path arg1, Collection<Path> arg2, CompletableFuture<HolderLookup.Provider> arg3, boolean arg4, boolean arg5, boolean arg6, boolean arg7, DataGenerator arg8, Collection<Path> arg9, Consumer<Consumer<PackResources>> arg10) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the DataGeneratorConfig constructor yet");
	}

	public Collection<Path> getInputs() {
		return this.inputs;
	}

	public Set<String> getMods() {
		return this.mods;
	}

	public boolean isFlat() {
		throw new UnsupportedOperationException("SteelWool does not implement DataGeneratorConfig.isFlat yet");
	}

	public DataGenerator makeGenerator(Function<Path, Path> arg0, boolean arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DataGeneratorConfig.makeGenerator yet");
	}

	public void runAll() {
		throw new UnsupportedOperationException("SteelWool does not implement DataGeneratorConfig.runAll yet");
	}

	private static ResourceManager createResourceManager(PackType arg0, Predicate<String> arg1, Collection<Path> arg2, Consumer<Consumer<PackResources>> arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement DataGeneratorConfig.createResourceManager yet");
	}
}
