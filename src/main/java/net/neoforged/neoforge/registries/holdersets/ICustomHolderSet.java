package net.neoforged.neoforge.registries.holdersets;

import net.minecraft.core.HolderSet;
import net.neoforged.neoforge.common.extensions.IHolderSetExtension;

/**
 * SteelWool re-implementation of NeoForge's {@code ICustomHolderSet}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface ICustomHolderSet<T extends Object> extends HolderSet<T> {
	HolderSetType type();

	default IHolderSetExtension.SerializationType serializationType() {
		throw new UnsupportedOperationException("SteelWool does not implement ICustomHolderSet.serializationType yet");
	}
}
