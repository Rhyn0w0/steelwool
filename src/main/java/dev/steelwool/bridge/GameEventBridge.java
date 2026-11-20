package dev.steelwool.bridge;

import dev.steelwool.loading.SteelWoolLoader;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.event.server.ServerStoppedEvent;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;

/**
 * Translates Fabric API callbacks into the NeoForge events SteelWool supports.
 */
public final class GameEventBridge {
	private GameEventBridge() {
	}

	public static void register() {
		ServerLifecycleEvents.SERVER_STARTING.register(server -> NeoForge.EVENT_BUS.post(new ServerAboutToStartEvent(server)));
		ServerLifecycleEvents.SERVER_STARTED.register(server -> {
			NeoForge.EVENT_BUS.post(new ServerStartingEvent(server));
			NeoForge.EVENT_BUS.post(new ServerStartedEvent(server));
		});
		ServerLifecycleEvents.SERVER_STOPPING.register(server -> NeoForge.EVENT_BUS.post(new ServerStoppingEvent(server)));
		ServerLifecycleEvents.SERVER_STOPPED.register(server -> NeoForge.EVENT_BUS.post(new ServerStoppedEvent(server)));

		CommandRegistrationCallback.EVENT.register((dispatcher, context, selection) ->
				NeoForge.EVENT_BUS.post(new RegisterCommandsEvent(dispatcher, selection, context)));

		CreativeModeTabEvents.MODIFY_OUTPUT_ALL.register((tab, output) -> BuiltInRegistries.CREATIVE_MODE_TAB.getResourceKey(tab)
				.ifPresent(key -> SteelWoolLoader.get().postToAllModBuses(new BuildCreativeModeTabContentsEvent(tab, key, output))));
	}
}
