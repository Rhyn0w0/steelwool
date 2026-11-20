package net.neoforged.fml;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.fml.event.lifecycle.ParallelDispatchEvent;
import net.neoforged.neoforgespi.language.IModInfo;
import net.neoforged.neoforgespi.language.ModFileScanData;
import net.neoforged.neoforgespi.locating.IModFile;
import org.apache.logging.log4j.Logger;

/**
 * SteelWool re-implementation of NeoForge's {@code ModLoader}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class ModLoader {
	private static final Logger LOGGER = null /* SteelWool: TODO */;
	private static final List<ModLoadingIssue> loadingIssues = null /* SteelWool: TODO */;
	private static ModList modList;

	private ModLoader() {
		super();
	}

	public static void gatherAndInitializeMods(Executor arg0, Executor arg1, Runnable arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.gatherAndInitializeMods yet");
	}

	private static void throwIfErrors(ModList arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.throwIfErrors yet");
	}

	private static void cancelLoading(ModList arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.cancelLoading yet");
	}

	private static void constructMods(Executor arg0, Executor arg1, Runnable arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.constructMods yet");
	}

	public static void runInitTask(String arg0, Executor arg1, Runnable arg2, Runnable arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.runInitTask yet");
	}

	public static void dispatchParallelEvent(String arg0, Executor arg1, Executor arg2, Runnable arg3, BiFunction<ModContainer, DeferredWorkQueue, ParallelDispatchEvent> arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.dispatchParallelEvent yet");
	}

	public static void waitForTask(String arg0, Runnable arg1, CompletableFuture<?> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.waitForTask yet");
	}

	public static void dispatchParallelTask(String arg0, Executor arg1, Runnable arg2, Consumer<ModContainer> arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.dispatchParallelTask yet");
	}

	private static void waitForFuture(String arg0, Runnable arg1, CompletableFuture<?> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.waitForFuture yet");
	}

	private static boolean isMeaningfulException(Throwable arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.isMeaningfulException yet");
	}

	private static void addLoadingIssuesFromException(String arg0, Throwable arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.addLoadingIssuesFromException yet");
	}

	private static List<ModContainer> buildMods(IModFile arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.buildMods yet");
	}

	private static ModContainer buildModContainerFromTOML(IModInfo arg0, ModFileScanData arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.buildModContainerFromTOML yet");
	}

	public static <T extends Event & IModBusEvent> void runEventGenerator(Function<ModContainer, T> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.buildModContainerFromTOML yet");
	}

	public static <T extends Event & IModBusEvent> void postEvent(T arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.buildModContainerFromTOML yet");
	}

	public static <T extends Event & IModBusEvent> T postEventWithReturn(T arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.buildModContainerFromTOML yet");
	}

	public static <T extends Event & IModBusEvent> void postEventWrapContainerInModOrder(T arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.buildModContainerFromTOML yet");
	}

	public static <T extends Event & IModBusEvent> void postEventWithWrapInModOrder(T arg0, BiConsumer<ModContainer, T> arg1, BiConsumer<ModContainer, T> arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.buildModContainerFromTOML yet");
	}

	public static boolean hasErrors() {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.hasErrors yet");
	}

	public static List<ModLoadingIssue> getLoadingErrors() {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.getLoadingErrors yet");
	}

	public static List<ModLoadingIssue> getLoadingWarnings() {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.getLoadingWarnings yet");
	}

	public static List<ModLoadingIssue> getLoadingIssues() {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.getLoadingIssues yet");
	}

	public static void clearLoadingIssues() {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.clearLoadingIssues yet");
	}

	public static void addLoadingIssue(ModLoadingIssue arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.addLoadingIssue yet");
	}

	public static void clear() {
		throw new UnsupportedOperationException("SteelWool does not implement ModLoader.clear yet");
	}

	static class DependentFutureFailedException extends RuntimeException {
		private DependentFutureFailedException() {
			super();
		}
	}
}
