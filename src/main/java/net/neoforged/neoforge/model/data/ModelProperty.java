package net.neoforged.neoforge.model.data;

import java.util.function.Predicate;

/** A key in {@link ModelData}; values must pass the predicate. */
public class ModelProperty<T> implements Predicate<T> {
	private final Predicate<T> predicate;

	public ModelProperty() {
		this(value -> true);
	}

	public ModelProperty(Predicate<T> predicate) {
		this.predicate = predicate;
	}

	@Override
	public boolean test(T value) {
		return predicate.test(value);
	}
}
