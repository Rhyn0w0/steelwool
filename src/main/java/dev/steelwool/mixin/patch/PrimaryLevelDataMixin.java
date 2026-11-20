package dev.steelwool.mixin.patch;

import net.minecraft.world.level.storage.PrimaryLevelData;
import org.spongepowered.asm.mixin.Mixin;

/**
 * Adds NeoForge's experimental-settings warning flag to {@link PrimaryLevelData}: the
 * {@code confirmedExperimentalWarning} field (which mods reach with {@code @Shadow}),
 * {@code hasConfirmedExperimentalWarning()} and {@code withConfirmedWarning(boolean)}. The flag is
 * not saved with the world.
 */
@Mixin(value = PrimaryLevelData.class, priority = 500)
public abstract class PrimaryLevelDataMixin {
	@SuppressWarnings("unused")
	private boolean confirmedExperimentalWarning;

	public boolean hasConfirmedExperimentalWarning() {
		return confirmedExperimentalWarning;
	}

	public PrimaryLevelData withConfirmedWarning(boolean confirmed) {
		confirmedExperimentalWarning = confirmed;
		return (PrimaryLevelData) (Object) this;
	}
}
