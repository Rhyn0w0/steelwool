package net.neoforged.neoforge.registries.datamaps.builtin;

import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.villager.VillagerType;

/**
 * SteelWool re-implementation of NeoForge's {@code BiomeVillagerType}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record BiomeVillagerType(ResourceKey<VillagerType> type) {
	public static final Codec<net.neoforged.neoforge.registries.datamaps.builtin.BiomeVillagerType> TYPE_CODEC = null /* SteelWool: TODO */;
	public static final Codec<net.neoforged.neoforge.registries.datamaps.builtin.BiomeVillagerType> CODEC = null /* SteelWool: TODO */;
}
