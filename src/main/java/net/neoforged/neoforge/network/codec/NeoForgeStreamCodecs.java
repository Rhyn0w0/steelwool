package net.neoforged.neoforge.network.codec;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.level.ChunkPos;

/**
 * SteelWool subset of NeoForge's {@code NeoForgeStreamCodecs}.
 */
public final class NeoForgeStreamCodecs {
	public static final StreamCodec<FriendlyByteBuf, byte[]> UNBOUNDED_BYTE_ARRAY = new StreamCodec<>() {
		@Override
		public byte[] decode(FriendlyByteBuf buf) {
			return buf.readByteArray();
		}

		@Override
		public void encode(FriendlyByteBuf buf, byte[] value) {
			buf.writeByteArray(value);
		}
	};

	public static final StreamCodec<FriendlyByteBuf, ChunkPos> CHUNK_POS = new StreamCodec<>() {
		@Override
		public ChunkPos decode(FriendlyByteBuf buf) {
			return buf.readChunkPos();
		}

		@Override
		public void encode(FriendlyByteBuf buf, ChunkPos pos) {
			buf.writeChunkPos(pos);
		}
	};

	private NeoForgeStreamCodecs() {
	}

	public static <B extends FriendlyByteBuf, V extends Enum<V>> StreamCodec<B, V> enumCodec(Class<V> enumClass) {
		return new StreamCodec<>() {
			@Override
			public V decode(B buf) {
				return buf.readEnum(enumClass);
			}

			@Override
			public void encode(B buf, V value) {
				buf.writeEnum(value);
			}
		};
	}

	/** A codec created on first use, for codecs that refer to each other. */
	public static <B, V> StreamCodec<B, V> lazy(java.util.function.Supplier<StreamCodec<B, V>> supplier) {
		java.util.function.Supplier<StreamCodec<B, V>> codec = com.google.common.base.Suppliers.memoize(supplier::get);
		return new StreamCodec<>() {
			@Override
			public V decode(B buf) {
				return codec.get().decode(buf);
			}

			@Override
			public void encode(B buf, V value) {
				codec.get().encode(buf, value);
			}
		};
	}

	/** Writes nothing and always reads {@code value}; does not check what is encoded. */
	public static <B, V> StreamCodec<B, V> uncheckedUnit(V value) {
		return new StreamCodec<>() {
			@Override
			public V decode(B buf) {
				return value;
			}

			@Override
			public void encode(B buf, V ignored) {
			}
		};
	}

	/** A registry key, written as its identifier. */
	public static <B extends FriendlyByteBuf> StreamCodec<B, net.minecraft.resources.ResourceKey<? extends net.minecraft.core.Registry<?>>> registryKey() {
		return new StreamCodec<>() {
			@Override
			public net.minecraft.resources.ResourceKey<? extends net.minecraft.core.Registry<?>> decode(B buf) {
				return net.minecraft.resources.ResourceKey.createRegistryKey(buf.readIdentifier());
			}

			@Override
			public void encode(B buf, net.minecraft.resources.ResourceKey<? extends net.minecraft.core.Registry<?>> key) {
				buf.writeIdentifier(key.identifier());
			}
		};
	}
}
