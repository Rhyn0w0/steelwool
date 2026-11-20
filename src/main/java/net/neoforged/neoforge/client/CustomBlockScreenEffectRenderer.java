package net.neoforged.neoforge.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.state.level.PlayerRenderState;
import net.minecraft.client.resources.model.sprite.SpriteGetter;

/**
 * SteelWool re-implementation of NeoForge's {@code CustomBlockScreenEffectRenderer}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface CustomBlockScreenEffectRenderer {
	public static final net.neoforged.neoforge.client.CustomBlockScreenEffectRenderer NO_OP = null /* SteelWool: TODO */;

	boolean submit(PlayerRenderState arg0, CameraRenderState arg1, SubmitNodeCollector arg2, PoseStack arg3, SpriteGetter arg4, float arg5, boolean arg6);
}
