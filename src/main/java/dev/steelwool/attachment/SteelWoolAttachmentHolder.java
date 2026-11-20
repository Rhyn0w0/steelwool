package dev.steelwool.attachment;

import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.attachment.IAttachmentHolder;
import org.jspecify.annotations.Nullable;

/**
 * {@link IAttachmentHolder} implemented on top of an {@link AttachmentStore}. The attachment mixins
 * make Minecraft classes implement this and provide the store.
 */
public interface SteelWoolAttachmentHolder extends IAttachmentHolder {
	AttachmentStore steelwool$attachments();

	@Override
	default boolean hasAttachments() {
		return steelwool$attachments().hasAttachments();
	}

	@Override
	default boolean hasData(AttachmentType<?> type) {
		return steelwool$attachments().has(type);
	}

	@Override
	default <T> T getData(AttachmentType<T> type) {
		return steelwool$attachments().get(type);
	}

	@Override
	default <T> @Nullable T getExistingDataOrNull(AttachmentType<T> type) {
		return steelwool$attachments().getOrNull(type);
	}

	@Override
	default <T> @Nullable T setData(AttachmentType<T> type, T data) {
		return steelwool$attachments().set(type, data);
	}

	@Override
	default <T> @Nullable T removeData(AttachmentType<T> type) {
		return steelwool$attachments().remove(type);
	}
}
