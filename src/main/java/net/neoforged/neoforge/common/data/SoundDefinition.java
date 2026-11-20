package net.neoforged.neoforge.common.data;

import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resources.Identifier;

/**
 * SteelWool re-implementation of NeoForge's {@code SoundDefinition}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class SoundDefinition {
	private final List<net.neoforged.neoforge.common.data.SoundDefinition.Sound> sounds;
	private boolean replace;
	private String subtitle;

	private SoundDefinition() {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the SoundDefinition constructor yet");
	}

	public static net.neoforged.neoforge.common.data.SoundDefinition definition() {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinition.definition yet");
	}

	public net.neoforged.neoforge.common.data.SoundDefinition replace(boolean arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinition.replace yet");
	}

	public net.neoforged.neoforge.common.data.SoundDefinition subtitle(String arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinition.subtitle yet");
	}

	public net.neoforged.neoforge.common.data.SoundDefinition with(net.neoforged.neoforge.common.data.SoundDefinition.Sound arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinition.with yet");
	}

	public net.neoforged.neoforge.common.data.SoundDefinition with(net.neoforged.neoforge.common.data.SoundDefinition.Sound... arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinition.with yet");
	}

	List<net.neoforged.neoforge.common.data.SoundDefinition.Sound> soundList() {
		return this.sounds;
	}

	JsonObject serialize() {
		throw new UnsupportedOperationException("SteelWool does not implement SoundDefinition.serialize yet");
	}

	public static final class Sound {
		private static final net.neoforged.neoforge.common.data.SoundDefinition.SoundType DEFAULT_TYPE = null /* SteelWool: TODO */;
		private static final float DEFAULT_VOLUME = 1.0f;
		private static final float DEFAULT_PITCH = 1.0f;
		private static final int DEFAULT_WEIGHT = 1;
		private static final boolean DEFAULT_STREAM = false;
		private static final int DEFAULT_ATTENUATION_DISTANCE = 16;
		private static final boolean DEFAULT_PRELOAD = false;
		private final Identifier name;
		private final net.neoforged.neoforge.common.data.SoundDefinition.SoundType type;
		private float volume;
		private float pitch;
		private int weight;
		private boolean stream;
		private int attenuationDistance;
		private boolean preload;

		private Sound(Identifier name, net.neoforged.neoforge.common.data.SoundDefinition.SoundType type) {
			super();
			this.volume = 1f;
			this.pitch = 1f;
			this.weight = 1;
			this.stream = false;
			this.attenuationDistance = 16;
			this.preload = false;
			this.name = name;
			this.type = type;
		}

		public static net.neoforged.neoforge.common.data.SoundDefinition.Sound sound(Identifier arg0, net.neoforged.neoforge.common.data.SoundDefinition.SoundType arg1) {
			throw new UnsupportedOperationException("SteelWool does not implement SoundDefinition.Sound.sound yet");
		}

		public net.neoforged.neoforge.common.data.SoundDefinition.Sound volume(double arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement SoundDefinition.Sound.volume yet");
		}

		public net.neoforged.neoforge.common.data.SoundDefinition.Sound volume(float arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement SoundDefinition.Sound.volume yet");
		}

		public net.neoforged.neoforge.common.data.SoundDefinition.Sound pitch(double arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement SoundDefinition.Sound.pitch yet");
		}

		public net.neoforged.neoforge.common.data.SoundDefinition.Sound pitch(float arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement SoundDefinition.Sound.pitch yet");
		}

		public net.neoforged.neoforge.common.data.SoundDefinition.Sound weight(int arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement SoundDefinition.Sound.weight yet");
		}

		public net.neoforged.neoforge.common.data.SoundDefinition.Sound stream() {
			throw new UnsupportedOperationException("SteelWool does not implement SoundDefinition.Sound.stream yet");
		}

		public net.neoforged.neoforge.common.data.SoundDefinition.Sound stream(boolean arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement SoundDefinition.Sound.stream yet");
		}

		public net.neoforged.neoforge.common.data.SoundDefinition.Sound attenuationDistance(int arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement SoundDefinition.Sound.attenuationDistance yet");
		}

		public net.neoforged.neoforge.common.data.SoundDefinition.Sound preload() {
			throw new UnsupportedOperationException("SteelWool does not implement SoundDefinition.Sound.preload yet");
		}

		public net.neoforged.neoforge.common.data.SoundDefinition.Sound preload(boolean arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement SoundDefinition.Sound.preload yet");
		}

		Identifier name() {
			return this.name;
		}

		net.neoforged.neoforge.common.data.SoundDefinition.SoundType type() {
			return this.type;
		}

		JsonElement serialize() {
			throw new UnsupportedOperationException("SteelWool does not implement SoundDefinition.Sound.serialize yet");
		}

		private boolean canBeInShortForm() {
			throw new UnsupportedOperationException("SteelWool does not implement SoundDefinition.Sound.canBeInShortForm yet");
		}

		private String stripMcPrefix(Identifier arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement SoundDefinition.Sound.stripMcPrefix yet");
		}
	}

	public enum SoundType {
		SOUND("file"), EVENT("event");

		private final String jsonString;

		SoundType(String jsonString) {
			this.jsonString = jsonString;
		}
	}
}
