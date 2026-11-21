package dev.steelwool.discovery;

import java.util.List;
import java.util.Map;

/**
 * The parts of a {@code META-INF/neoforge.mods.toml} file that SteelWool understands.
 *
 * @param properties the whole file as nested maps and lists, for FML's {@code IConfigurable} lookups
 */
public record ModsToml(
		String modLoader,
		String license,
		List<NeoForgeModMetadata> mods,
		List<String> mixinConfigs,
		List<String> accessTransformers,
		Map<String, Object> properties) {
	public ModsToml {
		mods = List.copyOf(mods);
		mixinConfigs = List.copyOf(mixinConfigs);
		accessTransformers = List.copyOf(accessTransformers);
		properties = Map.copyOf(properties);
	}

	public ModsToml(String modLoader, String license, List<NeoForgeModMetadata> mods, List<String> mixinConfigs, List<String> accessTransformers) {
		this(modLoader, license, mods, mixinConfigs, accessTransformers, Map.of());
	}
}
