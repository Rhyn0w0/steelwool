package net.neoforged.neoforge.network.event;

import java.util.Queue;

import net.minecraft.network.protocol.configuration.ServerConfigurationPacketListener;
import net.minecraft.server.network.ConfigurationTask;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterConfigurationTasksEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterConfigurationTasksEvent extends Event implements IModBusEvent {
	private final ServerConfigurationPacketListener listener;
	private final Queue<ConfigurationTask> configurationTasks;

	public RegisterConfigurationTasksEvent(ServerConfigurationPacketListener arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the RegisterConfigurationTasksEvent constructor yet");
	}

	public void register(ConfigurationTask arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterConfigurationTasksEvent.register yet");
	}

	public Queue<ConfigurationTask> getConfigurationTasks() {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterConfigurationTasksEvent.getConfigurationTasks yet");
	}

	public ServerConfigurationPacketListener getListener() {
		return this.listener;
	}
}
