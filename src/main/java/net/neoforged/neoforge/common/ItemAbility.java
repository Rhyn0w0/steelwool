package net.neoforged.neoforge.common;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

/**
 * SteelWool re-implementation of NeoForge's {@code ItemAbility}: a named action a tool can perform.
 * There is one instance per name.
 */
public final class ItemAbility {
	private static final Map<String, ItemAbility> ACTIONS = new ConcurrentHashMap<>();

	public static Codec<ItemAbility> CODEC = Codec.STRING.xmap(ItemAbility::get, ItemAbility::name);
	public static StreamCodec<ByteBuf, ItemAbility> STREAM_CODEC = ByteBufCodecs.STRING_UTF8.map(ItemAbility::get, ItemAbility::name);

	private final String name;

	private ItemAbility(String name) {
		this.name = name;
	}

	public static Collection<ItemAbility> getActions() {
		return Collections.unmodifiableCollection(ACTIONS.values());
	}

	public static ItemAbility get(String name) {
		return ACTIONS.computeIfAbsent(name, ItemAbility::new);
	}

	public String name() {
		return name;
	}

	@Override
	public String toString() {
		return "ItemAbility[" + name + "]";
	}
}
