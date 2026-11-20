package net.neoforged.neoforge.common.conditions;

import com.mojang.serialization.MapCodec;

/** Always fails. */
public final class NeverCondition implements ICondition {
	public static final NeverCondition INSTANCE = new NeverCondition();
	public static MapCodec<NeverCondition> CODEC = MapCodec.unit(INSTANCE).stable();

	private NeverCondition() {
	}

	@Override
	public boolean test(IContext context) {
		return false;
	}

	@Override
	public MapCodec<? extends ICondition> codec() {
		return CODEC;
	}

	@Override
	public String toString() {
		return "false";
	}
}
