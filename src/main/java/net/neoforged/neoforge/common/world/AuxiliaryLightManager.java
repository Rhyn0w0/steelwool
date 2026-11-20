package net.neoforged.neoforge.common.world;

import net.minecraft.core.BlockPos;

/**
 * SteelWool re-implementation of NeoForge's {@code AuxiliaryLightManager}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface AuxiliaryLightManager {
	void setLightAt(BlockPos arg0, int arg1);

	default void removeLightAt(BlockPos arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement AuxiliaryLightManager.removeLightAt yet");
	}

	int getLightAt(BlockPos arg0);
}
