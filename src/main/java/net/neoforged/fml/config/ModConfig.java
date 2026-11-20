package net.neoforged.fml.config;

import java.nio.file.Path;
import java.util.Locale;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.loading.FMLPaths;
import org.jspecify.annotations.Nullable;

/**
 * SteelWool re-implementation of FML's {@code ModConfig}: one registered config file of a mod.
 *
 * <p>SteelWool keeps every config type in the game's {@code config/} folder. (NeoForge stores
 * {@link Type#SYNCED} configs per world and syncs them to clients; SteelWool does not yet.)
 */
public final class ModConfig {
	private final Type type;
	private final IConfigSpec spec;
	private final ModContainer container;
	private final String fileName;
	private IConfigSpec.@Nullable ILoadedConfig loadedConfig;

	public ModConfig(Type type, IConfigSpec spec, ModContainer container, String fileName) {
		this.type = type;
		this.spec = spec;
		this.container = container;
		this.fileName = fileName;
	}

	public Type getType() {
		return type;
	}

	public String getFileName() {
		return fileName;
	}

	public IConfigSpec getSpec() {
		return spec;
	}

	public String getModId() {
		return container.getModId();
	}

	/** Not part of the NeoForge API. */
	public ModContainer steelwool$getContainer() {
		return container;
	}

	public IConfigSpec.@Nullable ILoadedConfig getLoadedConfig() {
		return loadedConfig;
	}

	/** Not part of the NeoForge API. */
	public void steelwool$setLoadedConfig(IConfigSpec.@Nullable ILoadedConfig loadedConfig) {
		this.loadedConfig = loadedConfig;
	}

	public Path getFullPath() {
		return FMLPaths.CONFIGDIR.get().resolve(fileName);
	}

	public enum Type {
		LOCAL,
		CLIENT,
		SYNCED,
		STARTUP;

		public String extension() {
			return name().toLowerCase(Locale.ROOT);
		}
	}
}
