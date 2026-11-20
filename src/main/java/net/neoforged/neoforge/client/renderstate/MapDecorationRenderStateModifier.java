package net.neoforged.neoforge.client.renderstate;

import net.minecraft.client.renderer.state.MapRenderState;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;

/**
 * SteelWool re-implementation of NeoForge's {@code MapDecorationRenderStateModifier}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface MapDecorationRenderStateModifier {
	void accept(MapItemSavedData arg0, MapRenderState arg1, MapRenderState.MapDecorationRenderState arg2);
}
