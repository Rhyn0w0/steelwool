package dev.steelwool.discovery;

import java.util.List;
import java.util.Map;

import org.jspecify.annotations.Nullable;

/**
 * One {@code [[mods]]} entry from a {@code META-INF/neoforge.mods.toml} file.
 *
 * @param config        the raw {@code [[mods]]} entry as nested maps and lists
 * @param modProperties the {@code [modproperties.<modid>]} table
 */
public record NeoForgeModMetadata(
		String modId,
		String version,
		String displayName,
		String description,
		List<Dependency> dependencies,
		Map<String, Object> config,
		Map<String, Object> modProperties) {
	public NeoForgeModMetadata {
		dependencies = List.copyOf(dependencies);
		config = Map.copyOf(config);
		modProperties = Map.copyOf(modProperties);
	}

	public NeoForgeModMetadata(String modId, String version, String displayName, String description, List<Dependency> dependencies) {
		this(modId, version, displayName, description, dependencies, Map.of(), Map.of());
	}

	/**
	 * One {@code [[dependencies.<modid>]]} entry.
	 *
	 * @param type one of {@code required}, {@code optional}, {@code incompatible} or {@code discouraged} (lower case)
	 * @param side one of {@code BOTH}, {@code CLIENT} or {@code SERVER}
	 */
	public record Dependency(String modId, String type, String versionRange, String side, String ordering, @Nullable String reason) {
		public Dependency(String modId, String type, String versionRange, String side) {
			this(modId, type, versionRange, side, "NONE", null);
		}

		public boolean isRequired() {
			return "required".equals(type);
		}

		public boolean isIncompatible() {
			return "incompatible".equals(type);
		}
	}
}
