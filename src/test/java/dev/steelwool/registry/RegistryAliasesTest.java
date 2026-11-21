package dev.steelwool.registry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import org.junit.jupiter.api.Test;

class RegistryAliasesTest {
	private static final ResourceKey<?> REGISTRY = ResourceKey.createRegistryKey(Identifier.fromNamespaceAndPath("steelwool_test", "aliases"));

	private static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath("steelwool_test", path);
	}

	@Test
	void aliasesResolveThroughChains() {
		RegistryAliases.add(REGISTRY, id("oldest"), id("old"));
		RegistryAliases.add(REGISTRY, id("old"), id("new"));
		assertTrue(RegistryAliases.hasAliases(REGISTRY));
		assertEquals(id("new"), RegistryAliases.resolve(REGISTRY, id("oldest")));
		assertEquals(id("unrelated"), RegistryAliases.resolve(REGISTRY, id("unrelated")));
	}

	@Test
	void aliasesAreKeptPerRegistry() {
		ResourceKey<?> other = ResourceKey.createRegistryKey(Identifier.fromNamespaceAndPath("steelwool_test", "no_aliases"));
		assertFalse(RegistryAliases.hasAliases(other));
		assertEquals(id("oldest"), RegistryAliases.resolve(other, id("oldest")));
	}

	@Test
	void selfAliasIsRejected() {
		assertThrows(IllegalArgumentException.class, () -> RegistryAliases.add(REGISTRY, id("x"), id("x")));
	}
}
