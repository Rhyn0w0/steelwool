package net.neoforged.neoforge.common.data;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.WithConditions;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;

/**
 * SteelWool re-implementation of NeoForge's {@code GlobalLootModifierProvider}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class GlobalLootModifierProvider implements DataProvider {
	private final PackOutput output;
	private final CompletableFuture<HolderLookup.Provider> registriesLookup;
	protected HolderLookup.Provider registries;
	private final String modid;
	private final Map<String, WithConditions<IGlobalLootModifier>> toSerialize;

	public GlobalLootModifierProvider(PackOutput arg0, CompletableFuture<HolderLookup.Provider> arg1, String arg2) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the GlobalLootModifierProvider constructor yet");
	}

	protected abstract void start();

	public final CompletableFuture<?> run(CachedOutput arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement GlobalLootModifierProvider.run yet");
	}

	protected CompletableFuture<?> run(CachedOutput arg0, HolderLookup.Provider arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement GlobalLootModifierProvider.run yet");
	}

	public <T extends IGlobalLootModifier> void add(String arg0, T arg1, List<ICondition> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement GlobalLootModifierProvider.add yet");
	}

	public <T extends IGlobalLootModifier> void add(String arg0, T arg1, ICondition... arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement GlobalLootModifierProvider.add yet");
	}

	public String getName() {
		throw new UnsupportedOperationException("SteelWool does not implement GlobalLootModifierProvider.getName yet");
	}
}
