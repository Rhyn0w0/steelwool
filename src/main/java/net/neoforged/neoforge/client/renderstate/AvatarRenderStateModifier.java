package net.neoforged.neoforge.client.renderstate;

import net.minecraft.client.entity.ClientAvatarEntity;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.Avatar;

/**
 * SteelWool re-implementation of NeoForge's {@code AvatarRenderStateModifier}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class AvatarRenderStateModifier {
	public AvatarRenderStateModifier() {
		super();
	}

	public abstract <T extends Avatar & ClientAvatarEntity> void accept(T arg0, AvatarRenderState arg1);
}
