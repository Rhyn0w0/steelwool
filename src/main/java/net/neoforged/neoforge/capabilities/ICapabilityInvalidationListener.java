package net.neoforged.neoforge.capabilities;

/**
 * SteelWool re-implementation of NeoForge's {@code ICapabilityInvalidationListener}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface ICapabilityInvalidationListener {
	boolean onInvalidate();
}
