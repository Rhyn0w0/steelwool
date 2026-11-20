package dev.steelwool.mixin.patch;

import dev.steelwool.attachment.AttachmentStore;
import dev.steelwool.attachment.SteelWoolAttachmentHolder;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Data attachments on block entities (NeoForge's {@code BlockEntity extends AttachmentHolder}), saved with the block entity. */
@Mixin(BlockEntity.class)
public abstract class BlockEntityAttachmentMixin implements SteelWoolAttachmentHolder {
	@Unique
	private AttachmentStore steelwool$attachmentStore;

	@Override
	public AttachmentStore steelwool$attachments() {
		if (steelwool$attachmentStore == null) {
			steelwool$attachmentStore = new AttachmentStore(this);
		}
		return steelwool$attachmentStore;
	}

	@Inject(method = {"saveWithoutMetadata(Lnet/minecraft/world/level/storage/ValueOutput;)V", "saveCustomOnly(Lnet/minecraft/world/level/storage/ValueOutput;)V"}, at = @At("TAIL"))
	private void steelwool$saveAttachments(ValueOutput output, CallbackInfo ci) {
		steelwool$attachments().save(output);
	}

	@Inject(method = {"loadWithComponents", "loadCustomOnly"}, at = @At("TAIL"))
	private void steelwool$loadAttachments(ValueInput input, CallbackInfo ci) {
		steelwool$attachments().load(input);
	}
}
