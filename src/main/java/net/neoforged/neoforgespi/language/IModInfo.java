package net.neoforged.neoforgespi.language;

/**
 * SteelWool subset of FML's {@code IModInfo}: metadata from a mod's {@code [[mods]]} entry.
 *
 * <p>Not yet supported: {@code getVersion()} (which returns a Maven {@code ArtifactVersion}),
 * {@code getOwningFile()}, {@code getDependencies()} and the other less common accessors.
 */
public interface IModInfo {
	String getModId();

	String getDisplayName();

	String getDescription();

	String getNamespace();
}
