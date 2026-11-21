package net.neoforged.neoforge.common.world.chunk;

import net.minecraft.server.level.ServerLevel;

/**
 * SteelWool re-implementation of NeoForge's {@code LoadingValidationCallback}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface LoadingValidationCallback {
	void validateTickets(ServerLevel arg0, TicketHelper arg1);
}
