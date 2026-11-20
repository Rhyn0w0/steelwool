package dev.steelwool.loading;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;
import java.util.List;

import dev.steelwool.discovery.AnnotationScanResult;
import dev.steelwool.discovery.ModsToml;
import dev.steelwool.discovery.NeoForgeModFile;
import dev.steelwool.discovery.NeoForgeModMetadata;
import org.junit.jupiter.api.Test;

class SteelWoolLoaderValidationTest {
	private static NeoForgeModFile file(String jar, String modId, NeoForgeModMetadata.Dependency... deps) {
		NeoForgeModMetadata mod = new NeoForgeModMetadata(modId, "1.0", modId, "", List.of(deps));
		return new NeoForgeModFile(Path.of(jar), new ModsToml("javafml", "MIT", List.of(mod), List.of(), List.of()),
				new AnnotationScanResult(List.of(), List.of()), List.of());
	}

	private static NeoForgeModMetadata.Dependency dep(String modId, String type) {
		return new NeoForgeModMetadata.Dependency(modId, type, "[1,)", "BOTH");
	}

	@Test
	void acceptsNeoForgeAndMinecraftDependencies() {
		assertDoesNotThrow(() -> SteelWoolLoader.validate(
				List.of(file("a.jar", "a", dep("neoforge", "required"), dep("minecraft", "required"))), id -> false));
	}

	@Test
	void acceptsDependenciesOnOtherNeoForgeOrFabricMods() {
		assertDoesNotThrow(() -> SteelWoolLoader.validate(List.of(
				file("a.jar", "a", dep("b", "required"), dep("sodium", "required")),
				file("b.jar", "b")), "sodium"::equals));
	}

	@Test
	void rejectsMissingRequiredDependency() {
		ModLoadingFailure failure = assertThrows(ModLoadingFailure.class, () -> SteelWoolLoader.validate(
				List.of(file("a.jar", "a", dep("missing", "required"))), id -> false));
		assertTrue(failure.getMessage().contains("requires 'missing'"));
	}

	@Test
	void ignoresMissingOptionalDependency() {
		assertDoesNotThrow(() -> SteelWoolLoader.validate(List.of(file("a.jar", "a", dep("missing", "optional"))), id -> false));
	}

	@Test
	void rejectsPresentIncompatibleMod() {
		assertThrows(ModLoadingFailure.class, () -> SteelWoolLoader.validate(
				List.of(file("a.jar", "a", dep("b", "incompatible")), file("b.jar", "b")), id -> false));
	}

	@Test
	void rejectsDuplicateModIds() {
		ModLoadingFailure failure = assertThrows(ModLoadingFailure.class, () -> SteelWoolLoader.validate(
				List.of(file("a.jar", "same"), file("b.jar", "same")), id -> false));
		assertTrue(failure.getMessage().contains("provided by both"));
	}
}
