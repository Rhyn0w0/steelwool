package net.neoforged.neoforgespi.language;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;
import org.apache.maven.artifact.versioning.ArtifactVersion;
import org.apache.maven.artifact.versioning.VersionRange;

/**
 * SteelWool re-implementation of FML's {@code IModInfo}: metadata from a mod's {@code [[mods]]} entry.
 *
 * <p>Not supported: {@code getLoader()} and {@code getForgeFeatures()}.
 */
public interface IModInfo {
	VersionRange UNBOUNDED = VersionRange.createFromVersion("");

	IModFileInfo getOwningFile();

	String getModId();

	String getDisplayName();

	String getDescription();

	ArtifactVersion getVersion();

	List<? extends ModVersion> getDependencies();

	String getNamespace();

	Map<String, Object> getModProperties();

	Optional<URL> getUpdateURL();

	Optional<URL> getModURL();

	Optional<String> getLogoFile();

	boolean getLogoBlur();

	IConfigurable getConfig();

	enum DependencyType {
		REQUIRED, OPTIONAL, INCOMPATIBLE, DISCOURAGED
	}

	enum Ordering {
		BEFORE, AFTER, NONE
	}

	enum DependencySide {
		CLIENT(Dist.CLIENT), SERVER(Dist.DEDICATED_SERVER), BOTH(Dist.values());

		private final Dist[] dist;

		DependencySide(Dist... dist) {
			this.dist = dist;
		}

		public boolean isContained(Dist side) {
			for (Dist d : dist) {
				if (d == side) {
					return true;
				}
			}

			return false;
		}

		public boolean isCorrectSide() {
			return this == BOTH || isContained(FMLEnvironment.getDist());
		}
	}

	interface ModVersion {
		String getModId();

		VersionRange getVersionRange();

		DependencyType getType();

		Optional<String> getReason();

		Ordering getOrdering();

		DependencySide getSide();

		void setOwner(IModInfo owner);

		IModInfo getOwner();

		Optional<URL> getReferralURL();
	}
}
