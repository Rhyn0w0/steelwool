package net.neoforged.neoforge.registries;

import com.mojang.serialization.Codec;
import java.util.Objects;
import java.util.function.Consumer;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.RegistryValidator;
import net.minecraft.resources.ResourceKey;
import org.jspecify.annotations.Nullable;

/**
 * Describes a datapack registry for {@link NewDatapackRegistryEvent}. On SteelWool the validator
 * and configurator are accepted but not used: Fabric's {@code DynamicRegistries} creates the registry.
 */
public final class DatapackRegistryBuilder<T> {
	private final boolean reloadable;
	private @Nullable ResourceKey<Registry<T>> key;
	private @Nullable Codec<T> codec;
	private @Nullable Codec<T> networkCodec;
	private RegistryValidator<T> validator = RegistryValidator.none();
	private Consumer<RegistryBuilder<T>> configurator = builder -> {};

	DatapackRegistryBuilder(boolean reloadable) {
		this.reloadable = reloadable;
	}

	public DatapackRegistryBuilder<T> key(ResourceKey<Registry<T>> key) {
		this.key = key;
		return this;
	}

	public DatapackRegistryBuilder<T> codec(Codec<T> codec) {
		this.codec = codec;
		return this;
	}

	/** Syncs the registry to clients with this codec. Reloadable registries are not synced. */
	public DatapackRegistryBuilder<T> networkCodec(Codec<T> networkCodec) {
		if (reloadable) {
			throw new IllegalStateException("Reloadable datapack registries cannot be synced");
		}
		this.networkCodec = networkCodec;
		return this;
	}

	public DatapackRegistryBuilder<T> validator(RegistryValidator<T> validator) {
		this.validator = Objects.requireNonNull(validator);
		return this;
	}

	public DatapackRegistryBuilder<T> configurator(Consumer<RegistryBuilder<T>> configurator) {
		this.configurator = Objects.requireNonNull(configurator);
		return this;
	}

	NewDatapackRegistryEvent.RegistryData<T> build() {
		Objects.requireNonNull(key, "Datapack registry key not set");
		Objects.requireNonNull(codec, "Datapack registry codec not set");
		return new NewDatapackRegistryEvent.RegistryData<>(new RegistryDataLoader.RegistryData<>(key, codec, validator), networkCodec);
	}
}
