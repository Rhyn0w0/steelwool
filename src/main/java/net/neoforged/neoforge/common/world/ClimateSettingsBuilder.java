package net.neoforged.neoforge.common.world;

import net.minecraft.world.level.biome.Biome;

/**
 * SteelWool re-implementation of NeoForge's {@code ClimateSettingsBuilder}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ClimateSettingsBuilder {
	private boolean hasPrecipitation;
	private float temperature;
	private Biome.TemperatureModifier temperatureModifier;
	private float downfall;

	public static net.neoforged.neoforge.common.world.ClimateSettingsBuilder copyOf(Biome.ClimateSettings arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ClimateSettingsBuilder.copyOf yet");
	}

	public static net.neoforged.neoforge.common.world.ClimateSettingsBuilder create(boolean arg0, float arg1, Biome.TemperatureModifier arg2, float arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ClimateSettingsBuilder.create yet");
	}

	private ClimateSettingsBuilder(boolean hasPrecipitation, float temperature, Biome.TemperatureModifier temperatureModifier, float downfall) {
		super();
		this.hasPrecipitation = hasPrecipitation;
		this.temperature = temperature;
		this.temperatureModifier = temperatureModifier;
		this.downfall = downfall;
	}

	public Biome.ClimateSettings build() {
		throw new UnsupportedOperationException("SteelWool does not implement ClimateSettingsBuilder.build yet");
	}

	public boolean hasPrecipitation() {
		return this.hasPrecipitation;
	}

	public void setHasPrecipitation(boolean hasPrecipitation) {
		this.hasPrecipitation = hasPrecipitation;
	}

	public float getTemperature() {
		return this.temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public Biome.TemperatureModifier getTemperatureModifier() {
		return this.temperatureModifier;
	}

	public void setTemperatureModifier(Biome.TemperatureModifier temperatureModifier) {
		this.temperatureModifier = temperatureModifier;
	}

	public float getDownfall() {
		return this.downfall;
	}

	public void setDownfall(float downfall) {
		this.downfall = downfall;
	}
}
