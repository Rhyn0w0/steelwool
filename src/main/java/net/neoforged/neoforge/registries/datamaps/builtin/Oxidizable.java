package net.neoforged.neoforge.registries.datamaps.builtin;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.block.Block;

/**
 * SteelWool re-implementation of NeoForge's {@code Oxidizable}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record Oxidizable(Block nextOxidationStage, boolean generateBlockTransform) {
	public static final Codec<net.neoforged.neoforge.registries.datamaps.builtin.Oxidizable> CODEC = null /* SteelWool: TODO */;

	public Oxidizable(Block arg0) {
		this(arg0, true);
	}
}
