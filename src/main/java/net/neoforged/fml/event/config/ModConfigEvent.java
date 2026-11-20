package net.neoforged.fml.event.config;

import net.neoforged.bus.api.Event;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.IModBusEvent;

/**
 * Fired on a mod's bus when one of its configs is loaded, reloaded or unloaded.
 */
public class ModConfigEvent extends Event implements IModBusEvent {
	private final ModConfig config;

	ModConfigEvent(ModConfig config) {
		this.config = config;
	}

	public ModConfig getConfig() {
		return config;
	}

	public static class Loading extends ModConfigEvent {
		public Loading(ModConfig config) {
			super(config);
		}
	}

	public static class Reloading extends ModConfigEvent {
		public Reloading(ModConfig config) {
			super(config);
		}
	}

	public static class Unloading extends ModConfigEvent {
		public Unloading(ModConfig config) {
			super(config);
		}
	}
}
