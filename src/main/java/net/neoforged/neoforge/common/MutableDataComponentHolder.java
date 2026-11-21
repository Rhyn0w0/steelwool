package net.neoforged.neoforge.common;

import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.component.DataComponentHolder;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponentType;

/**
 * SteelWool re-implementation of NeoForge's {@code MutableDataComponentHolder}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface MutableDataComponentHolder extends DataComponentHolder {
	<T extends Object> T set(DataComponentType<T> arg0, T arg1);

	default <T extends Object> T set(Supplier<? extends DataComponentType<T>> arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableDataComponentHolder.set yet");
	}

	default <T extends Object> void copyFrom(DataComponentType<T> arg0, DataComponentGetter arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableDataComponentHolder.copyFrom yet");
	}

	default <T extends Object> void copyFrom(Supplier<? extends DataComponentType<T>> arg0, DataComponentGetter arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableDataComponentHolder.copyFrom yet");
	}

	default <T extends Object, U extends Object> T update(DataComponentType<T> arg0, T arg1, U arg2, BiFunction<T, U, T> arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableDataComponentHolder.update yet");
	}

	default <T extends Object, U extends Object> T update(Supplier<? extends DataComponentType<T>> arg0, T arg1, U arg2, BiFunction<T, U, T> arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableDataComponentHolder.update yet");
	}

	default <T extends Object> T update(DataComponentType<T> arg0, T arg1, UnaryOperator<T> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableDataComponentHolder.update yet");
	}

	default <T extends Object> T update(Supplier<? extends DataComponentType<T>> arg0, T arg1, UnaryOperator<T> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableDataComponentHolder.update yet");
	}

	<T extends Object> T remove(DataComponentType<? extends T> arg0);

	default <T extends Object> T remove(Supplier<? extends DataComponentType<? extends T>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableDataComponentHolder.remove yet");
	}

	default void copyFrom(DataComponentHolder arg0, DataComponentType<?>... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableDataComponentHolder.copyFrom yet");
	}

	default void copyFrom(DataComponentHolder arg0, Supplier<? extends DataComponentType<?>>... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableDataComponentHolder.copyFrom yet");
	}

	void applyComponents(DataComponentPatch arg0);

	void applyComponents(DataComponentMap arg0);

	private <T extends Object> void copyFrom(DataComponentType<T> arg0, DataComponentHolder arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement MutableDataComponentHolder.copyFrom yet");
	}
}
