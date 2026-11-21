package net.neoforged.neoforge.registries.callback;

import net.minecraft.core.Registry;

/**
 * SteelWool re-implementation of NeoForge's {@code BakeCallback}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface BakeCallback<T extends Object> extends RegistryCallback<T> {
	void onBake(Registry<T> arg0);
}
