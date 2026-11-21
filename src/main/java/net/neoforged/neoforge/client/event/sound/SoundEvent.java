package net.neoforged.neoforge.client.event.sound;

import com.mojang.blaze3d.audio.Channel;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundEngine;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code SoundEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class SoundEvent extends Event {
	private final SoundEngine engine;

	protected SoundEvent(SoundEngine engine) {
		super();
		this.engine = engine;
	}

	public SoundEngine getEngine() {
		return this.engine;
	}

	public static abstract class SoundSourceEvent extends net.neoforged.neoforge.client.event.sound.SoundEvent {
		private final SoundInstance sound;
		private final Channel channel;
		private final String name;

		protected SoundSourceEvent(SoundEngine arg0, SoundInstance arg1, Channel arg2) {
			super((SoundEngine) null);
			throw new UnsupportedOperationException("SteelWool does not implement the SoundEvent.SoundSourceEvent constructor yet");
		}

		public SoundInstance getSound() {
			return this.sound;
		}

		public Channel getChannel() {
			return this.channel;
		}

		public String getName() {
			return this.name;
		}
	}
}
