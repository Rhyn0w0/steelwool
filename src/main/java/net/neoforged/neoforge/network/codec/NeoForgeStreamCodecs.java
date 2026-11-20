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
}
