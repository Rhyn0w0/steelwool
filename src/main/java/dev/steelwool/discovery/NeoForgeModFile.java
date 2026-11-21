package dev.steelwool.discovery;

import java.nio.file.Path;
import java.util.List;

import org.jspecify.annotations.Nullable;

/**
 * A NeoForge mod jar found by {@link NeoForgeModDiscovery}.
 *
 * @param path      the jar on disk (nested jars are extracted to a cache folder first)
 * @param modsToml  its parsed {@code neoforge.mods.toml}
 * @param scan      its {@code @Mod} / {@code @EventBusSubscriber} classes
 * @param libraries plain library jars it bundles via jar-in-jar ({@code META-INF/jarjar/})
 * @param parent    the jar it was nested in, or {@code null} for a top-level jar
 */
public record NeoForgeModFile(Path path, ModsToml modsToml, AnnotationScanResult scan, List<Path> libraries, @Nullable Path parent) {
	public NeoForgeModFile {
		libraries = List.copyOf(libraries);
	}

	public NeoForgeModFile(Path path, ModsToml modsToml, AnnotationScanResult scan, List<Path> libraries) {
		this(path, modsToml, scan, libraries, null);
	}

	public String fileName() {
		return path.getFileName().toString();
	}
}
