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

	protected static <T extends net.neoforged.neoforge.common.loot.LootModifier> Products.P2<RecordCodecBuilder.Mu<T>, Optional<Holder<LootItemCondition>>, Integer> codecStart(RecordCodecBuilder.Instance<T> instance) {
		return instance.group(
				LootItemCondition.CODEC.optionalFieldOf("condition").forGetter(modifier -> modifier.condition),
				com.mojang.serialization.Codec.INT.optionalFieldOf("priority", IGlobalLootModifier.DEFAULT_PRIORITY).forGetter(modifier -> modifier.priority));
	}

	protected LootModifier(Optional<Holder<LootItemCondition>> condition, int priority) {
		super();
		this.condition = condition;
		this.priority = priority;
	}

	/** Runs {@link #doApply} when there is no condition or the condition passes. */
	public final ObjectArrayList<ItemStack> apply(ObjectArrayList<ItemStack> loot, LootContext context) {
		if (condition.isPresent() && !condition.get().value().test(context)) {
			return loot;
		}
		return doApply(loot, context);
	}

	public int priority() {
		return this.priority;
	}

	protected abstract ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> arg0, LootContext arg1);
}
