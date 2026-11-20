package net.neoforged.neoforge.common.conditions;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;

/** Passes when all of {@code flags} are enabled. */
public record FeatureFlagsEnabledCondition(FeatureFlagSet flags) implements ICondition {
	public static final MapCodec<FeatureFlagsEnabledCondition> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
			FeatureFlags.CODEC.fieldOf("flags").forGetter(FeatureFlagsEnabledCondition::flags)).apply(instance, FeatureFlagsEnabledCondition::new));

	@Override
	public boolean test(IContext context) {
		return flags.isSubsetOf(context.enabledFeatures());
	}

	@Override
	public MapCodec<? extends ICondition> codec() {
		return CODEC;
	}
}
