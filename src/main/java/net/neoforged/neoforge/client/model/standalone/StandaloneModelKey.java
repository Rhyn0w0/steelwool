package net.neoforged.neoforge.client.model.standalone;

import net.minecraft.client.resources.model.ModelDebugName;

/**
 * SteelWool re-implementation of NeoForge's {@code StandaloneModelKey}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class StandaloneModelKey<T extends Object> extends Object {
	private final ModelDebugName name;

	public StandaloneModelKey(ModelDebugName name) {
		super();
		this.name = name;
	}

	public String getName() {
		throw new UnsupportedOperationException("SteelWool does not implement StandaloneModelKey.getName yet");
	}

	public String toString() {
		throw new UnsupportedOperationException("SteelWool does not implement StandaloneModelKey.toString yet");
	}
}
