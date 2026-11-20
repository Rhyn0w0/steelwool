package net.neoforged.neoforge.model.data;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import org.jspecify.annotations.Nullable;

/** Immutable extra data a block entity gives its block's model: values keyed by {@link ModelProperty}. */
public final class ModelData {
	public static final ModelData EMPTY = new ModelData(Map.of());

	private final Map<ModelProperty<?>, Object> properties;
	private @Nullable Set<ModelProperty<?>> propertySetView;

	private ModelData(Map<ModelProperty<?>, Object> properties) {
		this.properties = properties;
	}

	public Set<ModelProperty<?>> getProperties() {
		if (propertySetView == null) {
			propertySetView = Collections.unmodifiableSet(properties.keySet());
		}
		return propertySetView;
	}

	public boolean has(ModelProperty<?> property) {
		return properties.containsKey(property);
	}

	@SuppressWarnings("unchecked")
	public <T> @Nullable T get(ModelProperty<T> property) {
		return (T) properties.get(property);
	}

	/** A builder starting with this data's values. */
	public Builder derive() {
		return new Builder(this);
	}

	public static Builder builder() {
		return new Builder(null);
	}

	public static <T> ModelData of(ModelProperty<T> property, T value) {
		return builder().with(property, value).build();
	}

	public static final class Builder {
		private static final int HASH_THRESHOLD = 4;
		private Map<ModelProperty<?>, Object> properties;

		private Builder(@Nullable ModelData parent) {
			this.properties = parent != null ? new IdentityHashMap<>(parent.properties) : new IdentityHashMap<>();
		}

		public <T> Builder with(ModelProperty<T> property, T value) {
			if (!property.test(value)) {
				throw new IllegalArgumentException("Value " + value + " is not valid for model property " + property);
			}
			properties.put(property, value);
			return this;
		}

		public ModelData build() {
			return properties.isEmpty() ? EMPTY : new ModelData(Collections.unmodifiableMap(new IdentityHashMap<>(properties)));
		}
	}
}
