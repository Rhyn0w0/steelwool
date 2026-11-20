package net.neoforged.neoforge.transfer.resource;

import java.util.function.Supplier;

import net.minecraft.core.component.DataComponentHolder;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponentType;

/**
 * SteelWool re-implementation of NeoForge's {@code DataComponentHolderResource}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface DataComponentHolderResource<T extends Object> extends RegisteredResource<T>, DataComponentHolder {
	boolean isComponentsPatchEmpty();

	net.neoforged.neoforge.transfer.resource.DataComponentHolderResource<T> withMergedPatch(DataComponentPatch arg0);

	<D extends Object> net.neoforged.neoforge.transfer.resource.DataComponentHolderResource<T> with(DataComponentType<D> arg0, D arg1);

	net.neoforged.neoforge.transfer.resource.DataComponentHolderResource<T> without(DataComponentType<?> arg0);

	DataComponentPatch getComponentsPatch();

	default <D extends Object> net.neoforged.neoforge.transfer.resource.DataComponentHolderResource<T> with(Supplier<? extends DataComponentType<D>> arg0, D arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentHolderResource.with yet");
	}

	default net.neoforged.neoforge.transfer.resource.DataComponentHolderResource<T> without(Supplier<? extends DataComponentType<?>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DataComponentHolderResource.without yet");
	}
}
