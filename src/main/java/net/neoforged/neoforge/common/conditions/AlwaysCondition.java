package net.neoforged.neoforge.common.conditions;

import com.mojang.serialization.MapCodec;

/** Always passes. */
public final class AlwaysCondition implements ICondition {
	public static final AlwaysCondition INSTANCE = new AlwaysCondition();
	public static MapCodec<AlwaysCondition> CODEC = MapCodec.unit(INSTANCE).stable();

	private AlwaysCondition() {
	}

	@Override
	public boolean test(IContext context) {
		return true;
	}

	@Override
	public MapCodec<? extends ICondition> codec() {
		return CODEC;
	}

	@Override
	public String toString() {
		return "true";
	}
}
