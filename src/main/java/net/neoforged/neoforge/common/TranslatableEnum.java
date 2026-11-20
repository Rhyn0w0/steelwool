package net.neoforged.neoforge.common;

import net.minecraft.network.chat.Component;

/**
 * SteelWool re-implementation of NeoForge's {@code TranslatableEnum}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface TranslatableEnum {
	default Component getTranslatedName() {
		throw new UnsupportedOperationException("SteelWool does not implement TranslatableEnum.getTranslatedName yet");
	}
}
