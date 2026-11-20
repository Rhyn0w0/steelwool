package dev.steelwool.loading;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.jar.Manifest;

import net.neoforged.fml.jarcontents.JarContents;
import org.jspecify.annotations.Nullable;

/**
 * {@link JarContents} for a jar on disk, read through a zip file system that is opened on first use.
 */
public final class SteelWoolJarContents implements JarContents {
	private final Path jar;
	private @Nullable FileSystem fileSystem;

	public SteelWoolJarContents(Path jar) {
		this.jar = jar;
	}

	private synchronized Path root() {
		try {
			if (fileSystem == null || !fileSystem.isOpen()) {
				fileSystem = FileSystems.newFileSystem(jar);
			}

			return fileSystem.getPath("/");
		} catch (IOException e) {
			throw new UncheckedIOException("Could not open " + jar, e);
		}
	}

	private Path resolve(String relativePath) {
		return root().resolve(relativePath.startsWith("/") ? relativePath.substring(1) : relativePath);
	}

	@Override
	public Optional<String> getChecksum() {
		return Optional.empty();
	}

	@Override
	public Path getPrimaryPath() {
		return jar;
	}

	@Override
	public Collection<Path> getContentRoots() {
		return List.of(jar);
	}

	@Override
	public Optional<URI> findFile(String relativePath) {
		Path path = resolve(relativePath);
		return Files.isRegularFile(path) ? Optional.of(path.toUri()) : Optional.empty();
	}

	@Override
	public @Nullable InputStream openFile(String relativePath) throws IOException {
		Path path = resolve(relativePath);
		return Files.isRegularFile(path) ? Files.newInputStream(path) : null;
	}

	@Override
	public boolean containsFile(String relativePath) {
		return Files.isRegularFile(resolve(relativePath));
	}

	@Override
	public Manifest getManifest() {
		try (InputStream in = openFile("META-INF/MANIFEST.MF")) {
			return in == null ? new Manifest() : new Manifest(in);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	@Override
	public synchronized void close() throws IOException {
		if (fileSystem != null) {
			fileSystem.close();
			fileSystem = null;
		}
	}
}
