package net.neoforged.fml.config;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * SteelWool re-implementation of NeoForge's {@code ModConfigs}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class ModConfigs {
	public ModConfigs() {
		super();
	}

	public static List<ModConfig> getModConfigs(String arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModConfigs.getModConfigs yet");
	}

	public static List<String> getConfigFileNames(String arg0, ModConfig.Type arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ModConfigs.getConfigFileNames yet");
	}

	public static Set<ModConfig> getConfigSet(ModConfig.Type arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModConfigs.getConfigSet yet");
	}

	public static Map<String, ModConfig> getFileMap() {
		throw new UnsupportedOperationException("SteelWool does not implement ModConfigs.getFileMap yet");
	}
}
