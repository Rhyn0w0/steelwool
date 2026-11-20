package net.neoforged.neoforge.client.gui;

import java.util.stream.Collectors;

import dev.steelwool.config.SteelWoolConfigs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.AlertScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;

/**
 * Placeholder for NeoForge's generated config screen. SteelWool cannot edit configs in game yet,
 * so this screen tells the player which files to edit instead.
 */
public class ConfigurationScreen extends AlertScreen {
	public ConfigurationScreen(final ModContainer mod, final Screen parent) {
		super(() -> Minecraft.getInstance().setScreenAndShow(parent),
				Component.literal(mod.getModInfo().getDisplayName() + " config"),
				Component.literal("SteelWool cannot edit NeoForge configs in game yet. Edit these files instead: "
						+ SteelWoolConfigs.all().stream()
								.filter(c -> c.getModId().equals(mod.getModId()))
								.map(ModConfig::getFileName)
								.collect(Collectors.joining(", "))));
	}
}
