package net.neoforged.neoforge.registries;

import com.mojang.serialization.Codec;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;
import org.jspecify.annotations.Nullable;

/**
 * Fired on the mod event bus to add datapack (dynamic) registries. SteelWool registers them with
 * Fabric's {@code DynamicRegistries} after the event.
 */
public final class NewDatapackRegistryEvent extends Event implements IModBusEvent {
	private final List<RegistryData<?>> worldRegistries = new ArrayList<>();
	private final List<RegistryData<?>> reloadableRegistries = new ArrayList<>();

	NewDatapackRegistryEvent() {
	}

	public <T> void worldRegistry(ResourceKey<Registry<T>> key, Codec<T> codec) {
		worldRegistry(key, codec, null);
	}

	public <T> void worldRegistry(ResourceKey<Registry<T>> key, Codec<T> codec, @Nullable Codec<T> networkCodec) {
		worldRegistries.add(new RegistryData<>(key, codec, networkCodec));
	}

	public <T> void worldRegistry(Consumer<DatapackRegistryBuilder<T>> consumer) {
		DatapackRegistryBuilder<T> builder = new DatapackRegistryBuilder<>(false);
		consumer.accept(builder);
		worldRegistries.add(builder.build());
	}

	public <T> void reloadableRegistry(ResourceKey<Registry<T>> key, Codec<T> codec) {
		reloadableRegistries.add(new RegistryData<>(key, codec, null));
	}

	public <T> void reloadableRegistry(Consumer<DatapackRegistryBuilder<T>> consumer) {
		DatapackRegistryBuilder<T> builder = new DatapackRegistryBuilder<>(true);
		consumer.accept(builder);
		reloadableRegistries.add(builder.build());
	}

	void process() {
		worldRegistries.forEach(RegistryData::registerWorld);
		reloadableRegistries.forEach(RegistryData::registerReloadable);
	}

	record RegistryData<T>(RegistryDataLoader.RegistryData<T> loaderData, @Nullable Codec<T> networkCodec) {
		RegistryData(ResourceKey<Registry<T>> key, Codec<T> codec, @Nullable Codec<T> networkCodec) {
			this(new RegistryDataLoader.RegistryData<>(key, codec, net.minecraft.resources.RegistryValidator.none()), networkCodec);
		}

		private void registerWorld() {
			if (networkCodec != null) {
				DynamicRegistries.registerSynced(loaderData.key(), loaderData.elementCodec(), networkCodec);
			} else {
				DynamicRegistries.register(loaderData.key(), loaderData.elementCodec());
			}
		}

		private void registerReloadable() {
			DynamicRegistries.registerReloadable(loaderData.key(), loaderData.elementCodec());
		}
	}
}
