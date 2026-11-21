package net.neoforged.neoforge.event.level;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.LevelChunk;

/**
 * SteelWool re-implementation of NeoForge's {@code ChunkEvent}, with the same API.
 */
public abstract class ChunkEvent<T extends ChunkAccess> extends LevelEvent {
	private final T chunk;

	public ChunkEvent(T chunk) {
		this(chunk, chunk instanceof LevelChunk levelChunk ? levelChunk.getLevel() : null);
	}

	public ChunkEvent(T chunk, LevelAccessor arg1) {
		super(arg1);
		this.chunk = chunk;
	}

	public T getChunk() {
		return this.chunk;
	}

	public static class Load extends net.neoforged.neoforge.event.level.ChunkEvent<LevelChunk> {
		private final boolean newChunk;

		public Load(LevelChunk arg0, boolean newChunk) {
			super(arg0);
			this.newChunk = newChunk;
		}

		public boolean isNewChunk() {
			return this.newChunk;
		}
	}

	public static class Unload extends net.neoforged.neoforge.event.level.ChunkEvent<LevelChunk> {
		public Unload(LevelChunk arg0) {
			super(arg0);
		}
	}
}
