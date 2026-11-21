package net.neoforged.fml.loading;

/**
 * SteelWool re-implementation of NeoForge's {@code VersionInfo}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record VersionInfo(String neoForgeVersion, String mcVersion, String neoFormVersion) {
	public String mcAndNeoFormVersion() {
		throw new UnsupportedOperationException("SteelWool does not implement VersionInfo.mcAndNeoFormVersion yet");
	}
}
