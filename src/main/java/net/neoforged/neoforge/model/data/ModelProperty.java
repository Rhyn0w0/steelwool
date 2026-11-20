package net.neoforged.neoforge.model.data;

import java.util.function.Predicate;

/**
 * SteelWool re-implementation of NeoForge's {@code ModelProperty}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ModelProperty<T extends Object> extends Object implements Predicate<T> {
	private final Predicate<T> predicate;

	public ModelProperty() {
		this((Predicate) null);
		throw new UnsupportedOperationException("SteelWool does not implement the ModelProperty constructor yet");
	}

	public ModelProperty(Predicate<T> predicate) {
		super();
		this.predicate = predicate;
	}

	public boolean test(T arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModelProperty.test yet");
	}
}
