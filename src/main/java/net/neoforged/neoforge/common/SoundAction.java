package net.neoforged.neoforge.common;

import java.util.Map;

/**
 * SteelWool re-implementation of NeoForge's {@code SoundAction}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class SoundAction {
	private static final Map<String, net.neoforged.neoforge.common.SoundAction> ACTIONS = null /* SteelWool: TODO */;
	private final String name;

	public static net.neoforged.neoforge.common.SoundAction get(String arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SoundAction.get yet");
	}

	private SoundAction(String name) {
		super();
		this.name = name;
	}

	public String name() {
		return this.name;
	}

	public String toString() {
		throw new UnsupportedOperationException("SteelWool does not implement SoundAction.toString yet");
	}
}
