package net.neoforged.fml.loading;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

import net.fabricmc.loader.api.FabricLoader;

/**
 * SteelWool re-implementation of FML's {@code FMLPaths}, resolved against Fabric's game directory.
 */
public enum FMLPaths {
	GAMEDIR(""),
	JIJ_CACHEDIR(".cache/jij"),
	MODSDIR("mods"),
	CONFIGDIR("config"),
	FMLCONFIG("config/fml.toml");

	private final String relative;

	FMLPaths(String relative) {
		this.relative = relative;
	}

	public Path relative() {
		return Path.of(relative);
	}

	public Path get() {
		Path gameDir = FabricLoader.getInstance().getGameDir();
		return relative.isEmpty() ? gameDir : gameDir.resolve(relative);
	}

	public static Path getOrCreateGameRelativePath(Path path) {
		Path resolved = GAMEDIR.get().resolve(path);

		try {
			Files.createDirectories(resolved);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}

		return resolved;
	}
}
