package net.neoforged.neoforge.common.data;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.minecraft.data.registries.RegistriesDatapackGenerator;
import net.minecraft.resources.RegistryDataLoader;

/**
 * SteelWool re-implementation of NeoForge's {@code DatapackBuiltinEntriesProvider}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class DatapackBuiltinEntriesProvider extends RegistriesDatapackGenerator {
	private final CompletableFuture<HolderLookup.Provider> fullRegistries;

	public DatapackBuiltinEntriesProvider(PackOutput arg0, String arg1, Collection<RegistryDataLoader.RegistryData<?>> arg2, CompletableFuture<RegistrySetBuilder.PatchedRegistries> arg3, Set<String> arg4) {
		super(arg0, arg1, arg2, arg3.thenApply(RegistrySetBuilder.PatchedRegistries::patches));
		this.fullRegistries = arg3.thenApply(RegistrySetBuilder.PatchedRegistries::full);
	}

	public static net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider forWorldLayer(PackOutput arg0, String arg1, CompletableFuture<HolderLookup.Provider> arg2, RegistrySetBuilder arg3, Set<String> arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement DatapackBuiltinEntriesProvider.forWorldLayer yet");
	}

	public static net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider forReloadableLayer(PackOutput arg0, String arg1, CompletableFuture<HolderLookup.Provider> arg2, CompletableFuture<HolderLookup.Provider> arg3, RegistrySetBuilder arg4, Set<String> arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement DatapackBuiltinEntriesProvider.forReloadableLayer yet");
	}

	public CompletableFuture<HolderLookup.Provider> getRegistryProvider() {
		return this.fullRegistries;
	}
}
