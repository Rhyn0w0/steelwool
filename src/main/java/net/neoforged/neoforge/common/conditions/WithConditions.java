package net.neoforged.neoforge.common.conditions;

import java.util.Collection;
import java.util.List;

/**
 * SteelWool re-implementation of NeoForge's {@code WithConditions}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public record WithConditions<A extends Object>(List<ICondition> conditions, A carrier) {
	public WithConditions(A arg0) {
		this(List.of(), arg0);
	}

	public static <A extends Object> net.neoforged.neoforge.common.conditions.WithConditions.Builder<A> builder(A arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement WithConditions.builder yet");
	}

	public static class Builder<T extends Object> extends Object {
		private final List<ICondition> conditions;
		private T carrier;

		public Builder() {
			super();
			throw new UnsupportedOperationException("SteelWool does not implement the WithConditions.Builder constructor yet");
		}

		public net.neoforged.neoforge.common.conditions.WithConditions.Builder<T> addCondition(ICondition... arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement WithConditions.Builder.addCondition yet");
		}

		public net.neoforged.neoforge.common.conditions.WithConditions.Builder<T> addCondition(Collection<ICondition> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement WithConditions.Builder.addCondition yet");
		}

		public net.neoforged.neoforge.common.conditions.WithConditions.Builder<T> withCarrier(T arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement WithConditions.Builder.withCarrier yet");
		}

		public net.neoforged.neoforge.common.conditions.WithConditions<T> build() {
			throw new UnsupportedOperationException("SteelWool does not implement WithConditions.Builder.build yet");
		}
	}
}
