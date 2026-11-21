package net.neoforged.neoforge.client.resources;

import java.util.Map;

import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.PreparableReloadListener;

/**
 * SteelWool re-implementation of NeoForge's {@code VanillaClientListeners}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class VanillaClientListeners {
	private static final Map<Class<?>, Identifier> KNOWN_CLASSES = null /* SteelWool: TODO */;
	public static final Identifier LANGUAGE = null /* SteelWool: TODO */;
	public static final Identifier TEXTURES = null /* SteelWool: TODO */;
	public static final Identifier SHADERS = null /* SteelWool: TODO */;
	public static final Identifier SOUNDS = null /* SteelWool: TODO */;
	public static final Identifier SPLASHES = null /* SteelWool: TODO */;
	public static final Identifier ATLASES = null /* SteelWool: TODO */;
	public static final Identifier FONTS = null /* SteelWool: TODO */;
	public static final Identifier GRASS_COLOR = null /* SteelWool: TODO */;
	public static final Identifier FOLIAGE_COLOR = null /* SteelWool: TODO */;
	public static final Identifier DRY_FOLIAGE_COLOR = null /* SteelWool: TODO */;
	public static final Identifier MODELS = null /* SteelWool: TODO */;
	public static final Identifier EQUIPMENT_ASSETS = null /* SteelWool: TODO */;
	public static final Identifier PALETTED_TEXTURES = null /* SteelWool: TODO */;
	public static final Identifier ENTITY_RENDERER = null /* SteelWool: TODO */;
	public static final Identifier BLOCK_ENTITY_RENDERER = null /* SteelWool: TODO */;
	public static final Identifier PARTICLE_RESOURCES = null /* SteelWool: TODO */;
	public static final Identifier GAME_RENDERER = null /* SteelWool: TODO */;
	public static final Identifier WAYPOINT_STYLES = null /* SteelWool: TODO */;
	public static final Identifier LEVEL_EXTRACTOR = null /* SteelWool: TODO */;
	public static final Identifier CLOUD_RENDERER = null /* SteelWool: TODO */;
	public static final Identifier GPU_WARNLIST = null /* SteelWool: TODO */;
	public static final Identifier REGIONAL_COMPLIANCES = null /* SteelWool: TODO */;
	public static final Identifier FIRST = null /* SteelWool: TODO */;
	public static final Identifier LAST = null /* SteelWool: TODO */;

	public VanillaClientListeners() {
		super();
	}

	private static Identifier key(Class<? extends PreparableReloadListener> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement VanillaClientListeners.key yet");
	}

	public static Identifier getNameForClass(Class<? extends PreparableReloadListener> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement VanillaClientListeners.getNameForClass yet");
	}
}
