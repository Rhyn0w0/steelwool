package dev.steelwool;

import dev.steelwool.loading.SteelWoolLoader;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

/**
 * Runs before Minecraft's classes load: finds NeoForge mods and puts them on the class path.
 */
public final class SteelWoolPreLaunch implements PreLaunchEntrypoint {
	@Override
	public void onPreLaunch() {
		SteelWoolLoader.get().discoverAndAttach();
	}
}
