package net.neoforged.fml.jarcontents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * SteelWool re-implementation of NeoForge's {@code JarResource}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface JarResource {
	InputStream open() throws IOException;

	default BufferedReader bufferedReader() throws IOException {
		throw new UnsupportedOperationException("SteelWool does not implement JarResource.bufferedReader yet");
	}

	default BufferedReader bufferedReader(Charset arg0) throws IOException {
		throw new UnsupportedOperationException("SteelWool does not implement JarResource.bufferedReader yet");
	}

	default byte[] readAllBytes() throws IOException {
		throw new UnsupportedOperationException("SteelWool does not implement JarResource.readAllBytes yet");
	}

	JarResourceAttributes attributes() throws IOException;

	net.neoforged.fml.jarcontents.JarResource retain();
}
