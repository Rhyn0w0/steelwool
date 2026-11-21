package net.neoforged.neoforge.registries;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code ModifyRegistriesEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ModifyRegistriesEvent extends Event implements IModBusEvent {
	ModifyRegistriesEvent() {
		super();
	}

	public Iterable<? extends Registry<?>> getRegistries() {
		throw new UnsupportedOperationException("SteelWool does not implement ModifyRegistriesEvent.getRegistries yet");
	}

	public <T extends Object> Registry<T> getRegistry(ResourceKey<? extends Registry<T>> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModifyRegistriesEvent.getRegistry yet");
	}
}
