package dev.steelwool.discovery;

import java.nio.file.Path;
import java.util.List;

/**
 * A NeoForge mod jar found by {@link NeoForgeModDiscovery}.
 *
 * @param path      the jar on disk (nested jars are extracted to a cache folder first)
 * @param modsToml  its parsed {@code neoforge.mods.toml}
 * @param scan      its {@code @Mod} / {@code @EventBusSubscriber} classes
 * @param libraries plain library jars it bundles via jar-in-jar ({@code META-INF/jarjar/})
 */
public record NeoForgeModFile(Path path, ModsToml modsToml, AnnotationScanResult scan, List<Path> libraries) {
	public NeoForgeModFile {
		libraries = List.copyOf(libraries);
	}

	public String fileName() {
		return path.getFileName().toString();
	}
}
