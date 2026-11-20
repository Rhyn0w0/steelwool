package net.neoforged.neoforge.common.loot;

import java.util.Set;

import com.mojang.serialization.MapCodec;
import net.minecraft.util.context.ContextKey;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.ItemAbility;

/**
 * SteelWool re-implementation of NeoForge's {@code CanItemPerformAbility}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class CanItemPerformAbility implements LootItemCondition {
	public static MapCodec<net.neoforged.neoforge.common.loot.CanItemPerformAbility> CODEC;
	final ItemAbility ability;

	public CanItemPerformAbility(ItemAbility ability) {
		super();
		this.ability = ability;
	}

	public MapCodec<? extends LootItemCondition> codec() {
		throw new UnsupportedOperationException("SteelWool does not implement CanItemPerformAbility.codec yet");
	}

	public Set<ContextKey<?>> getReferencedContextParams() {
		throw new UnsupportedOperationException("SteelWool does not implement CanItemPerformAbility.getReferencedContextParams yet");
	}

	public boolean test(LootContext arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CanItemPerformAbility.test yet");
	}

	public static LootItemCondition.Builder canItemPerformAbility(ItemAbility arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CanItemPerformAbility.canItemPerformAbility yet");
	}
}
