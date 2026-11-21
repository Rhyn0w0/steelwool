package net.neoforged.neoforge.capabilities;

/**
 * SteelWool re-implementation of NeoForge's {@code ICapabilityProvider}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface ICapabilityProvider<O extends Object, C extends Object, T extends Object> {
	T getCapability(O arg0, C arg1);
}
