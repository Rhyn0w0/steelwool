package net.neoforged.neoforge.registries.datamaps;

import java.util.function.Consumer;

import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code DataMapsUpdatedEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class DataMapsUpdatedEvent extends Event {
	private final RegistryAccess registryAccess;
	private final Registry<?> registry;
	private final net.neoforged.neoforge.registries.datamaps.DataMapsUpdatedEvent.UpdateCause cause;

	public DataMapsUpdatedEvent(RegistryAccess registryAccess, Registry<?> registry, net.neoforged.neoforge.registries.datamaps.DataMapsUpdatedEvent.UpdateCause cause) {
		super();
		this.registryAccess = registryAccess;
		this.registry = registry;
		this.cause = cause;
	}

	public RegistryAccess getRegistries() {
		return this.registryAccess;
	}

	public Registry<?> getRegistry() {
		return this.registry;
	}

	public ResourceKey<? extends Registry<?>> getRegistryKey() {
		throw new UnsupportedOperationException("SteelWool does not implement DataMapsUpdatedEvent.getRegistryKey yet");
	}

	public <T extends Object> void ifRegistry(ResourceKey<Registry<T>> arg0, Consumer<Registry<T>> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement DataMapsUpdatedEvent.ifRegistry yet");
	}

	public net.neoforged.neoforge.registries.datamaps.DataMapsUpdatedEvent.UpdateCause getCause() {
		return this.cause;
	}

	public enum UpdateCause {
		CLIENT_SYNC, SERVER_RELOAD;
	}
}
