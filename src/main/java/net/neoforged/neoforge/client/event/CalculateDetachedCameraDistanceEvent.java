package net.neoforged.neoforge.client.event;

import net.minecraft.client.Camera;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code CalculateDetachedCameraDistanceEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class CalculateDetachedCameraDistanceEvent extends Event {
	private final Camera camera;
	private final boolean cameraFlipped;
	private final float entityScale;
	private final float entityDistance;
	private final float vehicleEntityScale;
	private final float vehicleEntityDistance;
	private float distance;

	public CalculateDetachedCameraDistanceEvent(Camera camera, boolean cameraFlipped, float entityScale, float entityDistance, float vehicleEntityScale, float vehicleEntityDistance) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the CalculateDetachedCameraDistanceEvent constructor yet");
	}

	public Camera getCamera() {
		return this.camera;
	}

	public boolean isCameraFlipped() {
		return this.cameraFlipped;
	}

	public float getEntityScalingFactor() {
		return this.entityScale;
	}

	public float getEntityDistance() {
		return this.entityDistance;
	}

	public float getVehicleEntityScalingFactor() {
		return this.vehicleEntityScale;
	}

	public float getVehicleEntityDistance() {
		return this.vehicleEntityDistance;
	}

	public float getDistance() {
		return this.distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}
}
