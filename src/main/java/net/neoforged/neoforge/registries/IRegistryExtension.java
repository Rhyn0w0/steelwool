package net.neoforged.neoforge.registries;

import dev.steelwool.registry.RegistryAliases;
import java.util.Map;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.registries.callback.AddCallback;
import net.neoforged.neoforge.registries.callback.RegistryCallback;
import net.neoforged.neoforge.registries.datamaps.DataMapType;
import org.jspecify.annotations.Nullable;

/**
 * Methods NeoForge adds to every {@link Registry}; SteelWool adds this interface to {@code Registry}
 * with a mixin. Add callbacks run through Fabric's {@code RegistryEntryAddedCallback}; bake and clear
 * callbacks are ignored, and data maps are not loaded yet, so they are empty.
 */
public interface IRegistryExtension<T> {
	private Registry<T> self() {
		@SuppressWarnings("unchecked")
		Registry<T> registry = (Registry<T>) this;
		return registry;
	}

	/** Whether the registry is synced to clients (only known for registries made with {@link RegistryBuilder}). */
	default boolean doesSync() {
		return Boolean.TRUE.equals(RegistryBuilder.SYNCED.get(self()));
	}

	default int getMaxId() {
		return Integer.MAX_VALUE - 1;
	}

	default void addCallback(RegistryCallback<T> callback) {
		if (callback instanceof AddCallback<T> add) {
			Registry<T> registry = self();
			RegistryEntryAddedCallback.event(registry).register((id, name, value) ->
					add.onAdd(registry, id, ResourceKey.create(registry.key(), name), value));
		}
	}

	default <C extends RegistryCallback<T>> void addCallback(Class<C> type, C callback) {
		addCallback(callback);
	}

	default void addAlias(Identifier from, Identifier to) {
		RegistryAliases.add(self().key(), from, to);
	}

	default Identifier resolve(Identifier name) {
		return RegistryAliases.resolve(self().key(), name);
	}

	default ResourceKey<T> resolve(ResourceKey<T> key) {
		Identifier target = resolve(key.identifier());
		return target.equals(key.identifier()) ? key : ResourceKey.create(key.registryKey(), target);
	}

	/** The numeric id of the entry, or -1 if there is none. */
	default int getId(ResourceKey<T> key) {
		return self().getOptional(key).map(self()::getId).orElse(-1);
	}

	default int getId(Identifier name) {
		return self().getOptional(name).map(self()::getId).orElse(-1);
	}

	default boolean containsValue(T value) {
		return self().getResourceKey(value).isPresent();
	}

	default <A> Map<ResourceKey<T>, A> getDataMap(DataMapType<T, A> type) {
		return Map.of();
	}

	default @Nullable Identifier getKeyOrNull(T value) {
		return self().getKey(value);
	}
}
