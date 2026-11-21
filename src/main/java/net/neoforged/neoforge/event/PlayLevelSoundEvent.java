package net.neoforged.neoforge.event;

import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code PlayLevelSoundEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class PlayLevelSoundEvent extends Event implements ICancellableEvent {
	private final Level level;
	private final float originalVolume;
	private final float originalPitch;
	private Holder<SoundEvent> sound;
	private SoundSource source;
	private float newVolume;
	private float newPitch;

	public PlayLevelSoundEvent(Level level, Holder<SoundEvent> sound, SoundSource source, float originalVolume, float originalPitch) {
		super();
		this.level = level;
		this.sound = sound;
		this.source = source;
		this.originalVolume = originalVolume;
		this.originalPitch = originalPitch;
		this.newVolume = originalVolume;
		this.newPitch = originalPitch;
	}

	public Level getLevel() {
		return this.level;
	}

	public Holder<SoundEvent> getSound() {
		return this.sound;
	}

	public void setSound(Holder<SoundEvent> sound) {
		this.sound = sound;
	}

	public SoundSource getSource() {
		return this.source;
	}

	public void setSource(SoundSource arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement PlayLevelSoundEvent.setSource yet");
	}

	public float getOriginalVolume() {
		return this.originalVolume;
	}

	public float getOriginalPitch() {
		return this.originalPitch;
	}

	public float getNewVolume() {
		return this.newVolume;
	}

	public void setNewVolume(float newVolume) {
		this.newVolume = newVolume;
	}

	public float getNewPitch() {
		return this.newPitch;
	}

	public void setNewPitch(float newPitch) {
		this.newPitch = newPitch;
	}

	public static class AtEntity extends net.neoforged.neoforge.event.PlayLevelSoundEvent {
		private final Entity entity;

		public AtEntity(Entity arg0, Holder<SoundEvent> arg1, SoundSource arg2, float arg3, float arg4) {
			super((Level) null, (Holder) null, (SoundSource) null, (float) 0, (float) 0);
			throw new UnsupportedOperationException("SteelWool does not implement the PlayLevelSoundEvent.AtEntity constructor yet");
		}

		public Entity getEntity() {
			return this.entity;
		}
	}

	public static class AtPosition extends net.neoforged.neoforge.event.PlayLevelSoundEvent {
		private final Vec3 position;

		public AtPosition(Level arg0, Vec3 position, Holder<SoundEvent> arg2, SoundSource arg3, float arg4, float arg5) {
			super(arg0, arg2, arg3, arg4, arg5);
			this.position = position;
		}

		public Vec3 getPosition() {
			return this.position;
		}
	}
}
