package dev.steelwool.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.pathfinder.PathType;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

/**
 * Registers the fluid types NeoForge gives vanilla's fluids ({@code minecraft:empty},
 * {@code minecraft:water} and {@code minecraft:lava}), which {@code NeoForgeMod.EMPTY_TYPE},
 * {@code WATER_TYPE} and {@code LAVA_TYPE} point to. Their sounds are not set.
 */
public final class VanillaFluidTypes {
	private VanillaFluidTypes() {
	}

	public static void register() {
		register("empty", FluidType.Properties.create()
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
		register("water", FluidType.Properties.create()
				.descriptionId("block.minecraft.water")
				.fallDistanceModifier(0)
				.canExtinguish(true)
				.canConvertToSource(true)
				.supportsBoating(true)
				.canHydrate(true)
				.isWaterLike(true));
		register("lava", FluidType.Properties.create()
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

	private static void register(String name, FluidType.Properties properties) {
		Registry.register(NeoForgeRegistries.FLUID_TYPES, Identifier.withDefaultNamespace(name), new FluidType(properties));
	}
}
