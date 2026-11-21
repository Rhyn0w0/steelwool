package net.neoforged.neoforge.common.data;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import com.mojang.serialization.Codec;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.common.conditions.WithConditions;
import org.slf4j.Logger;

/**
 * SteelWool re-implementation of NeoForge's {@code JsonCodecProvider}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class JsonCodecProvider<T extends Object> extends Object implements DataProvider {
	private static final Logger LOGGER = null /* SteelWool: TODO */;
	protected final PackOutput.PathProvider pathProvider;
	protected final CompletableFuture<HolderLookup.Provider> lookupProvider;
	protected final String modid;
	protected final String directory;
	protected final Codec<T> codec;
	protected final Map<Identifier, WithConditions<T>> conditions;

	public JsonCodecProvider(PackOutput arg0, PackOutput.Target arg1, String arg2, Codec<T> arg3, CompletableFuture<HolderLookup.Provider> arg4, String arg5) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the JsonCodecProvider constructor yet");
	}

	public CompletableFuture<?> run(CachedOutput arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement JsonCodecProvider.run yet");
	}

	protected abstract void gather();

	public String getName() {
		throw new UnsupportedOperationException("SteelWool does not implement JsonCodecProvider.getName yet");
	}

	public void unconditional(Identifier arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement JsonCodecProvider.unconditional yet");
	}

	public void conditionally(Identifier arg0, Consumer<WithConditions.Builder<T>> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement JsonCodecProvider.conditionally yet");
	}

	private void process(Identifier arg0, WithConditions<T> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement JsonCodecProvider.process yet");
	}
}
