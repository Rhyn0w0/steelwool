package net.neoforged.neoforge.common.extensions;

/**
 * SteelWool re-implementation of NeoForge's {@code IHolderSetExtension}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IHolderSetExtension<T extends Object> {
	default void addInvalidationListener(Runnable arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IHolderSetExtension.addInvalidationListener yet");
	}

	default net.neoforged.neoforge.common.extensions.IHolderSetExtension.SerializationType serializationType() {
		throw new UnsupportedOperationException("SteelWool does not implement IHolderSetExtension.serializationType yet");
	}

	default boolean isImmediatelyResolvable() {
		throw new UnsupportedOperationException("SteelWool does not implement IHolderSetExtension.isImmediatelyResolvable yet");
	}

	public enum SerializationType {
		UNKNOWN, STRING, LIST, OBJECT;
	}
}
