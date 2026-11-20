package net.neoforged.neoforge.client.extensions.common;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.Hud;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;

/**
 * SteelWool re-implementation of NeoForge's {@code IClientMobEffectExtensions}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IClientMobEffectExtensions {
	public static final net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions DEFAULT = null /* SteelWool: TODO */;

	static net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions of(MobEffectInstance arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientMobEffectExtensions.of yet");
	}

	static net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions of(MobEffect arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientMobEffectExtensions.of yet");
	}

	default boolean isVisibleInInventory(MobEffectInstance arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientMobEffectExtensions.isVisibleInInventory yet");
	}

	default boolean isVisibleInGui(MobEffectInstance arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientMobEffectExtensions.isVisibleInGui yet");
	}

	default boolean extractInventoryIcon(MobEffectInstance arg0, AbstractContainerScreen<?> arg1, GuiGraphicsExtractor arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientMobEffectExtensions.extractInventoryIcon yet");
	}

	default boolean extractInventoryText(MobEffectInstance arg0, AbstractContainerScreen<?> arg1, GuiGraphicsExtractor arg2, int arg3, int arg4, int arg5, int arg6) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientMobEffectExtensions.extractInventoryText yet");
	}

	default boolean extractHudIcon(MobEffectInstance arg0, Hud arg1, GuiGraphicsExtractor arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientMobEffectExtensions.extractHudIcon yet");
	}
}
