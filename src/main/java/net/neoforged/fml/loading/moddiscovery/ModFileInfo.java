package net.neoforged.fml.loading.moddiscovery;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import dev.steelwool.discovery.NeoForgeModFile;
import dev.steelwool.loading.MapConfigurable;
import net.neoforged.neoforgespi.language.IConfigurable;
import net.neoforged.neoforgespi.language.IModFileInfo;
import net.neoforged.neoforgespi.language.IModInfo;

/**
 * SteelWool re-implementation of FML's {@code ModFileInfo}: the parsed {@code neoforge.mods.toml} of a mod file.
 */
public class ModFileInfo implements IModFileInfo, IConfigurable {
	private final ModFile file;
	private final MapConfigurable config;
	private final List<IModInfo> mods;

	ModFileInfo(ModFile file, NeoForgeModFile source) {
		this.file = file;
		this.config = new MapConfigurable(source.modsToml().properties());
		this.mods = source.modsToml().mods().stream().<IModInfo>map(m -> new ModInfo(this, m)).toList();
	}

	@Override
	public List<IModInfo> getMods() {
		return mods;
	}

	@Override
	public ModFile getFile() {
		return file;
	}

	@Override
	public Map<String, Object> getFileProperties() {
		return Map.of();
	}

	@Override
	public boolean showAsResourcePack() {
		return config.<Boolean>getConfigElement("showAsResourcePack").orElse(false);
	}

	@Override
	public boolean showAsDataPack() {
		return config.<Boolean>getConfigElement("showAsDataPack").orElse(false);
	}

	@Override
	public <T> Optional<T> getConfigElement(String... key) {
		return config.getConfigElement(key);
	}

	@Override
	public List<? extends IConfigurable> getConfigList(String... key) {
		return config.getConfigList(key);
	}

	@Override
	public String getLicense() {
		return config.<String>getConfigElement("license").orElse("");
	}

	@Override
	public IConfigurable getConfig() {
		return this;
	}

	@Override
	public String versionString() {
		return mods.isEmpty() ? "0.0NONE" : mods.getFirst().getVersion().toString();
	}

	@Override
	public List<String> usesServices() {
		return config.<List<String>>getConfigElement("services").orElse(List.of());
	}

	@Override
	public String toString() {
		return "IModFileInfo(" + file.getFilePath() + ")";
	}
}
