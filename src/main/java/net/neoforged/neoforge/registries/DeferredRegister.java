package net.neoforged.neoforge.registries;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;

/**
 * SteelWool re-implementation of NeoForge's {@code DeferredRegister}: collects registry entries
 * and registers them when {@link RegisterEvent} fires for its registry.
 *
 * <p>Not yet supported: creating new custom registries ({@code makeRegistry}) and aliases.
 */
public class DeferredRegister<T> {
	private final ResourceKey<? extends Registry<T>> registryKey;
	private final String namespace;
	private final Map<DeferredHolder<T, ? extends T>, Supplier<? extends T>> entries = new LinkedHashMap<>();
	private final Set<DeferredHolder<T, ? extends T>> entriesView = Collections.unmodifiableSet(entries.keySet());
	private @org.jspecify.annotations.Nullable Registry<T> customRegistry;
	private boolean seenRegisterEvent;
	private boolean registeredEventBus;

	public static <T> DeferredRegister<T> create(Registry<T> registry, String namespace) {
		return new DeferredRegister<>(registry.key(), namespace);
	}

	public static <T> DeferredRegister<T> create(ResourceKey<? extends Registry<T>> key, String namespace) {
		return new DeferredRegister<>(key, namespace);
	}

	public static <B> DeferredRegister<B> create(Identifier registryName, String modid) {
		return new DeferredRegister<>(ResourceKey.createRegistryKey(registryName), modid);
	}

	public static Items createItems(String modid) {
		return new Items(modid);
	}

	public static Blocks createBlocks(String modid) {
		return new Blocks(modid);
	}

	public static DataComponents createDataComponents(ResourceKey<Registry<DataComponentType<?>>> registryKey, String modid) {
		return new DataComponents(registryKey, modid);
	}

	public static Entities createEntities(String modid) {
		return new Entities(modid);
	}

	protected DeferredRegister(ResourceKey<? extends Registry<T>> registryKey, String namespace) {
		this.registryKey = Objects.requireNonNull(registryKey);
		this.namespace = Objects.requireNonNull(namespace);
	}

	public <I extends T> DeferredHolder<T, I> register(final String name, final Supplier<? extends I> sup) {
		return this.register(name, key -> sup.get());
	}

	public <I extends T> DeferredHolder<T, I> register(final String name, final Function<Identifier, ? extends I> func) {
		if (seenRegisterEvent) {
			throw new IllegalStateException("Cannot register new entries to DeferredRegister after RegisterEvent has been fired.");
		}

		Objects.requireNonNull(name);
		Objects.requireNonNull(func);
		final Identifier key = Identifier.fromNamespaceAndPath(namespace, name);
		DeferredHolder<T, I> ret = createHolder(this.registryKey, key);

		if (entries.putIfAbsent(ret, () -> func.apply(key)) != null) {
			throw new IllegalArgumentException("Duplicate registration " + name);
		}

		return ret;
	}

	protected <I extends T> DeferredHolder<T, I> createHolder(ResourceKey<? extends Registry<T>> registryKey, Identifier key) {
		return DeferredHolder.create(registryKey, key);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Supplier<Registry<T>> getRegistry() {
		return () -> (Registry<T>) BuiltInRegistries.REGISTRY.getValueOrThrow((ResourceKey) this.registryKey);
	}

	public TagKey<T> createTagKey(String path) {
		return createTagKey(Identifier.fromNamespaceAndPath(this.namespace, Objects.requireNonNull(path)));
	}

	public TagKey<T> createTagKey(Identifier location) {
		return TagKey.create(this.registryKey, Objects.requireNonNull(location));
	}

	public void register(IEventBus bus) {
		if (this.registeredEventBus) {
			throw new IllegalStateException("Cannot register DeferredRegister to more than one event bus.");
		}

		this.registeredEventBus = true;
		bus.addListener(RegisterEvent.class, this::addEntries);

		if (this.customRegistry != null) {
			Registry<T> registry = this.customRegistry;
			bus.addListener(NewRegistryEvent.class, event -> event.register(registry));
		}
	}

	/**
	 * Creates a new registry for this register's registry key; it is added in {@link NewRegistryEvent}
	 * once this register is {@linkplain #register(IEventBus) registered} to a mod event bus.
	 */
	public Registry<T> makeRegistry(java.util.function.Consumer<RegistryBuilder<T>> consumer) {
		if (this.registeredEventBus) {
			throw new IllegalStateException("Cannot create a registry after the DeferredRegister is registered to an event bus");
		}
		if (this.customRegistry != null) {
			throw new IllegalStateException("This DeferredRegister already created a registry");
		}
		RegistryBuilder<T> builder = new RegistryBuilder<>(this.registryKey);
		consumer.accept(builder);
		this.customRegistry = builder.create();
		return this.customRegistry;
	}

	/**
	 * Accepted for compatibility; SteelWool does not support registry aliases yet, so worlds saved with
	 * the old name lose those entries.
	 */
	public void addAlias(Identifier from, Identifier to) {
	}

	public Collection<DeferredHolder<T, ? extends T>> getEntries() {
		return entriesView;
	}

	public ResourceKey<? extends Registry<T>> getRegistryKey() {
		return this.registryKey;
	}

	public Identifier getRegistryName() {
		return this.registryKey.identifier();
	}

	public String getNamespace() {
		return this.namespace;
	}

	private void addEntries(RegisterEvent event) {
		if (!event.getRegistryKey().equals(this.registryKey)) {
			return;
		}

		this.seenRegisterEvent = true;

		for (Map.Entry<DeferredHolder<T, ? extends T>, Supplier<? extends T>> e : entries.entrySet()) {
			event.register(this.registryKey, e.getKey().getId(), () -> e.getValue().get());
			e.getKey().steelwool$bind();
		}
	}

	public static class Blocks extends DeferredRegister<Block> {
		protected Blocks(String namespace) {
			super(Registries.BLOCK, namespace);
		}

		@SuppressWarnings("unchecked")
		@Override
		public <B extends Block> DeferredBlock<B> register(String name, Function<Identifier, ? extends B> func) {
			return (DeferredBlock<B>) super.register(name, func);
		}

		@Override
		public <B extends Block> DeferredBlock<B> register(String name, Supplier<? extends B> sup) {
			return this.register(name, key -> sup.get());
		}

		public <B extends Block> DeferredBlock<B> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends B> func, Supplier<BlockBehaviour.Properties> properties) {
			return this.register(name, key -> func.apply(properties.get().setId(ResourceKey.create(Registries.BLOCK, key))));
		}

		public <B extends Block> DeferredBlock<B> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends B> func, UnaryOperator<BlockBehaviour.Properties> properties) {
			return this.registerBlock(name, func, () -> properties.apply(BlockBehaviour.Properties.of()));
		}

		public <B extends Block> DeferredBlock<B> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends B> func) {
			return this.registerBlock(name, func, UnaryOperator.identity());
		}

		public DeferredBlock<Block> registerSimpleBlock(String name, Supplier<BlockBehaviour.Properties> properties) {
			return this.registerBlock(name, Block::new, properties);
		}

		public DeferredBlock<Block> registerSimpleBlock(String name, UnaryOperator<BlockBehaviour.Properties> properties) {
			return this.registerBlock(name, Block::new, properties);
		}

		public DeferredBlock<Block> registerSimpleBlock(String name) {
			return this.registerSimpleBlock(name, UnaryOperator.identity());
		}

		@Override
		protected <I extends Block> DeferredBlock<I> createHolder(ResourceKey<? extends Registry<Block>> registryKey, Identifier key) {
			return DeferredBlock.createBlock(ResourceKey.create(registryKey, key));
		}
	}

	public static class Items extends DeferredRegister<Item> {
		protected Items(String namespace) {
			super(Registries.ITEM, namespace);
		}

		@SuppressWarnings("unchecked")
		@Override
		public <I extends Item> DeferredItem<I> register(String name, Function<Identifier, ? extends I> func) {
			return (DeferredItem<I>) super.register(name, func);
		}

		@Override
		public <I extends Item> DeferredItem<I> register(String name, Supplier<? extends I> sup) {
			return this.register(name, key -> sup.get());
		}

		public DeferredItem<BlockItem> registerSimpleBlockItem(String name, Supplier<? extends Block> block, Supplier<Item.Properties> properties) {
			return this.registerItem(name, props -> new BlockItem(block.get(), props), () -> properties.get().useBlockDescriptionPrefix());
		}

		public DeferredItem<BlockItem> registerSimpleBlockItem(String name, Supplier<? extends Block> block, UnaryOperator<Item.Properties> properties) {
			return this.registerSimpleBlockItem(name, block, () -> properties.apply(new Item.Properties()));
		}

		public DeferredItem<BlockItem> registerSimpleBlockItem(String name, Supplier<? extends Block> block) {
			return this.registerSimpleBlockItem(name, block, UnaryOperator.identity());
		}

		public DeferredItem<BlockItem> registerSimpleBlockItem(Holder<Block> block, Supplier<Item.Properties> properties) {
			return this.registerSimpleBlockItem(block.unwrapKey().orElseThrow().identifier().getPath(), block::value, properties);
		}

		public DeferredItem<BlockItem> registerSimpleBlockItem(Holder<Block> block, UnaryOperator<Item.Properties> properties) {
			return this.registerSimpleBlockItem(block, () -> properties.apply(new Item.Properties()));
		}

		public DeferredItem<BlockItem> registerSimpleBlockItem(Holder<Block> block) {
			return this.registerSimpleBlockItem(block, UnaryOperator.identity());
		}

		public <I extends Item> DeferredItem<I> registerItem(String name, Function<Item.Properties, ? extends I> func, Supplier<Item.Properties> properties) {
			return this.register(name, key -> func.apply(properties.get().setId(ResourceKey.create(Registries.ITEM, key))));
		}

		public <I extends Item> DeferredItem<I> registerItem(String name, Function<Item.Properties, ? extends I> func, UnaryOperator<Item.Properties> properties) {
			return this.registerItem(name, func, () -> properties.apply(new Item.Properties()));
		}

		public <I extends Item> DeferredItem<I> registerItem(String name, Function<Item.Properties, ? extends I> func) {
			return this.registerItem(name, func, UnaryOperator.identity());
		}

		public DeferredItem<Item> registerSimpleItem(String name, Supplier<Item.Properties> properties) {
			return this.registerItem(name, Item::new, properties);
		}

		public DeferredItem<Item> registerSimpleItem(String name, UnaryOperator<Item.Properties> properties) {
			return this.registerItem(name, Item::new, properties);
		}

		public DeferredItem<Item> registerSimpleItem(String name) {
			return this.registerItem(name, Item::new, UnaryOperator.identity());
		}

		@Override
		protected <I extends Item> DeferredItem<I> createHolder(ResourceKey<? extends Registry<Item>> registryKey, Identifier key) {
			return DeferredItem.createItem(ResourceKey.create(registryKey, key));
		}
	}

	public static class DataComponents extends DeferredRegister<DataComponentType<?>> {
		protected DataComponents(ResourceKey<Registry<DataComponentType<?>>> registryKey, String namespace) {
			super(registryKey, namespace);
		}

		public <D> DeferredHolder<DataComponentType<?>, DataComponentType<D>> registerComponentType(String name, UnaryOperator<DataComponentType.Builder<D>> builder) {
			return this.register(name, () -> builder.apply(DataComponentType.builder()).build());
		}
	}

	public static class Entities extends DeferredRegister<EntityType<?>> {
		protected Entities(String namespace) {
			super(Registries.ENTITY_TYPE, namespace);
		}

		public <E extends Entity> DeferredHolder<EntityType<?>, EntityType<E>> registerEntityType(String name, EntityType.EntityFactory<E> factory, MobCategory category) {
			return this.registerEntityType(name, factory, category, UnaryOperator.identity());
		}

		public <E extends Entity> DeferredHolder<EntityType<?>, EntityType<E>> registerEntityType(String name, EntityType.EntityFactory<E> factory, MobCategory category,
				BiFunction<EntityType.EntityFactory<E>, MobCategory, EntityType.Builder<E>> builder) {
			return this.register(name, key -> builder.apply(factory, category).build(ResourceKey.create(Registries.ENTITY_TYPE, key)));
		}

		public <E extends Entity> DeferredHolder<EntityType<?>, EntityType<E>> registerEntityType(String name, EntityType.EntityFactory<E> factory, MobCategory category,
				UnaryOperator<EntityType.Builder<E>> builder) {
			return this.registerEntityType(name, factory, category, (fact, cat) -> builder.apply(EntityType.Builder.of(fact, cat)));
		}
	}
}
