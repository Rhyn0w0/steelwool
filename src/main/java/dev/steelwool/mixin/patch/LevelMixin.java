package dev.steelwool.mixin.patch;

import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import org.spongepowered.asm.mixin.Mixin;

/** Makes {@link Level} implement NeoForge's {@link ILevelExtension} (capability lookups). */
@Mixin(Level.class)
public abstract class LevelMixin implements ILevelExtension {
}
