package net.neoforged.neoforge.client.event.sound;

import net.minecraft.client.sounds.SoundEngine;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code SoundEngineLoadEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class SoundEngineLoadEvent extends SoundEvent implements IModBusEvent {
	public SoundEngineLoadEvent(SoundEngine arg0) {
		super(arg0);
	}
}
