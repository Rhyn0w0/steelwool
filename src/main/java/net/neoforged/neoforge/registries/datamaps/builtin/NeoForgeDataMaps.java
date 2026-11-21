package net.neoforged.neoforge.registries.datamaps.builtin;

import net.minecraft.core.component.BlockTransformer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.registries.datamaps.DataMapType;
import net.neoforged.neoforge.registries.datamaps.RegisterDataMapTypesEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code NeoForgeDataMaps}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class NeoForgeDataMaps {
	public static final DataMapType<EntityType<?>, AcceptableVillagerDistance> ACCEPTABLE_VILLAGER_DISTANCES = null /* SteelWool: TODO */;
	public static final DataMapType<BlockTransformer, BlockTransformAppender> BLOCK_TRANSFORM_APPENDERS = null /* SteelWool: TODO */;
	public static final DataMapType<EntityType<?>, MonsterRoomMob> MONSTER_ROOM_MOBS = null /* SteelWool: TODO */;
	public static final DataMapType<Block, Oxidizable> OXIDIZABLES = null /* SteelWool: TODO */;
	public static final DataMapType<EntityType<?>, ParrotImitation> PARROT_IMITATIONS = null /* SteelWool: TODO */;
	public static final DataMapType<VillagerProfession, RaidHeroGift> RAID_HERO_GIFTS = null /* SteelWool: TODO */;
	public static final DataMapType<Block, Transformable> TRANSFORMABLES = null /* SteelWool: TODO */;
	public static final DataMapType<GameEvent, VibrationFrequency> VIBRATION_FREQUENCIES = null /* SteelWool: TODO */;
	public static final DataMapType<Item, VillagerCompostable> VILLAGER_COMPOSTABLES = null /* SteelWool: TODO */;
	public static final DataMapType<Biome, BiomeVillagerType> VILLAGER_TYPES = null /* SteelWool: TODO */;
	public static final DataMapType<Block, Waxable> WAXABLES = null /* SteelWool: TODO */;
	public static final DataMapType<Block, Flammable> FLAMMABLE = null /* SteelWool: TODO */;

	public NeoForgeDataMaps() {
		super();
	}

	private static Identifier id(String arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement NeoForgeDataMaps.id yet");
	}

	private static void register(RegisterDataMapTypesEvent arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement NeoForgeDataMaps.register yet");
	}
}
