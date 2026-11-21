package net.neoforged.neoforge.event.level;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code BlockGrowFeatureEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class BlockGrowFeatureEvent extends LevelEvent implements ICancellableEvent {
	private final RandomSource rand;
	private final BlockPos pos;
	private Holder<Feature> feature;

	public BlockGrowFeatureEvent(LevelAccessor arg0, RandomSource rand, BlockPos pos, Holder<Feature> feature) {
		super(arg0);
		this.rand = rand;
		this.pos = pos;
		this.feature = feature;
	}

	public RandomSource getRandom() {
		return this.rand;
	}

	public BlockPos getPos() {
		return this.pos;
	}

	public Holder<Feature> getFeature() {
		return this.feature;
	}

	public void setFeature(Holder<Feature> feature) {
		this.feature = feature;
	}

	public void setFeature(ResourceKey<Feature> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement BlockGrowFeatureEvent.setFeature yet");
	}

	public void setCanceled(boolean arg0) {
		ICancellableEvent.super.setCanceled(arg0);
	}
}
