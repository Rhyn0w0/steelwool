package net.neoforged.neoforge.common.util;

import java.util.function.Supplier;

/**
 * SteelWool re-implementation of NeoForge's {@code Lazy}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class Lazy<T extends Object> extends Object implements Supplier<T> {
	private final Supplier<T> delegate;
	private volatile T cachedValue;

	public static <T extends Object> net.neoforged.neoforge.common.util.Lazy<T> of(Supplier<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement Lazy.of yet");
	}

	public synchronized void invalidate() {
		throw new UnsupportedOperationException("SteelWool does not implement Lazy.invalidate yet");
	}

	private Lazy(Supplier<T> delegate) {
		super();
		this.delegate = delegate;
	}

	public T get() {
		throw new UnsupportedOperationException("SteelWool does not implement Lazy.get yet");
	}
}
