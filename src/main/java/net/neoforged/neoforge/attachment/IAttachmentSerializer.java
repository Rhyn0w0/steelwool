package net.neoforged.neoforge.attachment;

import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

/**
 * SteelWool re-implementation of NeoForge's {@code IAttachmentSerializer}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IAttachmentSerializer<T extends Object> {
	T read(IAttachmentHolder arg0, ValueInput arg1);

	boolean write(T arg0, ValueOutput arg1);
}
