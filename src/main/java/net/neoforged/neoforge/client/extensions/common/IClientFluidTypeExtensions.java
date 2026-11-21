package net.neoforged.neoforge.client.extensions.common;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.fog.environment.FogEnvironment;
import net.minecraft.client.renderer.state.level.PlayerRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.FluidType;
import org.joml.Vector4f;

/**
 * SteelWool re-implementation of NeoForge's {@code IClientFluidTypeExtensions}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface IClientFluidTypeExtensions {
	public static final net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions DEFAULT = null /* SteelWool: TODO */;

	static net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions of(FluidState arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientFluidTypeExtensions.of yet");
	}

	static net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions of(Fluid arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientFluidTypeExtensions.of yet");
	}

	static net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions of(FluidType arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientFluidTypeExtensions.of yet");
	}

	default Identifier getRenderOverlayTexture(Minecraft arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientFluidTypeExtensions.getRenderOverlayTexture yet");
	}

	default void extractOverlay(Minecraft arg0, LocalPlayer arg1, PlayerRenderState arg2, BlockPos arg3, float arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientFluidTypeExtensions.extractOverlay yet");
	}

	default void modifyFogColor(Camera arg0, float arg1, ClientLevel arg2, int arg3, float arg4, Vector4f arg5) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientFluidTypeExtensions.modifyFogColor yet");
	}

	default void modifyFogRender(Camera arg0, FogEnvironment arg1, float arg2, float arg3, FogData arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement IClientFluidTypeExtensions.modifyFogRender yet");
	}
}
