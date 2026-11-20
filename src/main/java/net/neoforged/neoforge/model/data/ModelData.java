package net.neoforged.neoforge.model.data;

import java.util.Map;
import java.util.Set;

/**
 * SteelWool re-implementation of NeoForge's {@code ModelData}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class ModelData {
	public static final net.neoforged.neoforge.model.data.ModelData EMPTY = null /* SteelWool: TODO */;
	private final Map<ModelProperty<?>, Object> properties;
	private Set<ModelProperty<?>> propertySetView;

	private ModelData(Map<ModelProperty<?>, Object> properties) {
		super();
		this.properties = properties;
	}

	public Set<ModelProperty<?>> getProperties() {
		throw new UnsupportedOperationException("SteelWool does not implement ModelData.getProperties yet");
	}

	public boolean has(ModelProperty<?> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModelData.has yet");
	}

	public <T extends Object> T get(ModelProperty<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModelData.get yet");
	}

	public net.neoforged.neoforge.model.data.ModelData.Builder derive() {
		throw new UnsupportedOperationException("SteelWool does not implement ModelData.derive yet");
	}

	public static net.neoforged.neoforge.model.data.ModelData.Builder builder() {
		throw new UnsupportedOperationException("SteelWool does not implement ModelData.builder yet");
	}

	public static <T extends Object> net.neoforged.neoforge.model.data.ModelData of(ModelProperty<T> arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ModelData.of yet");
	}

	public static final class Builder {
		private static final int HASH_THRESHOLD = 4;
		private Map<ModelProperty<?>, Object> properties;

		private Builder(net.neoforged.neoforge.model.data.ModelData arg0) {
			super();
			throw new UnsupportedOperationException("SteelWool does not implement the ModelData.Builder constructor yet");
		}

		public <T extends Object> net.neoforged.neoforge.model.data.ModelData.Builder with(ModelProperty<T> arg0, T arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement ModelData.Builder.with yet");
		}

		public net.neoforged.neoforge.model.data.ModelData build() {
			throw new UnsupportedOperationException("SteelWool does not implement ModelData.Builder.build yet");
		}
	}
}
