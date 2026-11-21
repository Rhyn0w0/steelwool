package net.neoforged.neoforge.registries.datamaps.builtin;

import com.mojang.serialization.Codec;

/**
 * SteelWool re-implementation of NeoForge's {@code MonsterRoomMob}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record MonsterRoomMob(int weight) {
	public static final Codec<net.neoforged.neoforge.registries.datamaps.builtin.MonsterRoomMob> WEIGHT_CODEC = null /* SteelWool: TODO */;
	public static final Codec<net.neoforged.neoforge.registries.datamaps.builtin.MonsterRoomMob> CODEC = null /* SteelWool: TODO */;
}
