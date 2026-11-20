package net.neoforged.neoforge.common.util;

import java.util.function.Supplier;

/** A value computed on first use and then cached, until {@link #invalidate()} is called. */
public final class Lazy<T> implements Supplier<T> {
	private final Supplier<T> delegate;
	private volatile T cachedValue;
	private volatile boolean computed;

	public static <T> Lazy<T> of(Supplier<T> supplier) {
		return new Lazy<>(supplier);
	}

	public synchronized void invalidate() {
		computed = false;
		cachedValue = null;
	}

	private Lazy(Supplier<T> delegate) {
		this.delegate = delegate;
	}

	@Override
	public T get() {
		if (!computed) {
			synchronized (this) {
				if (!computed) {
					cachedValue = delegate.get();
					computed = true;
				}
			}
		}
		return cachedValue;
	}
}
