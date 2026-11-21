package dev.steelwool;

import dev.steelwool.bridge.GameEventBridge;
import dev.steelwool.bridge.GameplayEventBridge;
import dev.steelwool.loading.SteelWoolLoader;
import net.fabricmc.api.ModInitializer;

/**
 * SteelWool's main entrypoint: constructs NeoForge mods and runs registration and common setup.
 */
public final class SteelWool implements ModInitializer {
	public static final String MOD_ID = "steelwool";

	@Override
	public void onInitialize() {
		// In case another mod's preLaunch skipped ours (e.g. a custom launcher); no-op if already done.
		SteelWoolLoader.get().discoverAndAttach();
		GameEventBridge.register();
		GameplayEventBridge.register();
		SteelWoolLoader.get().constructAndRegister();
	}
}
