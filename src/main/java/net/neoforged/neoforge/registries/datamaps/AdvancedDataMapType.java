package net.neoforged.neoforge.registries.datamaps;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

/**
 * SteelWool re-implementation of NeoForge's {@code AdvancedDataMapType}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class AdvancedDataMapType<R extends Object, T extends Object, VR extends DataMapValueRemover<R, T>> extends DataMapType<R, T> {
	private final Codec<VR> remover;
	private final DataMapValueMerger<R, T> merger;
	private final boolean supportsTags;
	private final String noTagsReason;

	private AdvancedDataMapType(ResourceKey<Registry<R>> arg0, Identifier arg1, Codec<T> arg2, Codec<T> arg3, boolean arg4, Codec<VR> arg5, DataMapValueMerger<R, T> arg6, String arg7) {
		super(arg0, arg1, arg2, arg3, arg4);
		this.remover = arg5;
		this.merger = arg6;
		this.supportsTags = arg7 == null;
		this.noTagsReason = arg7;
	}

	public Codec<VR> remover() {
		return this.remover;
	}

	public DataMapValueMerger<R, T> merger() {
		return this.merger;
	}

	public boolean supportsTags() {
		return this.supportsTags;
	}

	public String getNoTagsReason() {
		return noTagsReason;
	}

	public static <T extends Object, R extends Object> net.neoforged.neoforge.registries.datamaps.AdvancedDataMapType.Builder<T, R, DataMapValueRemover.Default<T, R>> builder(Identifier arg0, ResourceKey<Registry<R>> arg1, Codec<T> arg2) {
		return new Builder<>(arg1, arg0, arg2);
	}

	public static final class Builder<T extends Object, R extends Object, VR extends DataMapValueRemover<R, T>> extends DataMapType.Builder<T, R> {
		private Codec<VR> remover;
		private DataMapValueMerger<R, T> merger;
		private String noTagsReason;

		Builder(ResourceKey<Registry<R>> arg0, Identifier arg1, Codec<T> arg2) {
			super(arg0, arg1, arg2);
			this.remover = (Codec) DataMapValueRemover.Default.codec();
			this.merger = DataMapValueMerger.defaultMerger();
		}

		public <VR1 extends DataMapValueRemover<R, T>> net.neoforged.neoforge.registries.datamaps.AdvancedDataMapType.Builder<T, R, VR1> remover(Codec<VR1> arg0) {
			this.remover = (Codec) arg0;
			return (Builder) this;
		}

		public net.neoforged.neoforge.registries.datamaps.AdvancedDataMapType.Builder<T, R, VR> merger(DataMapValueMerger<R, T> arg0) {
			this.merger = arg0;
			return this;
		}

		public net.neoforged.neoforge.registries.datamaps.AdvancedDataMapType.Builder<T, R, VR> synced(Codec<T> arg0, boolean arg1) {
			super.synced(arg0, arg1);
			return this;
		}

		public net.neoforged.neoforge.registries.datamaps.AdvancedDataMapType.Builder<T, R, VR> disableTagSupport(String arg0) {
			this.noTagsReason = arg0;
			return this;
		}

		public net.neoforged.neoforge.registries.datamaps.AdvancedDataMapType<R, T, VR> build() {
			return new AdvancedDataMapType<>(registryKey, id, codec, networkCodec, mandatorySync, remover, merger, noTagsReason);
		}
	}
}
