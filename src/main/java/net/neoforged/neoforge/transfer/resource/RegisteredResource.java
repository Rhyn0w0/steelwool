package net.neoforged.neoforge.transfer.resource;

import java.util.function.Predicate;

import net.minecraft.core.Holder;
import net.minecraft.core.TypedInstance;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisteredResource}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface RegisteredResource<T extends Object> extends Resource, TypedInstance<T> {
	T value();

	default boolean is(Predicate<Holder<T>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisteredResource.is yet");
	}
}
