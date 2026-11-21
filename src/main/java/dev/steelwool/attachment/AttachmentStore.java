package dev.steelwool.attachment;

import com.mojang.logging.LogUtils;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.attachment.IAttachmentHolder;
import net.neoforged.neoforge.attachment.IAttachmentSerializer;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;

/**
 * The data attachments of one holder (entity, block entity, chunk or level), and how they are saved:
 * under {@code "neoforge:attachments"}, one entry per attachment type id, as NeoForge does.
 */
public final class AttachmentStore {
	public static final String KEY = "neoforge:attachments";
	private static final Logger LOGGER = LogUtils.getLogger();

	private final IAttachmentHolder holder;
	private @Nullable Map<AttachmentType<?>, Object> values;

	public AttachmentStore(IAttachmentHolder holder) {
		this.holder = holder;
	}

	public boolean hasAttachments() {
		return values != null && !values.isEmpty();
	}

	public boolean has(AttachmentType<?> type) {
		return values != null && values.containsKey(type);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(AttachmentType<T> type) {
		T value = getOrNull(type);
		if (value == null) {
			value = Objects.requireNonNull(AttachmentTypes.defaultValue(type, holder), "Default attachment value is null");
			map().put(type, value);
		}
		return value;
	}

	@SuppressWarnings("unchecked")
	public <T> @Nullable T getOrNull(AttachmentType<T> type) {
		return values == null ? null : (T) values.get(type);
	}

	@SuppressWarnings("unchecked")
	public <T> @Nullable T set(AttachmentType<T> type, T value) {
		return (T) map().put(type, Objects.requireNonNull(value, "Attachment value is null"));
	}

	@SuppressWarnings("unchecked")
	public <T> @Nullable T remove(AttachmentType<T> type) {
		return values == null ? null : (T) values.remove(type);
	}

	private Map<AttachmentType<?>, Object> map() {
		if (values == null) {
			values = new IdentityHashMap<>();
		}
		return values;
	}

	/** Writes every serializable attachment. Writes nothing if there are none. */
	public void save(ValueOutput output) {
		if (!hasAttachments()) {
			return;
		}
		ValueOutput attachments = output.child(KEY);
		values.forEach((type, value) -> {
			IAttachmentSerializer<Object> serializer = AttachmentTypes.serializer(type);
			Identifier id = NeoForgeRegistries.ATTACHMENT_TYPES.getKey(type);
			if (serializer == null || id == null) {
				return;
			}
			String key = id.toString();
			if (!serializer.write(value, attachments.child(key))) {
				attachments.discard(key);
			}
		});
	}

	/** Reads the attachments {@link #save} wrote, for the attachment types registered now. */
	public void load(ValueInput input) {
		input.child(KEY).ifPresent(attachments -> {
			for (var entry : NeoForgeRegistries.ATTACHMENT_TYPES.entrySet()) {
				AttachmentType<?> type = entry.getValue();
				IAttachmentSerializer<Object> serializer = AttachmentTypes.serializer(type);
				if (serializer == null) {
					continue;
				}
				attachments.child(entry.getKey().identifier().toString()).ifPresent(data -> {
					try {
						map().put(type, serializer.read(holder, data));
					} catch (RuntimeException e) {
						LOGGER.error("Failed to load attachment {}", entry.getKey().identifier(), e);
					}
				});
			}
		});
	}

	/** Copies attachments to another holder: all serializable ones, or only those marked copy-on-death. */
	public void copyTo(AttachmentStore target, HolderLookup.Provider provider, boolean onlyCopyOnDeath) {
		if (!hasAttachments()) {
			return;
		}
		values.forEach((type, value) -> {
			if (onlyCopyOnDeath && !AttachmentTypes.copyOnDeath(type)) {
				return;
			}
			Object copy = AttachmentTypes.copy(type, value, target.holder, provider);
			if (copy != null) {
				target.map().put(type, copy);
			}
		});
	}
}
