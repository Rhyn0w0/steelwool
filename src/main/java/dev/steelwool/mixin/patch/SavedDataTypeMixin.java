package dev.steelwool.mixin.patch;

import net.minecraft.world.level.saveddata.SavedDataType;
import org.spongepowered.asm.mixin.Mixin;

/**
 * Target for NeoForge's {@code SavedDataType(id, constructor, codec)} constructor (no data fixer),
 * which {@code SteelWoolMixinPlugin} adds.
 */
@Mixin(SavedDataType.class)
public abstract class SavedDataTypeMixin {
}
