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
	private static final Logger LOGGER = org.apache.logging.log4j.LogManager.getLogger();
	private static final List<ModLoadingIssue> loadingIssues = new java.util.concurrent.CopyOnWriteArrayList<>();
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
		for (ModContainer container : ModList.get().getSortedMods()) {
			container.acceptEvent(arg0.apply(container));
		}
	}

	public static <T extends Event & IModBusEvent> void postEvent(T arg0) {
		for (ModContainer container : ModList.get().getSortedMods()) {
			container.acceptEvent(arg0);
		}
	}

	public static <T extends Event & IModBusEvent> T postEventWithReturn(T arg0) {
		postEvent(arg0);
		return arg0;
	}

	public static <T extends Event & IModBusEvent> void postEventWrapContainerInModOrder(T arg0) {
		postEventWithWrapInModOrder(arg0, (container, event) -> {}, (container, event) -> {});
	}

	public static <T extends Event & IModBusEvent> void postEventWithWrapInModOrder(T arg0, BiConsumer<ModContainer, T> arg1, BiConsumer<ModContainer, T> arg2) {
		// Each priority phase in turn, and within a phase the mods in order; pre and post run around each mod.
		for (net.neoforged.bus.api.EventPriority phase : net.neoforged.bus.api.EventPriority.values()) {
			for (ModContainer container : ModList.get().getSortedMods()) {
				arg1.accept(container, arg0);
				container.acceptEvent(phase, arg0);
				arg2.accept(container, arg0);
			}
		}
	}

	public static boolean hasErrors() {
		return loadingIssues.stream().anyMatch(issue -> issue.severity() == ModLoadingIssue.Severity.ERROR);
	}

	public static List<ModLoadingIssue> getLoadingErrors() {
		return loadingIssues.stream().filter(issue -> issue.severity() == ModLoadingIssue.Severity.ERROR).toList();
	}

	public static List<ModLoadingIssue> getLoadingWarnings() {
		return loadingIssues.stream().filter(issue -> issue.severity() == ModLoadingIssue.Severity.WARNING).toList();
	}

	public static List<ModLoadingIssue> getLoadingIssues() {
		return List.copyOf(loadingIssues);
	}

	public static void clearLoadingIssues() {
		loadingIssues.clear();
	}

	public static void addLoadingIssue(ModLoadingIssue arg0) {
		loadingIssues.add(arg0);
		LOGGER.warn("Mod loading issue: {} {}", arg0.translationKey(), arg0.translationArgs(), arg0.cause());
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
