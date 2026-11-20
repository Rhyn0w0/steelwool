package net.neoforged.neoforge.common.loot;

import java.util.Optional;

import com.mojang.datafixers.Products;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

/**
 * SteelWool re-implementation of NeoForge's {@code LootModifier}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class LootModifier implements IGlobalLootModifier {
	protected final Optional<Holder<LootItemCondition>> condition;
	protected final int priority;

	protected static <T extends net.neoforged.neoforge.common.loot.LootModifier> Products.P2<RecordCodecBuilder.Mu<T>, Optional<Holder<LootItemCondition>>, Integer> codecStart(RecordCodecBuilder.Instance<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement LootModifier.codecStart yet");
	}

	protected LootModifier(Optional<Holder<LootItemCondition>> condition, int priority) {
		super();
		this.condition = condition;
		this.priority = priority;
	}

	public final ObjectArrayList<ItemStack> apply(ObjectArrayList<ItemStack> arg0, LootContext arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LootModifier.apply yet");
	}

	public int priority() {
		return this.priority;
	}

	protected abstract ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> arg0, LootContext arg1);
}
