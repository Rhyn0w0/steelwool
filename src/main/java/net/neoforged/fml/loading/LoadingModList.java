package net.neoforged.fml.loading;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import net.neoforged.fml.loading.moddiscovery.ModFile;
import net.neoforged.fml.loading.moddiscovery.ModFileInfo;
import net.neoforged.fml.loading.moddiscovery.ModInfo;
import net.neoforged.neoforgespi.locating.IModFile;
import org.jspecify.annotations.Nullable;

/**
 * SteelWool re-implementation of FML's {@code LoadingModList}: the NeoForge mods found at startup,
 * available before they are constructed (for example to mixin config plugins).
 *
 * <p>Not supported: {@code getModLoadingIssues()}, {@code getPlugins()}, {@code getGameLibraries()}
 * and {@code getDependencies(IModInfo)}.
 */
public class LoadingModList {
	private static LoadingModList instance = new LoadingModList(List.of());

	private final List<ModFileInfo> modFiles;
	private final List<ModInfo> mods;
	private final Map<String, ModFileInfo> fileById;

	private LoadingModList(List<ModFile> files) {
		this.modFiles = files.stream().map(f -> (ModFileInfo) f.getModFileInfo()).toList();
		this.mods = modFiles.stream().flatMap(f -> f.getMods().stream()).map(ModInfo.class::cast).toList();
		this.fileById = mods.stream().collect(Collectors.toMap(ModInfo::getModId, ModInfo::getOwningFile, (a, b) -> a));
	}

	/** Called by SteelWool's loader; not part of the NeoForge API. */
	public static void steelwool$set(List<ModFile> files) {
		instance = new LoadingModList(files);
	}

	public static LoadingModList get() {
		return instance;
	}

	public boolean contains(IModFile file) {
		return modFiles.stream().anyMatch(f -> f.getFile() == file);
	}

	public List<ModFileInfo> getModFiles() {
		return modFiles;
	}

	public @Nullable ModFileInfo getModFileById(String modId) {
		return fileById.get(modId);
	}

	public List<ModInfo> getMods() {
		return mods;
	}

	public boolean hasErrors() {
		return false;
	}
}
