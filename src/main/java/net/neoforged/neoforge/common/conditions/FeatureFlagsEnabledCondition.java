package net.neoforged.neoforge.common.conditions;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.flag.FeatureFlagSet;

/**
 * SteelWool re-implementation of NeoForge's {@code FeatureFlagsEnabledCondition}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record FeatureFlagsEnabledCondition(FeatureFlagSet flags) implements ICondition {
	public static final MapCodec<net.neoforged.neoforge.common.conditions.FeatureFlagsEnabledCondition> CODEC = null /* SteelWool: TODO */;

	public boolean test(ICondition.IContext arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement FeatureFlagsEnabledCondition.test yet");
	}

	public MapCodec<? extends ICondition> codec() {
		throw new UnsupportedOperationException("SteelWool does not implement FeatureFlagsEnabledCondition.codec yet");
	}
}
