package dev.steelwool.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

/** Calls vanilla's private hopper lookup, for NeoForge's {@code HopperBlockEntity.getContainerOrHandlerAt}. */
@Mixin(HopperBlockEntity.class)
public interface HopperBlockEntityAccessor {
	@Invoker("getContainerAt")
	static @Nullable Container steelwool$getContainerAt(Level level, BlockPos pos, BlockState state, double x, double y, double z) {
		throw new AssertionError();
	}
}
