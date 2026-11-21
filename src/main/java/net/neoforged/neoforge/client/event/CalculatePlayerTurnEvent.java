package net.neoforged.neoforge.client.event;

import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code CalculatePlayerTurnEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class CalculatePlayerTurnEvent extends Event {
	private double mouseSensitivity;
	private boolean cinematicCameraEnabled;

	public CalculatePlayerTurnEvent(double arg0, boolean arg1) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the CalculatePlayerTurnEvent constructor yet");
	}

	public double getMouseSensitivity() {
		return this.mouseSensitivity;
	}

	public void setMouseSensitivity(double mouseSensitivity) {
		this.mouseSensitivity = mouseSensitivity;
	}

	public boolean getCinematicCameraEnabled() {
		return this.cinematicCameraEnabled;
	}

	public void setCinematicCameraEnabled(boolean cinematicCameraEnabled) {
		this.cinematicCameraEnabled = cinematicCameraEnabled;
	}
}
