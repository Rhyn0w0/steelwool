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
	private static boolean loaded;

	private SteelWoolConfigs() {
	}

	public static String defaultFileName(String modId, ModConfig.Type type) {
		return modId + "-" + type.extension() + ".toml";
	}

	public static synchronized void register(ModConfig config) {
		CONFIGS.add(config);

		// Configs registered after the initial load (unusual) are loaded straight away.
		if (loaded) {
			load(config);
		}
	}

	/** Loads every registered config and fires {@link ModConfigEvent.Loading} for each. */
	public static synchronized void loadAll() {
		loaded = true;

		for (ModConfig config : List.copyOf(CONFIGS)) {
			load(config);
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
