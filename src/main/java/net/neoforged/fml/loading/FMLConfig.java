package net.neoforged.fml.loading;

import java.util.List;
import java.util.Map;

/**
 * SteelWool re-implementation of FML's {@code FMLConfig} (FML's own {@code config/fml.toml}). SteelWool
 * has no FML config file, so every value is FML's default, except that there is no early loading window.
 */
public class FMLConfig {
	public FMLConfig() {
	}

	public enum ConfigValue {
		DISABLE_CONFIG_WATCHER(false),
		EARLY_WINDOW_CONTROL(false),
		MAX_THREADS(-1),
		VERSION_CHECK(true),
		DEBUG_OPENGL(false),
		DEFAULT_CONFIG_PATH("defaultconfigs"),
		DISABLE_OPTIMIZED_DFU(true),
		EARLY_WINDOW_PROVIDER("fmlearlywindow"),
		EARLY_WINDOW_WIDTH(854),
		EARLY_WINDOW_HEIGHT(480),
		EARLY_WINDOW_MAXIMIZED(false),
		EARLY_LOADING_SCREEN_THEME("");

		private final Object defaultValue;

		ConfigValue(Object defaultValue) {
			this.defaultValue = defaultValue;
		}
	}

	public static void load() {
	}

	public static String getConfigValue(ConfigValue value) {
		return String.valueOf(value.defaultValue);
	}

	public static boolean getBoolConfigValue(ConfigValue value) {
		return value.defaultValue instanceof Boolean b && b;
	}

	public static int getIntConfigValue(ConfigValue value) {
		return value.defaultValue instanceof Integer i ? i : 0;
	}

	@SuppressWarnings("unchecked")
	public static <A> List<A> getListConfigValue(ConfigValue value) {
		return value.defaultValue instanceof List<?> list ? (List<A>) list : List.of();
	}

	public static <T> void updateConfig(ConfigValue value, T newValue) {
	}

	public static String defaultConfigPath() {
		return getConfigValue(ConfigValue.DEFAULT_CONFIG_PATH);
	}

	public static Map<String, List<Object>> getDependencyOverrides() {
		return Map.of();
	}
}
