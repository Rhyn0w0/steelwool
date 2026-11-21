package net.neoforged.neoforge.event.level;

import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code BlockDropsEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class BlockDropsEvent extends BlockEvent implements ICancellableEvent {
	private final BlockEntity blockEntity;
	private final List<ItemEntity> drops;
	private final Entity breaker;
	private final ItemStack tool;
	private int experience;

	public BlockDropsEvent(ServerLevel arg0, BlockPos arg1, BlockState arg2, BlockEntity blockEntity, List<ItemEntity> drops, Entity breaker, ItemStack tool) {
		super((LevelAccessor) null, (BlockPos) null, (BlockState) null);
		throw new UnsupportedOperationException("SteelWool does not implement the BlockDropsEvent constructor yet");
	}

	public List<ItemEntity> getDrops() {
		return this.drops;
	}

	public BlockEntity getBlockEntity() {
		return this.blockEntity;
	}

	public Entity getBreaker() {
		return this.breaker;
	}

	public ItemStack getTool() {
		return this.tool;
	}

	public void setCanceled(boolean arg0) {
		ICancellableEvent.super.setCanceled(arg0);
	}

	public ServerLevel getLevel() {
		return (ServerLevel) super.getLevel();
	}

	public int getDroppedExperience() {
		return this.experience;
	}

	public void setDroppedExperience(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BlockDropsEvent.setDroppedExperience yet");
	}
}
