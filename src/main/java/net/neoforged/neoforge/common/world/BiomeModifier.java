package net.neoforged.neoforge.common.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.level.biome.Biome;

/**
 * SteelWool re-implementation of NeoForge's {@code BiomeModifier}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface BiomeModifier {
	public static final Codec<net.neoforged.neoforge.common.world.BiomeModifier> DIRECT_CODEC = null /* SteelWool: TODO */;
	public static final Codec<Holder<net.neoforged.neoforge.common.world.BiomeModifier>> REFERENCE_CODEC = null /* SteelWool: TODO */;
	public static final Codec<HolderSet<net.neoforged.neoforge.common.world.BiomeModifier>> LIST_CODEC = null /* SteelWool: TODO */;

	void modify(RegistryAccess arg0, Holder<Biome> arg1, net.neoforged.neoforge.common.world.BiomeModifier.Phase arg2, ModifiableBiomeInfo.BiomeInfo.Builder arg3);

	MapCodec<? extends net.neoforged.neoforge.common.world.BiomeModifier> codec();

	public enum Phase {
		BEFORE_EVERYTHING, ADD, REMOVE, MODIFY, AFTER_EVERYTHING;
	}
}
