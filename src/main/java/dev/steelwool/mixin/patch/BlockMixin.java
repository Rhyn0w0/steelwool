package dev.steelwool.mixin.patch;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.extensions.IBlockExtension;
import org.spongepowered.asm.mixin.Mixin;

/** Makes {@link Block} implement NeoForge's {@link IBlockExtension}. */
@Mixin(Block.class)
public abstract class BlockMixin implements IBlockExtension {
}
