package dev.steelwool.mixin.patch;

import net.minecraft.world.item.CreativeModeTab;
import org.spongepowered.asm.mixin.Mixin;

/**
 * Target marker for NeoForge's static {@code CreativeModeTab.builder()}, which
 * {@code SteelWoolMixinPlugin} adds (Mixin cannot add public static methods itself).
 */
@Mixin(CreativeModeTab.class)
public abstract class CreativeModeTabMixin {
}
