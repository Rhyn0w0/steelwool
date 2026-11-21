package dev.steelwool.config;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.electronwill.nightconfig.core.CommentedConfig;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.toml.TomlFormat;
import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Loads and saves the TOML config files that NeoForge mods register with
 * {@code ModContainer.registerConfig}.
 */
public final class SteelWoolConfigs {
	private static final Logger LOGGER = LoggerFactory.getLogger("SteelWool/Configs");
	private static final List<ModConfig> CONFIGS = new ArrayList<>();
	private static final java.util.Set<ModConfig.Type> LOADED_TYPES = java.util.EnumSet.noneOf(ModConfig.Type.class);

	private SteelWoolConfigs() {
	}

	public static String defaultFileName(String modId, ModConfig.Type type) {
		return modId + "-" + type.extension() + ".toml";
	}

	public static synchronized void register(ModConfig config) {
		CONFIGS.add(config);

		// Startup configs load as soon as they are registered, like NeoForge; configs registered
		// after their type was loaded (unusual) are loaded straight away too.
		if (config.getType() == ModConfig.Type.STARTUP || LOADED_TYPES.contains(config.getType())) {
			load(config);
		}
	}

	/**
	 * Loads the local and client configs (NeoForge loads these after constructing mods) and fires
	 * {@link ModConfigEvent.Loading} for each. Synced configs wait for {@link #loadSynced()}.
	 */
	public static synchronized void loadAll() {
		loadType(ModConfig.Type.LOCAL);
		loadType(ModConfig.Type.CLIENT);
	}

	/**
	 * Loads the synced configs, which NeoForge loads when a server starts (after registration, so
	 * they can refer to registered objects). SteelWool keeps them in {@code config/}, not per world.
	 */
	public static synchronized void loadSynced() {
		loadType(ModConfig.Type.SYNCED);
	}

	private static void loadType(ModConfig.Type type) {
		LOADED_TYPES.add(type);

		for (ModConfig config : List.copyOf(CONFIGS)) {
			if (config.getType() == type) {
				load(config);
			}
		}
	}

	public static synchronized List<ModConfig> all() {
		return List.copyOf(CONFIGS);
	}

	private static void load(ModConfig config) {
		Path path = config.getFullPath();
		CommentedFileConfig file = openAndCorrect(path, config.getSpec());
		IConfigSpec.ILoadedConfig loadedConfig = new FileBackedConfig(file);
		config.steelwool$setLoadedConfig(loadedConfig);
		config.getSpec().acceptConfig(loadedConfig);
		LOGGER.debug("Loaded {} config for {} from {}", config.getType(), config.getModId(), path);
		config.steelwool$getContainer().acceptEvent(new ModConfigEvent.Loading(config));
	}

	/**
	 * Reads {@code path} (creating it if missing), fixes missing or invalid values using
	 * {@code spec}, and writes it back if anything changed.
	 */
	public static CommentedFileConfig openAndCorrect(Path path, IConfigSpec spec) {
		try {
			Files.createDirectories(path.getParent());
		} catch (IOException e) {
			throw new UncheckedIOException("Could not create config folder for " + path, e);
		}

		CommentedFileConfig file = CommentedFileConfig.builder(path, TomlFormat.instance())
				.sync()
				.preserveInsertionOrder()
				.build();
		file.load();

		if (!spec.isCorrect(file)) {
			LOGGER.info("Config file {} is missing values or has invalid ones; correcting it", path);
			spec.correct(file);
			file.save();
		}

		return file;
	}

	private record FileBackedConfig(CommentedFileConfig file) implements IConfigSpec.ILoadedConfig {
		@Override
		public CommentedConfig config() {
			return file;
		}

		@Override
		public void save() {
			file.save();
		}
	}
}
