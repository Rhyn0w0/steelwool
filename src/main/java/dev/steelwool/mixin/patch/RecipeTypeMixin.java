package dev.steelwool.mixin.patch;

import net.minecraft.world.item.crafting.RecipeType;
import org.spongepowered.asm.mixin.Mixin;

/** Target for NeoForge's static {@code RecipeType.simple(Identifier)}, which {@code SteelWoolMixinPlugin} adds. */
@Mixin(RecipeType.class)
public interface RecipeTypeMixin {
}
