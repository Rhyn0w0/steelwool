package net.neoforged.neoforge.common;

import net.minecraft.tags.BlockItemTagId;
import net.minecraft.tags.TagKey;
import net.minecraft.world.clock.WorldClock;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ColorCollection;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.material.Fluid;

/**
 * SteelWool re-implementation of NeoForge's {@code Tags}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class Tags {
	public Tags() {
		super();
	}

	public static String getTagTranslationKey(TagKey<?> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement Tags.getTagTranslationKey yet");
	}

	public static class Biomes {
		public static final TagKey<Biome> NO_DEFAULT_MONSTERS = null /* SteelWool: TODO */;
		public static final TagKey<Biome> HIDDEN_FROM_LOCATOR_SELECTION = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_VOID = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_HOT = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_HOT_OVERWORLD = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_HOT_NETHER = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_HOT_END = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_TEMPERATE = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_TEMPERATE_OVERWORLD = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_TEMPERATE_NETHER = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_TEMPERATE_END = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_COLD = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_COLD_OVERWORLD = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_COLD_NETHER = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_COLD_END = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_SPARSE_VEGETATION = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_SPARSE_VEGETATION_OVERWORLD = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_SPARSE_VEGETATION_NETHER = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_SPARSE_VEGETATION_END = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_DENSE_VEGETATION = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_DENSE_VEGETATION_OVERWORLD = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_DENSE_VEGETATION_NETHER = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_DENSE_VEGETATION_END = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_WET = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_WET_OVERWORLD = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_WET_NETHER = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_WET_END = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_DRY = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_DRY_OVERWORLD = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_DRY_NETHER = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_DRY_END = null /* SteelWool: TODO */;
		public static final TagKey<Biome> PRIMARY_WOOD_TYPE = null /* SteelWool: TODO */;
		public static final TagKey<Biome> PRIMARY_WOOD_TYPE_OAK = null /* SteelWool: TODO */;
		public static final TagKey<Biome> PRIMARY_WOOD_TYPE_BIRCH = null /* SteelWool: TODO */;
		public static final TagKey<Biome> PRIMARY_WOOD_TYPE_SPRUCE = null /* SteelWool: TODO */;
		public static final TagKey<Biome> PRIMARY_WOOD_TYPE_JUNGLE = null /* SteelWool: TODO */;
		public static final TagKey<Biome> PRIMARY_WOOD_TYPE_ACACIA = null /* SteelWool: TODO */;
		public static final TagKey<Biome> PRIMARY_WOOD_TYPE_DARK_OAK = null /* SteelWool: TODO */;
		public static final TagKey<Biome> PRIMARY_WOOD_TYPE_POPLAR = null /* SteelWool: TODO */;
		public static final TagKey<Biome> PRIMARY_WOOD_TYPE_MANGROVE = null /* SteelWool: TODO */;
		public static final TagKey<Biome> PRIMARY_WOOD_TYPE_CHERRY = null /* SteelWool: TODO */;
		public static final TagKey<Biome> PRIMARY_WOOD_TYPE_PALE_OAK = null /* SteelWool: TODO */;
		public static final TagKey<Biome> PRIMARY_WOOD_TYPE_BAMBOO = null /* SteelWool: TODO */;
		public static final TagKey<Biome> PRIMARY_WOOD_TYPE_CRIMSON = null /* SteelWool: TODO */;
		public static final TagKey<Biome> PRIMARY_WOOD_TYPE_WARPED = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_OVERWORLD = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_CONIFEROUS_TREE = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_SAVANNA_TREE = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_JUNGLE_TREE = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_DECIDUOUS_TREE = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_MOUNTAIN = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_MOUNTAIN_PEAK = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_MOUNTAIN_SLOPE = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_PLAINS = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_SNOWY_PLAINS = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_FOREST = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_BIRCH_FOREST = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_DARK_FOREST = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_FLOWER_FOREST = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_TAIGA = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_OLD_GROWTH = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_HILL = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_WINDSWEPT = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_JUNGLE = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_SAVANNA = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_SWAMP = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_DESERT = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_BADLANDS = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_BEACH = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_STONY_SHORES = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_MUSHROOM = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_RIVER = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_OCEAN = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_DEEP_OCEAN = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_SHALLOW_OCEAN = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_UNDERGROUND = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_CAVE = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_LUSH = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_MAGICAL = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_RARE = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_PLATEAU = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_SPOOKY = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_WASTELAND = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_DEAD = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_FLORAL = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_SANDY = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_SNOWY = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_ICY = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_AQUATIC = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_AQUATIC_ICY = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_NETHER = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_NETHER_FOREST = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_END = null /* SteelWool: TODO */;
		public static final TagKey<Biome> IS_OUTER_END_ISLAND = null /* SteelWool: TODO */;

		public Biomes() {
			super();
		}

		private static TagKey<Biome> tag(String arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement Tags.Biomes.tag yet");
		}
	}

	public static class BlockItems {
		public static final BlockItemTagId BARRELS = null /* SteelWool: TODO */;
		public static final BlockItemTagId BARRELS_WOODEN = null /* SteelWool: TODO */;
		public static final BlockItemTagId BARS = null /* SteelWool: TODO */;
		public static final BlockItemTagId BARS_COPPER = null /* SteelWool: TODO */;
		public static final BlockItemTagId BARS_IRON = null /* SteelWool: TODO */;
		public static final BlockItemTagId BOOKSHELVES = null /* SteelWool: TODO */;
		public static final BlockItemTagId BUDDING_BLOCKS = null /* SteelWool: TODO */;
		public static final BlockItemTagId BUDS = null /* SteelWool: TODO */;
		public static final BlockItemTagId CHAINS = null /* SteelWool: TODO */;
		public static final BlockItemTagId CHESTS = null /* SteelWool: TODO */;
		public static final BlockItemTagId CHESTS_ENDER = null /* SteelWool: TODO */;
		public static final BlockItemTagId CHESTS_TRAPPED = null /* SteelWool: TODO */;
		public static final BlockItemTagId CHESTS_WOODEN = null /* SteelWool: TODO */;
		public static final BlockItemTagId CLUSTERS = null /* SteelWool: TODO */;
		public static final BlockItemTagId COBBLESTONES = null /* SteelWool: TODO */;
		public static final BlockItemTagId COBBLESTONES_NORMAL = null /* SteelWool: TODO */;
		public static final BlockItemTagId COBBLESTONES_INFESTED = null /* SteelWool: TODO */;
		public static final BlockItemTagId COBBLESTONES_MOSSY = null /* SteelWool: TODO */;
		public static final BlockItemTagId COBBLESTONES_DEEPSLATE = null /* SteelWool: TODO */;
		public static final BlockItemTagId CONCRETES = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYED = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYED_BLACK = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYED_BLUE = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYED_BROWN = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYED_CYAN = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYED_GRAY = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYED_GREEN = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYED_LIGHT_BLUE = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYED_LIGHT_GRAY = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYED_LIME = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYED_MAGENTA = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYED_ORANGE = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYED_PINK = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYED_PURPLE = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYED_RED = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYED_WHITE = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYED_YELLOW = null /* SteelWool: TODO */;
		public static final ColorCollection<BlockItemTagId> DYED_COLORS = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYEABLE_UNDYED_SIMPLE = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYEABLE_REDYEABLE_SIMPLE = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYEABLE_SIMPLE = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYEABLE_DYNAMIC = null /* SteelWool: TODO */;
		public static final BlockItemTagId DYEABLE = null /* SteelWool: TODO */;
		public static final BlockItemTagId END_STONES = null /* SteelWool: TODO */;
		public static final BlockItemTagId FENCE_GATES = null /* SteelWool: TODO */;
		public static final BlockItemTagId FENCE_GATES_WOODEN = null /* SteelWool: TODO */;
		public static final BlockItemTagId FENCES = null /* SteelWool: TODO */;
		public static final BlockItemTagId FENCES_NETHER_BRICK = null /* SteelWool: TODO */;
		public static final BlockItemTagId FENCES_WOODEN = null /* SteelWool: TODO */;
		public static final BlockItemTagId FLOWERS_SMALL = null /* SteelWool: TODO */;
		public static final BlockItemTagId FLOWERS_TALL = null /* SteelWool: TODO */;
		public static final BlockItemTagId FLOWERS = null /* SteelWool: TODO */;
		public static final BlockItemTagId FROGLIGHTS = null /* SteelWool: TODO */;
		public static final BlockItemTagId GLASS_BLOCKS = null /* SteelWool: TODO */;
		public static final BlockItemTagId GLASS_BLOCKS_COLORLESS = null /* SteelWool: TODO */;
		public static final BlockItemTagId GLASS_BLOCKS_CHEAP = null /* SteelWool: TODO */;
		public static final BlockItemTagId GLASS_BLOCKS_TINTED = null /* SteelWool: TODO */;
		public static final BlockItemTagId GLASS_PANES = null /* SteelWool: TODO */;
		public static final BlockItemTagId GLASS_PANES_COLORLESS = null /* SteelWool: TODO */;
		public static final BlockItemTagId GLAZED_TERRACOTTAS = null /* SteelWool: TODO */;
		public static final BlockItemTagId GRAVELS = null /* SteelWool: TODO */;
		public static final BlockItemTagId ICE = null /* SteelWool: TODO */;
		public static final BlockItemTagId NETHERRACKS = null /* SteelWool: TODO */;
		public static final BlockItemTagId OBSIDIANS = null /* SteelWool: TODO */;
		public static final BlockItemTagId OBSIDIANS_NORMAL = null /* SteelWool: TODO */;
		public static final BlockItemTagId OBSIDIANS_CRYING = null /* SteelWool: TODO */;
		public static final BlockItemTagId ORE_BEARING_GROUND_DEEPSLATE = null /* SteelWool: TODO */;
		public static final BlockItemTagId ORE_BEARING_GROUND_NETHERRACK = null /* SteelWool: TODO */;
		public static final BlockItemTagId ORE_BEARING_GROUND_STONE = null /* SteelWool: TODO */;
		public static final BlockItemTagId ORE_RATES_DENSE = null /* SteelWool: TODO */;
		public static final BlockItemTagId ORE_RATES_SINGULAR = null /* SteelWool: TODO */;
		public static final BlockItemTagId ORE_RATES_SPARSE = null /* SteelWool: TODO */;
		public static final BlockItemTagId ORES = null /* SteelWool: TODO */;
		public static final BlockItemTagId ORES_COAL = null /* SteelWool: TODO */;
		public static final BlockItemTagId ORES_COPPER = null /* SteelWool: TODO */;
		public static final BlockItemTagId ORES_DIAMOND = null /* SteelWool: TODO */;
		public static final BlockItemTagId ORES_EMERALD = null /* SteelWool: TODO */;
		public static final BlockItemTagId ORES_GOLD = null /* SteelWool: TODO */;
		public static final BlockItemTagId ORES_IRON = null /* SteelWool: TODO */;
		public static final BlockItemTagId ORES_LAPIS = null /* SteelWool: TODO */;
		public static final BlockItemTagId ORES_NETHERITE_SCRAP = null /* SteelWool: TODO */;
		public static final BlockItemTagId ORES_QUARTZ = null /* SteelWool: TODO */;
		public static final BlockItemTagId ORES_REDSTONE = null /* SteelWool: TODO */;
		public static final BlockItemTagId ORES_IN_GROUND_DEEPSLATE = null /* SteelWool: TODO */;
		public static final BlockItemTagId ORES_IN_GROUND_NETHERRACK = null /* SteelWool: TODO */;
		public static final BlockItemTagId ORES_IN_GROUND_STONE = null /* SteelWool: TODO */;
		public static final BlockItemTagId PUMPKINS = null /* SteelWool: TODO */;
		public static final BlockItemTagId PUMPKINS_NORMAL = null /* SteelWool: TODO */;
		public static final BlockItemTagId PUMPKINS_CARVED = null /* SteelWool: TODO */;
		public static final BlockItemTagId PUMPKINS_JACK_O_LANTERNS = null /* SteelWool: TODO */;
		public static final BlockItemTagId PLAYER_WORKSTATIONS_CRAFTING_TABLES = null /* SteelWool: TODO */;
		public static final BlockItemTagId PLAYER_WORKSTATIONS_FURNACES = null /* SteelWool: TODO */;
		public static final BlockItemTagId ROPES = null /* SteelWool: TODO */;
		public static final BlockItemTagId SANDS = null /* SteelWool: TODO */;
		public static final BlockItemTagId SANDS_COLORLESS = null /* SteelWool: TODO */;
		public static final BlockItemTagId SANDS_RED = null /* SteelWool: TODO */;
		public static final BlockItemTagId SANDSTONE_BLOCKS = null /* SteelWool: TODO */;
		public static final BlockItemTagId SANDSTONE_SLABS = null /* SteelWool: TODO */;
		public static final BlockItemTagId SANDSTONE_STAIRS = null /* SteelWool: TODO */;
		public static final BlockItemTagId SANDSTONE_RED_BLOCKS = null /* SteelWool: TODO */;
		public static final BlockItemTagId SANDSTONE_RED_SLABS = null /* SteelWool: TODO */;
		public static final BlockItemTagId SANDSTONE_RED_STAIRS = null /* SteelWool: TODO */;
		public static final BlockItemTagId SANDSTONE_UNCOLORED_BLOCKS = null /* SteelWool: TODO */;
		public static final BlockItemTagId SANDSTONE_UNCOLORED_SLABS = null /* SteelWool: TODO */;
		public static final BlockItemTagId SANDSTONE_UNCOLORED_STAIRS = null /* SteelWool: TODO */;
		public static final BlockItemTagId STONES = null /* SteelWool: TODO */;
		public static final BlockItemTagId STORAGE_BLOCKS = null /* SteelWool: TODO */;
		public static final BlockItemTagId STORAGE_BLOCKS_BONE_MEAL = null /* SteelWool: TODO */;
		public static final BlockItemTagId STORAGE_BLOCKS_COAL = null /* SteelWool: TODO */;
		public static final BlockItemTagId STORAGE_BLOCKS_COPPER = null /* SteelWool: TODO */;
		public static final BlockItemTagId STORAGE_BLOCKS_DIAMOND = null /* SteelWool: TODO */;
		public static final BlockItemTagId STORAGE_BLOCKS_DRIED_KELP = null /* SteelWool: TODO */;
		public static final BlockItemTagId STORAGE_BLOCKS_EMERALD = null /* SteelWool: TODO */;
		public static final BlockItemTagId STORAGE_BLOCKS_GOLD = null /* SteelWool: TODO */;
		public static final BlockItemTagId STORAGE_BLOCKS_IRON = null /* SteelWool: TODO */;
		public static final BlockItemTagId STORAGE_BLOCKS_LAPIS = null /* SteelWool: TODO */;
		public static final BlockItemTagId STORAGE_BLOCKS_NETHERITE = null /* SteelWool: TODO */;
		public static final BlockItemTagId STORAGE_BLOCKS_RAW_COPPER = null /* SteelWool: TODO */;
		public static final BlockItemTagId STORAGE_BLOCKS_RAW_GOLD = null /* SteelWool: TODO */;
		public static final BlockItemTagId STORAGE_BLOCKS_RAW_IRON = null /* SteelWool: TODO */;
		public static final BlockItemTagId STORAGE_BLOCKS_REDSTONE = null /* SteelWool: TODO */;
		public static final BlockItemTagId STORAGE_BLOCKS_RESIN = null /* SteelWool: TODO */;
		public static final BlockItemTagId STORAGE_BLOCKS_SLIME = null /* SteelWool: TODO */;
		public static final BlockItemTagId STORAGE_BLOCKS_WHEAT = null /* SteelWool: TODO */;
		public static final BlockItemTagId OVERWORLD_NATURAL_LOGS = null /* SteelWool: TODO */;
		public static final BlockItemTagId NETHER_NATURAL_LOGS = null /* SteelWool: TODO */;
		public static final BlockItemTagId NATURAL_LOGS = null /* SteelWool: TODO */;
		public static final BlockItemTagId NATURAL_WOODS = null /* SteelWool: TODO */;
		public static final BlockItemTagId STRIPPED_LOGS = null /* SteelWool: TODO */;
		public static final BlockItemTagId STRIPPED_WOODS = null /* SteelWool: TODO */;

		public BlockItems() {
			super();
		}

		private static BlockItemTagId tag(String arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement Tags.BlockItems.tag yet");
		}
	}

	public static class Blocks {
		public static final TagKey<Block> ENDERMAN_PLACE_ON_BLACKLIST = null /* SteelWool: TODO */;
		public static final TagKey<Block> NEEDS_WOOD_TOOL = null /* SteelWool: TODO */;
		public static final TagKey<Block> NEEDS_GOLD_TOOL = null /* SteelWool: TODO */;
		public static final TagKey<Block> NEEDS_NETHERITE_TOOL = null /* SteelWool: TODO */;
		public static final TagKey<Block> HIDDEN_FROM_RECIPE_VIEWERS = null /* SteelWool: TODO */;
		public static final TagKey<Block> RELOCATION_NOT_SUPPORTED = null /* SteelWool: TODO */;
		public static final TagKey<Block> SKULLS = null /* SteelWool: TODO */;
		public static final TagKey<Block> VILLAGER_JOB_SITES = null /* SteelWool: TODO */;
		public static final TagKey<Block> VILLAGER_FARMLANDS = null /* SteelWool: TODO */;
		public static final TagKey<Block> BARRELS = null /* SteelWool: TODO */;
		public static final TagKey<Block> BARRELS_WOODEN = null /* SteelWool: TODO */;
		public static final TagKey<Block> BARS = null /* SteelWool: TODO */;
		public static final TagKey<Block> BARS_COPPER = null /* SteelWool: TODO */;
		public static final TagKey<Block> BARS_IRON = null /* SteelWool: TODO */;
		public static final TagKey<Block> BOOKSHELVES = null /* SteelWool: TODO */;
		public static final TagKey<Block> BUDDING_BLOCKS = null /* SteelWool: TODO */;
		public static final TagKey<Block> BUDS = null /* SteelWool: TODO */;
		public static final TagKey<Block> CHAINS = null /* SteelWool: TODO */;
		public static final TagKey<Block> CHESTS = null /* SteelWool: TODO */;
		public static final TagKey<Block> CHESTS_ENDER = null /* SteelWool: TODO */;
		public static final TagKey<Block> CHESTS_TRAPPED = null /* SteelWool: TODO */;
		public static final TagKey<Block> CHESTS_WOODEN = null /* SteelWool: TODO */;
		public static final TagKey<Block> CLUSTERS = null /* SteelWool: TODO */;
		public static final TagKey<Block> COBBLESTONES = null /* SteelWool: TODO */;
		public static final TagKey<Block> COBBLESTONES_NORMAL = null /* SteelWool: TODO */;
		public static final TagKey<Block> COBBLESTONES_INFESTED = null /* SteelWool: TODO */;
		public static final TagKey<Block> COBBLESTONES_MOSSY = null /* SteelWool: TODO */;
		public static final TagKey<Block> COBBLESTONES_DEEPSLATE = null /* SteelWool: TODO */;
		public static final TagKey<Block> CONCRETES = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYED = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYED_BLACK = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYED_BLUE = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYED_BROWN = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYED_CYAN = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYED_GRAY = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYED_GREEN = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYED_LIGHT_BLUE = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYED_LIGHT_GRAY = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYED_LIME = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYED_MAGENTA = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYED_ORANGE = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYED_PINK = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYED_PURPLE = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYED_RED = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYED_WHITE = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYED_YELLOW = null /* SteelWool: TODO */;
		public static final ColorCollection<TagKey<Block>> DYED_COLORS = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYEABLE_UNDYED_SIMPLE = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYEABLE_REDYEABLE_SIMPLE = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYEABLE_SIMPLE = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYEABLE_DYNAMIC = null /* SteelWool: TODO */;
		public static final TagKey<Block> DYEABLE = null /* SteelWool: TODO */;
		public static final TagKey<Block> END_STONES = null /* SteelWool: TODO */;
		public static final TagKey<Block> FENCE_GATES = null /* SteelWool: TODO */;
		public static final TagKey<Block> FENCE_GATES_WOODEN = null /* SteelWool: TODO */;
		public static final TagKey<Block> FENCES = null /* SteelWool: TODO */;
		public static final TagKey<Block> FENCES_NETHER_BRICK = null /* SteelWool: TODO */;
		public static final TagKey<Block> FENCES_WOODEN = null /* SteelWool: TODO */;
		public static final TagKey<Block> FLOWERS_SMALL = null /* SteelWool: TODO */;
		public static final TagKey<Block> FLOWERS_TALL = null /* SteelWool: TODO */;
		public static final TagKey<Block> FLOWERS = null /* SteelWool: TODO */;
		public static final TagKey<Block> FROGLIGHTS = null /* SteelWool: TODO */;
		public static final TagKey<Block> GLASS_BLOCKS = null /* SteelWool: TODO */;
		public static final TagKey<Block> GLASS_BLOCKS_COLORLESS = null /* SteelWool: TODO */;
		public static final TagKey<Block> GLASS_BLOCKS_CHEAP = null /* SteelWool: TODO */;
		public static final TagKey<Block> GLASS_BLOCKS_TINTED = null /* SteelWool: TODO */;
		public static final TagKey<Block> GLASS_PANES = null /* SteelWool: TODO */;
		public static final TagKey<Block> GLASS_PANES_COLORLESS = null /* SteelWool: TODO */;
		public static final TagKey<Block> GLAZED_TERRACOTTAS = null /* SteelWool: TODO */;
		public static final TagKey<Block> GRAVELS = null /* SteelWool: TODO */;
		public static final TagKey<Block> NETHERRACKS = null /* SteelWool: TODO */;
		public static final TagKey<Block> OBSIDIANS = null /* SteelWool: TODO */;
		public static final TagKey<Block> OBSIDIANS_NORMAL = null /* SteelWool: TODO */;
		public static final TagKey<Block> OBSIDIANS_CRYING = null /* SteelWool: TODO */;
		public static final TagKey<Block> ORE_BEARING_GROUND_DEEPSLATE = null /* SteelWool: TODO */;
		public static final TagKey<Block> ORE_BEARING_GROUND_NETHERRACK = null /* SteelWool: TODO */;
		public static final TagKey<Block> ORE_BEARING_GROUND_STONE = null /* SteelWool: TODO */;
		public static final TagKey<Block> ORE_RATES_DENSE = null /* SteelWool: TODO */;
		public static final TagKey<Block> ORE_RATES_SINGULAR = null /* SteelWool: TODO */;
		public static final TagKey<Block> ORE_RATES_SPARSE = null /* SteelWool: TODO */;
		public static final TagKey<Block> ORES = null /* SteelWool: TODO */;
		public static final TagKey<Block> ORES_COAL = null /* SteelWool: TODO */;
		public static final TagKey<Block> ORES_COPPER = null /* SteelWool: TODO */;
		public static final TagKey<Block> ORES_DIAMOND = null /* SteelWool: TODO */;
		public static final TagKey<Block> ORES_EMERALD = null /* SteelWool: TODO */;
		public static final TagKey<Block> ORES_GOLD = null /* SteelWool: TODO */;
		public static final TagKey<Block> ORES_IRON = null /* SteelWool: TODO */;
		public static final TagKey<Block> ORES_LAPIS = null /* SteelWool: TODO */;
		public static final TagKey<Block> ORES_NETHERITE_SCRAP = null /* SteelWool: TODO */;
		public static final TagKey<Block> ORES_QUARTZ = null /* SteelWool: TODO */;
		public static final TagKey<Block> ORES_REDSTONE = null /* SteelWool: TODO */;
		public static final TagKey<Block> ORES_IN_GROUND_DEEPSLATE = null /* SteelWool: TODO */;
		public static final TagKey<Block> ORES_IN_GROUND_NETHERRACK = null /* SteelWool: TODO */;
		public static final TagKey<Block> ORES_IN_GROUND_STONE = null /* SteelWool: TODO */;
		public static final TagKey<Block> PUMPKINS = null /* SteelWool: TODO */;
		public static final TagKey<Block> PUMPKINS_NORMAL = null /* SteelWool: TODO */;
		public static final TagKey<Block> PUMPKINS_CARVED = null /* SteelWool: TODO */;
		public static final TagKey<Block> PUMPKINS_JACK_O_LANTERNS = null /* SteelWool: TODO */;
		public static final TagKey<Block> PLAYER_WORKSTATIONS_CRAFTING_TABLES = null /* SteelWool: TODO */;
		public static final TagKey<Block> PLAYER_WORKSTATIONS_FURNACES = null /* SteelWool: TODO */;
		public static final TagKey<Block> ROPES = null /* SteelWool: TODO */;
		public static final TagKey<Block> SANDS = null /* SteelWool: TODO */;
		public static final TagKey<Block> SANDS_COLORLESS = null /* SteelWool: TODO */;
		public static final TagKey<Block> SANDS_RED = null /* SteelWool: TODO */;
		public static final TagKey<Block> SANDSTONE_BLOCKS = null /* SteelWool: TODO */;
		public static final TagKey<Block> SANDSTONE_SLABS = null /* SteelWool: TODO */;
		public static final TagKey<Block> SANDSTONE_STAIRS = null /* SteelWool: TODO */;
		public static final TagKey<Block> SANDSTONE_RED_BLOCKS = null /* SteelWool: TODO */;
		public static final TagKey<Block> SANDSTONE_RED_SLABS = null /* SteelWool: TODO */;
		public static final TagKey<Block> SANDSTONE_RED_STAIRS = null /* SteelWool: TODO */;
		public static final TagKey<Block> SANDSTONE_UNCOLORED_BLOCKS = null /* SteelWool: TODO */;
		public static final TagKey<Block> SANDSTONE_UNCOLORED_SLABS = null /* SteelWool: TODO */;
		public static final TagKey<Block> SANDSTONE_UNCOLORED_STAIRS = null /* SteelWool: TODO */;
		public static final TagKey<Block> STONES = null /* SteelWool: TODO */;
		public static final TagKey<Block> STORAGE_BLOCKS = null /* SteelWool: TODO */;
		public static final TagKey<Block> STORAGE_BLOCKS_BONE_MEAL = null /* SteelWool: TODO */;
		public static final TagKey<Block> STORAGE_BLOCKS_COAL = null /* SteelWool: TODO */;
		public static final TagKey<Block> STORAGE_BLOCKS_COPPER = null /* SteelWool: TODO */;
		public static final TagKey<Block> STORAGE_BLOCKS_DIAMOND = null /* SteelWool: TODO */;
		public static final TagKey<Block> STORAGE_BLOCKS_DRIED_KELP = null /* SteelWool: TODO */;
		public static final TagKey<Block> STORAGE_BLOCKS_EMERALD = null /* SteelWool: TODO */;
		public static final TagKey<Block> STORAGE_BLOCKS_GOLD = null /* SteelWool: TODO */;
		public static final TagKey<Block> STORAGE_BLOCKS_IRON = null /* SteelWool: TODO */;
		public static final TagKey<Block> STORAGE_BLOCKS_LAPIS = null /* SteelWool: TODO */;
		public static final TagKey<Block> STORAGE_BLOCKS_NETHERITE = null /* SteelWool: TODO */;
		public static final TagKey<Block> STORAGE_BLOCKS_RAW_COPPER = null /* SteelWool: TODO */;
		public static final TagKey<Block> STORAGE_BLOCKS_RAW_GOLD = null /* SteelWool: TODO */;
		public static final TagKey<Block> STORAGE_BLOCKS_RAW_IRON = null /* SteelWool: TODO */;
		public static final TagKey<Block> STORAGE_BLOCKS_REDSTONE = null /* SteelWool: TODO */;
		public static final TagKey<Block> STORAGE_BLOCKS_RESIN = null /* SteelWool: TODO */;
		public static final TagKey<Block> STORAGE_BLOCKS_SLIME = null /* SteelWool: TODO */;
		public static final TagKey<Block> STORAGE_BLOCKS_WHEAT = null /* SteelWool: TODO */;
		public static final TagKey<Block> OVERWORLD_NATURAL_LOGS = null /* SteelWool: TODO */;
		public static final TagKey<Block> NETHER_NATURAL_LOGS = null /* SteelWool: TODO */;
		public static final TagKey<Block> NATURAL_LOGS = null /* SteelWool: TODO */;
		public static final TagKey<Block> NATURAL_WOODS = null /* SteelWool: TODO */;
		public static final TagKey<Block> STRIPPED_LOGS = null /* SteelWool: TODO */;
		public static final TagKey<Block> STRIPPED_WOODS = null /* SteelWool: TODO */;

		public Blocks() {
			super();
		}

		private static TagKey<Block> tag(String arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement Tags.Blocks.tag yet");
		}

		private static TagKey<Block> neoforgeTag(String arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement Tags.Blocks.neoforgeTag yet");
		}
	}

	public static class DamageTypes {
		public static final TagKey<DamageType> IS_MAGIC = null /* SteelWool: TODO */;
		public static final TagKey<DamageType> IS_POISON = null /* SteelWool: TODO */;
		public static final TagKey<DamageType> IS_WITHER = null /* SteelWool: TODO */;
		public static final TagKey<DamageType> IS_ENVIRONMENT = null /* SteelWool: TODO */;
		public static final TagKey<DamageType> IS_PHYSICAL = null /* SteelWool: TODO */;
		public static final TagKey<DamageType> IS_TECHNICAL = null /* SteelWool: TODO */;
		public static final TagKey<DamageType> NO_FLINCH = null /* SteelWool: TODO */;

		public DamageTypes() {
			super();
		}

		private static TagKey<DamageType> neoforgeTag(String arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement Tags.DamageTypes.neoforgeTag yet");
		}
	}

	public static class Enchantments {
		public static final TagKey<Enchantment> INCREASE_BLOCK_DROPS = null /* SteelWool: TODO */;
		public static final TagKey<Enchantment> INCREASE_ENTITY_DROPS = null /* SteelWool: TODO */;
		public static final TagKey<Enchantment> WEAPON_DAMAGE_ENHANCEMENTS = null /* SteelWool: TODO */;
		public static final TagKey<Enchantment> ENTITY_SPEED_ENHANCEMENTS = null /* SteelWool: TODO */;
		public static final TagKey<Enchantment> ENTITY_AUXILIARY_MOVEMENT_ENHANCEMENTS = null /* SteelWool: TODO */;
		public static final TagKey<Enchantment> ENTITY_DEFENSE_ENHANCEMENTS = null /* SteelWool: TODO */;
		public static final TagKey<Enchantment> HIDDEN_FROM_RECIPE_VIEWERS = null /* SteelWool: TODO */;

		public Enchantments() {
			super();
		}

		private static TagKey<Enchantment> tag(String arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement Tags.Enchantments.tag yet");
		}
	}

	public static class EntityTypes {
		public static final TagKey<EntityType<?>> BOSSES = null /* SteelWool: TODO */;
		public static final TagKey<EntityType<?>> MINECARTS = null /* SteelWool: TODO */;
		public static final TagKey<EntityType<?>> BOATS = null /* SteelWool: TODO */;
		public static final TagKey<EntityType<?>> ITEM_FRAMES = null /* SteelWool: TODO */;
		public static final TagKey<EntityType<?>> CAPTURING_NOT_SUPPORTED = null /* SteelWool: TODO */;
		public static final TagKey<EntityType<?>> TELEPORTING_NOT_SUPPORTED = null /* SteelWool: TODO */;

		public EntityTypes() {
			super();
		}

		private static TagKey<EntityType<?>> tag(String arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement Tags.EntityTypes.tag yet");
		}
	}

	public static class Fluids {
		public static final TagKey<Fluid> WATER = null /* SteelWool: TODO */;
		public static final TagKey<Fluid> LAVA = null /* SteelWool: TODO */;
		public static final TagKey<Fluid> MILK = null /* SteelWool: TODO */;
		public static final TagKey<Fluid> GASEOUS = null /* SteelWool: TODO */;
		public static final TagKey<Fluid> HONEY = null /* SteelWool: TODO */;
		public static final TagKey<Fluid> EXPERIENCE = null /* SteelWool: TODO */;
		public static final TagKey<Fluid> POTION = null /* SteelWool: TODO */;
		public static final TagKey<Fluid> SUSPICIOUS_STEW = null /* SteelWool: TODO */;
		public static final TagKey<Fluid> MUSHROOM_STEW = null /* SteelWool: TODO */;
		public static final TagKey<Fluid> RABBIT_STEW = null /* SteelWool: TODO */;
		public static final TagKey<Fluid> BEETROOT_SOUP = null /* SteelWool: TODO */;
		public static final TagKey<Fluid> HIDDEN_FROM_RECIPE_VIEWERS = null /* SteelWool: TODO */;

		public Fluids() {
			super();
		}

		private static TagKey<Fluid> tag(String arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement Tags.Fluids.tag yet");
		}
	}

	public static class Items {
		public static final TagKey<Item> ENCHANTING_FUELS = null /* SteelWool: TODO */;
		public static final TagKey<Item> PIGLIN_USABLE_CROSSBOWS = null /* SteelWool: TODO */;
		public static final TagKey<Item> PILLAGER_USABLE_CROSSBOWS = null /* SteelWool: TODO */;
		public static final TagKey<Item> SKELETON_USABLE_BOWS = null /* SteelWool: TODO */;
		public static final TagKey<Item> BONES = null /* SteelWool: TODO */;
		public static final TagKey<Item> BRICKS = null /* SteelWool: TODO */;
		public static final TagKey<Item> BRICKS_NORMAL = null /* SteelWool: TODO */;
		public static final TagKey<Item> BRICKS_NETHER = null /* SteelWool: TODO */;
		public static final TagKey<Item> BRICKS_RESIN = null /* SteelWool: TODO */;
		public static final TagKey<Item> BUCKETS = null /* SteelWool: TODO */;
		public static final TagKey<Item> BUCKETS_EMPTY = null /* SteelWool: TODO */;
		public static final TagKey<Item> BUCKETS_WATER = null /* SteelWool: TODO */;
		public static final TagKey<Item> BUCKETS_LAVA = null /* SteelWool: TODO */;
		public static final TagKey<Item> BUCKETS_MILK = null /* SteelWool: TODO */;
		public static final TagKey<Item> BUCKETS_POWDER_SNOW = null /* SteelWool: TODO */;
		public static final TagKey<Item> BUCKETS_ENTITY_WATER = null /* SteelWool: TODO */;
		public static final TagKey<Item> BUCKETS_ENTITY_DRY = null /* SteelWool: TODO */;
		public static final TagKey<Item> CONCRETE_POWDERS = null /* SteelWool: TODO */;
		public static final TagKey<Item> CLUMPS = null /* SteelWool: TODO */;
		public static final TagKey<Item> CLUMPS_RESIN = null /* SteelWool: TODO */;
		public static final TagKey<Item> CROPS = null /* SteelWool: TODO */;
		public static final TagKey<Item> CROPS_BEETROOT = null /* SteelWool: TODO */;
		public static final TagKey<Item> CROPS_CACTUS = null /* SteelWool: TODO */;
		public static final TagKey<Item> CROPS_CARROT = null /* SteelWool: TODO */;
		public static final TagKey<Item> CROPS_COCOA_BEAN = null /* SteelWool: TODO */;
		public static final TagKey<Item> CROPS_MELON = null /* SteelWool: TODO */;
		public static final TagKey<Item> CROPS_NETHER_WART = null /* SteelWool: TODO */;
		public static final TagKey<Item> CROPS_POTATO = null /* SteelWool: TODO */;
		public static final TagKey<Item> CROPS_PUMPKIN = null /* SteelWool: TODO */;
		public static final TagKey<Item> CROPS_SUGAR_CANE = null /* SteelWool: TODO */;
		public static final TagKey<Item> CROPS_WHEAT = null /* SteelWool: TODO */;
		public static final TagKey<Item> DRINKS = null /* SteelWool: TODO */;
		public static final TagKey<Item> DRINKS_WATER = null /* SteelWool: TODO */;
		public static final TagKey<Item> DRINKS_WATERY = null /* SteelWool: TODO */;
		public static final TagKey<Item> DRINKS_MILK = null /* SteelWool: TODO */;
		public static final TagKey<Item> DRINKS_HONEY = null /* SteelWool: TODO */;
		public static final TagKey<Item> DRINKS_MAGIC = null /* SteelWool: TODO */;
		public static final TagKey<Item> DRINKS_OMINOUS = null /* SteelWool: TODO */;
		public static final TagKey<Item> DRINKS_JUICE = null /* SteelWool: TODO */;
		public static final TagKey<Item> DRINK_CONTAINING_BOTTLE = null /* SteelWool: TODO */;
		public static final TagKey<Item> DRINK_CONTAINING_BUCKET = null /* SteelWool: TODO */;
		public static final TagKey<Item> DUSTS = null /* SteelWool: TODO */;
		public static final TagKey<Item> DUSTS_REDSTONE = null /* SteelWool: TODO */;
		public static final TagKey<Item> DUSTS_GLOWSTONE = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYES = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYES_BLACK = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYES_RED = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYES_GREEN = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYES_BROWN = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYES_BLUE = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYES_PURPLE = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYES_CYAN = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYES_LIGHT_GRAY = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYES_GRAY = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYES_PINK = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYES_LIME = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYES_YELLOW = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYES_LIGHT_BLUE = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYES_MAGENTA = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYES_ORANGE = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYES_WHITE = null /* SteelWool: TODO */;
		public static final ColorCollection<TagKey<Item>> DYE_COLORS = null /* SteelWool: TODO */;
		public static final TagKey<Item> EGGS = null /* SteelWool: TODO */;
		public static final TagKey<Item> ENDER_PEARLS = null /* SteelWool: TODO */;
		public static final TagKey<Item> FEATHERS = null /* SteelWool: TODO */;
		public static final TagKey<Item> FERTILIZERS = null /* SteelWool: TODO */;
		public static final TagKey<Item> FOODS = null /* SteelWool: TODO */;
		public static final TagKey<Item> FOODS_FRUIT = null /* SteelWool: TODO */;
		public static final TagKey<Item> FOODS_VEGETABLE = null /* SteelWool: TODO */;
		public static final TagKey<Item> FOODS_BERRY = null /* SteelWool: TODO */;
		public static final TagKey<Item> FOODS_BREAD = null /* SteelWool: TODO */;
		public static final TagKey<Item> FOODS_COOKIE = null /* SteelWool: TODO */;
		public static final TagKey<Item> FOODS_DOUGH = null /* SteelWool: TODO */;
		public static final TagKey<Item> FOODS_RAW_MEAT = null /* SteelWool: TODO */;
		public static final TagKey<Item> FOODS_COOKED_MEAT = null /* SteelWool: TODO */;
		public static final TagKey<Item> FOODS_RAW_FISH = null /* SteelWool: TODO */;
		public static final TagKey<Item> FOODS_COOKED_FISH = null /* SteelWool: TODO */;
		public static final TagKey<Item> FOODS_SOUP = null /* SteelWool: TODO */;
		public static final TagKey<Item> FOODS_CANDY = null /* SteelWool: TODO */;
		public static final TagKey<Item> FOODS_PIE = null /* SteelWool: TODO */;
		public static final TagKey<Item> FOODS_GOLDEN = null /* SteelWool: TODO */;
		public static final TagKey<Item> FOODS_EDIBLE_WHEN_PLACED = null /* SteelWool: TODO */;
		public static final TagKey<Item> FOODS_FOOD_POISONING = null /* SteelWool: TODO */;
		public static final TagKey<Item> ANIMAL_FOODS = null /* SteelWool: TODO */;
		public static final TagKey<Item> GEMS = null /* SteelWool: TODO */;
		public static final TagKey<Item> GEMS_DIAMOND = null /* SteelWool: TODO */;
		public static final TagKey<Item> GEMS_EMERALD = null /* SteelWool: TODO */;
		public static final TagKey<Item> GEMS_AMETHYST = null /* SteelWool: TODO */;
		public static final TagKey<Item> GEMS_LAPIS = null /* SteelWool: TODO */;
		public static final TagKey<Item> GEMS_PRISMARINE = null /* SteelWool: TODO */;
		public static final TagKey<Item> GEMS_QUARTZ = null /* SteelWool: TODO */;
		public static final TagKey<Item> GUNPOWDERS = null /* SteelWool: TODO */;
		public static final TagKey<Item> HIDDEN_FROM_RECIPE_VIEWERS = null /* SteelWool: TODO */;
		public static final TagKey<Item> INGOTS = null /* SteelWool: TODO */;
		public static final TagKey<Item> INGOTS_COPPER = null /* SteelWool: TODO */;
		public static final TagKey<Item> INGOTS_GOLD = null /* SteelWool: TODO */;
		public static final TagKey<Item> INGOTS_IRON = null /* SteelWool: TODO */;
		public static final TagKey<Item> INGOTS_NETHERITE = null /* SteelWool: TODO */;
		public static final TagKey<Item> LEATHERS = null /* SteelWool: TODO */;
		public static final TagKey<Item> MUSHROOMS = null /* SteelWool: TODO */;
		public static final TagKey<Item> MUSIC_DISCS = null /* SteelWool: TODO */;
		public static final TagKey<Item> NETHER_STARS = null /* SteelWool: TODO */;
		public static final TagKey<Item> NUGGETS = null /* SteelWool: TODO */;
		public static final TagKey<Item> NUGGETS_GOLD = null /* SteelWool: TODO */;
		public static final TagKey<Item> NUGGETS_IRON = null /* SteelWool: TODO */;
		public static final TagKey<Item> NUGGETS_COPPER = null /* SteelWool: TODO */;
		public static final TagKey<Item> POTIONS = null /* SteelWool: TODO */;
		public static final TagKey<Item> POTIONS_BOTTLE = null /* SteelWool: TODO */;
		public static final TagKey<Item> RAW_MATERIALS = null /* SteelWool: TODO */;
		public static final TagKey<Item> RAW_MATERIALS_COPPER = null /* SteelWool: TODO */;
		public static final TagKey<Item> RAW_MATERIALS_GOLD = null /* SteelWool: TODO */;
		public static final TagKey<Item> RAW_MATERIALS_IRON = null /* SteelWool: TODO */;
		public static final TagKey<Item> RODS = null /* SteelWool: TODO */;
		public static final TagKey<Item> RODS_BLAZE = null /* SteelWool: TODO */;
		public static final TagKey<Item> RODS_BREEZE = null /* SteelWool: TODO */;
		public static final TagKey<Item> RODS_WOODEN = null /* SteelWool: TODO */;
		public static final TagKey<Item> SEEDS = null /* SteelWool: TODO */;
		public static final TagKey<Item> SEEDS_BEETROOT = null /* SteelWool: TODO */;
		public static final TagKey<Item> SEEDS_MELON = null /* SteelWool: TODO */;
		public static final TagKey<Item> SEEDS_PUMPKIN = null /* SteelWool: TODO */;
		public static final TagKey<Item> SEEDS_TORCHFLOWER = null /* SteelWool: TODO */;
		public static final TagKey<Item> SEEDS_PITCHER_PLANT = null /* SteelWool: TODO */;
		public static final TagKey<Item> SEEDS_WHEAT = null /* SteelWool: TODO */;
		public static final TagKey<Item> SHULKER_BOXES = null /* SteelWool: TODO */;
		public static final TagKey<Item> SLIME_BALLS = null /* SteelWool: TODO */;
		public static final TagKey<Item> STRINGS = null /* SteelWool: TODO */;
		public static final TagKey<Item> VILLAGER_JOB_SITES = null /* SteelWool: TODO */;
		public static final TagKey<Item> TOOLS = null /* SteelWool: TODO */;
		public static final TagKey<Item> TOOLS_SHIELD = null /* SteelWool: TODO */;
		public static final TagKey<Item> TOOLS_BOW = null /* SteelWool: TODO */;
		public static final TagKey<Item> TOOLS_CROSSBOW = null /* SteelWool: TODO */;
		public static final TagKey<Item> TOOLS_FISHING_ROD = null /* SteelWool: TODO */;
		public static final TagKey<Item> TOOLS_TRIDENT = null /* SteelWool: TODO */;
		public static final TagKey<Item> TOOLS_SHEAR = null /* SteelWool: TODO */;
		public static final TagKey<Item> TOOLS_BRUSH = null /* SteelWool: TODO */;
		public static final TagKey<Item> TOOLS_IGNITER = null /* SteelWool: TODO */;
		public static final TagKey<Item> TOOLS_MACE = null /* SteelWool: TODO */;
		public static final TagKey<Item> TOOLS_WRENCH = null /* SteelWool: TODO */;
		public static final TagKey<Item> MELEE_WEAPON_TOOLS = null /* SteelWool: TODO */;
		public static final TagKey<Item> RANGED_WEAPON_TOOLS = null /* SteelWool: TODO */;
		public static final TagKey<Item> MINING_TOOL_TOOLS = null /* SteelWool: TODO */;
		public static final TagKey<Item> ARMORS = null /* SteelWool: TODO */;
		public static final TagKey<Item> ARMORS_HUMANOID = null /* SteelWool: TODO */;
		public static final TagKey<Item> ARMORS_HORSE = null /* SteelWool: TODO */;
		public static final TagKey<Item> ARMORS_NAUTILUS = null /* SteelWool: TODO */;
		public static final TagKey<Item> ARMORS_WOLF = null /* SteelWool: TODO */;
		public static final TagKey<Item> ENCHANTABLES = null /* SteelWool: TODO */;
		public static final TagKey<Item> BARRELS = null /* SteelWool: TODO */;
		public static final TagKey<Item> BARRELS_WOODEN = null /* SteelWool: TODO */;
		public static final TagKey<Item> BARS = null /* SteelWool: TODO */;
		public static final TagKey<Item> BARS_COPPER = null /* SteelWool: TODO */;
		public static final TagKey<Item> BARS_IRON = null /* SteelWool: TODO */;
		public static final TagKey<Item> BOOKSHELVES = null /* SteelWool: TODO */;
		public static final TagKey<Item> BUDDING_BLOCKS = null /* SteelWool: TODO */;
		public static final TagKey<Item> BUDS = null /* SteelWool: TODO */;
		public static final TagKey<Item> CHAINS = null /* SteelWool: TODO */;
		public static final TagKey<Item> CHESTS = null /* SteelWool: TODO */;
		public static final TagKey<Item> CHESTS_ENDER = null /* SteelWool: TODO */;
		public static final TagKey<Item> CHESTS_TRAPPED = null /* SteelWool: TODO */;
		public static final TagKey<Item> CHESTS_WOODEN = null /* SteelWool: TODO */;
		public static final TagKey<Item> COBBLESTONES = null /* SteelWool: TODO */;
		public static final TagKey<Item> COBBLESTONES_NORMAL = null /* SteelWool: TODO */;
		public static final TagKey<Item> COBBLESTONES_INFESTED = null /* SteelWool: TODO */;
		public static final TagKey<Item> COBBLESTONES_MOSSY = null /* SteelWool: TODO */;
		public static final TagKey<Item> COBBLESTONES_DEEPSLATE = null /* SteelWool: TODO */;
		public static final TagKey<Item> CONCRETES = null /* SteelWool: TODO */;
		public static final TagKey<Item> CLUSTERS = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYED = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYED_BLACK = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYED_BLUE = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYED_BROWN = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYED_CYAN = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYED_GRAY = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYED_GREEN = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYED_LIGHT_BLUE = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYED_LIGHT_GRAY = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYED_LIME = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYED_MAGENTA = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYED_ORANGE = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYED_PINK = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYED_PURPLE = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYED_RED = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYED_WHITE = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYED_YELLOW = null /* SteelWool: TODO */;
		public static final ColorCollection<TagKey<Item>> DYED_COLORS = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYEABLE_UNDYED_SIMPLE = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYEABLE_REDYEABLE_SIMPLE = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYEABLE_SIMPLE = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYEABLE_DYNAMIC = null /* SteelWool: TODO */;
		public static final TagKey<Item> DYEABLE = null /* SteelWool: TODO */;
		public static final TagKey<Item> END_STONES = null /* SteelWool: TODO */;
		public static final TagKey<Item> FENCE_GATES = null /* SteelWool: TODO */;
		public static final TagKey<Item> FENCE_GATES_WOODEN = null /* SteelWool: TODO */;
		public static final TagKey<Item> FENCES = null /* SteelWool: TODO */;
		public static final TagKey<Item> FENCES_NETHER_BRICK = null /* SteelWool: TODO */;
		public static final TagKey<Item> FENCES_WOODEN = null /* SteelWool: TODO */;
		public static final TagKey<Item> FLOWERS_SMALL = null /* SteelWool: TODO */;
		public static final TagKey<Item> FLOWERS_TALL = null /* SteelWool: TODO */;
		public static final TagKey<Item> FLOWERS = null /* SteelWool: TODO */;
		public static final TagKey<Item> FROGLIGHTS = null /* SteelWool: TODO */;
		public static final TagKey<Item> GLASS_BLOCKS = null /* SteelWool: TODO */;
		public static final TagKey<Item> GLASS_BLOCKS_COLORLESS = null /* SteelWool: TODO */;
		public static final TagKey<Item> GLASS_BLOCKS_CHEAP = null /* SteelWool: TODO */;
		public static final TagKey<Item> GLASS_BLOCKS_TINTED = null /* SteelWool: TODO */;
		public static final TagKey<Item> GLASS_PANES = null /* SteelWool: TODO */;
		public static final TagKey<Item> GLASS_PANES_COLORLESS = null /* SteelWool: TODO */;
		public static final TagKey<Item> GLAZED_TERRACOTTAS = null /* SteelWool: TODO */;
		public static final TagKey<Item> GRAVELS = null /* SteelWool: TODO */;
		public static final TagKey<Item> NETHERRACKS = null /* SteelWool: TODO */;
		public static final TagKey<Item> OBSIDIANS = null /* SteelWool: TODO */;
		public static final TagKey<Item> OBSIDIANS_NORMAL = null /* SteelWool: TODO */;
		public static final TagKey<Item> OBSIDIANS_CRYING = null /* SteelWool: TODO */;
		public static final TagKey<Item> ORE_BEARING_GROUND_DEEPSLATE = null /* SteelWool: TODO */;
		public static final TagKey<Item> ORE_BEARING_GROUND_NETHERRACK = null /* SteelWool: TODO */;
		public static final TagKey<Item> ORE_BEARING_GROUND_STONE = null /* SteelWool: TODO */;
		public static final TagKey<Item> ORE_RATES_DENSE = null /* SteelWool: TODO */;
		public static final TagKey<Item> ORE_RATES_SINGULAR = null /* SteelWool: TODO */;
		public static final TagKey<Item> ORE_RATES_SPARSE = null /* SteelWool: TODO */;
		public static final TagKey<Item> ORES = null /* SteelWool: TODO */;
		public static final TagKey<Item> ORES_COAL = null /* SteelWool: TODO */;
		public static final TagKey<Item> ORES_COPPER = null /* SteelWool: TODO */;
		public static final TagKey<Item> ORES_DIAMOND = null /* SteelWool: TODO */;
		public static final TagKey<Item> ORES_EMERALD = null /* SteelWool: TODO */;
		public static final TagKey<Item> ORES_GOLD = null /* SteelWool: TODO */;
		public static final TagKey<Item> ORES_IRON = null /* SteelWool: TODO */;
		public static final TagKey<Item> ORES_LAPIS = null /* SteelWool: TODO */;
		public static final TagKey<Item> ORES_NETHERITE_SCRAP = null /* SteelWool: TODO */;
		public static final TagKey<Item> ORES_QUARTZ = null /* SteelWool: TODO */;
		public static final TagKey<Item> ORES_REDSTONE = null /* SteelWool: TODO */;
		public static final TagKey<Item> ORES_IN_GROUND_DEEPSLATE = null /* SteelWool: TODO */;
		public static final TagKey<Item> ORES_IN_GROUND_NETHERRACK = null /* SteelWool: TODO */;
		public static final TagKey<Item> ORES_IN_GROUND_STONE = null /* SteelWool: TODO */;
		public static final TagKey<Item> PLAYER_WORKSTATIONS_CRAFTING_TABLES = null /* SteelWool: TODO */;
		public static final TagKey<Item> PLAYER_WORKSTATIONS_FURNACES = null /* SteelWool: TODO */;
		public static final TagKey<Item> PUMPKINS = null /* SteelWool: TODO */;
		public static final TagKey<Item> PUMPKINS_NORMAL = null /* SteelWool: TODO */;
		public static final TagKey<Item> PUMPKINS_CARVED = null /* SteelWool: TODO */;
		public static final TagKey<Item> PUMPKINS_JACK_O_LANTERNS = null /* SteelWool: TODO */;
		public static final TagKey<Item> ROPES = null /* SteelWool: TODO */;
		public static final TagKey<Item> SANDS = null /* SteelWool: TODO */;
		public static final TagKey<Item> SANDS_COLORLESS = null /* SteelWool: TODO */;
		public static final TagKey<Item> SANDS_RED = null /* SteelWool: TODO */;
		public static final TagKey<Item> SANDSTONE_BLOCKS = null /* SteelWool: TODO */;
		public static final TagKey<Item> SANDSTONE_SLABS = null /* SteelWool: TODO */;
		public static final TagKey<Item> SANDSTONE_STAIRS = null /* SteelWool: TODO */;
		public static final TagKey<Item> SANDSTONE_RED_BLOCKS = null /* SteelWool: TODO */;
		public static final TagKey<Item> SANDSTONE_RED_SLABS = null /* SteelWool: TODO */;
		public static final TagKey<Item> SANDSTONE_RED_STAIRS = null /* SteelWool: TODO */;
		public static final TagKey<Item> SANDSTONE_UNCOLORED_BLOCKS = null /* SteelWool: TODO */;
		public static final TagKey<Item> SANDSTONE_UNCOLORED_SLABS = null /* SteelWool: TODO */;
		public static final TagKey<Item> SANDSTONE_UNCOLORED_STAIRS = null /* SteelWool: TODO */;
		public static final TagKey<Item> STONES = null /* SteelWool: TODO */;
		public static final TagKey<Item> STORAGE_BLOCKS = null /* SteelWool: TODO */;
		public static final TagKey<Item> STORAGE_BLOCKS_BONE_MEAL = null /* SteelWool: TODO */;
		public static final TagKey<Item> STORAGE_BLOCKS_COAL = null /* SteelWool: TODO */;
		public static final TagKey<Item> STORAGE_BLOCKS_COPPER = null /* SteelWool: TODO */;
		public static final TagKey<Item> STORAGE_BLOCKS_DIAMOND = null /* SteelWool: TODO */;
		public static final TagKey<Item> STORAGE_BLOCKS_DRIED_KELP = null /* SteelWool: TODO */;
		public static final TagKey<Item> STORAGE_BLOCKS_EMERALD = null /* SteelWool: TODO */;
		public static final TagKey<Item> STORAGE_BLOCKS_GOLD = null /* SteelWool: TODO */;
		public static final TagKey<Item> STORAGE_BLOCKS_IRON = null /* SteelWool: TODO */;
		public static final TagKey<Item> STORAGE_BLOCKS_LAPIS = null /* SteelWool: TODO */;
		public static final TagKey<Item> STORAGE_BLOCKS_NETHERITE = null /* SteelWool: TODO */;
		public static final TagKey<Item> STORAGE_BLOCKS_RAW_COPPER = null /* SteelWool: TODO */;
		public static final TagKey<Item> STORAGE_BLOCKS_RAW_GOLD = null /* SteelWool: TODO */;
		public static final TagKey<Item> STORAGE_BLOCKS_RAW_IRON = null /* SteelWool: TODO */;
		public static final TagKey<Item> STORAGE_BLOCKS_REDSTONE = null /* SteelWool: TODO */;
		public static final TagKey<Item> STORAGE_BLOCKS_RESIN = null /* SteelWool: TODO */;
		public static final TagKey<Item> STORAGE_BLOCKS_SLIME = null /* SteelWool: TODO */;
		public static final TagKey<Item> STORAGE_BLOCKS_WHEAT = null /* SteelWool: TODO */;
		public static final TagKey<Item> OVERWORLD_NATURAL_LOGS = null /* SteelWool: TODO */;
		public static final TagKey<Item> NETHER_NATURAL_LOGS = null /* SteelWool: TODO */;
		public static final TagKey<Item> NATURAL_LOGS = null /* SteelWool: TODO */;
		public static final TagKey<Item> NATURAL_WOODS = null /* SteelWool: TODO */;
		public static final TagKey<Item> STRIPPED_LOGS = null /* SteelWool: TODO */;
		public static final TagKey<Item> STRIPPED_WOODS = null /* SteelWool: TODO */;

		public Items() {
			super();
		}

		private static TagKey<Item> tag(String arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement Tags.Items.tag yet");
		}

		private static TagKey<Item> neoforgeTag(String arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement Tags.Items.neoforgeTag yet");
		}
	}

	public static class Potions {
		public static final TagKey<Potion> HIDDEN_FROM_RECIPE_VIEWERS = null /* SteelWool: TODO */;

		public Potions() {
			super();
		}

		private static TagKey<Potion> tag(String arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement Tags.Potions.tag yet");
		}
	}

	public static class Structures {
		public static final TagKey<Structure> HIDDEN_FROM_DISPLAYERS = null /* SteelWool: TODO */;
		public static final TagKey<Structure> HIDDEN_FROM_LOCATOR_SELECTION = null /* SteelWool: TODO */;

		public Structures() {
			super();
		}

		private static TagKey<Structure> tag(String arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement Tags.Structures.tag yet");
		}
	}

	public static class WorldClocks {
		public static final TagKey<WorldClock> IGNORES_PAUSE_COMMAND = null /* SteelWool: TODO */;
		public static final TagKey<WorldClock> IGNORES_ADVANCE_TIME_RULE = null /* SteelWool: TODO */;

		public WorldClocks() {
			super();
		}

		private static TagKey<WorldClock> neoforgeTag(String arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement Tags.WorldClocks.neoforgeTag yet");
		}
	}
}
