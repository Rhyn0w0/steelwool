package net.neoforged.neoforge.common.world.chunk;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.LongSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.Ticket;
import net.minecraft.server.level.TicketType;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.TicketStorage;
import org.apache.logging.log4j.Logger;

/**
 * SteelWool re-implementation of NeoForge's {@code ForcedChunkManager}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ForcedChunkManager {
	private static final Logger LOGGER = null /* SteelWool: TODO */;
	private static boolean initialised;
	private static Map<Identifier, TicketController> controllers;

	public ForcedChunkManager() {
		super();
	}

	public static synchronized void init() {
		throw new UnsupportedOperationException("SteelWool does not implement ForcedChunkManager.init yet");
	}

	public static boolean hasForcedChunks(ServerLevel arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ForcedChunkManager.hasForcedChunks yet");
	}

	static <T extends Comparable<? super T>> boolean forceChunk(ServerLevel arg0, Identifier arg1, T arg2, int arg3, int arg4, boolean arg5, boolean arg6, Function<TicketStorage, net.neoforged.neoforge.common.world.chunk.ForcedChunkManager.TicketTracker<T>> arg7) {
		throw new UnsupportedOperationException("SteelWool does not implement ForcedChunkManager.forceChunk yet");
	}

	public static void activateAllDeactivatedTickets(ServerLevel arg0, TicketStorage arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ForcedChunkManager.activateAllDeactivatedTickets yet");
	}

	private static <T extends Comparable<? super T>> Map<Identifier, Map<T, TicketSet>> gatherTicketsById(net.neoforged.neoforge.common.world.chunk.ForcedChunkManager.TicketTracker<T> arg0, boolean arg1, boolean arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ForcedChunkManager.gatherTicketsById yet");
	}

	private static <T extends Comparable<? super T>> void gatherTicketsById(Long2ObjectMap<Set<net.neoforged.neoforge.common.world.chunk.ForcedChunkManager.TicketOwner<T>>> arg0, Function<TicketSet, LongSet> arg1, Map<Identifier, Map<T, TicketSet>> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ForcedChunkManager.gatherTicketsById yet");
	}

	public static App<RecordCodecBuilder.Mu<TicketStorage>, List<net.neoforged.neoforge.common.world.chunk.ForcedChunkManager.OwnedChunks>> defineExtraStorageParams() {
		throw new UnsupportedOperationException("SteelWool does not implement ForcedChunkManager.defineExtraStorageParams yet");
	}

	public static TicketStorage readStoredTickets(Function<List<Pair<ChunkPos, Ticket>>, TicketStorage> arg0, List<Pair<ChunkPos, Ticket>> arg1, List<net.neoforged.neoforge.common.world.chunk.ForcedChunkManager.OwnedChunks> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ForcedChunkManager.readStoredTickets yet");
	}

	public static record OwnedChunks(Identifier controller, Map<BlockPos, TicketSet> blockChunks, Map<UUID, TicketSet> entityChunks) {
		private static final Codec<Map<BlockPos, TicketSet>> BLOCK_CHUNK_CODEC = null /* SteelWool: TODO */;
		private static final Codec<Map<UUID, TicketSet>> ENTITY_CHUNK_CODEC = null /* SteelWool: TODO */;
		public static final Codec<net.neoforged.neoforge.common.world.chunk.ForcedChunkManager.OwnedChunks> CODEC = null /* SteelWool: TODO */;
	}

	static class TicketOwner<T extends Comparable<? super T>> extends Object implements Comparable<TicketOwner<T>> {
		private final Identifier id;
		private final T owner;

		TicketOwner(Identifier id, T owner) {
			super();
			this.id = id;
			this.owner = owner;
		}

		public int compareTo(net.neoforged.neoforge.common.world.chunk.ForcedChunkManager.TicketOwner<T> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement ForcedChunkManager.TicketOwner.compareTo yet");
		}

		public boolean equals(Object arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement ForcedChunkManager.TicketOwner.equals yet");
		}

		public int hashCode() {
			throw new UnsupportedOperationException("SteelWool does not implement ForcedChunkManager.TicketOwner.hashCode yet");
		}
	}

	public static class TicketTracker<T extends Comparable<? super T>> extends Object {
		private final Long2ObjectMap<Set<net.neoforged.neoforge.common.world.chunk.ForcedChunkManager.TicketOwner<T>>> sourcesLoading;
		private final Long2ObjectMap<Set<net.neoforged.neoforge.common.world.chunk.ForcedChunkManager.TicketOwner<T>>> sourcesLoadingNaturalSpawning;
		private final Long2ObjectMap<Set<net.neoforged.neoforge.common.world.chunk.ForcedChunkManager.TicketOwner<T>>> deactivatedSourcesLoading;
		private final Long2ObjectMap<Set<net.neoforged.neoforge.common.world.chunk.ForcedChunkManager.TicketOwner<T>>> deactivatedSourcesLoadingNaturalSpawning;
		private final Holder<TicketType> naturalSpawningTicketType;
		private final Holder<TicketType> ticketType;
		private final TicketStorage ticketStorage;

		public TicketTracker(TicketStorage arg0, Holder<TicketType> arg1, Holder<TicketType> arg2) {
			throw new UnsupportedOperationException("SteelWool does not implement the ForcedChunkManager.TicketTracker constructor yet");
		}

		public void deactivateTicketsOnClosing() {
			throw new UnsupportedOperationException("SteelWool does not implement ForcedChunkManager.TicketTracker.deactivateTicketsOnClosing yet");
		}

		private void inheritDeactivated(net.neoforged.neoforge.common.world.chunk.ForcedChunkManager.TicketOwner<T> arg0, TicketSet arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement ForcedChunkManager.TicketTracker.inheritDeactivated yet");
		}

		private void activateAllDeactivatedSources() {
			throw new UnsupportedOperationException("SteelWool does not implement ForcedChunkManager.TicketTracker.activateAllDeactivatedSources yet");
		}

		private void inheritSources(Holder<TicketType> arg0, Long2ObjectMap<Set<net.neoforged.neoforge.common.world.chunk.ForcedChunkManager.TicketOwner<T>>> arg1, Long2ObjectMap<Set<net.neoforged.neoforge.common.world.chunk.ForcedChunkManager.TicketOwner<T>>> arg2) {
			throw new UnsupportedOperationException("SteelWool does not implement ForcedChunkManager.TicketTracker.inheritSources yet");
		}

		public boolean hasNoDeactivatedTickets() {
			throw new UnsupportedOperationException("SteelWool does not implement ForcedChunkManager.TicketTracker.hasNoDeactivatedTickets yet");
		}

		public boolean isEmpty() {
			throw new UnsupportedOperationException("SteelWool does not implement ForcedChunkManager.TicketTracker.isEmpty yet");
		}

		private Long2ObjectMap<Set<net.neoforged.neoforge.common.world.chunk.ForcedChunkManager.TicketOwner<T>>> getSourcesLoading(boolean arg0, boolean arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement ForcedChunkManager.TicketTracker.getSourcesLoading yet");
		}

		private Ticket makeTicket(boolean arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement ForcedChunkManager.TicketTracker.makeTicket yet");
		}

		public boolean remove(net.neoforged.neoforge.common.world.chunk.ForcedChunkManager.TicketOwner<T> arg0, long arg1, boolean arg2, boolean arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement ForcedChunkManager.TicketTracker.remove yet");
		}

		private boolean add(net.neoforged.neoforge.common.world.chunk.ForcedChunkManager.TicketOwner<T> arg0, long arg1, boolean arg2) {
			throw new UnsupportedOperationException("SteelWool does not implement ForcedChunkManager.TicketTracker.add yet");
		}
	}
}
