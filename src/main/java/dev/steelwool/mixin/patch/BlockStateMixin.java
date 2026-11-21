package dev.steelwool.mixin.patch;

import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.extensions.IBlockStateExtension;
import org.spongepowered.asm.mixin.Mixin;

/** Makes {@link BlockState} implement NeoForge's {@link IBlockStateExtension}. */
@Mixin(BlockState.class)
public abstract class BlockStateMixin implements IBlockStateExtension {
}
