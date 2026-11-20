package net.neoforged.neoforge.common.conditions;

import com.mojang.serialization.MapCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;

/**
 * SteelWool re-implementation of NeoForge's {@code TagEmptyCondition}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record TagEmptyCondition<T extends Object>(TagKey<T> tag) implements ICondition {
	public static final MapCodec<net.neoforged.neoforge.common.conditions.TagEmptyCondition<?>> CODEC = null /* SteelWool: TODO */;

	private TagEmptyCondition(Identifier arg0, Identifier arg1) {
		this((TagKey) null);
		throw new UnsupportedOperationException("SteelWool does not implement the TagEmptyCondition constructor yet");
	}

	public boolean test(ICondition.IContext arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement TagEmptyCondition.test yet");
	}

	public MapCodec<? extends ICondition> codec() {
		throw new UnsupportedOperationException("SteelWool does not implement TagEmptyCondition.codec yet");
	}
}
