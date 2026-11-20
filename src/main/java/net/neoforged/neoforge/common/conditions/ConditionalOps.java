package net.neoforged.neoforge.common.conditions;

import java.util.List;
import java.util.Optional;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Decoder;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.Encoder;
import com.mojang.serialization.MapCodec;
import net.minecraft.resources.RegistryOps;

/**
 * SteelWool re-implementation of NeoForge's {@code ConditionalOps}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ConditionalOps<T extends Object> extends RegistryOps<T> {
	private final ICondition.IContext context;
	public static final String DEFAULT_CONDITIONS_KEY = "neoforge:conditions";
	public static final String CONDITIONAL_VALUE_KEY = "neoforge:value";

	public ConditionalOps(RegistryOps<T> arg0, ICondition.IContext context) {
		super(dev.steelwool.patch.RegistryOpsParts.delegate(arg0), dev.steelwool.patch.RegistryOpsParts.lookup(arg0));
		this.context = context;
	}

	public ConditionalOps(DynamicOps<T> arg0, RegistryOps.RegistryInfoLookup arg1, ICondition.IContext context) {
		super(arg0, arg1);
		this.context = context;
	}

	public static MapCodec<ICondition.IContext> retrieveContext() {
		throw new UnsupportedOperationException("SteelWool does not implement ConditionalOps.retrieveContext yet");
	}

	public static <T extends Object> Codec<Optional<T>> createConditionalCodec(Codec<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ConditionalOps.createConditionalCodec yet");
	}

	public static <T extends Object> Codec<Optional<T>> createConditionalCodec(Codec<T> arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ConditionalOps.createConditionalCodec yet");
	}

	public static <T extends Object> Codec<List<T>> decodeListWithElementConditions(Codec<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ConditionalOps.decodeListWithElementConditions yet");
	}

	public static <T extends Object> Codec<Optional<WithConditions<T>>> createConditionalCodecWithConditions(Codec<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ConditionalOps.createConditionalCodecWithConditions yet");
	}

	public static <T extends Object> Codec<Optional<WithConditions<T>>> createConditionalCodecWithConditions(Codec<T> arg0, String arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ConditionalOps.createConditionalCodecWithConditions yet");
	}

	public <U extends Object> net.neoforged.neoforge.common.conditions.ConditionalOps<U> withParent(DynamicOps<U> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ConditionalOps.withParent yet");
	}

	static final class ConditionalDecoder<A extends Object> extends Object implements Decoder<Optional<WithConditions<A>>> {
		private final String conditionalsPropertyKey;
		public final Codec<List<ICondition>> conditionsCodec;
		private final Codec<ICondition.IContext> contextCodec;
		private final Decoder<A> innerCodec;

		private ConditionalDecoder(String conditionalsPropertyKey, Codec<List<ICondition>> conditionsCodec, Codec<ICondition.IContext> contextCodec, Decoder<A> innerCodec) {
			super();
			this.conditionalsPropertyKey = conditionalsPropertyKey;
			this.conditionsCodec = conditionsCodec;
			this.contextCodec = contextCodec;
			this.innerCodec = innerCodec;
		}

		public <T extends Object> DataResult<Pair<Optional<WithConditions<A>>, T>> decode(DynamicOps<T> arg0, T arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement ConditionalOps.ConditionalDecoder.decode yet");
		}
	}

	static final class ConditionalEncoder<A extends Object> extends Object implements Encoder<Optional<WithConditions<A>>> {
		private final String conditionalsPropertyKey;
		public final Codec<List<ICondition>> conditionsCodec;
		private final Encoder<A> innerCodec;

		private ConditionalEncoder(String conditionalsPropertyKey, Codec<List<ICondition>> conditionsCodec, Encoder<A> innerCodec) {
			super();
			this.conditionalsPropertyKey = conditionalsPropertyKey;
			this.conditionsCodec = conditionsCodec;
			this.innerCodec = innerCodec;
		}

		public <T extends Object> DataResult<T> encode(Optional<WithConditions<A>> arg0, DynamicOps<T> arg1, T arg2) {
			throw new UnsupportedOperationException("SteelWool does not implement ConditionalOps.ConditionalEncoder.encode yet");
		}

		public String toString() {
			throw new UnsupportedOperationException("SteelWool does not implement ConditionalOps.ConditionalEncoder.toString yet");
		}
	}
}
