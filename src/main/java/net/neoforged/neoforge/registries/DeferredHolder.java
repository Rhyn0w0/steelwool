package net.neoforged.neoforge.registries;

import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderOwner;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import org.jspecify.annotations.Nullable;

/**
 * SteelWool re-implementation of NeoForge's {@code DeferredHolder}: a holder for a registry entry
 * that may not be registered yet. Once registered it delegates to the registry's real holder.
 */
public class DeferredHolder<R, T extends R> extends Holder.Reference<R> implements Supplier<T> {
	private @Nullable Holder<R> holder;

	public static <R, T extends R> DeferredHolder<R, T> create(ResourceKey<? extends Registry<R>> registryKey, Identifier valueName) {
		return create(ResourceKey.create(registryKey, valueName));
	}

	public static <R, T extends R> DeferredHolder<R, T> create(Identifier registryName, Identifier valueName) {
		return create(ResourceKey.createRegistryKey(registryName), valueName);
	}

	public static <R, T extends R> DeferredHolder<R, T> create(ResourceKey<R> key) {
		return new DeferredHolder<>(key);
	}

	@SuppressWarnings("unchecked")
	protected DeferredHolder(ResourceKey<R> key) {
		Objects.requireNonNull(key);
		Registry<R> registry = (Registry<R>) BuiltInRegistries.REGISTRY.getValue(key.registry());
		super(Holder.Reference.Type.STAND_ALONE, registry, key, null);
		this.bind(false);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T value() {
		bind(true);

		if (this.holder == null) {
			throw new NullPointerException("Trying to access unbound value: " + this.key());
		}

		return (T) this.holder.value();
	}

	@Override
	public T get() {
		return this.value();
	}

	public Optional<T> asOptional() {
		return isBound() ? Optional.of(value()) : Optional.empty();
	}

	@SuppressWarnings("unchecked")
	public HolderLookup.@Nullable RegistryLookup<R> unwrapLookup() {
		return (Registry<R>) BuiltInRegistries.REGISTRY.getValue(this.key().registry());
	}

	protected final void bind(boolean throwOnMissingRegistry) {
		if (this.holder != null) {
			return;
		}

		HolderLookup.RegistryLookup<R> registry = unwrapLookup();

		if (registry != null) {
			this.holder = registry.get(this.key()).orElse(null);
		} else if (throwOnMissingRegistry) {
			throw new IllegalStateException("Registry not present for " + this + ": " + this.key().registry());
		}
	}

	/** Called by {@link DeferredRegister} after registering; not part of the NeoForge API. */
	void steelwool$bind() {
		bind(false);
	}

	public Identifier getId() {
		return this.key().identifier();
	}

	@Override
	public String toString() {
		return String.format(Locale.ENGLISH, "DeferredHolder{%s}", this.key());
	}

	@Override
	public boolean isBound() {
		bind(false);
		return this.holder != null && this.holder.isBound();
	}

	@Override
	public boolean areComponentsBound() {
		bind(false);
		return this.holder != null && this.holder.areComponentsBound();
	}

	@Override
	public DataComponentMap components() {
		bind(true);
		return this.holder != null ? this.holder.components() : DataComponentMap.EMPTY;
	}

	@Override
	public boolean is(TagKey<R> tag) {
		bind(false);
		return this.holder != null && this.holder.is(tag);
	}

	@Override
	@Deprecated
	public boolean is(Holder<R> other) {
		bind(false);
		return this.holder != null && this.holder.is(other);
	}

	@Override
	public Stream<TagKey<R>> tags() {
		bind(false);
		return this.holder != null ? this.holder.tags() : Stream.empty();
	}

	@Override
	public boolean canSerializeIn(HolderOwner<R> owner) {
		bind(false);
		return this.holder != null && this.holder.canSerializeIn(owner);
	}

	public Holder<R> getDelegate() {
		bind(false);
		return this.holder != null ? this.holder : this;
	}
}
