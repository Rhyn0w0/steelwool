package net.neoforged.neoforge.data.event;

/**
 * SteelWool re-implementation of NeoForge's {@code DatapackRegistrySets}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record DatapackRegistrySets<T extends Object>(T worldAndDimension, T reloadable) {
}
