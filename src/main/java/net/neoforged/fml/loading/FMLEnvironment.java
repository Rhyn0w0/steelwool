package net.neoforged.fml.loading;

import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.neoforged.api.distmarker.Dist;

/**
 * SteelWool re-implementation of FML's {@code FMLEnvironment}, backed by Fabric Loader.
 */
public final class FMLEnvironment {
	private FMLEnvironment() {
	}

	public static Dist getDist() {
		return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT ? Dist.CLIENT : Dist.DEDICATED_SERVER;
	}

	public static boolean isProduction() {
		return !FabricLoader.getInstance().isDevelopmentEnvironment();
	}
}
