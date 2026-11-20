package dev.steelwool.patch;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.world.item.CreativeModeTab;

/**
 * Implementations of the static methods NeoForge patches into Minecraft classes. The methods are
 * added to the Minecraft classes by {@code SteelWoolMixinPlugin} and forward here.
 */
public final class StaticPatches {
	private StaticPatches() {
	}

	/**
	 * {@code CreativeModeTab.builder()}: NeoForge's builder for mod tabs, which are placed and paged
	 * automatically. Fabric API's {@link FabricCreativeModeTab#builder()} does the same.
	 */
	public static CreativeModeTab.Builder creativeModeTabBuilder() {
		return FabricCreativeModeTab.builder();
	}
}
