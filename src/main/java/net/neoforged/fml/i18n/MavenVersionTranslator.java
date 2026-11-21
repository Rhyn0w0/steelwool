package net.neoforged.fml.i18n;

import org.apache.maven.artifact.versioning.ArtifactVersion;
import org.apache.maven.artifact.versioning.Restriction;
import org.apache.maven.artifact.versioning.VersionRange;

/**
 * SteelWool re-implementation of NeoForge's {@code MavenVersionTranslator}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class MavenVersionTranslator {
	public MavenVersionTranslator() {
		super();
	}

	public static String artifactVersionToString(ArtifactVersion arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MavenVersionTranslator.artifactVersionToString yet");
	}

	public static String versionRangeToString(VersionRange arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MavenVersionTranslator.versionRangeToString yet");
	}

	public static String restrictionToString(Restriction arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MavenVersionTranslator.restrictionToString yet");
	}
}
