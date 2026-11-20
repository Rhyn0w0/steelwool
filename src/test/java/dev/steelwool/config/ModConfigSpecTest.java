package dev.steelwool.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.electronwill.nightconfig.core.CommentedConfig;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class ModConfigSpecTest {
	enum Mode { FAST, SAFE }

	@TempDir
	Path temp;

	private final ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
	private final ModConfigSpec.BooleanValue flag = builder.comment("A flag").define("flag", true);
	private final ModConfigSpec.IntValue number;
	private final ModConfigSpec.DoubleValue ratio;
	private final ModConfigSpec.EnumValue<Mode> mode;
	private final ModConfigSpec.ConfigValue<List<? extends String>> names;
	private final ModConfigSpec.ConfigValue<String> nested;
	private final ModConfigSpec spec;

	ModConfigSpecTest() {
		number = builder.defineInRange("number", 42, 0, 100);
		ratio = builder.defineInRange("ratio", 0.5, 0.0, 1.0);
		mode = builder.defineEnum("mode", Mode.SAFE);
		names = builder.defineListAllowEmpty("names", List.of("a"), () -> "", o -> o instanceof String s && !s.isBlank());
		builder.comment("A section").push("section");
		nested = builder.define("nested", "hello");
		builder.pop();
		spec = builder.build();
	}

	private static IConfigSpec.ILoadedConfig loaded(CommentedFileConfig file) {
		return new IConfigSpec.ILoadedConfig() {
			@Override
			public CommentedConfig config() {
				return file;
			}

			@Override
			public void save() {
				file.save();
			}
		};
	}

	@Test
	void returnsDefaultsBeforeLoading() {
		assertTrue(flag.getAsBoolean());
		assertEquals(42, number.getAsInt());
		assertEquals(Mode.SAFE, mode.get());
		assertEquals(List.of("section", "nested"), nested.getPath());
	}

	@Test
	void createsFileWithDefaultsAndComments() throws IOException {
		Path path = temp.resolve("test-local.toml");
		spec.acceptConfig(loaded(SteelWoolConfigs.openAndCorrect(path, spec)));

		String text = Files.readString(path);
		assertTrue(text.contains("#A flag"));
		assertTrue(text.contains("#A section"));
		assertTrue(text.contains("number = 42"));
		assertTrue(text.contains("mode = \"SAFE\""));
		assertTrue(text.contains("[section]"));
		assertEquals(42, number.getAsInt());
	}

	@Test
	void readsValuesAndCorrectsInvalidOnes() throws IOException {
		Path path = temp.resolve("test-local.toml");
		Files.writeString(path, """
				flag = false
				number = 500
				ratio = 1
				mode = "fast"
				names = ["x", "", "y"]
				[section]
				nested = "world"
				""");

		spec.acceptConfig(loaded(SteelWoolConfigs.openAndCorrect(path, spec)));

		assertFalse(flag.getAsBoolean());
		assertEquals(100, number.getAsInt(), "out-of-range values are clamped");
		assertEquals(1.0, ratio.getAsDouble(), "integers are accepted for doubles");
		assertEquals(Mode.FAST, mode.get(), "enum names are case-insensitive");
		assertEquals(List.of("x", "y"), names.get(), "invalid list elements are dropped");
		assertEquals("world", nested.get());
	}

	@Test
	void setAndSavePersist() throws IOException {
		Path path = temp.resolve("test-local.toml");
		spec.acceptConfig(loaded(SteelWoolConfigs.openAndCorrect(path, spec)));

		number.set(7);
		number.save();

		assertTrue(Files.readString(path).contains("number = 7"));
		assertEquals(7, number.getAsInt());
	}
}
