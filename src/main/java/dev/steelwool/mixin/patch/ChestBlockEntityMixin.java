package dev.steelwool.mixin.patch;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

/**
 * NeoForge's {@code ChestBlockEntity.setBlockState} override (vanilla only has
 * {@code BlockEntity.setBlockState}), which mods inject into. It just calls the inherited method.
 * Applied before other mods' mixins so the method exists for them.
 */
@Mixin(value = ChestBlockEntity.class, priority = 500)
public abstract class ChestBlockEntityMixin extends BlockEntity {
	private ChestBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		super(type, pos, state);
	}

	@Override
	public void setBlockState(BlockState state) {
		super.setBlockState(state);
	}
}
