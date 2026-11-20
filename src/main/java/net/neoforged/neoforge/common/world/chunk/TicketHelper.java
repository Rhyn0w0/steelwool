package net.neoforged.neoforge.common.world.chunk;

import java.util.Map;
import java.util.UUID;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.TicketStorage;

/**
 * SteelWool re-implementation of NeoForge's {@code TicketHelper}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class TicketHelper {
	private final Map<BlockPos, TicketSet> blockTickets;
	private final Map<UUID, TicketSet> entityTickets;
	private final TicketStorage saveData;
	private final Identifier controllerId;

	TicketHelper(TicketStorage saveData, Identifier controllerId, Map<BlockPos, TicketSet> blockTickets, Map<UUID, TicketSet> entityTickets) {
		super();
		this.saveData = saveData;
		this.controllerId = controllerId;
		this.blockTickets = blockTickets;
		this.entityTickets = entityTickets;
	}

	public Map<BlockPos, TicketSet> getBlockTickets() {
		return this.blockTickets;
	}

	public Map<UUID, TicketSet> getEntityTickets() {
		return this.entityTickets;
	}

	public void removeAllTickets(BlockPos arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement TicketHelper.removeAllTickets yet");
	}

	public void removeAllTickets(UUID arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement TicketHelper.removeAllTickets yet");
	}

	private <T extends Comparable<? super T>> void removeAllTickets(ForcedChunkManager.TicketTracker<T> arg0, T arg1, TicketSet arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement TicketHelper.removeAllTickets yet");
	}

	public void removeTicket(BlockPos arg0, long arg1, boolean arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement TicketHelper.removeTicket yet");
	}

	public void removeTicket(UUID arg0, long arg1, boolean arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement TicketHelper.removeTicket yet");
	}

	private <T extends Comparable<? super T>> void removeTicket(ForcedChunkManager.TicketTracker<T> arg0, T arg1, long arg2, boolean arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement TicketHelper.removeTicket yet");
	}
}
