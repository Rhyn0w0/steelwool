package net.neoforged.neoforge.registries;

import java.util.function.Consumer;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryValidator;
import net.minecraft.resources.ResourceKey;

/**
 * SteelWool re-implementation of NeoForge's {@code DatapackRegistryBuilder}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class DatapackRegistryBuilder<T extends Object> extends Object {
	private final boolean reloadable;
	private ResourceKey<Registry<T>> key;
	private Codec<T> codec;
	private Codec<T> networkCodec;
	private RegistryValidator<T> validator;
	private Consumer<RegistryBuilder<T>> configurator;

	DatapackRegistryBuilder(boolean arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the DatapackRegistryBuilder constructor yet");
	}

	public net.neoforged.neoforge.registries.DatapackRegistryBuilder<T> key(ResourceKey<Registry<T>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DatapackRegistryBuilder.key yet");
	}

	public net.neoforged.neoforge.registries.DatapackRegistryBuilder<T> codec(Codec<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DatapackRegistryBuilder.codec yet");
	}

	public net.neoforged.neoforge.registries.DatapackRegistryBuilder<T> networkCodec(Codec<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DatapackRegistryBuilder.networkCodec yet");
	}

	public net.neoforged.neoforge.registries.DatapackRegistryBuilder<T> validator(RegistryValidator<T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DatapackRegistryBuilder.validator yet");
	}

	public net.neoforged.neoforge.registries.DatapackRegistryBuilder<T> configurator(Consumer<RegistryBuilder<T>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement DatapackRegistryBuilder.configurator yet");
	}

	NewDatapackRegistryEvent.RegistryData<T> build() {
		throw new UnsupportedOperationException("SteelWool does not implement DatapackRegistryBuilder.build yet");
	}
}
