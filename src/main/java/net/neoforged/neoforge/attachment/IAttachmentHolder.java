package net.neoforged.neoforge.attachment;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * SteelWool re-implementation of NeoForge's {@code IAttachmentHolder}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IAttachmentHolder {
	boolean hasAttachments();

	boolean hasData(AttachmentType<?> arg0);

	default <T extends Object> boolean hasData(Supplier<AttachmentType<T>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IAttachmentHolder.hasData yet");
	}

	<T extends Object> T getData(AttachmentType<T> arg0);

	default <T extends Object> T getData(Supplier<AttachmentType<T>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IAttachmentHolder.getData yet");
	}

	default <T extends Object> Optional<T> getExistingData(AttachmentType<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IAttachmentHolder.getExistingData yet");
	}

	default <T extends Object> Optional<T> getExistingData(Supplier<AttachmentType<T>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IAttachmentHolder.getExistingData yet");
	}

	<T extends Object> T getExistingDataOrNull(AttachmentType<T> arg0);

	default <T extends Object> T getExistingDataOrNull(Supplier<AttachmentType<T>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IAttachmentHolder.getExistingDataOrNull yet");
	}

	<T extends Object> T setData(AttachmentType<T> arg0, T arg1);

	default <T extends Object> T setData(Supplier<AttachmentType<T>> arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IAttachmentHolder.setData yet");
	}

	<T extends Object> T removeData(AttachmentType<T> arg0);

	default <T extends Object> T removeData(Supplier<AttachmentType<T>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IAttachmentHolder.removeData yet");
	}

	default void syncData(AttachmentType<?> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IAttachmentHolder.syncData yet");
	}

	default void syncData(Supplier<? extends AttachmentType<?>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IAttachmentHolder.syncData yet");
	}
}
