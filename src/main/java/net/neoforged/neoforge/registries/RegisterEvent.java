package net.neoforged.neoforge.registries;

import java.util.function.Consumer;
import java.util.function.Supplier;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;
import org.jspecify.annotations.Nullable;

/**
 * Fired on each mod bus once per registry. Mods register their entries for that registry here
 * ({@link DeferredRegister} does this automatically).
 */
public class RegisterEvent extends Event implements IModBusEvent {
	private final ResourceKey<? extends Registry<?>> registryKey;
	private final Registry<?> registry;

	/** Public in SteelWool so its loader can create it; package-private in NeoForge. */
	public RegisterEvent(ResourceKey<? extends Registry<?>> registryKey, Registry<?> registry) {
		this.registryKey = registryKey;
		this.registry = registry;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> void register(ResourceKey<? extends Registry<T>> registryKey, Identifier name, Supplier<T> valueSupplier) {
		if (this.registryKey.equals(registryKey)) {
			Registry.register((Registry) this.registry, name, valueSupplier.get());
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> void register(ResourceKey<? extends Registry<T>> registryKey, Consumer<RegisterHelper<T>> consumer) {
		if (this.registryKey.equals(registryKey)) {
			consumer.accept((name, value) -> Registry.register((Registry) this.registry, name, value));
		}
	}

	public ResourceKey<? extends Registry<?>> getRegistryKey() {
		return this.registryKey;
	}

	public Registry<?> getRegistry() {
		return this.registry;
	}

	@SuppressWarnings("unchecked")
	public <T> @Nullable Registry<T> getRegistry(ResourceKey<? extends Registry<T>> key) {
		return key == this.registryKey ? (Registry<T>) this.registry : null;
	}

	@FunctionalInterface
	public interface RegisterHelper<T> {
		default void register(ResourceKey<T> key, T value) {
			register(key.identifier(), value);
		}

		void register(Identifier name, T value);
	}
}
