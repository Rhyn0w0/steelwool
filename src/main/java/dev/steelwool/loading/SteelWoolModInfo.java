package dev.steelwool.loading;

import dev.steelwool.discovery.NeoForgeModFile;
import dev.steelwool.discovery.NeoForgeModMetadata;
import net.neoforged.neoforgespi.language.IModInfo;

/**
 * {@link IModInfo} for a NeoForge mod loaded by SteelWool.
 */
public record SteelWoolModInfo(NeoForgeModMetadata metadata, NeoForgeModFile file) implements IModInfo {
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
	public String getNamespace() {
		return metadata.modId();
	}

	/** The mod's version string from {@code neoforge.mods.toml}. */
	public String versionString() {
		return metadata.version();
	}
}
