package dev.steelwool.mixin.patch;

import dev.steelwool.attachment.AttachmentStore;
import dev.steelwool.attachment.SteelWoolAttachmentHolder;
import net.minecraft.world.level.chunk.ChunkAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

/** Data attachments on {@link ChunkAccess}. SteelWool keeps them in memory only; they are not saved yet. */
@Mixin(ChunkAccess.class)
public abstract class ChunkAccessAttachmentMixin implements SteelWoolAttachmentHolder {
	@Unique
	private AttachmentStore steelwool$attachmentStore;

	@Override
	public AttachmentStore steelwool$attachments() {
		if (steelwool$attachmentStore == null) {
			steelwool$attachmentStore = new AttachmentStore(this);
		}
		return steelwool$attachmentStore;
	}
}
