package net.neoforged.neoforge.registries.datamaps.builtin;

import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

/**
 * SteelWool re-implementation of NeoForge's {@code RaidHeroGift}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record RaidHeroGift(ResourceKey<LootTable> lootTable) {
	public static final Codec<net.neoforged.neoforge.registries.datamaps.builtin.RaidHeroGift> LOOT_TABLE_CODEC = null /* SteelWool: TODO */;
	public static final Codec<net.neoforged.neoforge.registries.datamaps.builtin.RaidHeroGift> CODEC = null /* SteelWool: TODO */;
}
