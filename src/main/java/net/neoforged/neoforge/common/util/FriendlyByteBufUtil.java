package net.neoforged.neoforge.common.util;

import java.util.function.Consumer;

import net.minecraft.core.RegistryAccess;
import net.minecraft.network.RegistryFriendlyByteBuf;

/**
 * SteelWool re-implementation of NeoForge's {@code FriendlyByteBufUtil}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class FriendlyByteBufUtil {
	private FriendlyByteBufUtil() {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the FriendlyByteBufUtil constructor yet");
	}

	public static byte[] writeCustomData(Consumer<RegistryFriendlyByteBuf> arg0, RegistryAccess arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FriendlyByteBufUtil.writeCustomData yet");
	}
}
