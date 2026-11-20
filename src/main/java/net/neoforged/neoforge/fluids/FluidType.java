package net.neoforged.neoforge.fluids;

import java.util.Map;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.BlockAndLightGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.SoundAction;
import net.neoforged.neoforge.common.util.Lazy;

/**
 * SteelWool re-implementation of NeoForge's {@code FluidType}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class FluidType {
	public static final int BUCKET_VOLUME = 1000;
	public static final Lazy<Integer> SIZE = Lazy.of(() -> net.neoforged.neoforge.registries.NeoForgeRegistries.FLUID_TYPES.keySet().size());
	private String descriptionId;
	private final double motionScale;
	private final boolean canPushEntity;
	private final boolean canSwim;
	private final boolean canDrown;
	private final float fallDistanceModifier;
	private final boolean canExtinguish;
	private final boolean canConvertToSource;
	private final boolean supportsBoating;
	private final PathType pathType;
	private final PathType adjacentPathType;
	private final boolean canHydrate;
	private final int lightLevel;
	private final int density;
	private final int temperature;
	private final int viscosity;
	private final Rarity rarity;
	private final net.neoforged.neoforge.fluids.FluidType.DripstoneDripInfo dripInfo;
	private final boolean isWaterLike;
	protected final Map<SoundAction, SoundEvent> sounds;

	public FluidType(net.neoforged.neoforge.fluids.FluidType.Properties arg0) {
		this.descriptionId = arg0.descriptionId;
		this.motionScale = arg0.motionScale;
		this.canPushEntity = arg0.canPushEntity;
		this.canSwim = arg0.canSwim;
		this.canDrown = arg0.canDrown;
		this.fallDistanceModifier = arg0.fallDistanceModifier;
		this.canExtinguish = arg0.canExtinguish;
		this.canConvertToSource = arg0.canConvertToSource;
		this.supportsBoating = arg0.supportsBoating;
		this.pathType = arg0.pathType;
		this.adjacentPathType = arg0.adjacentPathType;
		this.canHydrate = arg0.canHydrate;
		this.lightLevel = arg0.lightLevel;
		this.density = arg0.density;
		this.temperature = arg0.temperature;
		this.viscosity = arg0.viscosity;
		this.rarity = arg0.rarity;
		this.dripInfo = arg0.dripInfo;
		this.isWaterLike = arg0.isWaterLike;
		this.sounds = Map.copyOf(arg0.sounds);
	}

	public Component getDescription() {
		return Component.translatable(getDescriptionId());
	}

	public String getDescriptionId() {
		if (descriptionId == null) {
			descriptionId = net.minecraft.util.Util.makeDescriptionId("fluid_type", net.neoforged.neoforge.registries.NeoForgeRegistries.FLUID_TYPES.getKey(this));
		}
		return descriptionId;
	}

	public int getLightLevel() {
		return this.lightLevel;
	}

	public int getDensity() {
		return this.density;
	}

	public int getTemperature() {
		return this.temperature;
	}

	public int getViscosity() {
		return this.viscosity;
	}

	public Rarity getRarity() {
		return this.rarity;
	}

	public net.neoforged.neoforge.fluids.FluidType.DripstoneDripInfo getDripInfo() {
		return this.dripInfo;
	}

	public SoundEvent getSound(SoundAction arg0) {
		return sounds.get(arg0);
	}

	public double motionScale(Entity arg0) {
		return this.motionScale;
	}

	public boolean canPushEntity(Entity arg0) {
		return this.canPushEntity;
	}

	public boolean canSwim(Entity arg0) {
		return this.canSwim;
	}

	public float getFallDistanceModifier(Entity arg0) {
		return this.fallDistanceModifier;
	}

	public boolean canExtinguish(Entity arg0) {
		return this.canExtinguish;
	}

	public boolean move(LivingEntity arg0, Vec3 arg1, double arg2) {
		// false: the entity moves through the fluid the vanilla way.
		return false;
	}

	public boolean canDrownIn(LivingEntity arg0) {
		return this.canDrown;
	}

	public void setItemMovement(ItemEntity arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.setItemMovement yet");
	}

	public boolean supportsBoating(AbstractBoat arg0) {
		return this.supportsBoating;
	}

	public boolean supportsBoating(FluidState arg0, AbstractBoat arg1) {
		return supportsBoating(arg1);
	}

	public boolean canRideVehicleUnder(Entity arg0, Entity arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.canRideVehicleUnder yet");
	}

	public boolean canHydrate(Entity arg0) {
		return this.canHydrate;
	}

	public SoundEvent getSound(Entity arg0, SoundAction arg1) {
		return getSound(arg1);
	}

	public boolean canExtinguish(FluidState arg0, BlockGetter arg1, BlockPos arg2) {
		return this.canExtinguish;
	}

	public boolean canConvertToSource(FluidState arg0, LevelReader arg1, BlockPos arg2) {
		return this.canConvertToSource;
	}

	public PathType getBlockPathType(FluidState arg0, BlockGetter arg1, BlockPos arg2, Mob arg3, boolean arg4) {
		return this.pathType;
	}

	public PathType getAdjacentBlockPathType(FluidState arg0, BlockGetter arg1, BlockPos arg2, Mob arg3, PathType arg4) {
		return this.adjacentPathType;
	}

	public SoundEvent getSound(LivingEntity arg0, BlockGetter arg1, BlockPos arg2, SoundAction arg3) {
		return getSound(arg3);
	}

	public boolean canHydrate(FluidState arg0, BlockGetter arg1, BlockState arg2, BlockPos arg3) {
		return this.canHydrate;
	}

	public int getLightLevel(FluidState arg0, BlockAndLightGetter arg1, BlockPos arg2) {
		return getLightLevel();
	}

	public int getDensity(FluidState arg0, BlockAndLightGetter arg1, BlockPos arg2) {
		return getDensity();
	}

	public int getTemperature(FluidState arg0, BlockAndLightGetter arg1, BlockPos arg2) {
		return getTemperature();
	}

	public int getViscosity(FluidState arg0, BlockAndLightGetter arg1, BlockPos arg2) {
		return getViscosity();
	}

	public boolean handleCauldronDrip(Fluid arg0, Level arg1, BlockPos arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.handleCauldronDrip yet");
	}

	public boolean getIsWaterLike() {
		return this.isWaterLike;
	}

	public boolean canConvertToSource(FluidStack arg0) {
		return this.canConvertToSource;
	}

	public SoundEvent getSound(FluidStack arg0, SoundAction arg1) {
		return getSound(arg1);
	}

	public Component getDescription(FluidStack arg0) {
		return Component.translatable(getDescriptionId(arg0));
	}

	public String getDescriptionId(FluidStack arg0) {
		return getDescriptionId();
	}

	public boolean canHydrate(FluidStack arg0) {
		return this.canHydrate;
	}

	public int getLightLevel(FluidStack arg0) {
		return getLightLevel();
	}

	public int getDensity(FluidStack arg0) {
		return getDensity();
	}

	public int getTemperature(FluidStack arg0) {
		return getTemperature();
	}

	public int getViscosity(FluidStack arg0) {
		return getViscosity();
	}

	public Rarity getRarity(FluidStack arg0) {
		return getRarity();
	}

	public final boolean isAir() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.isAir yet");
	}

	public final boolean isVanilla() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.isVanilla yet");
	}

	public ItemStack getBucket(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.getBucket yet");
	}

	public BlockState getBlockForFluidState(BlockAndLightGetter arg0, BlockPos arg1, FluidState arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.getBlockForFluidState yet");
	}

	public FluidState getStateForPlacement(BlockAndLightGetter arg0, BlockPos arg1, FluidStack arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.getStateForPlacement yet");
	}

	public final boolean canBePlacedInLevel(BlockAndLightGetter arg0, BlockPos arg1, FluidState arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.canBePlacedInLevel yet");
	}

	public final boolean canBePlacedInLevel(BlockAndLightGetter arg0, BlockPos arg1, FluidStack arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.canBePlacedInLevel yet");
	}

	public final boolean isLighterThanAir() {
		return getDensity() <= 0;
	}

	public boolean isVaporizedOnPlacement(Level arg0, BlockPos arg1, FluidStack arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.isVaporizedOnPlacement yet");
	}

	public void onVaporize(LivingEntity arg0, Level arg1, BlockPos arg2, FluidStack arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.onVaporize yet");
	}

	public String toString() {
		net.minecraft.resources.Identifier name = net.neoforged.neoforge.registries.NeoForgeRegistries.FLUID_TYPES.getKey(this);
		return name != null ? name.toString() : "Unregistered FluidType";
	}

	public static record DripstoneDripInfo(float chance, ParticleOptions dripParticle, Block filledCauldron) {
	}

	public static final class Properties {
		private String descriptionId;
		private double motionScale;
		private boolean canPushEntity;
		private boolean canSwim;
		private boolean canDrown;
		private float fallDistanceModifier;
		private boolean canExtinguish;
		private boolean canConvertToSource;
		private boolean supportsBoating;
		private PathType pathType;
		private PathType adjacentPathType;
		private final Map<SoundAction, SoundEvent> sounds;
		private boolean canHydrate;
		private int lightLevel;
		private int density;
		private int temperature;
		private int viscosity;
		private Rarity rarity;
		private net.neoforged.neoforge.fluids.FluidType.DripstoneDripInfo dripInfo;
		private boolean isWaterLike;

		private Properties() {
			// Defaults match NeoForge's.
			motionScale = 0.014;
			canPushEntity = true;
			canSwim = true;
			canDrown = true;
			fallDistanceModifier = 0.5F;
			pathType = PathType.WATER;
			adjacentPathType = PathType.WATER_BORDER;
			sounds = new java.util.HashMap<>();
			density = 1000;
			temperature = 300;
			viscosity = 1000;
			rarity = Rarity.COMMON;
		}

		public static net.neoforged.neoforge.fluids.FluidType.Properties create() {
			return new Properties();
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties descriptionId(String arg0) {
			this.descriptionId = arg0;
			return this;
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties motionScale(double arg0) {
			this.motionScale = arg0;
			return this;
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties canPushEntity(boolean arg0) {
			this.canPushEntity = arg0;
			return this;
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties canSwim(boolean arg0) {
			this.canSwim = arg0;
			return this;
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties canDrown(boolean arg0) {
			this.canDrown = arg0;
			return this;
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties fallDistanceModifier(float arg0) {
			this.fallDistanceModifier = arg0;
			return this;
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties canExtinguish(boolean arg0) {
			this.canExtinguish = arg0;
			return this;
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties canConvertToSource(boolean arg0) {
			this.canConvertToSource = arg0;
			return this;
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties supportsBoating(boolean arg0) {
			this.supportsBoating = arg0;
			return this;
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties pathType(PathType arg0) {
			this.pathType = arg0;
			return this;
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties adjacentPathType(PathType arg0) {
			this.adjacentPathType = arg0;
			return this;
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties sound(SoundAction arg0, SoundEvent arg1) {
			sounds.put(arg0, arg1);
			return this;
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties canHydrate(boolean arg0) {
			this.canHydrate = arg0;
			return this;
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties lightLevel(int arg0) {
			this.lightLevel = arg0;
			return this;
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties density(int arg0) {
			this.density = arg0;
			return this;
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties temperature(int arg0) {
			this.temperature = arg0;
			return this;
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties viscosity(int arg0) {
			this.viscosity = arg0;
			return this;
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties rarity(Rarity arg0) {
			this.rarity = arg0;
			return this;
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties addDripstoneDripping(float arg0, ParticleOptions arg1, Block arg2, SoundEvent arg3) {
			if (arg3 != null) {
				sounds.put(net.neoforged.neoforge.common.SoundActions.CAULDRON_DRIP, arg3);
			}
			dripInfo = new DripstoneDripInfo(arg0, arg1, arg2);
			return this;
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties isWaterLike(boolean arg0) {
			this.isWaterLike = arg0;
			return this;
		}
	}
}
