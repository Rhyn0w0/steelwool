package net.neoforged.neoforge.common.loot;

import java.util.Optional;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.neoforged.neoforge.common.conditions.WithConditions;

/**
 * SteelWool re-implementation of NeoForge's {@code IGlobalLootModifier}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IGlobalLootModifier {
	public static final Codec<net.neoforged.neoforge.common.loot.IGlobalLootModifier> DIRECT_CODEC = null /* SteelWool: TODO */;
	public static final Codec<Optional<WithConditions<net.neoforged.neoforge.common.loot.IGlobalLootModifier>>> CONDITIONAL_CODEC = null /* SteelWool: TODO */;
	public static final int DEFAULT_PRIORITY = 1000;

	ObjectArrayList<ItemStack> apply(ObjectArrayList<ItemStack> arg0, LootContext arg1);

	MapCodec<? extends net.neoforged.neoforge.common.loot.IGlobalLootModifier> codec();

	int priority();
}
