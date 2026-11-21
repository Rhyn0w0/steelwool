package dev.steelwool.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class NeoForgeModDiscoveryTest {
	@TempDir
	Path temp;

	static byte[] jar(Map<String, byte[]> entries, String implementationVersion) throws IOException {
		Manifest manifest = new Manifest();
		manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");

		if (implementationVersion != null) {
			manifest.getMainAttributes().put(Attributes.Name.IMPLEMENTATION_VERSION, implementationVersion);
		}

		ByteArrayOutputStream bytes = new ByteArrayOutputStream();

		try (JarOutputStream out = new JarOutputStream(bytes, manifest)) {
			for (Map.Entry<String, byte[]> entry : entries.entrySet()) {
				out.putNextEntry(new JarEntry(entry.getKey()));
				out.write(entry.getValue());
				out.closeEntry();
			}
		}

		return bytes.toByteArray();
	}

	static byte[] modsToml(String modId) {
		return ("[[mods]]\nmodId=\"" + modId + "\"\nversion=\"${file.jarVersion}\"\n").getBytes(StandardCharsets.UTF_8);
	}

	private static void write(Path path, byte[] content) throws IOException {
		try (OutputStream out = Files.newOutputStream(path)) {
			out.write(content);
		}
	}

	@Test
	void missingFolderFindsNothing() throws IOException {
		var result = new NeoForgeModDiscovery(temp.resolve("cache")).discover(temp.resolve("does-not-exist"));
		assertEquals(List.of(), result.mods());
	}

	@Test
	void findsModsAndScansClasses() throws IOException {
		Path mods = Files.createDirectory(temp.resolve("neoforge"));
		Map<String, byte[]> entries = new LinkedHashMap<>();
		entries.put("META-INF/neoforge.mods.toml", modsToml("alpha"));
		entries.put("com/example/Alpha.class", AnnotationScannerTest.annotatedClass("com/example/Alpha", AnnotationScanner.MOD_DESC, "alpha", null, null));
		write(mods.resolve("alpha.jar"), jar(entries, "2.0.0"));

		var result = new NeoForgeModDiscovery(temp.resolve("cache")).discover(mods);

		assertEquals(1, result.mods().size());
		NeoForgeModFile file = result.mods().getFirst();
		assertEquals("alpha", file.modsToml().mods().getFirst().modId());
		assertEquals("2.0.0", file.modsToml().mods().getFirst().version());
		assertEquals("com.example.Alpha", file.scan().modClasses().getFirst().className());
	}

	@Test
	void reportsWhyJarsAreSkipped() throws IOException {
		Path mods = Files.createDirectory(temp.resolve("neoforge"));
		write(mods.resolve("forge.jar"), jar(Map.of("META-INF/mods.toml", modsToml("old")), null));
		write(mods.resolve("fabric.jar"), jar(Map.of("fabric.mod.json", "{}".getBytes(StandardCharsets.UTF_8)), null));
		write(mods.resolve("random.jar"), jar(Map.of("readme.txt", new byte[0]), null));
		write(mods.resolve("notes.txt"), new byte[0]);

		var result = new NeoForgeModDiscovery(temp.resolve("cache")).discover(mods);

		assertEquals(List.of(), result.mods());
		assertEquals(3, result.skipped().size());
		assertTrue(result.skipped().get(mods.resolve("forge.jar")).contains("Forge mod"));
		assertTrue(result.skipped().get(mods.resolve("fabric.jar")).contains("Fabric mod"));
		assertTrue(result.skipped().get(mods.resolve("random.jar")).contains("neoforge.mods.toml"));
	}

	@Test
	void extractsJarInJarModsAndLibraries() throws IOException {
		Path mods = Files.createDirectory(temp.resolve("neoforge"));
		byte[] nestedMod = jar(Map.of("META-INF/neoforge.mods.toml", modsToml("nested")), "1.0");
		byte[] library = jar(Map.of("com/lib/Lib.class", new byte[0]), null);
		Map<String, byte[]> entries = new LinkedHashMap<>();
		entries.put("META-INF/neoforge.mods.toml", modsToml("outer"));
		entries.put("META-INF/jarjar/nested.jar", nestedMod);
		entries.put("META-INF/jarjar/library.jar", library);
		write(mods.resolve("outer.jar"), jar(entries, "1.0"));

		var result = new NeoForgeModDiscovery(temp.resolve("cache")).discover(mods);

		assertEquals(List.of("outer", "nested"), result.mods().stream().map(f -> f.modsToml().mods().getFirst().modId()).toList());
		NeoForgeModFile outer = result.mods().getFirst();
		assertEquals(1, outer.libraries().size());
		assertTrue(Files.isRegularFile(outer.libraries().getFirst()));
	}

	@Test
	void extractsJarsListedInJarJarMetadata() throws IOException {
		Path mods = Files.createDirectory(temp.resolve("neoforge"));
		byte[] library = jar(Map.of("kotlin/Lib.class", new byte[0]), null);
		byte[] metadata = """
				{"jars": [{"identifier": {"group": "org.jetbrains.kotlin", "artifact": "kotlin-stdlib"},
				  "version": {"range": "[2.0,)", "artifactVersion": "2.0"}, "path": "META-INF/jars/kotlin-stdlib.jar"}]}
				""".getBytes(StandardCharsets.UTF_8);
		Map<String, byte[]> entries = new LinkedHashMap<>();
		entries.put("META-INF/neoforge.mods.toml", modsToml("outer"));
		entries.put("META-INF/jarjar/metadata.json", metadata);
		entries.put("META-INF/jars/kotlin-stdlib.jar", library);
		write(mods.resolve("outer.jar"), jar(entries, "1.0"));

		var result = new NeoForgeModDiscovery(temp.resolve("cache")).discover(mods);

		NeoForgeModFile outer = result.mods().getFirst();
		assertEquals(List.of("kotlin-stdlib.jar"), outer.libraries().stream().map(p -> p.getFileName().toString()).toList());
	}

	@Test
	void skipsUnsupportedLoaders() throws IOException {
		Path mods = Files.createDirectory(temp.resolve("neoforge"));
		byte[] toml = "modLoader=\"lowcodefml\"\n[[mods]]\nmodId=\"low\"\n".getBytes(StandardCharsets.UTF_8);
		write(mods.resolve("low.jar"), jar(Map.of("META-INF/neoforge.mods.toml", toml), null));

		var result = new NeoForgeModDiscovery(temp.resolve("cache")).discover(mods);

		assertEquals(List.of(), result.mods());
		assertTrue(result.skipped().get(mods.resolve("low.jar")).contains("lowcodefml"));
	}

	@Test
	void loadsKotlinMods() throws IOException {
		Path mods = Files.createDirectory(temp.resolve("neoforge"));

		for (String loader : List.of("kotlinforforge", "klf")) {
			byte[] toml = ("modLoader=\"" + loader + "\"\n[[mods]]\nmodId=\"" + loader + "_mod\"\n").getBytes(StandardCharsets.UTF_8);
			write(mods.resolve(loader + ".jar"), jar(Map.of("META-INF/neoforge.mods.toml", toml), null));
		}

		var result = new NeoForgeModDiscovery(temp.resolve("cache")).discover(mods);

		assertEquals(List.of("kotlinforforge_mod", "klf_mod"), result.mods().stream().map(f -> f.modsToml().mods().getFirst().modId()).sorted(java.util.Comparator.reverseOrder()).toList());
	}

	@Test
	void loadsLibraryJarsAndTheModsTheyBundle() throws IOException {
		Path mods = Files.createDirectory(temp.resolve("neoforge"));
		byte[] nestedMod = jar(Map.of("META-INF/neoforge.mods.toml", modsToml("bundled")), "1.0");
		byte[] nestedLib = jar(Map.of("com/lib/Lib.class", new byte[0]), null);
		Map<String, byte[]> entries = new LinkedHashMap<>();
		entries.put("META-INF/jarjar/bundled.jar", nestedMod);
		entries.put("META-INF/jarjar/lib.jar", nestedLib);
		write(mods.resolve("container.jar"), jar(entries, null));

		Manifest manifest = new Manifest();
		manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
		manifest.getMainAttributes().putValue("FMLModType", "GAMELIBRARY");
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();

		try (JarOutputStream out = new JarOutputStream(bytes, manifest)) {
			out.putNextEntry(new JarEntry("com/gamelib/Api.class"));
			out.closeEntry();
		}

		write(mods.resolve("gamelib.jar"), bytes.toByteArray());

		var result = new NeoForgeModDiscovery(temp.resolve("cache")).discover(mods);

		assertEquals(List.of("bundled"), result.mods().stream().map(f -> f.modsToml().mods().getFirst().modId()).toList());
		assertEquals(List.of("container.jar", "lib.jar", "gamelib.jar"), result.libraries().stream().map(p -> p.getFileName().toString()).toList());
		assertEquals(Map.of(), result.skipped());
	}
}
