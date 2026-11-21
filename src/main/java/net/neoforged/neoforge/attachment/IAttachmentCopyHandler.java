package net.neoforged.neoforge.attachment;

import net.minecraft.core.HolderLookup;

/**
 * SteelWool re-implementation of NeoForge's {@code IAttachmentCopyHandler}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IAttachmentCopyHandler<T extends Object> {
	T copy(T arg0, IAttachmentHolder arg1, HolderLookup.Provider arg2);
}
