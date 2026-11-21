package net.neoforged.neoforge.registries.datamaps.builtin;

import com.mojang.serialization.Codec;

/**
 * SteelWool re-implementation of NeoForge's {@code VibrationFrequency}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record VibrationFrequency(int frequency) {
	public static final Codec<net.neoforged.neoforge.registries.datamaps.builtin.VibrationFrequency> FREQUENCY_CODEC = null /* SteelWool: TODO */;
	public static final Codec<net.neoforged.neoforge.registries.datamaps.builtin.VibrationFrequency> CODEC = null /* SteelWool: TODO */;
}
