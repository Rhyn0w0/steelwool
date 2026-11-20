package net.neoforged.neoforge.client.gui;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;

/**
 * SteelWool re-implementation of NeoForge's {@code GuiLayer}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface GuiLayer {
	void render(GuiGraphicsExtractor arg0, DeltaTracker arg1);
}
