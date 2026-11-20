package net.neoforged.neoforge.registries;

import java.util.List;
import java.util.function.Consumer;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code NewDatapackRegistryEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class NewDatapackRegistryEvent extends Event implements IModBusEvent {
	private final List<net.neoforged.neoforge.registries.NewDatapackRegistryEvent.RegistryData<?>> worldRegistries;
	private final List<net.neoforged.neoforge.registries.NewDatapackRegistryEvent.RegistryData<?>> reloadableRegistries;

	NewDatapackRegistryEvent() {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the NewDatapackRegistryEvent constructor yet");
	}

	public <T extends Object> void worldRegistry(ResourceKey<Registry<T>> arg0, Codec<T> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement NewDatapackRegistryEvent.worldRegistry yet");
	}

	public <T extends Object> void worldRegistry(ResourceKey<Registry<T>> arg0, Codec<T> arg1, Codec<T> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement NewDatapackRegistryEvent.worldRegistry yet");
	}

	public <T extends Object> void worldRegistry(Consumer<DatapackRegistryBuilder<T>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement NewDatapackRegistryEvent.worldRegistry yet");
	}

	public <T extends Object> void reloadableRegistry(ResourceKey<Registry<T>> arg0, Codec<T> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement NewDatapackRegistryEvent.reloadableRegistry yet");
	}

	public <T extends Object> void reloadableRegistry(Consumer<DatapackRegistryBuilder<T>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement NewDatapackRegistryEvent.reloadableRegistry yet");
	}

	void process() {
		throw new UnsupportedOperationException("SteelWool does not implement NewDatapackRegistryEvent.process yet");
	}

	static record RegistryData<T extends Object>(RegistryDataLoader.RegistryData<T> loaderData, Codec<T> networkCodec) {
		RegistryData(ResourceKey<Registry<T>> arg0, Codec<T> arg1, Codec<T> arg2) {
			this((RegistryDataLoader.RegistryData) null, (Codec) null);
			throw new UnsupportedOperationException("SteelWool does not implement the NewDatapackRegistryEvent.RegistryData constructor yet");
		}
	}
}
