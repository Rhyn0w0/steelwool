package net.neoforged.fml.loading;

import java.util.Optional;

/**
 * SteelWool re-implementation of FML's {@code JarVersionLookupHandler}: a class's jar version from its
 * package's {@code Implementation-Version}.
 */
public class JarVersionLookupHandler {
	public JarVersionLookupHandler() {
	}

	public static Optional<String> getVersion(Class<?> clazz) {
		Package pkg = clazz.getPackage();
		return Optional.ofNullable(pkg == null ? null : pkg.getImplementationVersion());
	}
}
