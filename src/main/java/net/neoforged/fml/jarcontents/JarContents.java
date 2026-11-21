package net.neoforged.fml.jarcontents;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Optional;
import java.util.jar.Manifest;

import dev.steelwool.loading.SteelWoolJarContents;
import org.jspecify.annotations.Nullable;

/**
 * SteelWool subset of FML's {@code JarContents}: read access to the files in a mod jar.
 *
 * <p>Not supported: {@code get(String)} and {@code visitContent(...)}, which use FML's resource types.
 */
public interface JarContents extends Closeable {
	static JarContents ofPath(Path path) throws IOException {
		return new SteelWoolJarContents(path);
	}

	Optional<String> getChecksum();

	Path getPrimaryPath();

	Collection<Path> getContentRoots();

	Optional<URI> findFile(String relativePath);

	@Nullable InputStream openFile(String relativePath) throws IOException;

	default byte @Nullable [] readFile(String relativePath) throws IOException {
		try (InputStream in = openFile(relativePath)) {
			return in == null ? null : in.readAllBytes();
		}
	}

	boolean containsFile(String relativePath);

	Manifest getManifest();
}
