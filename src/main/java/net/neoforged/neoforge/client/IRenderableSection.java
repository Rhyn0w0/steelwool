package net.neoforged.neoforge.client;

import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.AABB;

/**
 * SteelWool re-implementation of NeoForge's {@code IRenderableSection}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IRenderableSection {
	BlockPos getRenderOrigin();

	AABB getBoundingBox();

	boolean isEmpty();
}
