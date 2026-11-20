package net.neoforged.neoforge.registries.datamaps.builtin;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.block.Block;

/**
 * SteelWool re-implementation of NeoForge's {@code Waxable}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record Waxable(Block waxed, boolean generateBlockTransform) {
	public static final Codec<net.neoforged.neoforge.registries.datamaps.builtin.Waxable> CODEC = null /* SteelWool: TODO */;

	public Waxable(Block arg0) {
		this(arg0, true);
	}
}
