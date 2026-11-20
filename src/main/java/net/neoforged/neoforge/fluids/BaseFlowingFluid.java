package net.neoforged.neoforge.fluids;

import java.util.Optional;
import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

/**
 * SteelWool re-implementation of NeoForge's {@code BaseFlowingFluid}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class BaseFlowingFluid extends FlowingFluid {
	private final Supplier<? extends FluidType> fluidType;
	private final Supplier<? extends Fluid> flowing;
	private final Supplier<? extends Fluid> still;
	private final Supplier<? extends Item> bucket;
	private final Supplier<? extends LiquidBlock> block;
	private final int slopeFindDistance;
	private final int levelDecreasePerBlock;
	private final float explosionResistance;
	private final int tickRate;

	protected BaseFlowingFluid(net.neoforged.neoforge.fluids.BaseFlowingFluid.Properties arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the BaseFlowingFluid constructor yet");
	}

	public FluidType getFluidType() {
		throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.getFluidType yet");
	}

	public Fluid getFlowing() {
		throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.getFlowing yet");
	}

	public Fluid getSource() {
		throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.getSource yet");
	}

	protected boolean canConvertToSource(ServerLevel arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.canConvertToSource yet");
	}

	public boolean canConvertToSource(FluidState arg0, ServerLevel arg1, BlockPos arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.canConvertToSource yet");
	}

	protected void beforeDestroyingBlock(LevelAccessor arg0, BlockPos arg1, BlockState arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.beforeDestroyingBlock yet");
	}

	protected int getSlopeFindDistance(LevelReader arg0) {
		return this.slopeFindDistance;
	}

	protected int getDropOff(LevelReader arg0) {
		return this.levelDecreasePerBlock;
	}

	public Item getBucket() {
		throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.getBucket yet");
	}

	protected boolean canBeReplacedWith(FluidState arg0, BlockGetter arg1, BlockPos arg2, Fluid arg3, Direction arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.canBeReplacedWith yet");
	}

	public int getTickDelay(LevelReader arg0) {
		return this.tickRate;
	}

	protected float getExplosionResistance() {
		return this.explosionResistance;
	}

	protected BlockState createLegacyBlock(FluidState arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.createLegacyBlock yet");
	}

	public boolean isSame(Fluid arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.isSame yet");
	}

	public Optional<SoundEvent> getPickupSound() {
		throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.getPickupSound yet");
	}

	public static class Flowing extends net.neoforged.neoforge.fluids.BaseFlowingFluid {
		public Flowing(net.neoforged.neoforge.fluids.BaseFlowingFluid.Properties arg0) {
			super((net.neoforged.neoforge.fluids.BaseFlowingFluid.Properties) null);
			throw new UnsupportedOperationException("SteelWool does not implement the BaseFlowingFluid.Flowing constructor yet");
		}

		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.Flowing.createFluidStateDefinition yet");
		}

		public int getAmount(FluidState arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.Flowing.getAmount yet");
		}

		public boolean isSource(FluidState arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.Flowing.isSource yet");
		}
	}

	public static class Properties {
		private Supplier<? extends FluidType> fluidType;
		private Supplier<? extends Fluid> still;
		private Supplier<? extends Fluid> flowing;
		private Supplier<? extends Item> bucket;
		private Supplier<? extends LiquidBlock> block;
		private int slopeFindDistance;
		private int levelDecreasePerBlock;
		private float explosionResistance;
		private int tickRate;

		public Properties(Supplier<? extends FluidType> fluidType, Supplier<? extends Fluid> still, Supplier<? extends Fluid> flowing) {
			super();
			this.slopeFindDistance = 4;
			this.levelDecreasePerBlock = 1;
			this.explosionResistance = 1f;
			this.tickRate = 5;
			this.fluidType = fluidType;
			this.still = still;
			this.flowing = flowing;
		}

		public net.neoforged.neoforge.fluids.BaseFlowingFluid.Properties bucket(Supplier<? extends Item> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.Properties.bucket yet");
		}

		public net.neoforged.neoforge.fluids.BaseFlowingFluid.Properties block(Supplier<? extends LiquidBlock> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.Properties.block yet");
		}

		public net.neoforged.neoforge.fluids.BaseFlowingFluid.Properties slopeFindDistance(int arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.Properties.slopeFindDistance yet");
		}

		public net.neoforged.neoforge.fluids.BaseFlowingFluid.Properties levelDecreasePerBlock(int arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.Properties.levelDecreasePerBlock yet");
		}

		public net.neoforged.neoforge.fluids.BaseFlowingFluid.Properties explosionResistance(float arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.Properties.explosionResistance yet");
		}

		public net.neoforged.neoforge.fluids.BaseFlowingFluid.Properties tickRate(int arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.Properties.tickRate yet");
		}
	}

	public static class Source extends net.neoforged.neoforge.fluids.BaseFlowingFluid {
		public Source(net.neoforged.neoforge.fluids.BaseFlowingFluid.Properties arg0) {
			super(arg0);
		}

		public int getAmount(FluidState arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.Source.getAmount yet");
		}

		public boolean isSource(FluidState arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement BaseFlowingFluid.Source.isSource yet");
		}
	}
}
