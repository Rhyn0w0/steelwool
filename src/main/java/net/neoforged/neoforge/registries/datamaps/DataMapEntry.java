package net.neoforged.neoforge.registries.datamaps;

import java.util.Optional;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;

/**
 * SteelWool re-implementation of NeoForge's {@code DataMapEntry}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record DataMapEntry<T extends Object>(T value, boolean replace) {
	private DataMapEntry(T arg0) {
		this(arg0, false);
	}

	public static <T extends Object> Codec<net.neoforged.neoforge.registries.datamaps.DataMapEntry<T>> codec(DataMapType<?, T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DataMapEntry.codec yet");
	}

	public static record Removal<T extends Object, R extends Object>(Either<TagKey<R>, ResourceKey<R>> key, Optional<DataMapValueRemover<R, T>> remover) {
		private Removal(Either<TagKey<R>, ResourceKey<R>> arg0) {
			this((Either) null, (Optional) null);
			throw new UnsupportedOperationException("SteelWool does not implement the DataMapEntry.Removal constructor yet");
		}

		public static <T extends Object, R extends Object> Codec<net.neoforged.neoforge.registries.datamaps.DataMapEntry.Removal<T, R>> codec(Codec<Either<TagKey<R>, ResourceKey<R>>> arg0, DataMapType<R, T> arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement DataMapEntry.Removal.codec yet");
		}
	}
}
