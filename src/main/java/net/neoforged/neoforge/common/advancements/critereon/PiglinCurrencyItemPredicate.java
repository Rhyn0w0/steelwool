package net.neoforged.neoforge.common.advancements.critereon;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.component.predicates.DataComponentPredicate;

/**
 * SteelWool re-implementation of NeoForge's {@code PiglinCurrencyItemPredicate}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class PiglinCurrencyItemPredicate implements DataComponentPredicate {
	public static final net.neoforged.neoforge.common.advancements.critereon.PiglinCurrencyItemPredicate INSTANCE = null /* SteelWool: TODO */;
	public static final Codec<net.neoforged.neoforge.common.advancements.critereon.PiglinCurrencyItemPredicate> CODEC = null /* SteelWool: TODO */;
	public static final DataComponentPredicate.Type<net.neoforged.neoforge.common.advancements.critereon.PiglinCurrencyItemPredicate> TYPE = null /* SteelWool: TODO */;

	private PiglinCurrencyItemPredicate() {
		super();
	}

	public boolean matches(DataComponentGetter arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement PiglinCurrencyItemPredicate.matches yet");
	}
}
