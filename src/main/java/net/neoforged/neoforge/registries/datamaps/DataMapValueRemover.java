package net.neoforged.neoforge.registries.datamaps;

import java.util.Optional;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;

/**
 * SteelWool re-implementation of NeoForge's {@code DataMapValueRemover}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface DataMapValueRemover<R extends Object, T extends Object> {
	Optional<T> remove(T arg0, Registry<R> arg1, Either<TagKey<R>, ResourceKey<R>> arg2, R arg3);

	public static class Default<T extends Object, R extends Object> extends Object implements net.neoforged.neoforge.registries.datamaps.DataMapValueRemover<R, T> {
		public static final net.neoforged.neoforge.registries.datamaps.DataMapValueRemover.Default<?, ?> INSTANCE = new Default<>();

		public static <T extends Object, R extends Object> net.neoforged.neoforge.registries.datamaps.DataMapValueRemover.Default<T, R> defaultRemover() {
			return (Default<T, R>) INSTANCE;
		}

		public static <T extends Object, R extends Object> Codec<net.neoforged.neoforge.registries.datamaps.DataMapValueRemover.Default<T, R>> codec() {
			return MapCodec.unitCodec((Default<T, R>) INSTANCE);
		}

		private Default() {
			super();
		}

		public Optional<T> remove(T arg0, Registry<R> arg1, Either<TagKey<R>, ResourceKey<R>> arg2, R arg3) {
			return Optional.empty();
		}
	}
}
