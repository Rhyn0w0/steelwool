package net.neoforged.neoforge.client.event.sound;

import com.mojang.blaze3d.audio.Channel;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundEngine;

/**
 * SteelWool re-implementation of NeoForge's {@code PlaySoundSourceEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class PlaySoundSourceEvent extends SoundEvent.SoundSourceEvent {
	public PlaySoundSourceEvent(SoundEngine arg0, SoundInstance arg1, Channel arg2) {
		super(arg0, arg1, arg2);
	}
}
