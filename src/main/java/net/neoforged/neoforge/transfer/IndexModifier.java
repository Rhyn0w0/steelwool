package net.neoforged.neoforge.transfer;

import net.neoforged.neoforge.transfer.resource.Resource;

/**
 * SteelWool re-implementation of NeoForge's {@code IndexModifier}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IndexModifier<T extends Resource> {
	void set(int arg0, T arg1, int arg2);
}
