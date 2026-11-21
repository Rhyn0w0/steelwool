package net.neoforged.neoforge.common.extensions;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.storage.ValueInput;
import net.neoforged.neoforge.model.data.ModelData;

/**
 * Methods NeoForge adds to {@link BlockEntity}; SteelWool adds this interface with a mixin. Of the
 * hooks, only {@link #onLoad()} is called (when the block entity is loaded into a level).
 */
public interface IBlockEntityExtension {
	private BlockEntity self() {
		return (BlockEntity) this;
	}

	/** Reads the data a client receives in a block entity update packet. */
	default void onDataPacket(Connection connection, ValueInput input) {
		self().loadWithComponents(input);
	}

	/** Reads the data a client receives with the chunk. */
	default void handleUpdateTag(ValueInput input) {
		self().loadWithComponents(input);
	}

	/** Data mods can store on any block entity; saved under {@code NeoForgeData}. */
	CompoundTag getPersistentData();

	default void onChunkUnloaded() {
	}

	default void onLoad() {
	}

	default void requestModelDataUpdate() {
	}

	default ModelData getModelData() {
		return ModelData.EMPTY;
	}

	/** SteelWool does not cache capabilities, so there is nothing to invalidate. */
	default void invalidateCapabilities() {
	}

	default void applyStructureRotation(Mirror mirror, Rotation rotation) {
	}
}
