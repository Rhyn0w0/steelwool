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
import net.neoforged.neoforgespi.language.IModInfo;

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
