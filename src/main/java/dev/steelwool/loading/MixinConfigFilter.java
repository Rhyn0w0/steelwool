package dev.steelwool.loading;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jspecify.annotations.Nullable;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Drops mixins whose target classes do not exist from a NeoForge mod's mixin config.
 *
 * <p>Some mods list client-only mixins in their common {@code "mixins"} list. That works on NeoForge,
 * whose dedicated server tolerates it, but Fabric's Mixin stops the game when a required mixin's target
 * is missing. On a dedicated server SteelWool registers a copy of such a config without those mixins.
 */
final class MixinConfigFilter {
	private static final Logger LOGGER = LoggerFactory.getLogger("SteelWool");
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

	private final Path outputDir;
	private final Predicate<String> classExists;

	/**
	 * @param outputDir   where filtered configs are written; it must be on the class path
	 * @param classExists whether a class (internal name) exists in the game
	 */
	MixinConfigFilter(Path outputDir, Predicate<String> classExists) {
		this.outputDir = outputDir;
		this.classExists = classExists;
	}

	/** The config name to register: {@code configName}, or a filtered copy's name if mixins were dropped. */
	String filter(Path modJar, String configName) throws IOException {
		try (FileSystem jar = FileSystems.newFileSystem(modJar)) {
			Path configPath = jar.getPath(configName);
			if (!Files.exists(configPath)) {
				return configName;
			}
			JsonObject config = JsonParser.parseString(Files.readString(configPath, StandardCharsets.UTF_8)).getAsJsonObject();
			String pkg = config.has("package") ? config.get("package").getAsString() : "";
			JsonElement mixins = config.get("mixins");
			if (!(mixins instanceof JsonArray list)) {
				return configName;
			}

			JsonArray kept = new JsonArray();
			List<String> dropped = new ArrayList<>();
			for (JsonElement element : list) {
				String mixin = element.getAsString();
				List<String> targets = targets(jar.getPath((pkg.isEmpty() ? "" : pkg + ".").replace('.', '/') + mixin.replace('.', '/') + ".class"));
				if (targets != null && !targets.isEmpty() && targets.stream().noneMatch(classExists)) {
					dropped.add(mixin);
				} else {
					kept.add(element);
				}
			}

			if (dropped.isEmpty()) {
				return configName;
			}

			LOGGER.info("Skipping mixins in {} whose targets do not exist on this side: {}", configName, dropped);
			config.add("mixins", kept);
			String filteredName = "steelwool-filtered/" + configName;
			Path out = outputDir.resolve(filteredName);
			Files.createDirectories(out.getParent());
			Files.writeString(out, GSON.toJson(config), StandardCharsets.UTF_8);
			return filteredName;
		}
	}

	/** The target classes (internal names) of the mixin class at {@code classFile}, or {@code null} if it cannot be read. */
	private static @Nullable List<String> targets(Path classFile) {
		if (!Files.exists(classFile)) {
			return null;
		}
		List<String> targets = new ArrayList<>();
		try (InputStream in = Files.newInputStream(classFile)) {
			new ClassReader(in).accept(new ClassVisitor(Opcodes.ASM9) {
				@Override
				public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
					if (!descriptor.equals("Lorg/spongepowered/asm/mixin/Mixin;")) {
						return null;
					}
					return new AnnotationVisitor(Opcodes.ASM9) {
						@Override
						public AnnotationVisitor visitArray(String name) {
							return new AnnotationVisitor(Opcodes.ASM9) {
								@Override
								public void visit(String unused, Object value) {
									if (value instanceof Type type) {
										targets.add(type.getInternalName());
									} else if (value instanceof String target) {
										targets.add(target.replace('.', '/'));
									}
								}
							};
						}
					};
				}
			}, ClassReader.SKIP_CODE | ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
		} catch (IOException | RuntimeException e) {
			return null;
		}
		return targets;
	}
}
