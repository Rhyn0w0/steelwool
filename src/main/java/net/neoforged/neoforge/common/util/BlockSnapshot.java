package net.neoforged.neoforge.common.util;

import java.lang.ref.WeakReference;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.slf4j.Logger;

/**
 * SteelWool re-implementation of NeoForge's {@code BlockSnapshot}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class BlockSnapshot {
	private static final boolean DEBUG = false /* SteelWool: TODO */;
	private static final Logger LOGGER = null /* SteelWool: TODO */;
	private final ResourceKey<Level> dim;
	private final BlockPos pos;
	private final int flags;
	private final BlockState state;
	private final CompoundTag nbt;
	private WeakReference<LevelAccessor> level;
	private String toString;

	private BlockSnapshot(ResourceKey<Level> dim, LevelAccessor arg1, BlockPos arg2, BlockState arg3, CompoundTag arg4, int arg5) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the BlockSnapshot constructor yet");
	}

	public static net.neoforged.neoforge.common.util.BlockSnapshot create(ResourceKey<Level> arg0, LevelAccessor arg1, BlockPos arg2, int arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement BlockSnapshot.create yet");
	}

	public static net.neoforged.neoforge.common.util.BlockSnapshot create(ResourceKey<Level> arg0, LevelAccessor arg1, BlockPos arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement BlockSnapshot.create yet");
	}

	public ResourceKey<Level> getDimension() {
		return this.dim;
	}

	public BlockPos getPos() {
		return this.pos;
	}

	public int getFlags() {
		return this.flags;
	}

	public CompoundTag getTag() {
		return this.nbt;
	}

	public BlockState getState() {
		return this.state;
	}

	public LevelAccessor getLevel() {
		throw new UnsupportedOperationException("SteelWool does not implement BlockSnapshot.getLevel yet");
	}

	public BlockState getCurrentState() {
		throw new UnsupportedOperationException("SteelWool does not implement BlockSnapshot.getCurrentState yet");
	}

	public BlockEntity recreateBlockEntity(HolderLookup.Provider arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BlockSnapshot.recreateBlockEntity yet");
	}

	public boolean restoreToLocation(LevelAccessor arg0, BlockPos arg1, int arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement BlockSnapshot.restoreToLocation yet");
	}

	public boolean restore(int arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BlockSnapshot.restore yet");
	}

	public boolean restore() {
		throw new UnsupportedOperationException("SteelWool does not implement BlockSnapshot.restore yet");
	}

	public boolean restoreBlockEntity(LevelAccessor arg0, BlockPos arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement BlockSnapshot.restoreBlockEntity yet");
	}

	public boolean equals(Object arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BlockSnapshot.equals yet");
	}

	public int hashCode() {
		throw new UnsupportedOperationException("SteelWool does not implement BlockSnapshot.hashCode yet");
	}

	public String toString() {
		throw new UnsupportedOperationException("SteelWool does not implement BlockSnapshot.toString yet");
	}

	private static CompoundTag getBlockEntityTag(LevelAccessor arg0, BlockPos arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement BlockSnapshot.getBlockEntityTag yet");
	}
}
