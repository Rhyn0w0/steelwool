package net.neoforged.neoforge.common.data;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import com.google.gson.JsonElement;
import com.mojang.datafixers.util.Either;
import com.mojang.serialization.DynamicOps;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.WithConditions;
import net.neoforged.neoforge.registries.datamaps.AdvancedDataMapType;
import net.neoforged.neoforge.registries.datamaps.DataMapEntry;
import net.neoforged.neoforge.registries.datamaps.DataMapFile;
import net.neoforged.neoforge.registries.datamaps.DataMapType;
import net.neoforged.neoforge.registries.datamaps.DataMapValueRemover;

/**
 * SteelWool re-implementation of NeoForge's {@code DataMapProvider}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class DataMapProvider implements DataProvider {
	protected final CompletableFuture<HolderLookup.Provider> lookupProvider;
	protected final PackOutput.PathProvider pathProvider;
	private final Map<DataMapType<?, ?>, net.neoforged.neoforge.common.data.DataMapProvider.Builder<?, ?>> builders;

	protected DataMapProvider(PackOutput arg0, CompletableFuture<HolderLookup.Provider> arg1) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the DataMapProvider constructor yet");
	}

	public CompletableFuture<?> run(CachedOutput arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DataMapProvider.run yet");
	}

	private <T extends Object, R extends Object> CompletableFuture<?> generate(Path arg0, CachedOutput arg1, net.neoforged.neoforge.common.data.DataMapProvider.Builder<T, R> arg2, DynamicOps<JsonElement> arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement DataMapProvider.generate yet");
	}

	protected abstract void gather(HolderLookup.Provider arg0);

	public <T extends Object, R extends Object> net.neoforged.neoforge.common.data.DataMapProvider.Builder<T, R> builder(DataMapType<R, T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DataMapProvider.builder yet");
	}

	public <T extends Object, R extends Object, VR extends DataMapValueRemover<R, T>> net.neoforged.neoforge.common.data.DataMapProvider.AdvancedBuilder<T, R, VR> builder(AdvancedDataMapType<R, T, VR> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DataMapProvider.builder yet");
	}

	public String getName() {
		throw new UnsupportedOperationException("SteelWool does not implement DataMapProvider.getName yet");
	}

	public static class AdvancedBuilder<T extends Object, R extends Object, VR extends DataMapValueRemover<R, T>> extends net.neoforged.neoforge.common.data.DataMapProvider.Builder<T, R> {
		public AdvancedBuilder(AdvancedDataMapType<R, T, VR> arg0) {
			super(arg0);
		}

		public net.neoforged.neoforge.common.data.DataMapProvider.AdvancedBuilder<T, R, VR> remove(TagKey<R> arg0, VR arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement DataMapProvider.AdvancedBuilder.remove yet");
		}

		public net.neoforged.neoforge.common.data.DataMapProvider.AdvancedBuilder<T, R, VR> remove(Holder<R> arg0, VR arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement DataMapProvider.AdvancedBuilder.remove yet");
		}

		public net.neoforged.neoforge.common.data.DataMapProvider.AdvancedBuilder<T, R, VR> remove(Identifier arg0, VR arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement DataMapProvider.AdvancedBuilder.remove yet");
		}
	}

	public static class Builder<T extends Object, R extends Object> extends Object {
		private final Map<Either<TagKey<R>, ResourceKey<R>>, Optional<WithConditions<DataMapEntry<T>>>> values;
		protected final List<DataMapEntry.Removal<T, R>> removals;
		protected final ResourceKey<Registry<R>> registryKey;
		private final DataMapType<R, T> type;
		private final List<ICondition> conditions;
		private final String noTagsReason;
		private boolean replace;

		public Builder(DataMapType<R, T> arg0) {
			super();
			throw new UnsupportedOperationException("SteelWool does not implement the DataMapProvider.Builder constructor yet");
		}

		public net.neoforged.neoforge.common.data.DataMapProvider.Builder<T, R> add(ResourceKey<R> arg0, T arg1, boolean arg2, ICondition... arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement DataMapProvider.Builder.add yet");
		}

		public net.neoforged.neoforge.common.data.DataMapProvider.Builder<T, R> add(Identifier arg0, T arg1, boolean arg2, ICondition... arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement DataMapProvider.Builder.add yet");
		}

		public net.neoforged.neoforge.common.data.DataMapProvider.Builder<T, R> add(Holder<R> arg0, T arg1, boolean arg2, ICondition... arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement DataMapProvider.Builder.add yet");
		}

		public net.neoforged.neoforge.common.data.DataMapProvider.Builder<T, R> add(TagKey<R> arg0, T arg1, boolean arg2, ICondition... arg3) {
			throw new UnsupportedOperationException("SteelWool does not implement DataMapProvider.Builder.add yet");
		}

		public net.neoforged.neoforge.common.data.DataMapProvider.Builder<T, R> remove(Identifier arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement DataMapProvider.Builder.remove yet");
		}

		public net.neoforged.neoforge.common.data.DataMapProvider.Builder<T, R> remove(TagKey<R> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement DataMapProvider.Builder.remove yet");
		}

		public net.neoforged.neoforge.common.data.DataMapProvider.Builder<T, R> remove(Holder<R> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement DataMapProvider.Builder.remove yet");
		}

		public net.neoforged.neoforge.common.data.DataMapProvider.Builder<T, R> replace(boolean arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement DataMapProvider.Builder.replace yet");
		}

		public net.neoforged.neoforge.common.data.DataMapProvider.Builder<T, R> conditions(ICondition... arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement DataMapProvider.Builder.conditions yet");
		}

		public WithConditions<DataMapFile<T, R>> build() {
			throw new UnsupportedOperationException("SteelWool does not implement DataMapProvider.Builder.build yet");
		}
	}
}
