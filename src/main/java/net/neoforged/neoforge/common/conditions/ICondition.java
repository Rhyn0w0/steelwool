package net.neoforged.neoforge.common.conditions;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.MapCodec;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.RegistryOps;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.server.ServerLifecycleHooks;

/**
 * A condition on data, such as a recipe that should only load when a mod is present. Conditions are
 * written in a {@code "neoforge:conditions"} list next to the data; each has a {@code "type"} from
 * {@link NeoForgeRegistries#CONDITION_SERIALIZERS}.
 */
public interface ICondition {
	Codec<ICondition> CODEC = NeoForgeRegistries.CONDITION_SERIALIZERS.byNameCodec().dispatch(ICondition::codec, Function.identity());
	Codec<List<ICondition>> LIST_CODEC = CODEC.listOf();

	/** Decodes {@code input} with {@code codec} unless its conditions fail, in which case it is empty. */
	static <V, T> Optional<T> getConditionally(Codec<T> codec, DynamicOps<V> ops, V input) {
		if (!conditionsMatched(ops, input)) {
			return Optional.empty();
		}
		return Optional.of(codec.parse(ops, input).getOrThrow());
	}

	static <V, T> Optional<T> getWithConditionalCodec(Codec<Optional<T>> codec, DynamicOps<V> ops, V input) {
		return codec.parse(ops, input).getOrThrow();
	}

	/** Whether the {@code "neoforge:conditions"} of {@code input} (if any) all pass. */
	static <V> boolean conditionsMatched(DynamicOps<V> ops, V input) {
		return ops.getMap(input).result()
				.map(map -> map.get(ConditionalOps.DEFAULT_CONDITIONS_KEY))
				.map(conditions -> {
					DataResult<List<ICondition>> parsed = LIST_CODEC.parse(ops, conditions);
					IContext context = ops instanceof ConditionalOps<?> conditional ? conditional.conditionContext() : IContext.EMPTY;
					return parsed.getOrThrow().stream().allMatch(condition -> condition.test(context));
				})
				.orElse(true);
	}

	static void writeConditions(HolderLookup.Provider registries, JsonObject json, ICondition... conditions) {
		writeConditions(registries, json, List.of(conditions));
	}

	static void writeConditions(HolderLookup.Provider registries, JsonObject json, List<ICondition> conditions) {
		writeConditions(RegistryOps.create(JsonOps.INSTANCE, registries), json, conditions);
	}

	static void writeConditions(DynamicOps<JsonElement> ops, JsonObject json, List<ICondition> conditions) {
		if (!conditions.isEmpty()) {
			json.add(ConditionalOps.DEFAULT_CONDITIONS_KEY, LIST_CODEC.encodeStart(ops, conditions).getOrThrow());
		}
	}

	boolean test(IContext context);

	MapCodec<? extends ICondition> codec();

	/** What conditions can look at: loaded tags, registries and enabled features. */
	interface IContext {
		IContext EMPTY = new IContext() {
			@Override
			public <T> boolean isTagLoaded(TagKey<T> key) {
				return false;
			}
		};

		IContext TAGS_INVALID = new IContext() {
			@Override
			public <T> boolean isTagLoaded(TagKey<T> key) {
				throw new UnsupportedOperationException("Tag conditions cannot be used here");
			}
		};

		<T> boolean isTagLoaded(TagKey<T> key);

		default <T> Collection<Holder<T>> getTag(TagKey<T> key) {
			return List.of();
		}

		default HolderGetter.Provider registries() {
			return RegistryAccess.EMPTY;
		}

		/** The running server's enabled features, or vanilla's when there is no server. */
		default FeatureFlagSet enabledFeatures() {
			var server = ServerLifecycleHooks.getCurrentServer();
			return server != null ? server.getWorldData().enabledFeatures() : FeatureFlags.VANILLA_SET;
		}
	}
}
