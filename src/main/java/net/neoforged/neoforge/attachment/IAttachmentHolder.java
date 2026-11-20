package net.neoforged.neoforge.attachment;

import java.util.Optional;
import java.util.function.Supplier;
import org.jspecify.annotations.Nullable;

/**
 * Something data attachments can be attached to. SteelWool makes entities, block entities, chunks
 * and levels implement it with mixins.
 */
public interface IAttachmentHolder {
	boolean hasAttachments();

	boolean hasData(AttachmentType<?> type);

	default <T> boolean hasData(Supplier<AttachmentType<T>> type) {
		return hasData(type.get());
	}

	<T> T getData(AttachmentType<T> type);

	default <T> T getData(Supplier<AttachmentType<T>> type) {
		return getData(type.get());
	}

	default <T> Optional<T> getExistingData(AttachmentType<T> type) {
		return Optional.ofNullable(getExistingDataOrNull(type));
	}

	default <T> Optional<T> getExistingData(Supplier<AttachmentType<T>> type) {
		return getExistingData(type.get());
	}

	<T> @Nullable T getExistingDataOrNull(AttachmentType<T> type);

	default <T> @Nullable T getExistingDataOrNull(Supplier<AttachmentType<T>> type) {
		return getExistingDataOrNull(type.get());
	}

	<T> @Nullable T setData(AttachmentType<T> type, T data);

	default <T> @Nullable T setData(Supplier<AttachmentType<T>> type, T data) {
		return setData(type.get(), data);
	}

	<T> @Nullable T removeData(AttachmentType<T> type);

	default <T> @Nullable T removeData(Supplier<AttachmentType<T>> type) {
		return removeData(type.get());
	}

	/** SteelWool does not sync attachments to clients yet, so this does nothing. */
	default void syncData(AttachmentType<?> type) {
	}

	default void syncData(Supplier<? extends AttachmentType<?>> type) {
		syncData(type.get());
	}
}
