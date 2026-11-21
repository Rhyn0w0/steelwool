package net.neoforged.neoforge.common.advancements.critereon;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.component.predicates.DataComponentPredicate;
import net.neoforged.neoforge.common.ItemAbility;

/**
 * SteelWool re-implementation of NeoForge's {@code ItemAbilityPredicate}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record ItemAbilityPredicate(ItemAbility action) implements DataComponentPredicate {
	public static final Codec<net.neoforged.neoforge.common.advancements.critereon.ItemAbilityPredicate> CODEC = null /* SteelWool: TODO */;
	public static final DataComponentPredicate.Type<net.neoforged.neoforge.common.advancements.critereon.ItemAbilityPredicate> TYPE = null /* SteelWool: TODO */;

	public boolean matches(DataComponentGetter arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemAbilityPredicate.matches yet");
	}
}
