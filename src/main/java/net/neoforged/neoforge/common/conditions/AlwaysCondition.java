package net.neoforged.neoforge.common.conditions;

import com.mojang.serialization.MapCodec;

/**
 * SteelWool re-implementation of NeoForge's {@code AlwaysCondition}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class AlwaysCondition implements ICondition {
	public static final net.neoforged.neoforge.common.conditions.AlwaysCondition INSTANCE = null /* SteelWool: TODO */;
	public static MapCodec<net.neoforged.neoforge.common.conditions.AlwaysCondition> CODEC;

	private AlwaysCondition() {
		super();
	}

	public boolean test(ICondition.IContext arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement AlwaysCondition.test yet");
	}

	public MapCodec<? extends ICondition> codec() {
		throw new UnsupportedOperationException("SteelWool does not implement AlwaysCondition.codec yet");
	}

	public String toString() {
		throw new UnsupportedOperationException("SteelWool does not implement AlwaysCondition.toString yet");
	}
}
