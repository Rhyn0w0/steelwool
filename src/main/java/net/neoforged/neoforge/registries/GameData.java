package net.neoforged.neoforge.registries;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.Table;
import net.minecraft.core.Holder;
import net.minecraft.core.IdMapper;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.slf4j.Logger;
import org.slf4j.Marker;

/**
 * SteelWool re-implementation of NeoForge's {@code GameData}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class GameData {
	private static final Logger LOGGER = null /* SteelWool: TODO */;
	private static final Marker REGISTRIES = null /* SteelWool: TODO */;

	public GameData() {
		super();
	}

	public static Map<Block, Item> getBlockItemMap() {
		throw new UnsupportedOperationException("SteelWool does not implement GameData.getBlockItemMap yet");
	}

	public static IdMapper<BlockState> getBlockStateIDMap() {
		throw new UnsupportedOperationException("SteelWool does not implement GameData.getBlockStateIDMap yet");
	}

	public static Map<BlockState, Holder<PoiType>> getBlockStatePointOfInterestTypeMap() {
		throw new UnsupportedOperationException("SteelWool does not implement GameData.getBlockStatePointOfInterestTypeMap yet");
	}

	public static Table<Block, Block, Block> getFlowerPotBlockTable() {
		throw new UnsupportedOperationException("SteelWool does not implement GameData.getFlowerPotBlockTable yet");
	}

	public static void vanillaSnapshot() {
		throw new UnsupportedOperationException("SteelWool does not implement GameData.vanillaSnapshot yet");
	}

	public static void unfreezeData() {
		throw new UnsupportedOperationException("SteelWool does not implement GameData.unfreezeData yet");
	}

	public static void freezeData() {
		throw new UnsupportedOperationException("SteelWool does not implement GameData.freezeData yet");
	}

	public static void postRegisterEvents() {
		throw new UnsupportedOperationException("SteelWool does not implement GameData.postRegisterEvents yet");
	}

	public static Set<Identifier> getRegistrationOrder() {
		throw new UnsupportedOperationException("SteelWool does not implement GameData.getRegistrationOrder yet");
	}
}
