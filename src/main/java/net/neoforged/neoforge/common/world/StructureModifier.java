package net.neoforged.neoforge.common.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.level.levelgen.structure.Structure;

/**
 * SteelWool re-implementation of NeoForge's {@code StructureModifier}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface StructureModifier {
	public static final Codec<net.neoforged.neoforge.common.world.StructureModifier> DIRECT_CODEC = null /* SteelWool: TODO */;
	public static final Codec<Holder<net.neoforged.neoforge.common.world.StructureModifier>> REFERENCE_CODEC = null /* SteelWool: TODO */;
	public static final Codec<HolderSet<net.neoforged.neoforge.common.world.StructureModifier>> LIST_CODEC = null /* SteelWool: TODO */;

	void modify(RegistryAccess arg0, Holder<Structure> arg1, net.neoforged.neoforge.common.world.StructureModifier.Phase arg2, ModifiableStructureInfo.StructureInfo.Builder arg3);

	MapCodec<? extends net.neoforged.neoforge.common.world.StructureModifier> codec();

	public enum Phase {
		BEFORE_EVERYTHING, ADD, REMOVE, MODIFY, AFTER_EVERYTHING;
	}
}
