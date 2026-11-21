package net.neoforged.neoforge.client.event;

import java.util.List;
import java.util.Map;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Options;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterKeyMappingsEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterKeyMappingsEvent extends Event implements IModBusEvent {
	private final Options options;
	private final Map<Identifier, KeyMapping.Category> moddedCategories;

	public RegisterKeyMappingsEvent(Options arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the RegisterKeyMappingsEvent constructor yet");
	}

	public void register(KeyMapping arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterKeyMappingsEvent.register yet");
	}

	public void registerCategory(KeyMapping.Category arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterKeyMappingsEvent.registerCategory yet");
	}

	public void sortAndStoreCategories(List<KeyMapping.Category> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterKeyMappingsEvent.sortAndStoreCategories yet");
	}
}
