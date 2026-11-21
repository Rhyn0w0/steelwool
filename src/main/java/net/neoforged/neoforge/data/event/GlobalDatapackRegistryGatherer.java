package net.neoforged.neoforge.data.event;

/**
 * SteelWool re-implementation of NeoForge's {@code GlobalDatapackRegistryGatherer}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public interface GlobalDatapackRegistryGatherer extends DatapackRegistryGatherer {
	DatapackRegistryGatherer gatherFor(String arg0, String... arg1);
}
