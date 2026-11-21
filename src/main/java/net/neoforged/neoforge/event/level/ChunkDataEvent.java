package net.neoforged.neoforge.event.level;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.status.ChunkType;
import net.minecraft.world.level.chunk.storage.SerializableChunkData;

/**
 * SteelWool re-implementation of NeoForge's {@code ChunkDataEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class ChunkDataEvent extends ChunkEvent<ChunkAccess> {
	private final SerializableChunkData data;

	public ChunkDataEvent(ChunkAccess arg0, SerializableChunkData data) {
		super(arg0);
		this.data = data;
	}

	public ChunkDataEvent(ChunkAccess arg0, LevelAccessor arg1, SerializableChunkData data) {
		super(arg0, arg1);
		this.data = data;
	}

	public SerializableChunkData getData() {
		return this.data;
	}

	public static class Load extends net.neoforged.neoforge.event.level.ChunkDataEvent {
		private final ChunkType status;

		public Load(ChunkAccess arg0, SerializableChunkData arg1) {
			super(arg0, arg1);
			this.status = arg0.getPersistedStatus().getChunkType();
		}

		public ChunkType getType() {
			return this.status;
		}
	}

	public static class Save extends net.neoforged.neoforge.event.level.ChunkDataEvent {
		public Save(ChunkAccess arg0, LevelAccessor arg1, SerializableChunkData arg2) {
			super(arg0, arg1, arg2);
		}
	}
}
