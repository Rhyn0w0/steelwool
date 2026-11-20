package net.neoforged.neoforge.attachment;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;

/**
 * SteelWool re-implementation of NeoForge's {@code AttachmentSyncHandler}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface AttachmentSyncHandler<T extends Object> {
	default boolean sendToPlayer(IAttachmentHolder arg0, ServerPlayer arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement AttachmentSyncHandler.sendToPlayer yet");
	}

	void write(RegistryFriendlyByteBuf arg0, T arg1, boolean arg2);

	T read(IAttachmentHolder arg0, RegistryFriendlyByteBuf arg1, T arg2);
}
