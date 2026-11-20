package dev.steelwool.loading;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ModLoadingFailureTest {
	@Test
	void namesMissingNeoForgeClass() {
		Throwable cause = new RuntimeException(new NoClassDefFoundError("net/neoforged/neoforge/capabilities/Capabilities"));
		String message = ModLoadingFailure.of("examplemod", "its mod class could not be constructed", cause).getMessage();

		assertTrue(message.contains("examplemod"));
		assertTrue(message.contains("net.neoforged.neoforge.capabilities.Capabilities"));
		assertTrue(message.contains("does not support yet"));
	}

	@Test
	void doesNotBlameSteelWoolForOtherErrors() {
		String message = ModLoadingFailure.of("examplemod", "it crashed", new IllegalStateException("bug in the mod")).getMessage();
		assertFalse(message.contains("does not support yet"));
	}
}
