package net.neoforged.neoforge.common.conditions;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlagSet;

/**
 * SteelWool re-implementation of NeoForge's {@code ICondition}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface ICondition {
	public static final Codec<net.neoforged.neoforge.common.conditions.ICondition> CODEC = null /* SteelWool: TODO */;
	public static final Codec<List<net.neoforged.neoforge.common.conditions.ICondition>> LIST_CODEC = null /* SteelWool: TODO */;

	static <V extends Object, T extends Object> Optional<T> getConditionally(Codec<T> arg0, DynamicOps<V> arg1, V arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ICondition.getConditionally yet");
	}

	static <V extends Object, T extends Object> Optional<T> getWithConditionalCodec(Codec<Optional<T>> arg0, DynamicOps<V> arg1, V arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ICondition.getWithConditionalCodec yet");
	}

	static <V extends Object> boolean conditionsMatched(DynamicOps<V> arg0, V arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ICondition.conditionsMatched yet");
	}

	static void writeConditions(HolderLookup.Provider arg0, JsonObject arg1, net.neoforged.neoforge.common.conditions.ICondition... arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ICondition.writeConditions yet");
	}

	static void writeConditions(HolderLookup.Provider arg0, JsonObject arg1, List<net.neoforged.neoforge.common.conditions.ICondition> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ICondition.writeConditions yet");
	}

	static void writeConditions(DynamicOps<JsonElement> arg0, JsonObject arg1, List<net.neoforged.neoforge.common.conditions.ICondition> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ICondition.writeConditions yet");
	}

	boolean test(net.neoforged.neoforge.common.conditions.ICondition.IContext arg0);

	MapCodec<? extends net.neoforged.neoforge.common.conditions.ICondition> codec();

	public interface IContext {
		public static final net.neoforged.neoforge.common.conditions.ICondition.IContext EMPTY = null /* SteelWool: TODO */;
		public static final net.neoforged.neoforge.common.conditions.ICondition.IContext TAGS_INVALID = null /* SteelWool: TODO */;

		<T extends Object> boolean isTagLoaded(TagKey<T> arg0);

		default <T extends Object> Collection<Holder<T>> getTag(TagKey<T> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement ICondition.IContext.getTag yet");
		}

		default HolderGetter.Provider registries() {
			throw new UnsupportedOperationException("SteelWool does not implement ICondition.IContext.registries yet");
		}

		default FeatureFlagSet enabledFeatures() {
			throw new UnsupportedOperationException("SteelWool does not implement ICondition.IContext.enabledFeatures yet");
		}
	}
}
