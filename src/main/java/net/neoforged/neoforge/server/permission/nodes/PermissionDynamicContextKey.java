package net.neoforged.neoforge.server.permission.nodes;

import java.util.function.Function;

/**
 * SteelWool re-implementation of NeoForge's {@code PermissionDynamicContextKey}, with the same API.
 */
public record PermissionDynamicContextKey<T extends Object>(Class<T> typeToken, String name, Function<T, String> serializer) {
	public PermissionDynamicContext<T> createContext(T value) {
		return new PermissionDynamicContext<>(this, value);
	}
}
