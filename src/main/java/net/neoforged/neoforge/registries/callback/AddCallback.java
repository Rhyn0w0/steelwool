package net.neoforged.neoforge.registries.callback;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

/**
 * SteelWool re-implementation of NeoForge's {@code AddCallback}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface AddCallback<T extends Object> extends RegistryCallback<T> {
	void onAdd(Registry<T> arg0, int arg1, ResourceKey<T> arg2, T arg3);
}
