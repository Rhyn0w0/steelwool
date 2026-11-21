package net.neoforged.neoforge.client.config;

import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.client.TagConventionLogWarningClient;
import net.neoforged.neoforge.common.ModConfigSpec;

/**
 * SteelWool re-implementation of NeoForge's {@code NeoForgeClientConfig}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class NeoForgeClientConfig {
	public static final ModConfigSpec SPEC = null /* SteelWool: TODO */;
	public static final net.neoforged.neoforge.client.config.NeoForgeClientConfig INSTANCE = null /* SteelWool: TODO */;
	public final ModConfigSpec.BooleanValue enhancedLighting;
	boolean enhancedLightingActive;
	public final ModConfigSpec.BooleanValue showLoadWarnings;
	public final ModConfigSpec.EnumValue<TagConventionLogWarningClient.LogWarningMode> logUntranslatedItemTagWarnings;
	public final ModConfigSpec.BooleanValue logUntranslatedConfigurationWarnings;
	public final ModConfigSpec.BooleanValue reducedDepthStencilFormat;
	public final ModConfigSpec.BooleanValue handleAmbientOcclusionPerPart;
	boolean perPartAoActive;
	public final ModConfigSpec.BooleanValue enableB3DValidationLayer;
	public final ModConfigSpec.BooleanValue skipModdedSplashesIfVanillaModified;

	private NeoForgeClientConfig(ModConfigSpec.Builder arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the NeoForgeClientConfig constructor yet");
	}

	static void onLoad(ModConfigEvent.Loading arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement NeoForgeClientConfig.onLoad yet");
	}

	static void onFileChange(ModConfigEvent.Reloading arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement NeoForgeClientConfig.onFileChange yet");
	}
}
