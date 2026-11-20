package net.neoforged.fml.loading.moddiscovery;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import dev.steelwool.discovery.NeoForgeModMetadata;
import dev.steelwool.loading.MapConfigurable;
import net.neoforged.neoforgespi.language.IConfigurable;
import net.neoforged.neoforgespi.language.IModInfo;
import org.apache.maven.artifact.versioning.ArtifactVersion;
import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.apache.maven.artifact.versioning.InvalidVersionSpecificationException;
import org.apache.maven.artifact.versioning.VersionRange;

/**
 * SteelWool re-implementation of FML's {@code ModInfo}: one {@code [[mods]]} entry of a loaded mod file.
 */
public class ModInfo implements IModInfo, IConfigurable {
	private final ModFileInfo owningFile;
	private final NeoForgeModMetadata metadata;
	private final MapConfigurable config;
	private final ArtifactVersion version;
	private final List<ModVersion> dependencies;

	/** Created by SteelWool's loader; not part of the NeoForge API. */
	public ModInfo(ModFileInfo owningFile, NeoForgeModMetadata metadata) {
		this.owningFile = owningFile;
		this.metadata = metadata;
		this.config = new MapConfigurable(metadata.config());
		this.version = new DefaultArtifactVersion(metadata.version());
		this.dependencies = metadata.dependencies().stream().map(d -> new ModVersion(this, d)).toList();
	}

	/** The parsed metadata SteelWool read; not part of the NeoForge API. */
	public NeoForgeModMetadata steelwool$metadata() {
		return metadata;
	}

	@Override
	public ModFileInfo getOwningFile() {
		return owningFile;
	}

	@Override
	public String getModId() {
		return metadata.modId();
	}

	@Override
	public String getDisplayName() {
		return metadata.displayName();
	}

	@Override
	public String getDescription() {
		return metadata.description();
	}

	@Override
	public ArtifactVersion getVersion() {
		return version;
	}

	@Override
	public List<? extends IModInfo.ModVersion> getDependencies() {
		return dependencies;
	}

	@Override
	public String getNamespace() {
		return config.<String>getConfigElement("namespace").orElse(metadata.modId());
	}

	@Override
	public Map<String, Object> getModProperties() {
		return metadata.modProperties();
	}

	@Override
	public Optional<URL> getUpdateURL() {
		return url("updateJSONURL");
	}

	@Override
	public Optional<URL> getModURL() {
		return url("modUrl");
	}

	@Override
	public Optional<String> getLogoFile() {
		Optional<String> own = config.getConfigElement("logoFile");
		return own.isPresent() ? own : owningFile.getConfig().getConfigElement("logoFile");
	}

	@Override
	public boolean getLogoBlur() {
		return config.<Boolean>getConfigElement("logoBlur").orElse(true);
	}

	@Override
	public IConfigurable getConfig() {
		return this;
	}

	@Override
	public <T> Optional<T> getConfigElement(String... key) {
		return config.getConfigElement(key);
	}

	@Override
	public List<? extends IConfigurable> getConfigList(String... key) {
		return config.getConfigList(key);
	}

	private Optional<URL> url(String key) {
		return config.<String>getConfigElement(key).map(s -> {
			try {
				return URI.create(s).toURL();
			} catch (IllegalArgumentException | MalformedURLException e) {
				return null;
			}
		});
	}

	@Override
	public String toString() {
		return "Mod(" + getModId() + " " + version + ")";
	}

	public static class ModVersion implements IModInfo.ModVersion {
		private IModInfo owner;
		private final NeoForgeModMetadata.Dependency dependency;
		private final VersionRange range;

		ModVersion(IModInfo owner, NeoForgeModMetadata.Dependency dependency) {
			this.owner = owner;
			this.dependency = dependency;
			this.range = parseRange(dependency.versionRange());
		}

		private static VersionRange parseRange(String spec) {
			if (spec.isBlank() || "*".equals(spec)) {
				return UNBOUNDED;
			}

			try {
				return VersionRange.createFromVersionSpec(spec);
			} catch (InvalidVersionSpecificationException e) {
				return UNBOUNDED;
			}
		}

		@Override
		public String getModId() {
			return dependency.modId();
		}

		@Override
		public VersionRange getVersionRange() {
			return range;
		}

		@Override
		public DependencyType getType() {
			return DependencyType.valueOf(dependency.type().toUpperCase(Locale.ROOT));
		}

		@Override
		public Optional<String> getReason() {
			return Optional.ofNullable(dependency.reason());
		}

		@Override
		public Ordering getOrdering() {
			try {
				return Ordering.valueOf(dependency.ordering());
			} catch (IllegalArgumentException e) {
				return Ordering.NONE;
			}
		}

		@Override
		public DependencySide getSide() {
			try {
				return DependencySide.valueOf(dependency.side());
			} catch (IllegalArgumentException e) {
				return DependencySide.BOTH;
			}
		}

		@Override
		public void setOwner(IModInfo owner) {
			this.owner = owner;
		}

		@Override
		public IModInfo getOwner() {
			return owner;
		}

		@Override
		public Optional<URL> getReferralURL() {
			return Optional.empty();
		}

		@Override
		public String toString() {
			return dependency.modId() + " " + range;
		}
	}
}
