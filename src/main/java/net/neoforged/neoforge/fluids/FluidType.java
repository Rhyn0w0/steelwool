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
	public static final Lazy<Integer> SIZE = null /* SteelWool: TODO */;
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
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the FluidType constructor yet");
	}

	public Component getDescription() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.getDescription yet");
	}

	public String getDescriptionId() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.getDescriptionId yet");
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
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.getSound yet");
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
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.move yet");
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
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.supportsBoating yet");
	}

	public boolean canRideVehicleUnder(Entity arg0, Entity arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.canRideVehicleUnder yet");
	}

	public boolean canHydrate(Entity arg0) {
		return this.canHydrate;
	}

	public SoundEvent getSound(Entity arg0, SoundAction arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.getSound yet");
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
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.getSound yet");
	}

	public boolean canHydrate(FluidState arg0, BlockGetter arg1, BlockState arg2, BlockPos arg3) {
		return this.canHydrate;
	}

	public int getLightLevel(FluidState arg0, BlockAndLightGetter arg1, BlockPos arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.getLightLevel yet");
	}

	public int getDensity(FluidState arg0, BlockAndLightGetter arg1, BlockPos arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.getDensity yet");
	}

	public int getTemperature(FluidState arg0, BlockAndLightGetter arg1, BlockPos arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.getTemperature yet");
	}

	public int getViscosity(FluidState arg0, BlockAndLightGetter arg1, BlockPos arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.getViscosity yet");
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
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.getSound yet");
	}

	public Component getDescription(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.getDescription yet");
	}

	public String getDescriptionId(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.getDescriptionId yet");
	}

	public boolean canHydrate(FluidStack arg0) {
		return this.canHydrate;
	}

	public int getLightLevel(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.getLightLevel yet");
	}

	public int getDensity(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.getDensity yet");
	}

	public int getTemperature(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.getTemperature yet");
	}

	public int getViscosity(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.getViscosity yet");
	}

	public Rarity getRarity(FluidStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.getRarity yet");
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
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.isLighterThanAir yet");
	}

	public boolean isVaporizedOnPlacement(Level arg0, BlockPos arg1, FluidStack arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.isVaporizedOnPlacement yet");
	}

	public void onVaporize(LivingEntity arg0, Level arg1, BlockPos arg2, FluidStack arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.onVaporize yet");
	}

	public String toString() {
		throw new UnsupportedOperationException("SteelWool does not implement FluidType.toString yet");
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
			super();
			throw new UnsupportedOperationException("SteelWool does not implement the FluidType.Properties constructor yet");
		}

		public static net.neoforged.neoforge.fluids.FluidType.Properties create() {
			throw new UnsupportedOperationException("SteelWool does not implement FluidType.Properties.create yet");
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties descriptionId(String arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FluidType.Properties.descriptionId yet");
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties motionScale(double arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FluidType.Properties.motionScale yet");
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties canPushEntity(boolean arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FluidType.Properties.canPushEntity yet");
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties canSwim(boolean arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FluidType.Properties.canSwim yet");
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties canDrown(boolean arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FluidType.Properties.canDrown yet");
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties fallDistanceModifier(float arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FluidType.Properties.fallDistanceModifier yet");
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties canExtinguish(boolean arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FluidType.Properties.canExtinguish yet");
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties canConvertToSource(boolean arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FluidType.Properties.canConvertToSource yet");
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties supportsBoating(boolean arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FluidType.Properties.supportsBoating yet");
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties pathType(PathType arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FluidType.Properties.pathType yet");
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties adjacentPathType(PathType arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FluidType.Properties.adjacentPathType yet");
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties sound(SoundAction arg0, SoundEvent arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement FluidType.Properties.sound yet");
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties canHydrate(boolean arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FluidType.Properties.canHydrate yet");
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties lightLevel(int arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FluidType.Properties.lightLevel yet");
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties density(int arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FluidType.Properties.density yet");
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties temperature(int arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FluidType.Properties.temperature yet");
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties viscosity(int arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FluidType.Properties.viscosity yet");
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties rarity(Rarity arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FluidType.Properties.rarity yet");
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties addDripstoneDripping(float arg0, ParticleOptions arg1, Block arg2, SoundEvent arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement FluidType.Properties.addDripstoneDripping yet");
		}

		public net.neoforged.neoforge.fluids.FluidType.Properties isWaterLike(boolean arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement FluidType.Properties.isWaterLike yet");
		}
	}
}
