package net.neoforged.neoforge.registries.datamaps;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.neoforged.neoforge.common.conditions.WithConditions;

/**
 * SteelWool re-implementation of NeoForge's {@code DataMapFile}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record DataMapFile<T extends Object, R extends Object>(boolean replace, Map<Either<TagKey<R>, ResourceKey<R>>, Optional<WithConditions<DataMapEntry<T>>>> values, List<DataMapEntry.Removal<T, R>> removals) {
	public static <T extends Object, R extends Object> Codec<net.neoforged.neoforge.registries.datamaps.DataMapFile<T, R>> codec(ResourceKey<Registry<R>> arg0, DataMapType<R, T> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DataMapFile.codec yet");
	}
}
