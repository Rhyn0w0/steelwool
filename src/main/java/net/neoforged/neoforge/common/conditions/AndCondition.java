package net.neoforged.neoforge.common.conditions;

import java.util.List;

import com.mojang.serialization.MapCodec;

/**
 * SteelWool re-implementation of NeoForge's {@code AndCondition}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record AndCondition(List<ICondition> children) implements ICondition {
	public static final MapCodec<net.neoforged.neoforge.common.conditions.AndCondition> CODEC = null /* SteelWool: TODO */;

	public boolean test(ICondition.IContext arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement AndCondition.test yet");
	}

	public MapCodec<? extends ICondition> codec() {
		throw new UnsupportedOperationException("SteelWool does not implement AndCondition.codec yet");
	}
}
