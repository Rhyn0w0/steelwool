package net.neoforged.neoforge.attachment;

import com.mojang.serialization.MapCodec;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.storage.TagValueInput;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.common.util.ValueIOSerializable;
import org.jspecify.annotations.Nullable;

/**
 * A kind of data that can be attached to entities, block entities, chunks and levels. Register it in
 * {@code NeoForgeRegistries.ATTACHMENT_TYPES}. Serializable attachments are saved with entities and
 * block entities.
 *
 * <p>On SteelWool, sync handlers are accepted but attachments are not synced to clients yet.
 */
public final class AttachmentType<T> {
	final Function<IAttachmentHolder, T> defaultValueSupplier;
	final @Nullable IAttachmentSerializer<T> serializer;
	final boolean copyOnDeath;
	final @Nullable IAttachmentCopyHandler<T> copyHandler;
	@Nullable AttachmentSyncHandler<T> syncHandler;

	private AttachmentType(Builder<T> builder) {
		this.defaultValueSupplier = builder.defaultValueSupplier;
		this.serializer = builder.serializer;
		this.copyOnDeath = builder.copyOnDeath;
		this.copyHandler = builder.copyHandler != null ? builder.copyHandler
				: builder.serializer != null ? defaultCopyHandler(builder.serializer) : null;
		this.syncHandler = builder.syncHandler;
	}

	/** Copies a value by writing it with the serializer and reading it back into the new holder. */
	private static <T> IAttachmentCopyHandler<T> defaultCopyHandler(IAttachmentSerializer<T> serializer) {
		return (value, holder, provider) -> {
			TagValueOutput output = TagValueOutput.createWithContext(net.minecraft.util.ProblemReporter.DISCARDING, provider);
			if (!serializer.write(value, output)) {
				return null;
			}
			ValueInput input = TagValueInput.create(net.minecraft.util.ProblemReporter.DISCARDING, provider, output.buildResult());
			return serializer.read(holder, input);
		};
	}

	public static <T> Builder<T> builder(Supplier<T> defaultValueSupplier) {
		return builder(holder -> defaultValueSupplier.get());
	}

	public static <T> Builder<T> builder(Function<IAttachmentHolder, T> defaultValueConstructor) {
		return new Builder<>(defaultValueConstructor);
	}

	public static <T extends ValueIOSerializable> Builder<T> serializable(Supplier<T> defaultValueSupplier) {
		return serializable(holder -> defaultValueSupplier.get());
	}

	public static <T extends ValueIOSerializable> Builder<T> serializable(Function<IAttachmentHolder, T> defaultValueConstructor) {
		return builder(defaultValueConstructor).serialize(new IAttachmentSerializer<T>() {
			@Override
			public T read(IAttachmentHolder holder, ValueInput input) {
				T value = defaultValueConstructor.apply(holder);
				value.deserialize(input);
				return value;
			}

			@Override
			public boolean write(T value, ValueOutput output) {
				value.serialize(output);
				return true;
			}
		});
	}

	public static class Builder<T> {
		private final Function<IAttachmentHolder, T> defaultValueSupplier;
		private @Nullable IAttachmentSerializer<T> serializer;
		private boolean copyOnDeath;
		private @Nullable IAttachmentCopyHandler<T> copyHandler;
		private @Nullable AttachmentSyncHandler<T> syncHandler;

		private Builder(Function<IAttachmentHolder, T> defaultValueSupplier) {
			this.defaultValueSupplier = defaultValueSupplier;
		}

		public Builder<T> serialize(IAttachmentSerializer<T> serializer) {
			if (this.serializer != null) {
				throw new IllegalStateException("Serializer already set");
			}
			this.serializer = Objects.requireNonNull(serializer);
			return this;
		}

		public Builder<T> serialize(MapCodec<T> codec) {
			return serialize(codec, value -> true);
		}

		public Builder<T> serialize(MapCodec<T> codec, Predicate<? super T> shouldSerialize) {
			Objects.requireNonNull(codec);
			return serialize(new IAttachmentSerializer<T>() {
				@Override
				public T read(IAttachmentHolder holder, ValueInput input) {
					return input.read(codec).orElseThrow(() -> new IllegalStateException("Could not read attachment"));
				}

				@Override
				public boolean write(T value, ValueOutput output) {
					if (!shouldSerialize.test(value)) {
						return false;
					}
					output.store(codec, value);
					return true;
				}
			});
		}

		public Builder<T> copyOnDeath() {
			if (serializer == null) {
				throw new IllegalStateException("copyOnDeath needs a serializer");
			}
			this.copyOnDeath = true;
			return this;
		}

		public Builder<T> copyHandler(IAttachmentCopyHandler<T> copyHandler) {
			this.copyHandler = Objects.requireNonNull(copyHandler);
			return this;
		}

		public Builder<T> sync(AttachmentSyncHandler<T> syncHandler) {
			this.syncHandler = Objects.requireNonNull(syncHandler);
			return this;
		}

		public Builder<T> sync(StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec) {
			return sync((holder, player) -> true, streamCodec);
		}

		public Builder<T> sync(BiPredicate<IAttachmentHolder, ServerPlayer> sendToPlayer, StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec) {
			Objects.requireNonNull(streamCodec);
			return sync(new AttachmentSyncHandler<T>() {
				@Override
				public boolean sendToPlayer(IAttachmentHolder holder, ServerPlayer player) {
					return sendToPlayer.test(holder, player);
				}

				@Override
				public void write(RegistryFriendlyByteBuf buf, T attachment, boolean initialSync) {
					streamCodec.encode(buf, attachment);
				}

				@Override
				public T read(IAttachmentHolder holder, RegistryFriendlyByteBuf buf, @Nullable T previousValue) {
					return streamCodec.decode(buf);
				}
			});
		}

		public AttachmentType<T> build() {
			return new AttachmentType<>(this);
		}
	}
}
