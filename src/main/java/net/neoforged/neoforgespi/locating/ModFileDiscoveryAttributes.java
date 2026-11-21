package net.neoforged.neoforgespi.locating;

import org.jspecify.annotations.Nullable;

/**
 * SteelWool subset of FML's {@code ModFileDiscoveryAttributes}: how a mod file was found.
 * Only {@link #parent()} (the jar it was nested in, for jar-in-jar) is tracked.
 */
public record ModFileDiscoveryAttributes(@Nullable IModFile parent) {
	public static final ModFileDiscoveryAttributes DEFAULT = new ModFileDiscoveryAttributes(null);

	public ModFileDiscoveryAttributes withParent(IModFile parent) {
		return new ModFileDiscoveryAttributes(parent);
	}
}
