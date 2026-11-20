package net.neoforged.neoforge.client.event;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.entity.ClientAvatarEntity;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.Avatar;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RenderPlayerEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class RenderPlayerEvent<T extends Avatar & ClientAvatarEntity> extends RenderLivingEvent<T, AvatarRenderState, PlayerModel> {
	protected RenderPlayerEvent(AvatarRenderState arg0, AvatarRenderer<T> arg1, float arg2, PoseStack arg3, SubmitNodeCollector arg4) {
		super(arg0, arg1, arg2, arg3, arg4);
	}

	public AvatarRenderer<T> getRenderer() {
		return (AvatarRenderer) super.getRenderer();
	}

	public static class Post<T extends Avatar & ClientAvatarEntity> extends net.neoforged.neoforge.client.event.RenderPlayerEvent<T> {
		public Post(AvatarRenderState arg0, AvatarRenderer<T> arg1, float arg2, PoseStack arg3, SubmitNodeCollector arg4) {
			super(arg0, arg1, arg2, arg3, arg4);
		}
	}

	public static class Pre<T extends Avatar & ClientAvatarEntity> extends net.neoforged.neoforge.client.event.RenderPlayerEvent<T> implements ICancellableEvent {
		public Pre(AvatarRenderState arg0, AvatarRenderer<T> arg1, float arg2, PoseStack arg3, SubmitNodeCollector arg4) {
			super(arg0, arg1, arg2, arg3, arg4);
		}
	}
}
