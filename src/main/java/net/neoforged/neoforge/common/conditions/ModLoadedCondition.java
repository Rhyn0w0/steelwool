package net.neoforged.neoforge.common.conditions;

import com.mojang.serialization.MapCodec;

/**
 * SteelWool re-implementation of NeoForge's {@code ModLoadedCondition}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record ModLoadedCondition(String modid) implements ICondition {
	public static MapCodec<net.neoforged.neoforge.common.conditions.ModLoadedCondition> CODEC;

	public boolean test(ICondition.IContext arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoadedCondition.test yet");
	}

	public MapCodec<? extends ICondition> codec() {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoadedCondition.codec yet");
	}
}
