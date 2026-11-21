package net.neoforged.neoforge.registries.datamaps.builtin;

import com.mojang.serialization.Codec;

/**
 * SteelWool re-implementation of NeoForge's {@code AcceptableVillagerDistance}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record AcceptableVillagerDistance(float distance) {
	public static final Codec<net.neoforged.neoforge.registries.datamaps.builtin.AcceptableVillagerDistance> DISTANCE_CODEC = null /* SteelWool: TODO */;
	public static final Codec<net.neoforged.neoforge.registries.datamaps.builtin.AcceptableVillagerDistance> CODEC = null /* SteelWool: TODO */;
}
