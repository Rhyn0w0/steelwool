package dev.steelwool.mixin.patch;

import dev.steelwool.attachment.AttachmentStore;
import dev.steelwool.attachment.SteelWoolAttachmentHolder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.common.extensions.IBlockEntityExtension;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * NeoForge's additions to block entities: data attachments ({@code BlockEntity extends AttachmentHolder})
 * and {@link IBlockEntityExtension} with its persistent data, both saved with the block entity.
 */
@Mixin(BlockEntity.class)
public abstract class BlockEntityAttachmentMixin implements SteelWoolAttachmentHolder, IBlockEntityExtension {
	@Unique
	private AttachmentStore steelwool$attachmentStore;
	@Unique
	private @Nullable CompoundTag steelwool$persistentData;

	@Override
	public CompoundTag getPersistentData() {
		if (steelwool$persistentData == null) {
			steelwool$persistentData = new CompoundTag();
		}
		return steelwool$persistentData;
	}

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
		if (steelwool$persistentData != null && !steelwool$persistentData.isEmpty()) {
			output.store(PERSISTENT_DATA_KEY, CompoundTag.CODEC, steelwool$persistentData);
		}
	}

	@Inject(method = {"loadWithComponents", "loadCustomOnly"}, at = @At("TAIL"))
	private void steelwool$loadAttachments(ValueInput input, CallbackInfo ci) {
		steelwool$attachments().load(input);
		input.read(PERSISTENT_DATA_KEY, CompoundTag.CODEC).ifPresent(tag -> steelwool$persistentData = tag);
	}

	@Unique
	private static final String PERSISTENT_DATA_KEY = "NeoForgeData";
}
