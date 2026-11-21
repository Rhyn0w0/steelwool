package net.neoforged.neoforge.data.loading;

import java.nio.file.Path;
import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;

import net.minecraft.data.DataGenerator;
import net.minecraft.server.packs.PackResources;
import net.neoforged.neoforge.data.event.DataGeneratorConfig;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.internal.CommonModLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * SteelWool re-implementation of NeoForge's {@code DatagenModLoader}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class DatagenModLoader extends CommonModLoader {
	private static final Logger LOGGER = LogManager.getLogger();
	private static DataGeneratorConfig dataGeneratorConfig;
	private static boolean runningDataGen;

	public DatagenModLoader() {
		super();
	}

	/** SteelWool never runs data generation. */
	public static boolean isRunningDataGen() {
		return runningDataGen;
	}

	public static void begin(Set<String> arg0, Path arg1, Collection<Path> arg2, Collection<Path> arg3, boolean arg4, boolean arg5, boolean arg6, boolean arg7, boolean arg8, Runnable arg9, GatherDataEvent.GatherDataEventGenerator arg10, DataGenerator arg11, Consumer<Consumer<PackResources>> arg12) {
		throw new UnsupportedOperationException("SteelWool does not implement DatagenModLoader.begin yet");
	}
}
