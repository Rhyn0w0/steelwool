package dev.steelwool.client;

import dev.steelwool.loading.SteelWoolLoader;
import net.fabricmc.api.ClientModInitializer;
import net.neoforged.api.distmarker.Dist;

/**
 * Client entrypoint: fires {@code FMLClientSetupEvent} and the remaining lifecycle events.
 */
public final class SteelWoolClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		SteelWoolLoader.get().finishLoading(Dist.CLIENT);
	}
}
