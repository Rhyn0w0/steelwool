package net.neoforged.neoforge.registries.callback;

import net.minecraft.core.Registry;

/**
 * SteelWool re-implementation of NeoForge's {@code ClearCallback}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface ClearCallback<T extends Object> extends RegistryCallback<T> {
	void onClear(Registry<T> arg0, boolean arg1);
}
