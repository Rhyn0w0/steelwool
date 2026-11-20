package net.neoforged.neoforge.client.event;

import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.Music;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code SelectMusicEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class SelectMusicEvent extends Event implements ICancellableEvent {
	private Music music;
	private final Music originalMusic;
	private final SoundInstance playingMusic;

	public SelectMusicEvent(Music music, SoundInstance playingMusic) {
		super();
		this.music = music;
		this.originalMusic = music;
		this.playingMusic = playingMusic;
	}

	public Music getOriginalMusic() {
		return this.originalMusic;
	}

	public SoundInstance getPlayingMusic() {
		return this.playingMusic;
	}

	public Music getMusic() {
		return this.music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	public void overrideMusic(Music arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SelectMusicEvent.overrideMusic yet");
	}
}
