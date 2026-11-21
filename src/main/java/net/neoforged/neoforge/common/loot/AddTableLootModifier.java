package net.neoforged.neoforge.common.loot;

import java.util.Optional;

import com.mojang.serialization.MapCodec;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

/**
 * SteelWool re-implementation of NeoForge's {@code AddTableLootModifier}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class AddTableLootModifier extends LootModifier {
	public static final MapCodec<net.neoforged.neoforge.common.loot.AddTableLootModifier> CODEC = null /* SteelWool: TODO */;
	private final ResourceKey<LootTable> table;

	public AddTableLootModifier(Optional<Holder<LootItemCondition>> arg0, int arg1, ResourceKey<LootTable> table) {
		super(arg0, arg1);
		this.table = table;
	}

	public ResourceKey<LootTable> table() {
		return this.table;
	}

	protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> arg0, LootContext arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement AddTableLootModifier.doApply yet");
	}

	public MapCodec<? extends IGlobalLootModifier> codec() {
		throw new UnsupportedOperationException("SteelWool does not implement AddTableLootModifier.codec yet");
	}
}
