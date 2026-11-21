package net.neoforged.neoforge.common.world.chunk;

import java.util.UUID;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

/**
 * SteelWool re-implementation of NeoForge's {@code TicketController}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record TicketController(Identifier id, LoadingValidationCallback callback) {
	public TicketController(Identifier arg0) {
		this(arg0, null);
	}

	public boolean forceChunk(ServerLevel arg0, BlockPos arg1, int arg2, int arg3, boolean arg4, boolean arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement TicketController.forceChunk yet");
	}

	public boolean forceChunk(ServerLevel arg0, Entity arg1, int arg2, int arg3, boolean arg4, boolean arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement TicketController.forceChunk yet");
	}

	public boolean forceChunk(ServerLevel arg0, UUID arg1, int arg2, int arg3, boolean arg4, boolean arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement TicketController.forceChunk yet");
	}
}
