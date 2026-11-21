package net.neoforged.neoforge.registries.datamaps;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.util.Either;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;

/**
 * SteelWool re-implementation of NeoForge's {@code DataMapValueMerger}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface DataMapValueMerger<R extends Object, T extends Object> {
	T merge(Registry<R> arg0, Either<TagKey<R>, ResourceKey<R>> arg1, T arg2, Either<TagKey<R>, ResourceKey<R>> arg3, T arg4);

	static <T extends Object, R extends Object> net.neoforged.neoforge.registries.datamaps.DataMapValueMerger<R, T> defaultMerger() {
		return (registry, firstKey, first, secondKey, second) -> second;
	}

	static <T extends Object, R extends Object> net.neoforged.neoforge.registries.datamaps.DataMapValueMerger<R, List<T>> listMerger() {
		throw new UnsupportedOperationException("SteelWool does not implement DataMapValueMerger.listMerger yet");
	}

	static <T extends Object, R extends Object, E extends Object> net.neoforged.neoforge.registries.datamaps.DataMapValueMerger<R, T> wrappedListMerger(Function<T, List<E>> arg0, Function<List<E>, T> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DataMapValueMerger.wrappedListMerger yet");
	}

	static <T extends Object, R extends Object> net.neoforged.neoforge.registries.datamaps.DataMapValueMerger<R, Set<T>> setMerger() {
		throw new UnsupportedOperationException("SteelWool does not implement DataMapValueMerger.setMerger yet");
	}

	static <T extends Object, R extends Object, E extends Object> net.neoforged.neoforge.registries.datamaps.DataMapValueMerger<R, T> wrappedSetMerger(Function<T, Set<E>> arg0, Function<Set<E>, T> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DataMapValueMerger.wrappedSetMerger yet");
	}

	static <K extends Object, V extends Object, R extends Object> net.neoforged.neoforge.registries.datamaps.DataMapValueMerger<R, Map<K, V>> mapMerger() {
		throw new UnsupportedOperationException("SteelWool does not implement DataMapValueMerger.mapMerger yet");
	}

	static <T extends Object, K extends Object, V extends Object, R extends Object> net.neoforged.neoforge.registries.datamaps.DataMapValueMerger<R, T> wrappedMapMerger(Function<T, Map<K, V>> arg0, Function<Map<K, V>, T> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DataMapValueMerger.wrappedMapMerger yet");
	}
}
