package dev.steelwool.testmod;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;

/**
 * Exercises {@code @EventBusSubscriber}: mod-bus and game-bus events in one class.
 */
@EventBusSubscriber(modid = TestMod.MODID)
public final class TestModSubscriber {
	private TestModSubscriber() {
	}

	@SubscribeEvent
	static void onDedicatedServerSetup(FMLDedicatedServerSetupEvent event) {
		TestModState.dedicatedServerSetupFired = true;
	}

	@SubscribeEvent
	static void onClientSetup(FMLClientSetupEvent event) {
		TestModState.clientSetupFired = true;
	}

	@SubscribeEvent
	static void onLoadComplete(FMLLoadCompleteEvent event) {
		TestModState.loadCompleteFired = true;
	}

	@SubscribeEvent
	static void onServerStarted(ServerStartedEvent event) {
		TestModState.serverStartedFiredViaSubscriber = true;
	}
}
