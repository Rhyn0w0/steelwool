package net.neoforged.neoforge.capabilities;

import net.minecraft.resources.Identifier;

/**
 * SteelWool re-implementation of NeoForge's {@code BaseCapability}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class BaseCapability<T extends Object, C extends Object> extends Object {
	private final Identifier name;
	private final Class<T> typeClass;
	private final Class<C> contextClass;

	protected BaseCapability(Identifier name, Class<T> typeClass, Class<C> contextClass) {
		super();
		this.name = name;
		this.typeClass = typeClass;
		this.contextClass = contextClass;
	}

	public final Identifier name() {
		return this.name;
	}

	public final Class<T> typeClass() {
		return this.typeClass;
	}

	public final Class<C> contextClass() {
		return this.contextClass;
	}
}
