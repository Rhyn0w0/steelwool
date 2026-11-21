package dev.steelwool.client;

import dev.steelwool.loading.SteelWoolLoader;
import net.fabricmc.api.ClientModInitializer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.network.event.RegisterClientPayloadHandlersEvent;

/**
 * Client entrypoint: fires {@code FMLClientSetupEvent} and the remaining lifecycle events.
 */
public final class SteelWoolClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		SteelWoolLoader.get().postToAllModBuses(new RegisterClientPayloadHandlersEvent());
		SteelWoolClientNetworking.registerReceivers();
		SteelWoolLoader.get().finishLoading(Dist.CLIENT);
	}
}
