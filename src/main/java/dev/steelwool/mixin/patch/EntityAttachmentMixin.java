package dev.steelwool.mixin.patch;

import dev.steelwool.attachment.AttachmentStore;
import dev.steelwool.attachment.SteelWoolAttachmentHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.attachment.AttachmentType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Data attachments on entities (NeoForge's {@code Entity extends AttachmentHolder}), saved with the
 * entity. {@code syncData} is declared here, not only inherited, because mods inject into it; it does
 * nothing yet. Applied before other mods' mixins so they find it.
 */
@Mixin(value = Entity.class, priority = 500)
public abstract class EntityAttachmentMixin implements SteelWoolAttachmentHolder {
	@Unique
	private AttachmentStore steelwool$attachmentStore;

	@Override
	public AttachmentStore steelwool$attachments() {
		if (steelwool$attachmentStore == null) {
			steelwool$attachmentStore = new AttachmentStore(this);
		}
		return steelwool$attachmentStore;
	}

	@Override
	public void syncData(AttachmentType<?> type) {
	}

	@Inject(method = "saveWithoutId", at = @At("TAIL"))
	private void steelwool$saveAttachments(ValueOutput output, CallbackInfo ci) {
		steelwool$attachments().save(output);
	}

	@Inject(method = "load", at = @At("TAIL"))
	private void steelwool$loadAttachments(ValueInput input, CallbackInfo ci) {
		steelwool$attachments().load(input);
	}
}
