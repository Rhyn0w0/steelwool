package net.neoforged.neoforge.registries.datamaps.builtin;

import com.mojang.serialization.Codec;
import net.minecraft.sounds.SoundEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code ParrotImitation}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record ParrotImitation(SoundEvent sound) {
	public static final Codec<net.neoforged.neoforge.registries.datamaps.builtin.ParrotImitation> SOUND_CODEC = null /* SteelWool: TODO */;
	public static final Codec<net.neoforged.neoforge.registries.datamaps.builtin.ParrotImitation> CODEC = null /* SteelWool: TODO */;
}
