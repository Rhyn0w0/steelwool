package net.neoforged.neoforge.attachment;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.common.util.ValueIOSerializable;

/**
 * SteelWool re-implementation of NeoForge's {@code AttachmentType}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class AttachmentType<T extends Object> extends Object {
	final Function<IAttachmentHolder, T> defaultValueSupplier;
	final IAttachmentSerializer<T> serializer;
	final boolean copyOnDeath;
	final IAttachmentCopyHandler<T> copyHandler;
	AttachmentSyncHandler<T> syncHandler;

	private AttachmentType(net.neoforged.neoforge.attachment.AttachmentType.Builder<T> arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the AttachmentType constructor yet");
	}

	private static <T extends Object> IAttachmentCopyHandler<T> defaultCopyHandler(IAttachmentSerializer<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement AttachmentType.defaultCopyHandler yet");
	}

	public static <T extends Object> net.neoforged.neoforge.attachment.AttachmentType.Builder<T> builder(Supplier<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement AttachmentType.builder yet");
	}

	public static <T extends Object> net.neoforged.neoforge.attachment.AttachmentType.Builder<T> builder(Function<IAttachmentHolder, T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement AttachmentType.builder yet");
	}

	public static <T extends ValueIOSerializable> net.neoforged.neoforge.attachment.AttachmentType.Builder<T> serializable(Supplier<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement AttachmentType.serializable yet");
	}

	public static <T extends ValueIOSerializable> net.neoforged.neoforge.attachment.AttachmentType.Builder<T> serializable(Function<IAttachmentHolder, T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement AttachmentType.serializable yet");
	}

	public static class Builder<T extends Object> extends Object {
		private final Function<IAttachmentHolder, T> defaultValueSupplier;
		private IAttachmentSerializer<T> serializer;
		private boolean copyOnDeath;
		private IAttachmentCopyHandler<T> copyHandler;
		private AttachmentSyncHandler<T> syncHandler;

		private Builder(Function<IAttachmentHolder, T> defaultValueSupplier) {
			super();
			this.defaultValueSupplier = defaultValueSupplier;
		}

		public net.neoforged.neoforge.attachment.AttachmentType.Builder<T> serialize(IAttachmentSerializer<T> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement AttachmentType.Builder.serialize yet");
		}

		public net.neoforged.neoforge.attachment.AttachmentType.Builder<T> serialize(MapCodec<T> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement AttachmentType.Builder.serialize yet");
		}

		public net.neoforged.neoforge.attachment.AttachmentType.Builder<T> serialize(MapCodec<T> arg0, Predicate<? super T> arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement AttachmentType.Builder.serialize yet");
		}

		public net.neoforged.neoforge.attachment.AttachmentType.Builder<T> copyOnDeath() {
			throw new UnsupportedOperationException("SteelWool does not implement AttachmentType.Builder.copyOnDeath yet");
		}

		public net.neoforged.neoforge.attachment.AttachmentType.Builder<T> copyHandler(IAttachmentCopyHandler<T> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement AttachmentType.Builder.copyHandler yet");
		}

		public net.neoforged.neoforge.attachment.AttachmentType.Builder<T> sync(AttachmentSyncHandler<T> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement AttachmentType.Builder.sync yet");
		}

		public net.neoforged.neoforge.attachment.AttachmentType.Builder<T> sync(StreamCodec<? super RegistryFriendlyByteBuf, T> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement AttachmentType.Builder.sync yet");
		}

		public net.neoforged.neoforge.attachment.AttachmentType.Builder<T> sync(BiPredicate<IAttachmentHolder, ServerPlayer> arg0, StreamCodec<? super RegistryFriendlyByteBuf, T> arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement AttachmentType.Builder.sync yet");
		}

		public net.neoforged.neoforge.attachment.AttachmentType<T> build() {
			throw new UnsupportedOperationException("SteelWool does not implement AttachmentType.Builder.build yet");
		}
	}
}
