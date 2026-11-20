package dev.steelwool.mixin.patch;

import net.minecraft.core.component.BlockTransformer;
import org.spongepowered.asm.mixin.Mixin;

/** Target for NeoForge's {@code transformBlock(UseOnContext, Holder)}, which {@code SteelWoolMixinPlugin} makes from vanilla's {@code transformBlock(UseOnContext)} (applied first so it exists for other mods' mixins). */
@Mixin(value = BlockTransformer.class, priority = 1)
public abstract class BlockTransformerMixin {
}
