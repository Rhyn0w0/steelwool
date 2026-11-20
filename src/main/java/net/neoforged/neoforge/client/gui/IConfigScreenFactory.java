package net.neoforged.neoforge.client.gui;

import java.util.Optional;

import net.minecraft.client.gui.screens.Screen;
import net.neoforged.fml.IExtensionPoint;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.neoforgespi.language.IModInfo;

/**
 * Extension point a mod registers to provide its config screen.
 */
public interface IConfigScreenFactory extends IExtensionPoint {
	Screen createScreen(ModContainer container, Screen modListScreen);

	static Optional<IConfigScreenFactory> getForMod(IModInfo selectedMod) {
		return ModList.get().getModContainerById(selectedMod.getModId()).flatMap(m -> m.getCustomExtension(IConfigScreenFactory.class));
	}
}
