package dev.steelwool.server;

import dev.steelwool.loading.SteelWoolLoader;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.neoforged.api.distmarker.Dist;

/**
 * Dedicated server entrypoint: fires {@code FMLDedicatedServerSetupEvent} and the remaining
 * lifecycle events.
 */
public final class SteelWoolServer implements DedicatedServerModInitializer {
	@Override
	public void onInitializeServer() {
		SteelWoolLoader.get().finishLoading(Dist.DEDICATED_SERVER);
	}
}
