package net.neoforged.neoforge.common;

/**
 * SteelWool re-implementation of NeoForge's {@code SoundActions}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class SoundActions {
	public static final SoundAction BUCKET_FILL = SoundAction.get("bucket_fill");
	public static final SoundAction BUCKET_EMPTY = SoundAction.get("bucket_empty");
	public static final SoundAction FLUID_VAPORIZE = SoundAction.get("fluid_vaporize");
	public static final SoundAction CAULDRON_DRIP = SoundAction.get("cauldron_drip");

	private SoundActions() {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the SoundActions constructor yet");
	}
}
