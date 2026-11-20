package net.neoforged.neoforge.registries.datamaps;

import java.util.Map;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterDataMapTypesEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterDataMapTypesEvent extends Event implements IModBusEvent {
	private final Map<ResourceKey<Registry<?>>, Map<Identifier, DataMapType<?, ?>>> attachments;

	public RegisterDataMapTypesEvent(Map<ResourceKey<Registry<?>>, Map<Identifier, DataMapType<?, ?>>> attachments) {
		super();
		this.attachments = attachments;
	}

	public <T extends Object, R extends Object> void register(DataMapType<R, T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterDataMapTypesEvent.register yet");
	}
}
