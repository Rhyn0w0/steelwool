package net.neoforged.fml;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import net.fabricmc.loader.api.FabricLoader;
import net.neoforged.fml.loading.LoadingModList;
import net.neoforged.fml.loading.moddiscovery.ModFileInfo;
import net.neoforged.neoforgespi.language.IModFileInfo;
import net.neoforged.neoforgespi.language.IModInfo;
import net.neoforged.neoforgespi.language.ModFileScanData;
import net.neoforged.neoforgespi.locating.IModFile;
import org.jspecify.annotations.Nullable;

/**
 * SteelWool re-implementation of FML's {@code ModList}. {@link #isLoaded(String)} also reports
 * Fabric mods, so NeoForge mods' optional integrations with mods that exist on both loaders work.
 */
public class ModList {
	private static final ModList INSTANCE = new ModList();

	private final Map<String, ModContainer> containers = new LinkedHashMap<>();

	public static ModList get() {
		return INSTANCE;
	}

	/** Called by SteelWool's loader; not part of the NeoForge API. */
	public void steelwool$add(ModContainer container) {
		containers.put(container.getModId(), container);
	}

	public List<IModFileInfo> getModFiles() {
		return List.copyOf(LoadingModList.get().getModFiles());
	}

	public @Nullable IModFileInfo getModFileById(String modId) {
		return LoadingModList.get().getModFileById(modId);
	}

	public List<ModFileScanData> getAllScanData() {
		return LoadingModList.get().getModFiles().stream().map(f -> f.getFile().getScanResult()).toList();
	}

	public void forEachModFile(Consumer<IModFile> consumer) {
		LoadingModList.get().getModFiles().stream().map(ModFileInfo::getFile).forEach(consumer);
	}

	public <T> Stream<T> applyForEachModFile(Function<IModFile, T> function) {
		return LoadingModList.get().getModFiles().stream().map(ModFileInfo::getFile).map(function);
	}

	public <T> Stream<T> applyForEachModFileAlphabetical(Function<IModFile, T> function) {
		return LoadingModList.get().getModFiles().stream().map(ModFileInfo::getFile)
				.sorted(java.util.Comparator.comparing(IModFile::getId)).map(function);
	}

	public Optional<? extends ModContainer> getModContainerById(String modId) {
		return Optional.ofNullable(containers.get(modId));
	}

	public List<IModInfo> getMods() {
		return containers.values().stream().map(ModContainer::getModInfo).toList();
	}

	public boolean isLoaded(String modTarget) {
		return containers.containsKey(modTarget)
				|| "neoforge".equals(modTarget)
				|| FabricLoader.getInstance().isModLoaded(modTarget);
	}

	public int size() {
		return containers.size();
	}

	public List<ModContainer> getSortedMods() {
		return new ArrayList<>(containers.values());
	}

	public void forEachModContainer(BiConsumer<String, ModContainer> consumer) {
		containers.forEach(consumer);
	}

	public void forEachModInOrder(Consumer<ModContainer> consumer) {
		containers.values().forEach(consumer);
	}

	public <T> Stream<T> applyForEachModContainer(Function<ModContainer, T> function) {
		return containers.values().stream().map(function);
	}
}
