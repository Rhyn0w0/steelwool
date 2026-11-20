package dev.steelwool.discovery;

import java.util.List;

/**
 * The parts of a {@code META-INF/neoforge.mods.toml} file that SteelWool understands.
 */
public record ModsToml(
		String modLoader,
		String license,
		List<NeoForgeModMetadata> mods,
		List<String> mixinConfigs,
		List<String> accessTransformers) {
	public ModsToml {
		mods = List.copyOf(mods);
		mixinConfigs = List.copyOf(mixinConfigs);
		accessTransformers = List.copyOf(accessTransformers);
	}
}
