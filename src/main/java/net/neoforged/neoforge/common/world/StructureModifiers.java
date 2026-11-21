package net.neoforged.neoforge.common.world;

import java.util.Set;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryAccess;
import net.minecraft.util.random.Weighted;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.structure.Structure;

/**
 * SteelWool re-implementation of NeoForge's {@code StructureModifiers}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class StructureModifiers {
	private StructureModifiers() {
		super();
	}

	public static record AddSpawnsStructureModifier(HolderSet<Structure> structures, WeightedList<MobSpawnSettings.SpawnerData> spawners) implements StructureModifier {
		public static net.neoforged.neoforge.common.world.StructureModifiers.AddSpawnsStructureModifier singleSpawn(HolderSet<Structure> arg0, Weighted<MobSpawnSettings.SpawnerData> arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement StructureModifiers.AddSpawnsStructureModifier.singleSpawn yet");
		}

		public void modify(RegistryAccess arg0, Holder<Structure> arg1, StructureModifier.Phase arg2, ModifiableStructureInfo.StructureInfo.Builder arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement StructureModifiers.AddSpawnsStructureModifier.modify yet");
		}

		public MapCodec<? extends StructureModifier> codec() {
			throw new UnsupportedOperationException("SteelWool does not implement StructureModifiers.AddSpawnsStructureModifier.codec yet");
		}
	}

	public static record ClearSpawnsStructureModifier(HolderSet<Structure> structures, Set<MobCategory> categories) implements StructureModifier {
		public void modify(RegistryAccess arg0, Holder<Structure> arg1, StructureModifier.Phase arg2, ModifiableStructureInfo.StructureInfo.Builder arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement StructureModifiers.ClearSpawnsStructureModifier.modify yet");
		}

		public MapCodec<? extends StructureModifier> codec() {
			throw new UnsupportedOperationException("SteelWool does not implement StructureModifiers.ClearSpawnsStructureModifier.codec yet");
		}
	}

	public static record RemoveSpawnsStructureModifier(HolderSet<Structure> structures, HolderSet<EntityType<?>> entityTypes) implements StructureModifier {
		public void modify(RegistryAccess arg0, Holder<Structure> arg1, StructureModifier.Phase arg2, ModifiableStructureInfo.StructureInfo.Builder arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement StructureModifiers.RemoveSpawnsStructureModifier.modify yet");
		}

		public MapCodec<? extends StructureModifier> codec() {
			throw new UnsupportedOperationException("SteelWool does not implement StructureModifiers.RemoveSpawnsStructureModifier.codec yet");
		}
	}
}
