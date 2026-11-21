package net.neoforged.neoforge.client.event;

import net.minecraft.client.Camera;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.fog.environment.FogEnvironment;
import net.minecraft.world.level.material.FogType;
import net.neoforged.bus.api.Event;
import org.joml.Vector4f;

/**
 * SteelWool re-implementation of NeoForge's {@code ViewportEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class ViewportEvent extends Event {
	private final GameRenderer renderer;
	private final Camera camera;
	private final float partialTick;

	public ViewportEvent(GameRenderer renderer, Camera camera, float partialTick) {
		super();
		this.renderer = renderer;
		this.camera = camera;
		this.partialTick = partialTick;
	}

	public GameRenderer getRenderer() {
		return this.renderer;
	}

	public Camera getCamera() {
		return this.camera;
	}

	public float getPartialTick() {
		return this.partialTick;
	}

	public static class ComputeCameraAngles extends net.neoforged.neoforge.client.event.ViewportEvent {
		private float yaw;
		private float pitch;
		private float roll;

		public ComputeCameraAngles(Camera arg0, float arg1, float arg2, float arg3, float arg4) {
			super((GameRenderer) null, (Camera) null, (float) 0);
			throw new UnsupportedOperationException("SteelWool does not implement the ViewportEvent.ComputeCameraAngles constructor yet");
		}

		public float getYaw() {
			return this.yaw;
		}

		public void setYaw(float yaw) {
			this.yaw = yaw;
		}

		public float getPitch() {
			return this.pitch;
		}

		public void setPitch(float pitch) {
			this.pitch = pitch;
		}

		public float getRoll() {
			return this.roll;
		}

		public void setRoll(float roll) {
			this.roll = roll;
		}
	}

	public static class ComputeFogColor extends net.neoforged.neoforge.client.event.ViewportEvent {
		private final Vector4f color;

		public ComputeFogColor(Camera arg0, float arg1, Vector4f arg2) {
			super((GameRenderer) null, (Camera) null, (float) 0);
			throw new UnsupportedOperationException("SteelWool does not implement the ViewportEvent.ComputeFogColor constructor yet");
		}

		public float getRed() {
			throw new UnsupportedOperationException("SteelWool does not implement ViewportEvent.ComputeFogColor.getRed yet");
		}

		public void setRed(float arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement ViewportEvent.ComputeFogColor.setRed yet");
		}

		public float getGreen() {
			throw new UnsupportedOperationException("SteelWool does not implement ViewportEvent.ComputeFogColor.getGreen yet");
		}

		public void setGreen(float arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement ViewportEvent.ComputeFogColor.setGreen yet");
		}

		public float getBlue() {
			throw new UnsupportedOperationException("SteelWool does not implement ViewportEvent.ComputeFogColor.getBlue yet");
		}

		public void setBlue(float arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement ViewportEvent.ComputeFogColor.setBlue yet");
		}
	}

	public static class ComputeFov extends net.neoforged.neoforge.client.event.ViewportEvent {
		private float fov;

		public ComputeFov(GameRenderer arg0, Camera arg1, float arg2, float arg3) {
			super((GameRenderer) null, (Camera) null, (float) 0);
			throw new UnsupportedOperationException("SteelWool does not implement the ViewportEvent.ComputeFov constructor yet");
		}

		public float getFOV() {
			return this.fov;
		}

		public void setFOV(float fov) {
			this.fov = fov;
		}
	}

	public static class RenderFog extends net.neoforged.neoforge.client.event.ViewportEvent {
		private final FogEnvironment environment;
		private final FogType type;
		private final FogData fogData;

		public RenderFog(FogEnvironment arg0, FogType arg1, Camera arg2, float arg3, FogData arg4) {
			super((GameRenderer) null, (Camera) null, (float) 0);
			throw new UnsupportedOperationException("SteelWool does not implement the ViewportEvent.RenderFog constructor yet");
		}

		public FogEnvironment getEnvironment() {
			return this.environment;
		}

		public FogType getType() {
			return this.type;
		}

		public float getFarPlaneDistance() {
			throw new UnsupportedOperationException("SteelWool does not implement ViewportEvent.RenderFog.getFarPlaneDistance yet");
		}

		public float getNearPlaneDistance() {
			throw new UnsupportedOperationException("SteelWool does not implement ViewportEvent.RenderFog.getNearPlaneDistance yet");
		}

		public FogData getFogData() {
			return this.fogData;
		}

		public void setFarPlaneDistance(float arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement ViewportEvent.RenderFog.setFarPlaneDistance yet");
		}

		public void setNearPlaneDistance(float arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement ViewportEvent.RenderFog.setNearPlaneDistance yet");
		}

		public void scaleFarPlaneDistance(float arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement ViewportEvent.RenderFog.scaleFarPlaneDistance yet");
		}

		public void scaleNearPlaneDistance(float arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement ViewportEvent.RenderFog.scaleNearPlaneDistance yet");
		}
	}
}
