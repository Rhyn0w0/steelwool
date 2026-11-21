package dev.steelwool.mixin.patch;

import net.minecraft.server.level.ChunkMap;
import org.spongepowered.asm.mixin.Mixin;

/**
 * Target for the {@code ChunkDataEvent.Load} post {@code SteelWoolMixinPlugin} adds to
 * {@code ChunkMap.scheduleChunkLoad}, where NeoForge posts it and mods' mixins look for it. Lowest
 * priority, so it is added before other mods' injectors run.
 */
@Mixin(value = ChunkMap.class, priority = 1)
public abstract class ChunkMapMixin {
}
