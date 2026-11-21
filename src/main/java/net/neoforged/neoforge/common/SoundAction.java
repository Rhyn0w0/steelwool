package net.neoforged.neoforge.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** A named action a fluid can play a sound for, such as filling a bucket. There is one instance per name. */
public final class SoundAction {
	private static final Map<String, SoundAction> ACTIONS = new ConcurrentHashMap<>();
	private final String name;

	public static SoundAction get(String name) {
		return ACTIONS.computeIfAbsent(name, SoundAction::new);
	}

	private SoundAction(String name) {
		this.name = name;
	}

	public String name() {
		return name;
	}

	@Override
	public String toString() {
		return "SoundAction[" + name + "]";
	}
}
