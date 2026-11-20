package net.neoforged.neoforge.common;

/**
 * SteelWool re-implementation of NeoForge's {@code SoundActions}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class SoundActions {
	public static final SoundAction BUCKET_FILL = null /* SteelWool: TODO */;
	public static final SoundAction BUCKET_EMPTY = null /* SteelWool: TODO */;
	public static final SoundAction FLUID_VAPORIZE = null /* SteelWool: TODO */;
	public static final SoundAction CAULDRON_DRIP = null /* SteelWool: TODO */;

	private SoundActions() {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the SoundActions constructor yet");
	}
}
