package net.neoforged.neoforge.common.util;

import java.util.Map;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.level.ServerLevel;

/**
 * SteelWool re-implementation of NeoForge's {@code FakePlayerFactory}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class FakePlayerFactory {
	private static final GameProfile MINECRAFT = null /* SteelWool: TODO */;
	private static final Map<net.neoforged.neoforge.common.util.FakePlayerFactory.FakePlayerKey, FakePlayer> fakePlayers = null /* SteelWool: TODO */;

	public FakePlayerFactory() {
		super();
	}

	public static FakePlayer getMinecraft(ServerLevel arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FakePlayerFactory.getMinecraft yet");
	}

	public static FakePlayer get(ServerLevel arg0, GameProfile arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FakePlayerFactory.get yet");
	}

	public static void unloadLevel(ServerLevel arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FakePlayerFactory.unloadLevel yet");
	}

	static record FakePlayerKey(ServerLevel level, GameProfile username) {
	}
}
