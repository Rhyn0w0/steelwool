package dev.steelwool.resource;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import dev.steelwool.discovery.NeoForgeModFile;
import dev.steelwool.discovery.NeoForgeModMetadata;
import dev.steelwool.loading.SteelWoolLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.FilePackResources;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackCompatibility;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlagSet;

/**
 * Exposes each NeoForge mod jar's {@code assets/} and {@code data/} folders as an always-enabled
 * built-in pack, the way NeoForge does for its own mods.
 */
public final class NeoForgeModPacks {
	/** Shown as "(NeoForge mod)" next to the pack name. */
	private static final PackSource SOURCE = PackSource.create(
			name -> Component.translatable("pack.nameAndSource", name, Component.literal("NeoForge mod via SteelWool")), true);
	private static final PackSelectionConfig SELECTION = new PackSelectionConfig(true, Pack.Position.TOP, false);

	private NeoForgeModPacks() {
	}

	public static void loadPacks(PackType type, Consumer<Pack> consumer) {
		for (NeoForgeModFile file : SteelWoolLoader.get().modFiles()) {
			consumer.accept(create(file, type));
		}
	}

	static Pack create(NeoForgeModFile file, PackType type) {
		List<NeoForgeModMetadata> mods = file.modsToml().mods();
		NeoForgeModMetadata first = mods.getFirst();
		PackLocationInfo location = new PackLocationInfo(
				"steelwool/" + first.modId(),
				Component.literal(first.displayName()),
				SOURCE,
				Optional.empty());
		Pack.Metadata metadata = new Pack.Metadata(
				Component.literal("Resources for " + first.displayName()),
				PackCompatibility.COMPATIBLE,
				FeatureFlagSet.of(),
				List.of());
		return new Pack(location, new FilePackResources.FileResourcesSupplier(file.path()), metadata, SELECTION);
	}
}
