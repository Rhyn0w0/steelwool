package net.neoforged.neoforge.registries.datamaps.builtin;

import com.mojang.serialization.Codec;

/**
 * SteelWool re-implementation of NeoForge's {@code Flammable}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record Flammable(int igniteOdds, int burnOdds) {
	public static final Codec<net.neoforged.neoforge.registries.datamaps.builtin.Flammable> CODEC = null /* SteelWool: TODO */;
}
