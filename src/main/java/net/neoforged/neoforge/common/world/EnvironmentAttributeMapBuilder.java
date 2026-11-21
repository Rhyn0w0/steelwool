package net.neoforged.neoforge.common.world;

import net.minecraft.world.attribute.EnvironmentAttribute;
import net.minecraft.world.attribute.EnvironmentAttributeMap;

/**
 * SteelWool re-implementation of NeoForge's {@code EnvironmentAttributeMapBuilder}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class EnvironmentAttributeMapBuilder extends EnvironmentAttributeMap.Builder {
	public static net.neoforged.neoforge.common.world.EnvironmentAttributeMapBuilder copyOf(EnvironmentAttributeMap arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement EnvironmentAttributeMapBuilder.copyOf yet");
	}

	private EnvironmentAttributeMapBuilder() {
		super();
	}

	public <V extends Object> EnvironmentAttributeMap.Entry<V, ?> get(EnvironmentAttribute<V> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement EnvironmentAttributeMapBuilder.get yet");
	}
}
