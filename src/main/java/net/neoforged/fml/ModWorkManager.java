package net.neoforged.fml;

import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

import org.apache.logging.log4j.Logger;

/**
 * SteelWool re-implementation of NeoForge's {@code ModWorkManager}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ModWorkManager {
	private static final Logger LOGGER = null /* SteelWool: TODO */;
	private static final Executor syncWorkExecutor = null /* SteelWool: TODO */;
	private static ForkJoinPool parallelThreadPool;

	public ModWorkManager() {
		super();
	}

	public static Executor syncExecutor() {
		throw new UnsupportedOperationException("SteelWool does not implement ModWorkManager.syncExecutor yet");
	}

	public static Executor parallelExecutor() {
		throw new UnsupportedOperationException("SteelWool does not implement ModWorkManager.parallelExecutor yet");
	}

	private static ForkJoinWorkerThread newForkJoinWorkerThread(ForkJoinPool arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModWorkManager.newForkJoinWorkerThread yet");
	}
}
