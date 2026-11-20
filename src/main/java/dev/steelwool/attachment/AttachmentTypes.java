package dev.steelwool.attachment;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.function.Function;
import net.minecraft.core.HolderLookup;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.attachment.IAttachmentCopyHandler;
import net.neoforged.neoforge.attachment.IAttachmentHolder;
import net.neoforged.neoforge.attachment.IAttachmentSerializer;
import org.jspecify.annotations.Nullable;

/** Reads the package-private settings of an {@link AttachmentType} (NeoForge keeps them internal). */
final class AttachmentTypes {
	private static final VarHandle DEFAULT_VALUE = field("defaultValueSupplier", Function.class);
	private static final VarHandle SERIALIZER = field("serializer", IAttachmentSerializer.class);
	private static final VarHandle COPY_ON_DEATH = field("copyOnDeath", boolean.class);
	private static final VarHandle COPY_HANDLER = field("copyHandler", IAttachmentCopyHandler.class);

	private AttachmentTypes() {
	}

	private static VarHandle field(String name, Class<?> type) {
		try {
			return MethodHandles.privateLookupIn(AttachmentType.class, MethodHandles.lookup()).findVarHandle(AttachmentType.class, name, type);
		} catch (ReflectiveOperationException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	@SuppressWarnings("unchecked")
	static <T> T defaultValue(AttachmentType<T> type, IAttachmentHolder holder) {
		return ((Function<IAttachmentHolder, T>) DEFAULT_VALUE.get(type)).apply(holder);
	}

	@SuppressWarnings("unchecked")
	static @Nullable IAttachmentSerializer<Object> serializer(AttachmentType<?> type) {
		return (IAttachmentSerializer<Object>) SERIALIZER.get(type);
	}

	static boolean copyOnDeath(AttachmentType<?> type) {
		return (boolean) COPY_ON_DEATH.get(type);
	}

	@SuppressWarnings("unchecked")
	static @Nullable Object copy(AttachmentType<?> type, Object value, IAttachmentHolder target, HolderLookup.Provider provider) {
		IAttachmentCopyHandler<Object> handler = (IAttachmentCopyHandler<Object>) COPY_HANDLER.get(type);
		return handler == null ? null : handler.copy(value, target, provider);
	}
}
