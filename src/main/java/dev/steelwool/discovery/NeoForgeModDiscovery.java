package dev.steelwool.discovery;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Manifest;
import java.util.stream.Stream;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Finds NeoForge mod jars in a folder (normally {@code mods/neoforge/}).
 */
public final class NeoForgeModDiscovery {
	private static final Logger LOGGER = LoggerFactory.getLogger("SteelWool/Discovery");
	static final String MODS_TOML = "META-INF/neoforge.mods.toml";
	static final String LEGACY_FORGE_TOML = "META-INF/mods.toml";
	static final String JARJAR_DIR = "META-INF/jarjar";

	private final Path jarJarCache;

	/**
	 * @param jarJarCache folder that nested (jar-in-jar) jars are extracted to
	 */
	public NeoForgeModDiscovery(Path jarJarCache) {
		this.jarJarCache = jarJarCache;
	}

	/**
	 * Result of a discovery run.
	 *
	 * @param mods    NeoForge mod jars, top-level and nested, in load order
	 * @param skipped jars that were ignored, with the reason
	 */
	public record Result(List<NeoForgeModFile> mods, Map<Path, String> skipped) {
	}

	public Result discover(Path folder) throws IOException {
		List<NeoForgeModFile> mods = new ArrayList<>();
		Map<Path, String> skipped = new HashMap<>();

		if (!Files.isDirectory(folder)) {
			return new Result(mods, skipped);
		}

		List<Path> jars;

		try (Stream<Path> files = Files.list(folder)) {
			jars = files.filter(NeoForgeModDiscovery::isCandidate)
					.sorted(Comparator.comparing(p -> p.getFileName().toString()))
					.toList();
		}

		for (Path jar : jars) {
			readJar(jar, mods, skipped, true);
		}

		return new Result(mods, skipped);
	}

	static boolean isCandidate(Path path) {
		String name = path.getFileName().toString();
		return Files.isRegularFile(path) && name.endsWith(".jar") && !name.startsWith(".");
	}

	private void readJar(Path jar, List<NeoForgeModFile> mods, Map<Path, String> skipped, boolean topLevel) throws IOException {
		try (FileSystem fs = FileSystems.newFileSystem(jar)) {
			Path root = fs.getPath("/");
			Path toml = root.resolve(MODS_TOML);

			if (!Files.exists(toml)) {
				if (topLevel) {
					String reason = Files.exists(root.resolve(LEGACY_FORGE_TOML))
							? "it is a (Lex) Forge mod, not a NeoForge mod"
							: Files.exists(root.resolve("fabric.mod.json"))
							? "it is a Fabric mod; put it in the main mods folder instead"
							: "it has no META-INF/neoforge.mods.toml";
					skipped.put(jar, reason);
				}

				return;
			}

			ModsToml modsToml;

			try (InputStream in = Files.newInputStream(toml)) {
				modsToml = ModsTomlParser.parse(in, implementationVersion(root));
			}

			if (!"javafml".equals(modsToml.modLoader())) {
				skipped.put(jar, "it uses the unsupported mod loader '" + modsToml.modLoader() + "' (only javafml is supported)");
				return;
			}

			AnnotationScanner scanner = new AnnotationScanner();

			try (Stream<Path> files = Files.walk(root)) {
				for (Path file : (Iterable<Path>) files::iterator) {
					if (file.toString().endsWith(".class") && Files.isRegularFile(file)) {
						try (InputStream in = Files.newInputStream(file)) {
							scanner.scan(in);
						}
					}
				}
			}

			// Jar-in-jar: nested NeoForge mods are loaded as mods, anything else as a library.
			List<Path> libraries = new ArrayList<>();
			List<Path> nestedMods = new ArrayList<>();
			Path jarJar = root.resolve(JARJAR_DIR);

			if (Files.isDirectory(jarJar)) {
				try (Stream<Path> nested = Files.list(jarJar)) {
					for (Path inner : (Iterable<Path>) nested.filter(p -> p.toString().endsWith(".jar")).sorted()::iterator) {
						Path extracted = extract(jar, inner);

						if (containsModsToml(extracted)) {
							nestedMods.add(extracted);
						} else {
							libraries.add(extracted);
						}
					}
				}
			}

			mods.add(new NeoForgeModFile(jar, modsToml, scanner.result(), libraries));

			for (Path nested : nestedMods) {
				readJar(nested, mods, skipped, false);
			}
		}
	}

	private static @Nullable String implementationVersion(Path root) throws IOException {
		Path manifest = root.resolve("META-INF/MANIFEST.MF");

		if (!Files.exists(manifest)) {
			return null;
		}

		try (InputStream in = Files.newInputStream(manifest)) {
			return new Manifest(in).getMainAttributes().getValue("Implementation-Version");
		}
	}

	private static boolean containsModsToml(Path jar) throws IOException {
		try (FileSystem fs = FileSystems.newFileSystem(jar)) {
			return Files.exists(fs.getPath(MODS_TOML));
		}
	}

	private Path extract(Path outerJar, Path inner) throws IOException {
		String outerName = outerJar.getFileName().toString().replaceAll("\\.jar$", "");
		Path target = jarJarCache.resolve(outerName).resolve(inner.getFileName().toString());
		Files.createDirectories(target.getParent());
		Files.copy(inner, target, StandardCopyOption.REPLACE_EXISTING);
		LOGGER.debug("Extracted nested jar {} from {}", inner, outerJar);
		return target;
	}
}
