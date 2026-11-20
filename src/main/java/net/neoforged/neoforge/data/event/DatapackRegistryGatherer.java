package net.neoforged.neoforge.data.event;

import java.util.List;
import java.util.function.BiFunction;

import net.minecraft.advancements.Advancement;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.MultiRegistryBootstrap;
import net.minecraft.core.registries.SingleRegistryBootstrap;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.Recipe;

/**
 * SteelWool re-implementation of NeoForge's {@code DatapackRegistryGatherer}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface DatapackRegistryGatherer {
	<T extends Object> net.neoforged.neoforge.data.event.DatapackRegistryGatherer add(ResourceKey<? extends Registry<T>> arg0, SingleRegistryBootstrap<T> arg1) throws IllegalArgumentException;

	net.neoforged.neoforge.data.event.DatapackRegistryGatherer add(MultiRegistryBootstrap arg0) throws IllegalArgumentException;

	default net.neoforged.neoforge.data.event.DatapackRegistryGatherer lootTable(LootTableProvider.SubProviderEntry arg0, LootTableProvider.SubProviderEntry... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DatapackRegistryGatherer.lootTable yet");
	}

	default net.neoforged.neoforge.data.event.DatapackRegistryGatherer advancement(AdvancementSubProvider.Factory arg0, AdvancementSubProvider.Factory... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DatapackRegistryGatherer.advancement yet");
	}

	default net.neoforged.neoforge.data.event.DatapackRegistryGatherer recipe(BiFunction<BootstrapContext<Recipe<?>>, BootstrapContext<Advancement>, ? extends RecipeProvider> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DatapackRegistryGatherer.recipe yet");
	}

	private static <T extends Object> List<T> createList(T arg0, T... arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DatapackRegistryGatherer.createList yet");
	}
}
