package net.neoforged.neoforge.server.permission.nodes;

import java.util.Objects;

/**
 * SteelWool re-implementation of NeoForge's {@code PermissionDynamicContext}, with the same API.
 */
public final class PermissionDynamicContext<T extends Object> extends Object {
	private PermissionDynamicContextKey<T> dynamic;
	private T value;

	PermissionDynamicContext(PermissionDynamicContextKey<T> dynamic, T value) {
		super();
		this.dynamic = dynamic;
		this.value = value;
	}

	public PermissionDynamicContextKey<T> getDynamic() {
		return this.dynamic;
	}

	public T getValue() {
		return this.value;
	}

	public String getSerializedValue() {
		return dynamic.serializer().apply(value);
	}

	public boolean equals(Object o) {
		return this == o || o instanceof PermissionDynamicContext<?> other && dynamic.equals(other.dynamic) && Objects.equals(value, other.value);
	}

	public int hashCode() {
		return Objects.hash(dynamic, value);
	}
}
