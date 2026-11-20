package net.neoforged.neoforge.common.world;

import net.minecraft.resources.Identifier;
import net.minecraft.world.attribute.EnvironmentAttribute;

/**
 * The environment attributes NeoForge registers, naming custom renderers for clouds, the sky and
 * weather. SteelWool registers them so data that sets them loads; it does not use them for rendering.
 */
public final class NeoForgeEnvironmentAttributes {
	public static Identifier DEFAULT_CUSTOM_CLOUDS = Identifier.withDefaultNamespace("default");
	public static EnvironmentAttribute<Identifier> CUSTOM_CLOUDS = EnvironmentAttribute.builder(NeoForgeAttributeTypes.IDENTIFIER)
			.defaultValue(DEFAULT_CUSTOM_CLOUDS).syncable().build();
	public static Identifier DEFAULT_CUSTOM_SKYBOX = Identifier.withDefaultNamespace("default");
	public static EnvironmentAttribute<Identifier> CUSTOM_SKYBOX = EnvironmentAttribute.builder(NeoForgeAttributeTypes.IDENTIFIER)
			.defaultValue(DEFAULT_CUSTOM_SKYBOX).syncable().build();
	public static Identifier DEFAULT_CUSTOM_WEATHER_EFFECTS = Identifier.withDefaultNamespace("default");
	public static EnvironmentAttribute<Identifier> CUSTOM_WEATHER_EFFECTS = EnvironmentAttribute.builder(NeoForgeAttributeTypes.IDENTIFIER)
			.defaultValue(DEFAULT_CUSTOM_WEATHER_EFFECTS).syncable().build();

	private NeoForgeEnvironmentAttributes() {
	}
}
