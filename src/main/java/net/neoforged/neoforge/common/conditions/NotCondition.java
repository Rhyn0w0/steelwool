package net.neoforged.neoforge.common.conditions;

import com.mojang.serialization.MapCodec;

/**
 * SteelWool re-implementation of NeoForge's {@code NotCondition}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record NotCondition(ICondition value) implements ICondition {
	public static final MapCodec<net.neoforged.neoforge.common.conditions.NotCondition> CODEC = null /* SteelWool: TODO */;

	public boolean test(ICondition.IContext arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement NotCondition.test yet");
	}

	public MapCodec<? extends ICondition> codec() {
		throw new UnsupportedOperationException("SteelWool does not implement NotCondition.codec yet");
	}
}
