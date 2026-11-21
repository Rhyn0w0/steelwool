package net.neoforged.neoforge.common;

/**
 * SteelWool re-implementation of NeoForge's {@code NeoForgeVersion}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class NeoForgeVersion {
	private static final NeoForgeBuildType BUILD_TYPE = null /* SteelWool: TODO */;

	private NeoForgeVersion() {
		super();
	}

	public static String getVersion() {
		throw new UnsupportedOperationException("SteelWool does not implement NeoForgeVersion.getVersion yet");
	}

	public static NeoForgeBuildType getBuildType() {
		throw new UnsupportedOperationException("SteelWool does not implement NeoForgeVersion.getBuildType yet");
	}
}
