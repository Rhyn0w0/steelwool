package net.neoforged.neoforge.common.conditions;

import com.mojang.serialization.MapCodec;

/**
 * SteelWool re-implementation of NeoForge's {@code NeverCondition}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class NeverCondition implements ICondition {
	public static final net.neoforged.neoforge.common.conditions.NeverCondition INSTANCE = null /* SteelWool: TODO */;
	public static final MapCodec<net.neoforged.neoforge.common.conditions.NeverCondition> CODEC = null /* SteelWool: TODO */;

	private NeverCondition() {
		super();
	}

	public boolean test(ICondition.IContext arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement NeverCondition.test yet");
	}

	public MapCodec<? extends ICondition> codec() {
		throw new UnsupportedOperationException("SteelWool does not implement NeverCondition.codec yet");
	}

	public String toString() {
		throw new UnsupportedOperationException("SteelWool does not implement NeverCondition.toString yet");
	}
}
