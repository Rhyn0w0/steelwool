package net.neoforged.neoforge.model.data;

import it.unimi.dsi.fastutil.longs.Long2ObjectFunction;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.LongSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.event.level.ChunkEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code ModelDataManager}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ModelDataManager {
	private final Thread owningThread;
	private final Level level;
	private final Long2ObjectMap<LongSet> needModelDataRefresh;
	private final Long2ObjectMap<Long2ObjectMap<ModelData>> modelDataCache;
	public static final Long2ObjectFunction<ModelData> EMPTY_SNAPSHOT = null /* SteelWool: TODO */;

	public ModelDataManager(Level arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the ModelDataManager constructor yet");
	}

	public void requestRefresh(BlockPos arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModelDataManager.requestRefresh yet");
	}

	public void requestRefresh(BlockEntity arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModelDataManager.requestRefresh yet");
	}

	public Long2ObjectMap<ModelData> getAt(SectionPos arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModelDataManager.getAt yet");
	}

	public ModelData getAt(BlockPos arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModelDataManager.getAt yet");
	}

	public Long2ObjectFunction<ModelData> snapshotSectionRegion(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement ModelDataManager.snapshotSectionRegion yet");
	}

	private void refreshAt(long arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModelDataManager.refreshAt yet");
	}

	private boolean isOtherThread() {
		throw new UnsupportedOperationException("SteelWool does not implement ModelDataManager.isOtherThread yet");
	}

	public static void onChunkUnload(ChunkEvent.Unload arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModelDataManager.onChunkUnload yet");
	}
}
