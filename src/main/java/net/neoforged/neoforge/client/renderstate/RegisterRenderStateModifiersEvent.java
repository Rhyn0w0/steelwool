package net.neoforged.neoforge.client.renderstate;

import java.util.function.BiConsumer;

import com.google.common.reflect.TypeToken;
import net.minecraft.client.entity.ClientAvatarEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.state.MapRenderState;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Avatar;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterRenderStateModifiersEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterRenderStateModifiersEvent extends Event implements IModBusEvent {
	public RegisterRenderStateModifiersEvent() {
		super();
	}

	public <E extends Entity, S extends EntityRenderState> void registerEntityModifier(TypeToken<? extends EntityRenderer<? extends E, ? extends S>> arg0, BiConsumer<E, S> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterRenderStateModifiersEvent.registerEntityModifier yet");
	}

	public <E extends Entity, S extends EntityRenderState> void registerEntityModifier(Class<? extends EntityRenderer<? extends E, ? extends S>> arg0, BiConsumer<E, S> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterRenderStateModifiersEvent.registerEntityModifier yet");
	}

	public void registerAvatarEntityModifier(AvatarRenderStateModifier arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterRenderStateModifiersEvent.registerAvatarEntityModifier yet");
	}

	private static <T extends Avatar & ClientAvatarEntity> BiConsumer<?, ?> coerce(AvatarRenderStateModifier arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterRenderStateModifiersEvent.coerce yet");
	}

	public void registerMapModifier(BiConsumer<MapItemSavedData, MapRenderState> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterRenderStateModifiersEvent.registerMapModifier yet");
	}

	public void registerMapDecorationModifier(ResourceKey<MapDecorationType> arg0, MapDecorationRenderStateModifier arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterRenderStateModifiersEvent.registerMapDecorationModifier yet");
	}

	private static void ensureParametersMatchBounds(TypeToken<? extends EntityRenderer<? extends Entity, ? extends EntityRenderState>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterRenderStateModifiersEvent.ensureParametersMatchBounds yet");
	}

	static record Container<X extends Object>() {
		private static <Z extends Object> TypeToken<net.neoforged.neoforge.client.renderstate.RegisterRenderStateModifiersEvent.Container<Z>> of(TypeToken<Z> arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement RegisterRenderStateModifiersEvent.Container.of yet");
		}
	}
}
