package net.neoforged.neoforge.common.extensions;

import com.mojang.datafixers.util.Either;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.entity.BlockEntity;

/**
 * SteelWool re-implementation of NeoForge's {@code IOwnedSpawner}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IOwnedSpawner {
	Either<BlockEntity, Entity> getOwner();
}
