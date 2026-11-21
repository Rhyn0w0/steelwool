package net.neoforged.neoforge.server.permission.nodes;

import java.util.Objects;

/**
 * SteelWool re-implementation of NeoForge's {@code PermissionType}, with the same API.
 */
public final class PermissionType<T extends Object> extends Object {
	private final Class<T> typeToken;
	private final String typeName;

	PermissionType(Class<T> typeToken, String typeName) {
		super();
		this.typeToken = typeToken;
		this.typeName = typeName;
	}

	public Class<T> typeToken() {
		return this.typeToken;
	}

	public String typeName() {
		return this.typeName;
	}

	public boolean equals(Object o) {
		return this == o || o instanceof PermissionType<?> other && typeToken.equals(other.typeToken) && typeName.equals(other.typeName);
	}

	public int hashCode() {
		return Objects.hash(typeToken, typeName);
	}

	public String toString() {
		return "PermissionType[" + typeName + "]";
	}
}
