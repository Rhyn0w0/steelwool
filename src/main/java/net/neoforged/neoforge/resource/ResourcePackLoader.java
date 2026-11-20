package net.neoforged.neoforge.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

import com.mojang.serialization.Codec;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.MetadataSectionType;
import net.minecraft.server.packs.metadata.pack.PackFormat;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackRepository;
import net.minecraft.server.packs.repository.RepositorySource;
import net.minecraft.util.InclusiveRange;
import net.neoforged.fml.jarcontents.JarContents;
import net.neoforged.neoforgespi.language.IModFileInfo;
import net.neoforged.neoforgespi.locating.IModFile;
import org.apache.logging.log4j.Logger;

/**
 * SteelWool re-implementation of NeoForge's {@code ResourcePackLoader}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ResourcePackLoader {
	public static final String MOD_DATA_ID = "mod_data";
	public static final String MOD_RESOURCES_ID = "mod_resources";
	private static Map<IModFile, Pack.ResourcesSupplier> modResourcePacks;
	private static final Logger LOGGER = null /* SteelWool: TODO */;
	private static final PackSelectionConfig MOD_PACK_SELECTION_CONFIG = null /* SteelWool: TODO */;
	private static final InclusiveRange<PackFormat> UNLIMITED_SUPPORT = null /* SteelWool: TODO */;
	private static final MetadataSectionType<PackMetadataSection> OPTIONAL_CLIENT_FORMAT = null /* SteelWool: TODO */;
	private static final MetadataSectionType<PackMetadataSection> OPTIONAL_SERVER_FORMAT = null /* SteelWool: TODO */;

	public ResourcePackLoader() {
		super();
	}

	public static Optional<Pack.ResourcesSupplier> getPackFor(String arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourcePackLoader.getPackFor yet");
	}

	public static void populatePackRepository(PackRepository arg0, PackType arg1, boolean arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourcePackLoader.populatePackRepository yet");
	}

	private static synchronized void findResourcePacks() {
		throw new UnsupportedOperationException("SteelWool does not implement ResourcePackLoader.findResourcePacks yet");
	}

	public static RepositorySource buildPackFinder(Map<IModFile, Pack.ResourcesSupplier> arg0, PackType arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourcePackLoader.buildPackFinder yet");
	}

	private static void packFinder(Map<IModFile, Pack.ResourcesSupplier> arg0, Consumer<Pack> arg1, PackType arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourcePackLoader.packFinder yet");
	}

	private static Codec<PackMetadataSection> metadataCodecForPackType(PackType arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourcePackLoader.metadataCodecForPackType yet");
	}

	private static MetadataSectionType<PackMetadataSection> metadataTypeForPackType(PackType arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourcePackLoader.metadataTypeForPackType yet");
	}

	public static Pack readWithOptionalMeta(PackLocationInfo arg0, Pack.ResourcesSupplier arg1, PackType arg2, PackSelectionConfig arg3) throws IOException {
		throw new UnsupportedOperationException("SteelWool does not implement ResourcePackLoader.readWithOptionalMeta yet");
	}

	private static Pack.Metadata readMeta(PackType arg0, PackLocationInfo arg1, Pack.ResourcesSupplier arg2) throws IOException {
		throw new UnsupportedOperationException("SteelWool does not implement ResourcePackLoader.readMeta yet");
	}

	private static Pack makePack(PackType arg0, ArrayList<Pack> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourcePackLoader.makePack yet");
	}

	public static Pack.ResourcesSupplier createPackForMod(IModFileInfo arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourcePackLoader.createPackForMod yet");
	}

	public static Pack.ResourcesSupplier createPackForJarContents(JarContents arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourcePackLoader.createPackForJarContents yet");
	}

	public static List<String> getPackNames(PackType arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourcePackLoader.getPackNames yet");
	}

	public static String getPackName(IModFile arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourcePackLoader.getPackName yet");
	}

	private static boolean hasResourcePack(IModFile arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourcePackLoader.hasResourcePack yet");
	}

	public static List<Pack> expandAndRemoveRootChildren(Stream<Pack> arg0, Collection<Pack> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourcePackLoader.expandAndRemoveRootChildren yet");
	}

	public static void reorderNewlyDiscoveredPacks(Collection<String> arg0, Collection<String> arg1, PackRepository arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ResourcePackLoader.reorderNewlyDiscoveredPacks yet");
	}
}
