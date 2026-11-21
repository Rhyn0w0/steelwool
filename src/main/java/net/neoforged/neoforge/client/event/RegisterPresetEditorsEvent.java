package net.neoforged.neoforge.client.event;

import java.util.Map;

import net.minecraft.client.gui.screens.worldselection.PresetEditor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.presets.WorldPreset;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;
import org.apache.logging.log4j.Logger;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterPresetEditorsEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterPresetEditorsEvent extends Event implements IModBusEvent {
	private static final Logger LOGGER = null /* SteelWool: TODO */;
	private final Map<ResourceKey<WorldPreset>, PresetEditor> editors;

	public RegisterPresetEditorsEvent(Map<ResourceKey<WorldPreset>, PresetEditor> editors) {
		super();
		this.editors = editors;
	}

	public void register(ResourceKey<WorldPreset> arg0, PresetEditor arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterPresetEditorsEvent.register yet");
	}
}
