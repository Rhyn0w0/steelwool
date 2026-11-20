package net.neoforged.neoforge.client.renderstate;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.state.MapRenderState;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;

/**
 * SteelWool re-implementation of NeoForge's {@code RenderStateExtensions}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class RenderStateExtensions {
	private static final Map<Class<?>, Collection<BiConsumer<?, ?>>> ENTITY = null /* SteelWool: TODO */;
	private static final Map<Class<?>, Collection<BiConsumer<?, ?>>> ENTITY_CACHE = null /* SteelWool: TODO */;
	private static final List<BiConsumer<MapItemSavedData, MapRenderState>> MAP = null /* SteelWool: TODO */;
	private static final Map<ResourceKey<MapDecorationType>, Collection<MapDecorationRenderStateModifier>> MAP_DECORATION = null /* SteelWool: TODO */;

	private RenderStateExtensions() {
		super();
	}

	public static <E extends Entity, S extends EntityRenderState> void onUpdateEntityRenderState(EntityRenderer<E, S> arg0, E arg1, S arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement RenderStateExtensions.onUpdateEntityRenderState yet");
	}

	public static void onUpdateMapRenderState(MapItemSavedData arg0, MapRenderState arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RenderStateExtensions.onUpdateMapRenderState yet");
	}

	public static MapRenderState.MapDecorationRenderState onUpdateMapDecorationRenderState(Holder<MapDecorationType> arg0, MapItemSavedData arg1, MapRenderState arg2, MapRenderState.MapDecorationRenderState arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement RenderStateExtensions.onUpdateMapDecorationRenderState yet");
	}

	static void registerEntity(Class<?> arg0, BiConsumer<?, ?> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RenderStateExtensions.registerEntity yet");
	}

	static void registerMap(BiConsumer<MapItemSavedData, MapRenderState> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RenderStateExtensions.registerMap yet");
	}

	static void registerMapDecoration(ResourceKey<MapDecorationType> arg0, MapDecorationRenderStateModifier arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RenderStateExtensions.registerMapDecoration yet");
	}
}
