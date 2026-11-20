package net.neoforged.neoforge.client.event.sound;

import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundEngine;

/**
 * SteelWool re-implementation of NeoForge's {@code PlaySoundEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class PlaySoundEvent extends SoundEvent {
	private final String name;
	private final SoundInstance originalSound;
	private SoundInstance sound;

	public PlaySoundEvent(SoundEngine arg0, SoundInstance originalSound) {
		super((SoundEngine) null);
		throw new UnsupportedOperationException("SteelWool does not implement the PlaySoundEvent constructor yet");
	}

	public String getName() {
		return this.name;
	}

	public SoundInstance getOriginalSound() {
		return this.originalSound;
	}

	public SoundInstance getSound() {
		return this.sound;
	}

	public void setSound(SoundInstance sound) {
		this.sound = sound;
	}
}
