package dev.steelwool.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.junit.jupiter.api.Test;

class ModsTomlParserTest {
	private static ModsToml parse(String toml, String jarVersion) throws IOException {
		return ModsTomlParser.parse(new StringReader(toml), jarVersion);
	}

	@Test
	void parsesMdkStyleFile() throws IOException {
		ModsToml toml = parse("""
				license="MIT"
				[[mods]]
				modId="examplemod"
				version="${file.jarVersion}"
				displayName="Example Mod"
				description='''
				Example mod description.
				'''
				[[mixins]]
				config="examplemod.mixins.json"
				[[accessTransformers]]
				file="META-INF/accesstransformer.cfg"
				[[dependencies.examplemod]]
				    modId="neoforge"
				    type="required"
				    versionRange="[26.3,)"
				    ordering="NONE"
				    side="BOTH"
				[[dependencies.examplemod]]
				    modId="jei"
				    type="optional"
				    side="client"
				""", "1.2.3");

		assertEquals("javafml", toml.modLoader());
		assertEquals("MIT", toml.license());
		assertEquals(List.of("examplemod.mixins.json"), toml.mixinConfigs());
		assertEquals(List.of("META-INF/accesstransformer.cfg"), toml.accessTransformers());

		NeoForgeModMetadata mod = toml.mods().getFirst();
		assertEquals("examplemod", mod.modId());
		assertEquals("1.2.3", mod.version(), "${file.jarVersion} is replaced by the manifest version");
		assertEquals("Example Mod", mod.displayName());
		assertEquals("Example mod description.", mod.description());
		assertEquals(2, mod.dependencies().size());
		assertTrue(mod.dependencies().get(0).isRequired());
		assertEquals("CLIENT", mod.dependencies().get(1).side());
		assertEquals("optional", mod.dependencies().get(1).type());
	}

	@Test
	void defaultsMissingOptionalFields() throws IOException {
		NeoForgeModMetadata mod = parse("""
				[[mods]]
				modId="minimal"
				""", null).mods().getFirst();

		assertEquals("minimal", mod.displayName());
		assertEquals("1", mod.version());
		assertEquals(List.of(), mod.dependencies());
	}

	@Test
	void supportsLegacyMandatoryFlag() throws IOException {
		NeoForgeModMetadata mod = parse("""
				[[mods]]
				modId="old"
				[[dependencies.old]]
				modId="lib"
				mandatory=false
				""", null).mods().getFirst();

		assertEquals("optional", mod.dependencies().getFirst().type());
	}

	@Test
	void rejectsFileWithoutMods() {
		assertThrows(IOException.class, () -> parse("license=\"MIT\"", null));
	}

	@Test
	void rejectsInvalidToml() {
		assertThrows(IOException.class, () -> parse("[[mods]\nmodId=", null));
	}
}
