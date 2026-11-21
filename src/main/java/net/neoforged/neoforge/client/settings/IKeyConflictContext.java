package net.neoforged.neoforge.client.settings;

/**
 * SteelWool re-implementation of NeoForge's {@code IKeyConflictContext}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IKeyConflictContext {
	boolean isActive();

	boolean conflicts(net.neoforged.neoforge.client.settings.IKeyConflictContext arg0);
}
