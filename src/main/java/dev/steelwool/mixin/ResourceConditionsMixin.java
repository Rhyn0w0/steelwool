package dev.steelwool.mixin;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import dev.steelwool.crafting.NeoForgeIngredientJson;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import net.fabricmc.fabric.impl.resource.conditions.ResourceConditionsImpl;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.neoforged.neoforge.common.conditions.ConditionalOps;
import net.neoforged.neoforge.common.conditions.ICondition;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Hooks into the place where Fabric API checks its own load conditions (recipes, loot tables,
 * advancements and other data) to handle NeoForge's data formats too: data whose
 * {@code "neoforge:conditions"} fail is skipped, as on NeoForge, and NeoForge custom ingredients are
 * rewritten into Fabric API ones ({@link NeoForgeIngredientJson}).
 */
@Mixin(value = ResourceConditionsImpl.class, remap = false)
public abstract class ResourceConditionsMixin {
	private static final Logger STEELWOOL_LOGGER = LoggerFactory.getLogger("SteelWool");

	@Inject(method = "applyResourceConditions", at = @At("HEAD"), cancellable = true)
	private static void steelwool$applyNeoForgeConditions(JsonObject obj, String dataType, Identifier key, RegistryOps.@Nullable RegistryInfoLookup registryInfo,
			CallbackInfoReturnable<Boolean> cir) {
		if (NeoForgeIngredientJson.mentions(obj)) {
			NeoForgeIngredientJson.rewrite(obj);
		}

		JsonElement conditions = obj.get(ConditionalOps.DEFAULT_CONDITIONS_KEY);
		if (conditions == null) {
			return;
		}
		try {
			List<ICondition> parsed = ICondition.LIST_CODEC.parse(JsonOps.INSTANCE, conditions).getOrThrow();
			ICondition.IContext context = steelwool$context(registryInfo);
			if (!parsed.stream().allMatch(condition -> condition.test(context))) {
				STEELWOOL_LOGGER.debug("Skipping {} {}: its NeoForge conditions are not met", dataType, key);
				cir.setReturnValue(false);
			}
		} catch (RuntimeException e) {
			STEELWOOL_LOGGER.error("Skipping {} {}: could not read its NeoForge conditions", dataType, key, e);
			cir.setReturnValue(false);
		}
	}

	/** Conditions see the tags and registries of the data being loaded. */
	private static ICondition.IContext steelwool$context(RegistryOps.@Nullable RegistryInfoLookup registryInfo) {
		return new ICondition.IContext() {
			@Override
			public <T> boolean isTagLoaded(TagKey<T> tag) {
				return info(tag.registry()).flatMap(getter -> getter.get(tag)).isPresent();
			}

			@Override
			public <T> Collection<Holder<T>> getTag(TagKey<T> tag) {
				return info(tag.registry()).flatMap(getter -> getter.get(tag))
						.<Collection<Holder<T>>>map(set -> {
							try {
								return set.stream().toList();
							} catch (IllegalStateException unbound) {
								// While data loads, tags exist but their contents are not bound yet. A defined
								// tag is treated as non-empty (contents unknown), like Fabric's tag conditions.
								return java.util.Collections.singletonList(null);
							}
						})
						.orElse(List.of());
			}

			@Override
			public HolderGetter.Provider registries() {
				return new HolderGetter.Provider() {
					@Override
					public <T> Optional<? extends HolderGetter<T>> lookup(ResourceKey<? extends Registry<? extends T>> registryKey) {
						return info(registryKey);
					}
				};
			}

			@Override
			public FeatureFlagSet enabledFeatures() {
				return ResourceConditionsImpl.currentFeatures != null ? ResourceConditionsImpl.currentFeatures : ICondition.IContext.super.enabledFeatures();
			}

			private <T> Optional<HolderGetter<T>> info(ResourceKey<? extends Registry<? extends T>> registryKey) {
				return registryInfo == null ? Optional.empty() : registryInfo.lookup(registryKey);
			}
		};
	}
}
