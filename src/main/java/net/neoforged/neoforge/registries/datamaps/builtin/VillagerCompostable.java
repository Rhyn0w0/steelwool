package net.neoforged.neoforge.registries.datamaps.builtin;

import com.mojang.serialization.Codec;

/**
 * SteelWool re-implementation of NeoForge's {@code VillagerCompostable}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record VillagerCompostable(boolean canVillagerCompost) {
	public static final Codec<net.neoforged.neoforge.registries.datamaps.builtin.VillagerCompostable> BOOLEAN_CODEC = null /* SteelWool: TODO */;
	public static final Codec<net.neoforged.neoforge.registries.datamaps.builtin.VillagerCompostable> CODEC = null /* SteelWool: TODO */;
}
