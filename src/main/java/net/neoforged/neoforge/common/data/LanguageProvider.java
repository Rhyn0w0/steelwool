package net.neoforged.neoforge.common.data;

import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import com.mojang.serialization.Codec;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.fluids.FluidType;

/**
 * SteelWool re-implementation of NeoForge's {@code LanguageProvider}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class LanguageProvider implements DataProvider {
	private static final Codec<Map<String, Component>> CODEC = null /* SteelWool: TODO */;
	private final Map<String, Component> data;
	private final PackOutput output;
	private final String modid;
	private final String locale;

	public LanguageProvider(PackOutput arg0, String arg1, String arg2) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the LanguageProvider constructor yet");
	}

	protected abstract void addTranslations();

	public CompletableFuture<?> run(CachedOutput arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.run yet");
	}

	public String getName() {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.getName yet");
	}

	private CompletableFuture<?> save(CachedOutput arg0, Path arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.save yet");
	}

	public void addBlock(Supplier<? extends Block> arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.addBlock yet");
	}

	public void add(Block arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.add yet");
	}

	public void addItem(Supplier<? extends Item> arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.addItem yet");
	}

	public void add(Item arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.add yet");
	}

	public void addEffect(Supplier<? extends MobEffect> arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.addEffect yet");
	}

	public void add(MobEffect arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.add yet");
	}

	public void addEntityType(Supplier<? extends EntityType<?>> arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.addEntityType yet");
	}

	public void add(EntityType<?> arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.add yet");
	}

	public void addTag(Supplier<? extends TagKey<?>> arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.addTag yet");
	}

	public void add(TagKey<?> arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.add yet");
	}

	public void add(String arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.add yet");
	}

	public void add(String arg0, Component arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.add yet");
	}

	public void addDimension(ResourceKey<Level> arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.addDimension yet");
	}

	public void addBiome(ResourceKey<Biome> arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.addBiome yet");
	}

	public void add(GameRule<?> arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.add yet");
	}

	public void add(GameRule<?> arg0, String arg1, String arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.add yet");
	}

	public void add(GameRuleCategory arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.add yet");
	}

	public void addGameRule(Supplier<? extends GameRule<?>> arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.addGameRule yet");
	}

	public void addGameRule(Supplier<? extends GameRule<?>> arg0, String arg1, String arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.addGameRule yet");
	}

	public void add(FluidType arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.add yet");
	}

	public void addFluidType(Supplier<? extends FluidType> arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.addFluidType yet");
	}

	public void addKey(ResourceKey<?> arg0, String arg1, String arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.addKey yet");
	}

	public void addTranslatableComponent(Component arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.addTranslatableComponent yet");
	}

	public void addConfigCategory(String arg0, String arg1, String arg2, String arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.addConfigCategory yet");
	}

	public void addConfigValue(ModConfigSpec.ConfigValue<?> arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement LanguageProvider.addConfigValue yet");
	}
}
