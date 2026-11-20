package net.neoforged.neoforge.registries;

import java.util.ArrayList;
import java.util.List;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.minecraft.core.Registry;
import net.minecraft.core.WritableRegistry;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * Fired on the mod event bus before registration, to add new registries. SteelWool adds them to the
 * root registry through Fabric's {@code FabricRegistryBuilder} after the event.
 */
public class NewRegistryEvent extends Event implements IModBusEvent {
	private final List<Registry<?>> registries = new ArrayList<>();

	NewRegistryEvent() {
	}

	public <T> Registry<T> create(RegistryBuilder<T> builder) {
		Registry<T> registry = builder.create();
		register(registry);
		return registry;
	}

	public <T> void register(Registry<T> registry) {
		registries.add(registry);
	}

	void fill() {
		registries.forEach(NewRegistryEvent::registerToRootRegistry);
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	private static void registerToRootRegistry(Registry<?> registry) {
		if (!(registry instanceof WritableRegistry writable)) {
			throw new IllegalArgumentException("Registry " + registry.key() + " cannot be registered: it is not writable");
		}
		FabricRegistryBuilder builder = FabricRegistryBuilder.from(writable);
		if (Boolean.TRUE.equals(RegistryBuilder.SYNCED.get(registry))) {
			builder.attribute(RegistryAttribute.SYNCED);
		}
		builder.buildAndRegister();
	}

	/** Adds NeoForge's own registries ({@link NeoForgeRegistries}) to the root registry. */
	static void registerNeoForgeRegistries() {
		NewRegistryEvent event = new NewRegistryEvent();
		event.register(NeoForgeRegistries.ENTITY_DATA_SERIALIZERS);
		event.register(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS);
		event.register(NeoForgeRegistries.BIOME_MODIFIER_SERIALIZERS);
		event.register(NeoForgeRegistries.STRUCTURE_MODIFIER_SERIALIZERS);
		event.register(NeoForgeRegistries.FLUID_TYPES);
		event.register(NeoForgeRegistries.HOLDER_SET_TYPES);
		event.register(NeoForgeRegistries.INGREDIENT_TYPES);
		event.register(NeoForgeRegistries.FLUID_INGREDIENT_TYPES);
		event.register(NeoForgeRegistries.CONDITION_SERIALIZERS);
		event.register(NeoForgeRegistries.ATTACHMENT_TYPES);
		event.fill();
	}
}
