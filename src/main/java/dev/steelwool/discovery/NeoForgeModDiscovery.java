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
	/**
	 * Language loaders SteelWool can run. Kotlin for Forge's loader works like {@code javafml}, except that
	 * a Kotlin {@code object} mod class is used through its {@code INSTANCE} field.
	 */
	static final List<String> SUPPORTED_LOADERS = List.of("javafml", "kotlinforforge");

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
	 * @param libraries library jars that are not mods: top-level jars marked {@code FMLModType: LIBRARY} /
	 *                  {@code GAMELIBRARY} or that only bundle other jars, and the plain jars nested in them
	 * @param skipped   jars that were ignored, with the reason
	 */
	public record Result(List<NeoForgeModFile> mods, List<Path> libraries, Map<Path, String> skipped) {
	}

	public Result discover(Path folder) throws IOException {
		List<NeoForgeModFile> mods = new ArrayList<>();
		List<Path> libraries = new ArrayList<>();
		Map<Path, String> skipped = new HashMap<>();

		if (!Files.isDirectory(folder)) {
			return new Result(mods, libraries, skipped);
		}

		List<Path> jars;

		try (Stream<Path> files = Files.list(folder)) {
			jars = files.filter(NeoForgeModDiscovery::isCandidate)
					.sorted(Comparator.comparing(p -> p.getFileName().toString()))
					.toList();
		}

		for (Path jar : jars) {
			readJar(jar, null, mods, libraries, skipped);
		}

		return new Result(mods, libraries, skipped);
	}

	static boolean isCandidate(Path path) {
		String name = path.getFileName().toString();
		return Files.isRegularFile(path) && name.endsWith(".jar") && !name.startsWith(".");
	}

	private void readJar(Path jar, @Nullable Path parent, List<NeoForgeModFile> mods, List<Path> topLibraries, Map<Path, String> skipped) throws IOException {
		boolean topLevel = parent == null;

		try (FileSystem fs = FileSystems.newFileSystem(jar)) {
			Path root = fs.getPath("/");
			Path toml = root.resolve(MODS_TOML);

			if (!Files.exists(toml)) {
				if (topLevel && isLibrary(root)) {
					// A library jar (e.g. Kotlin for Forge) or a jar that only bundles other jars.
					topLibraries.add(jar);
					List<Path> nestedMods = new ArrayList<>();
					extractJarJar(jar, root, nestedMods, topLibraries);

					for (Path nested : nestedMods) {
						readJar(nested, jar, mods, topLibraries, skipped);
					}
				} else if (topLevel) {
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

			if (!SUPPORTED_LOADERS.contains(modsToml.modLoader())) {
				skipped.put(jar, "it uses the unsupported mod loader '" + modsToml.modLoader() + "' (supported: " + String.join(", ", SUPPORTED_LOADERS) + ")");
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
			extractJarJar(jar, root, nestedMods, libraries);

			mods.add(new NeoForgeModFile(jar, modsToml, scanner.result(), libraries, parent));

			for (Path nested : nestedMods) {
				readJar(nested, jar, mods, topLibraries, skipped);
			}
		}
	}

	/** Extracts {@code META-INF/jarjar/*.jar}, sorting them into NeoForge mods and plain libraries. */
	private void extractJarJar(Path jar, Path root, List<Path> nestedMods, List<Path> libraries) throws IOException {
		Path jarJar = root.resolve(JARJAR_DIR);

		if (!Files.isDirectory(jarJar)) {
			return;
		}

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

	/** A jar without a mods.toml that NeoForge would still load: a declared library, or a jar-in-jar container. */
	private static boolean isLibrary(Path root) throws IOException {
		if (Files.isDirectory(root.resolve(JARJAR_DIR))) {
			return true;
		}

		String modType = manifestAttribute(root, "FMLModType");
		return "LIBRARY".equals(modType) || "GAMELIBRARY".equals(modType);
	}

	private static @Nullable String implementationVersion(Path root) throws IOException {
		return manifestAttribute(root, "Implementation-Version");
	}

	private static @Nullable String manifestAttribute(Path root, String name) throws IOException {
		Path manifest = root.resolve("META-INF/MANIFEST.MF");

		if (!Files.exists(manifest)) {
			return null;
		}

		try (InputStream in = Files.newInputStream(manifest)) {
			return new Manifest(in).getMainAttributes().getValue(name);
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
