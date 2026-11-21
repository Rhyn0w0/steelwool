package dev.steelwool.mixin.patch;

import net.minecraft.world.item.ItemStackTemplate;
import org.spongepowered.asm.mixin.Mixin;

/**
 * Target for NeoForge's {@code ItemStackTemplate(Item, int, DataComponentPatch)} constructor, which
 * {@code SteelWoolMixinPlugin} adds (Mixin cannot add constructors).
 */
@Mixin(ItemStackTemplate.class)
public abstract class ItemStackTemplateMixin {
}
