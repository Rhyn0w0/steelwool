package net.neoforged.neoforge.client.extensions;

import net.minecraft.util.context.ContextKey;

/**
 * SteelWool re-implementation of NeoForge's {@code IRenderStateExtension}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IRenderStateExtension {
	<T extends Object> T getRenderData(ContextKey<T> arg0);

	<T extends Object> void setRenderData(ContextKey<T> arg0, T arg1);

	default <T extends Object> T getRenderDataOrThrow(ContextKey<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IRenderStateExtension.getRenderDataOrThrow yet");
	}

	default <T extends Object> T getRenderDataOrDefault(ContextKey<T> arg0, T arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement IRenderStateExtension.getRenderDataOrDefault yet");
	}
}
