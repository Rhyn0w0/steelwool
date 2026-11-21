package net.neoforged.neoforge.registries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import com.mojang.serialization.Lifecycle;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.core.DefaultedMappedRegistry;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.registries.callback.AddCallback;
import net.neoforged.neoforge.registries.callback.BakeCallback;
import net.neoforged.neoforge.registries.callback.ClearCallback;
import net.neoforged.neoforge.registries.callback.RegistryCallback;
import org.jspecify.annotations.Nullable;

/**
 * Builds a new registry. Register the result with {@link NewRegistryEvent#register} (or create it
 * through {@link NewRegistryEvent#create}) so it is added to the root registry.
 *
 * <p>On SteelWool, add callbacks run through Fabric's {@code RegistryEntryAddedCallback}; bake and
 * clear callbacks are accepted but never called, and {@code maxId} is not enforced.
 */
public class RegistryBuilder<T> {
	private final ResourceKey<? extends Registry<T>> registryKey;
	private final List<RegistryCallback<T>> callbacks = new ArrayList<>();
	private @Nullable Identifier defaultKey;
	private boolean intrusiveHolders;
	private int maxId = Integer.MAX_VALUE - 1;
	private boolean sync;
	private boolean registrationCheck = true;

	public RegistryBuilder(ResourceKey<? extends Registry<T>> registryKey) {
		this.registryKey = registryKey;
	}

	public RegistryBuilder<T> defaultKey(Identifier key) {
		this.defaultKey = key;
		return this;
	}

	public RegistryBuilder<T> defaultKey(ResourceKey<T> key) {
		this.defaultKey = key.identifier();
		return this;
	}

	public RegistryBuilder<T> withIntrusiveHolders() {
		this.intrusiveHolders = true;
		return this;
	}

	public RegistryBuilder<T> callback(RegistryCallback<T> callback) {
		callbacks.add(callback);
		return this;
	}

	public RegistryBuilder<T> onAdd(AddCallback<T> callback) {
		return callback(callback);
	}

	public RegistryBuilder<T> onBake(BakeCallback<T> callback) {
		return callback(callback);
	}

	public RegistryBuilder<T> onClear(ClearCallback<T> callback) {
		return callback(callback);
	}

	public RegistryBuilder<T> maxId(int maxId) {
		this.maxId = maxId;
		return this;
	}

	public RegistryBuilder<T> sync(boolean sync) {
		this.sync = sync;
		return this;
	}

	public RegistryBuilder<T> disableRegistrationCheck() {
		this.registrationCheck = false;
		return this;
	}

	public Registry<T> create() {
		MappedRegistry<T> registry = defaultKey != null
				? new DefaultedMappedRegistry<>(defaultKey.toString(), registryKey, Lifecycle.stable(), intrusiveHolders)
				: new MappedRegistry<>(registryKey, Lifecycle.stable(), intrusiveHolders);

		for (RegistryCallback<T> callback : callbacks) {
			if (callback instanceof AddCallback<T> add) {
				RegistryEntryAddedCallback.event(registry).register((id, name, value) ->
						add.onAdd(registry, id, ResourceKey.create(registry.key(), name), value));
			}
		}

		SYNCED.put(registry, sync);
		return registry;
	}

	/** Whether each registry built here should be synced to clients (read when it is registered). */
	static final Map<Registry<?>, Boolean> SYNCED = Collections.synchronizedMap(new WeakHashMap<>());
}
