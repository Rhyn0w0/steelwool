package net.neoforged.neoforge.client;

import java.util.List;

import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.neoforged.bus.api.IEventBus;
import org.apache.logging.log4j.Logger;

/**
 * SteelWool re-implementation of NeoForge's {@code TagConventionLogWarningClient}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class TagConventionLogWarningClient {
	private static final Logger LOGGER = null /* SteelWool: TODO */;

	private TagConventionLogWarningClient() {
		super();
	}

	static void init() {
		throw new UnsupportedOperationException("SteelWool does not implement TagConventionLogWarningClient.init yet");
	}

	static void setupUntranslatedItemTagWarning(IEventBus arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement TagConventionLogWarningClient.setupUntranslatedItemTagWarning yet");
	}

	private static void extractUnregisteredModdedTags(Registry<?> arg0, List<TagKey<?>> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement TagConventionLogWarningClient.extractUnregisteredModdedTags yet");
	}

	public enum LogWarningMode {
		SILENCED, DEV_SHORT, DEV_VERBOSE, PROD_SHORT, PROD_VERBOSE;
	}
}
