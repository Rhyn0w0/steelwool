package dev.steelwool.registry;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.pathfinder.PathType;
import net.neoforged.neoforge.common.conditions.AlwaysCondition;
import net.neoforged.neoforge.common.conditions.AndCondition;
import net.neoforged.neoforge.common.conditions.FeatureFlagsEnabledCondition;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.conditions.NeverCondition;
import net.neoforged.neoforge.common.conditions.NotCondition;
import net.neoforged.neoforge.common.conditions.OrCondition;
import net.neoforged.neoforge.common.conditions.RegisteredCondition;
import net.neoforged.neoforge.common.conditions.TagEmptyCondition;
import net.neoforged.neoforge.common.world.NeoForgeAttributeTypes;
import net.neoforged.neoforge.common.world.NeoForgeEnvironmentAttributes;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

/**
 * Registers entries NeoForge itself registers (as the {@code neoforge} mod) that mods rely on:
 * <ul>
 * <li>the fluid types of vanilla's fluids ({@code minecraft:empty}, {@code water} and {@code lava}),
 * which {@code NeoForgeMod.EMPTY_TYPE}, {@code WATER_TYPE} and {@code LAVA_TYPE} point to (their
 * sounds are not set);
 * <li>the built-in condition codecs ({@code neoforge:and}, {@code mod_loaded}, ...);
 * <li>the {@code neoforge:identifier} attribute type and NeoForge's environment attributes
 * ({@code neoforge:custom_clouds}, {@code custom_skybox}, {@code custom_weather_effects}).
 * </ul>
 */
public final class NeoForgeBuiltIns {
	private NeoForgeBuiltIns() {
	}

	public static void register() {
		registerFluidTypes();
		registerConditions();
		registerEnvironmentAttributes();
	}

	private static void registerEnvironmentAttributes() {
		Registry.register(BuiltInRegistries.ATTRIBUTE_TYPE, neoforge("identifier"), NeoForgeAttributeTypes.IDENTIFIER);
		Registry.register(BuiltInRegistries.ENVIRONMENT_ATTRIBUTE, neoforge("custom_weather_effects"), NeoForgeEnvironmentAttributes.CUSTOM_WEATHER_EFFECTS);
		Registry.register(BuiltInRegistries.ENVIRONMENT_ATTRIBUTE, neoforge("custom_clouds"), NeoForgeEnvironmentAttributes.CUSTOM_CLOUDS);
		Registry.register(BuiltInRegistries.ENVIRONMENT_ATTRIBUTE, neoforge("custom_skybox"), NeoForgeEnvironmentAttributes.CUSTOM_SKYBOX);
	}

	private static Identifier neoforge(String path) {
		return Identifier.fromNamespaceAndPath("neoforge", path);
	}

	private static void registerConditions() {
		condition("and", AndCondition.CODEC);
		condition("never", NeverCondition.CODEC);
		condition("registered", RegisteredCondition.CODEC);
		condition("mod_loaded", ModLoadedCondition.CODEC);
		condition("not", NotCondition.CODEC);
		condition("or", OrCondition.CODEC);
		condition("tag_empty", TagEmptyCondition.CODEC);
		condition("always", AlwaysCondition.CODEC);
		condition("feature_flags_enabled", FeatureFlagsEnabledCondition.CODEC);
	}

	private static void condition(String name, MapCodec<? extends ICondition> codec) {
		Registry.register(NeoForgeRegistries.CONDITION_SERIALIZERS, Identifier.fromNamespaceAndPath("neoforge", name), codec);
	}

	private static void registerFluidTypes() {
		fluidType("empty", FluidType.Properties.create()
				.descriptionId("block.minecraft.air")
				.motionScale(1)
				.canPushEntity(false)
				.canSwim(false)
				.canDrown(false)
				.fallDistanceModifier(1)
				.pathType(null)
				.adjacentPathType(null)
				.density(0)
				.temperature(0)
				.viscosity(0));
		fluidType("water", FluidType.Properties.create()
				.descriptionId("block.minecraft.water")
				.fallDistanceModifier(0)
				.canExtinguish(true)
				.canConvertToSource(true)
				.supportsBoating(true)
				.canHydrate(true)
				.isWaterLike(true));
		fluidType("lava", FluidType.Properties.create()
				.descriptionId("block.minecraft.lava")
				.canSwim(false)
				.canDrown(false)
				.pathType(PathType.LAVA)
				.adjacentPathType(null)
				.lightLevel(15)
				.density(3000)
				.viscosity(6000)
				.temperature(1300)
				.rarity(Rarity.COMMON));
	}

	private static void fluidType(String name, FluidType.Properties properties) {
		Registry.register(NeoForgeRegistries.FLUID_TYPES, Identifier.withDefaultNamespace(name), new FluidType(properties));
	}
}
