package net.neoforged.neoforge.client;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.world.item.ItemStack;

/**
 * SteelWool re-implementation of NeoForge's {@code IItemDecorator}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IItemDecorator {
	boolean render(GuiGraphicsExtractor arg0, Font arg1, ItemStack arg2, int arg3, int arg4);
}
