package net.neoforged.neoforge.registries.datamaps;

import java.util.Objects;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

/**
 * SteelWool re-implementation of NeoForge's {@code DataMapType}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class DataMapType<R extends Object, T extends Object> extends Object {
	private final ResourceKey<Registry<R>> registryKey;
	private final Identifier id;
	private final Codec<T> codec;
	private final Codec<T> networkCodec;
	private final boolean mandatorySync;

	DataMapType(ResourceKey<Registry<R>> arg0, Identifier arg1, Codec<T> arg2, Codec<T> arg3, boolean arg4) {
		super();
		if (arg3 == null && arg4) {
			throw new IllegalArgumentException("Mandatory sync cannot be enabled when the data map isn't synchronized");
		}
		this.registryKey = Objects.requireNonNull(arg0, "registryKey");
		this.id = Objects.requireNonNull(arg1, "id");
		this.codec = Objects.requireNonNull(arg2, "codec");
		this.networkCodec = arg3;
		this.mandatorySync = arg4;
	}

	public static <T extends Object, R extends Object> net.neoforged.neoforge.registries.datamaps.DataMapType.Builder<T, R> builder(Identifier arg0, ResourceKey<Registry<R>> arg1, Codec<T> arg2) {
		return new Builder<>(arg1, arg0, arg2);
	}

	public ResourceKey<Registry<R>> registryKey() {
		return this.registryKey;
	}

	public Identifier id() {
		return this.id;
	}

	public Codec<T> codec() {
		return this.codec;
	}

	public Codec<T> networkCodec() {
		return this.networkCodec;
	}

	public boolean mandatorySync() {
		return this.mandatorySync;
	}

	public static class Builder<T extends Object, R extends Object> extends Object {
		protected final ResourceKey<Registry<R>> registryKey;
		protected final Identifier id;
		protected final Codec<T> codec;
		protected Codec<T> networkCodec;
		protected boolean mandatorySync;

		Builder(ResourceKey<Registry<R>> registryKey, Identifier id, Codec<T> codec) {
			super();
			this.registryKey = registryKey;
			this.id = id;
			this.codec = codec;
		}

		public net.neoforged.neoforge.registries.datamaps.DataMapType.Builder<T, R> synced(Codec<T> arg0, boolean arg1) {
			this.networkCodec = arg0;
			this.mandatorySync = arg1;
			return this;
		}

		public net.neoforged.neoforge.registries.datamaps.DataMapType<R, T> build() {
			return new DataMapType<>(registryKey, id, codec, networkCodec, mandatorySync);
		}
	}
}
