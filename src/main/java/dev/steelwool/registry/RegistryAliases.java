package dev.steelwool.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

/**
 * Registry aliases (NeoForge's {@code DeferredRegister.addAlias}): an old name that resolves to a
 * new one in lookups, as long as nothing is registered under the old name itself.
 */
public final class RegistryAliases {
	private static final int MAX_CHAIN = 16;
	private static final Map<Identifier, Map<Identifier, Identifier>> ALIASES = new ConcurrentHashMap<>();

	private RegistryAliases() {
	}

	public static void add(ResourceKey<?> registryKey, Identifier from, Identifier to) {
		if (from.equals(to)) {
			throw new IllegalArgumentException("Registry alias " + from + " points to itself");
		}
		ALIASES.computeIfAbsent(registryKey.identifier(), key -> new ConcurrentHashMap<>()).put(from, to);
	}

	/** The name {@code name} is an alias for (following chains), or {@code name} if it is not an alias. */
	public static Identifier resolve(ResourceKey<?> registryKey, Identifier name) {
		Map<Identifier, Identifier> aliases = ALIASES.get(registryKey.identifier());
		if (aliases == null) {
			return name;
		}
		Identifier current = name;
		for (int i = 0; i < MAX_CHAIN; i++) {
			Identifier next = aliases.get(current);
			if (next == null) {
				return current;
			}
			current = next;
		}
		return current;
	}

	public static boolean hasAliases(ResourceKey<?> registryKey) {
		return ALIASES.containsKey(registryKey.identifier());
	}
}
