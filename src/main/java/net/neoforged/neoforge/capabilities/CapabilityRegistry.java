package net.neoforged.neoforge.capabilities;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import net.minecraft.resources.Identifier;

/**
 * Keeps one capability object per name, so every mod that creates a capability with the same name
 * gets the same object. Creating it again with different types is an error.
 */
public class CapabilityRegistry<C> {
	private final ConcurrentMap<Identifier, StoredCap<C>> caps = new ConcurrentHashMap<>();
	private final CapabilityConstructor<C> constructor;

	public CapabilityRegistry(CapabilityConstructor<C> constructor) {
		this.constructor = constructor;
	}

	public C create(Identifier name, Class<?> typeClass, Class<?> contextClass) {
		StoredCap<C> stored = caps.computeIfAbsent(name, n -> new StoredCap<>(constructor.create(n, typeClass, contextClass), typeClass, contextClass));

		if (stored.typeClass() != typeClass || stored.contextClass() != contextClass) {
			throw new IllegalArgumentException("Capability " + name + " already exists with type " + stored.typeClass().getName()
					+ " and context " + stored.contextClass().getName() + ", not " + typeClass.getName() + " and " + contextClass.getName());
		}

		return stored.cap();
	}

	public List<C> getAll() {
		return caps.values().stream().map(StoredCap::cap).toList();
	}

	public interface CapabilityConstructor<C> {
		C create(Identifier name, Class<?> typeClass, Class<?> contextClass);
	}

	record StoredCap<C>(C cap, Class<?> typeClass, Class<?> contextClass) {
	}
}
