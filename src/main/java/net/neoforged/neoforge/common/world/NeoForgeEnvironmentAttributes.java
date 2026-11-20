package net.neoforged.neoforge.common.world;

import net.minecraft.resources.Identifier;
import net.minecraft.world.attribute.EnvironmentAttribute;

/**
 * SteelWool re-implementation of NeoForge's {@code NeoForgeEnvironmentAttributes}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class NeoForgeEnvironmentAttributes {
	public static Identifier DEFAULT_CUSTOM_CLOUDS;
	public static EnvironmentAttribute<Identifier> CUSTOM_CLOUDS;
	public static Identifier DEFAULT_CUSTOM_SKYBOX;
	public static EnvironmentAttribute<Identifier> CUSTOM_SKYBOX;
	public static Identifier DEFAULT_CUSTOM_WEATHER_EFFECTS;
	public static EnvironmentAttribute<Identifier> CUSTOM_WEATHER_EFFECTS;

	private NeoForgeEnvironmentAttributes() {
		super();
	}
}
