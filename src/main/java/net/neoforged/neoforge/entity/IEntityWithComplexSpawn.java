package net.neoforged.neoforge.entity;

import net.minecraft.network.RegistryFriendlyByteBuf;

/**
 * SteelWool re-implementation of NeoForge's {@code IEntityWithComplexSpawn}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IEntityWithComplexSpawn {
	void writeSpawnData(RegistryFriendlyByteBuf arg0);

	void readSpawnData(RegistryFriendlyByteBuf arg0);
}
