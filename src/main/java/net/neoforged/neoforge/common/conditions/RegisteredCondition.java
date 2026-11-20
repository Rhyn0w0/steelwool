package net.neoforged.neoforge.common.conditions;

import com.mojang.serialization.MapCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisteredCondition}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record RegisteredCondition<T extends Object>(ResourceKey<T> registryKey) implements ICondition {
	public static final MapCodec<net.neoforged.neoforge.common.conditions.RegisteredCondition<?>> CODEC = null /* SteelWool: TODO */;

	private RegisteredCondition(Identifier arg0, Identifier arg1) {
		this((ResourceKey) null);
		throw new UnsupportedOperationException("SteelWool does not implement the RegisteredCondition constructor yet");
	}

	public boolean test(ICondition.IContext arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisteredCondition.test yet");
	}

	public MapCodec<? extends ICondition> codec() {
		throw new UnsupportedOperationException("SteelWool does not implement RegisteredCondition.codec yet");
	}
}
