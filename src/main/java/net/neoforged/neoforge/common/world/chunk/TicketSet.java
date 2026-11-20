package net.neoforged.neoforge.common.world.chunk;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.longs.LongSet;

/**
 * SteelWool re-implementation of NeoForge's {@code TicketSet}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record TicketSet(LongSet normal, LongSet naturalSpawning) {
	private static final Codec<LongSet> LONG_SET_CODEC = null /* SteelWool: TODO */;
	public static final Codec<net.neoforged.neoforge.common.world.chunk.TicketSet> CODEC = null /* SteelWool: TODO */;

	public boolean isEmpty() {
		throw new UnsupportedOperationException("SteelWool does not implement TicketSet.isEmpty yet");
	}

	public LongSet getChunks(boolean arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement TicketSet.getChunks yet");
	}
}
