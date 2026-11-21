package net.neoforged.neoforge.common.util;

import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

/**
 * SteelWool re-implementation of NeoForge's {@code ValueIOSerializable}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface ValueIOSerializable {
	void serialize(ValueOutput arg0);

	void deserialize(ValueInput arg0);
}
