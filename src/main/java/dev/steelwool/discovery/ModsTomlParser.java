package dev.steelwool.discovery;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.electronwill.nightconfig.core.UnmodifiableConfig;
import com.electronwill.nightconfig.core.io.ParsingException;
import com.electronwill.nightconfig.toml.TomlParser;
import org.jspecify.annotations.Nullable;

/**
 * Parses {@code META-INF/neoforge.mods.toml}.
 */
public final class ModsTomlParser {
	/** NeoForge replaces this placeholder with the jar manifest's {@code Implementation-Version}. */
	private static final String JAR_VERSION_PLACEHOLDER = "${file.jarVersion}";

	private ModsTomlParser() {
	}

	public static ModsToml parse(InputStream in, @Nullable String jarVersion) throws IOException {
		try (Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8)) {
			return parse(reader, jarVersion);
		}
	}

	public static ModsToml parse(Reader reader, @Nullable String jarVersion) throws IOException {
		UnmodifiableConfig toml;

		try {
			toml = new TomlParser().parse(reader);
		} catch (ParsingException e) {
			throw new IOException("Invalid neoforge.mods.toml: " + e.getMessage(), e);
		}

		String modLoader = toml.getOrElse("modLoader", "javafml");
		String license = toml.getOrElse("license", "");

		List<NeoForgeModMetadata> mods = new ArrayList<>();

		for (UnmodifiableConfig mod : configList(toml, "mods")) {
			String modId = mod.get("modId");

			if (modId == null || modId.isBlank()) {
				throw new IOException("A [[mods]] entry is missing its modId");
			}

			String version = mod.getOrElse("version", "1");

			if (JAR_VERSION_PLACEHOLDER.equals(version)) {
				version = jarVersion != null ? jarVersion : "0.0NONE";
			}

			mods.add(new NeoForgeModMetadata(
					modId,
					version,
					mod.getOrElse("displayName", modId),
					mod.getOrElse("description", "").strip(),
					dependencies(toml, modId)));
		}

		if (mods.isEmpty()) {
			throw new IOException("neoforge.mods.toml declares no [[mods]]");
		}

		List<String> mixins = new ArrayList<>();

		for (UnmodifiableConfig mixin : configList(toml, "mixins")) {
			String config = mixin.get("config");

			if (config != null) {
				mixins.add(config);
			}
		}

		List<String> ats = new ArrayList<>();

		for (UnmodifiableConfig at : configList(toml, "accessTransformers")) {
			String file = at.get("file");

			if (file != null) {
				ats.add(file);
			}
		}

		return new ModsToml(modLoader, license, mods, mixins, ats);
	}

	private static List<NeoForgeModMetadata.Dependency> dependencies(UnmodifiableConfig toml, String modId) {
		List<NeoForgeModMetadata.Dependency> result = new ArrayList<>();

		// Read the path as a list so mod ids containing dots are not split.
		Object raw = toml.get(List.of("dependencies", modId));

		if (raw instanceof List<?> list) {
			for (Object entry : list) {
				if (entry instanceof UnmodifiableConfig dep && dep.get("modId") instanceof String depId) {
					String type = dep.getOrElse("type", "required").toLowerCase(Locale.ROOT);

					// Older files used `mandatory = true/false` instead of `type`.
					if (dep.contains("mandatory") && !dep.contains("type")) {
						type = Boolean.TRUE.equals(dep.get("mandatory")) ? "required" : "optional";
					}

					result.add(new NeoForgeModMetadata.Dependency(
							depId,
							type,
							dep.getOrElse("versionRange", ""),
							dep.getOrElse("side", "BOTH").toUpperCase(Locale.ROOT)));
				}
			}
		}

		return result;
	}

	private static List<UnmodifiableConfig> configList(UnmodifiableConfig toml, String key) {
		Object raw = toml.get(List.of(key));
		List<UnmodifiableConfig> result = new ArrayList<>();

		if (raw instanceof List<?> list) {
			for (Object entry : list) {
				if (entry instanceof UnmodifiableConfig config) {
					result.add(config);
				}
			}
		}

		return result;
	}
}
