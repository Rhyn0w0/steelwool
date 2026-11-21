package net.neoforged.neoforge.internal;

/**
 * SteelWool re-implementation of NeoForge's {@code CommonModLoader}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class CommonModLoader {
	private static boolean registriesLoaded;

	public CommonModLoader() {
		super();
	}

	public static boolean areRegistriesLoaded() {
		throw new UnsupportedOperationException("SteelWool does not implement CommonModLoader.areRegistriesLoaded yet");
	}

	protected static void begin(Runnable arg0, boolean arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonModLoader.begin yet");
	}

	protected static void load(Runnable arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement CommonModLoader.load yet");
	}
}
