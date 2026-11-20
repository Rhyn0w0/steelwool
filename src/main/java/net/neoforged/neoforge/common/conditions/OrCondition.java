package net.neoforged.neoforge.common.conditions;

import java.util.List;

import com.mojang.serialization.MapCodec;

/**
 * SteelWool re-implementation of NeoForge's {@code OrCondition}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record OrCondition(List<ICondition> values) implements ICondition {
	public static final MapCodec<net.neoforged.neoforge.common.conditions.OrCondition> CODEC = null /* SteelWool: TODO */;

	public boolean test(ICondition.IContext arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement OrCondition.test yet");
	}

	public MapCodec<? extends ICondition> codec() {
		throw new UnsupportedOperationException("SteelWool does not implement OrCondition.codec yet");
	}
}
