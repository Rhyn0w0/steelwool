package dev.steelwool.mixin.patch;

import net.minecraft.world.level.block.entity.HopperBlockEntity;
import org.spongepowered.asm.mixin.Mixin;

/** Target for NeoForge's static {@code getContainerOrHandlerAt(Level, BlockPos, Direction)}, which {@code SteelWoolMixinPlugin} adds. */
@Mixin(value = HopperBlockEntity.class, priority = 1)
public abstract class HopperBlockEntityMixin {
}
