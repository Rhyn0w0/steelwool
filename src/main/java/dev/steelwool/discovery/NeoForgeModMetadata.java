package dev.steelwool.discovery;

import java.util.List;

/**
 * One {@code [[mods]]} entry from a {@code META-INF/neoforge.mods.toml} file.
 */
public record NeoForgeModMetadata(
		String modId,
		String version,
		String displayName,
		String description,
		List<Dependency> dependencies) {
	public NeoForgeModMetadata {
		dependencies = List.copyOf(dependencies);
	}

	/**
	 * One {@code [[dependencies.<modid>]]} entry.
	 *
	 * @param type one of {@code required}, {@code optional}, {@code incompatible} or {@code discouraged} (lower case)
	 * @param side one of {@code BOTH}, {@code CLIENT} or {@code SERVER}
	 */
	public record Dependency(String modId, String type, String versionRange, String side) {
		public boolean isRequired() {
			return "required".equals(type);
		}

		public boolean isIncompatible() {
			return "incompatible".equals(type);
		}
	}
}
