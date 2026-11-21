package net.neoforged.neoforge.client.settings;

import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;

/**
 * SteelWool re-implementation of NeoForge's {@code KeyMappingLookup}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class KeyMappingLookup {
	private final EnumMap<KeyModifier, Map<InputConstants.Key, Collection<KeyMapping>>> map;

	public KeyMappingLookup() {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the KeyMappingLookup constructor yet");
	}

	public List<KeyMapping> getAll(InputConstants.Key arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement KeyMappingLookup.getAll yet");
	}

	public List<KeyMapping> getAll(InputConstants.Key arg0, boolean arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement KeyMappingLookup.getAll yet");
	}

	private List<KeyMapping> findKeybinds(InputConstants.Key arg0, KeyModifier arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement KeyMappingLookup.findKeybinds yet");
	}

	public void put(InputConstants.Key arg0, KeyMapping arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement KeyMappingLookup.put yet");
	}

	public void remove(KeyMapping arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement KeyMappingLookup.remove yet");
	}

	public void clear() {
		throw new UnsupportedOperationException("SteelWool does not implement KeyMappingLookup.clear yet");
	}
}
