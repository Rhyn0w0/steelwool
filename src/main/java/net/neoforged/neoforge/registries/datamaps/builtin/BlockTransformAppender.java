package net.neoforged.neoforge.registries.datamaps.builtin;

import java.util.List;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.BlockTransformer;

/**
 * SteelWool re-implementation of NeoForge's {@code BlockTransformAppender}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record BlockTransformAppender(List<BlockTransformer.BlockTransformData> entries) {
	public static final Codec<net.neoforged.neoforge.registries.datamaps.builtin.BlockTransformAppender> CODEC = null /* SteelWool: TODO */;
}
