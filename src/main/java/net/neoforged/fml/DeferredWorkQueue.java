package net.neoforged.fml;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * SteelWool re-implementation of FML's {@code DeferredWorkQueue}: work enqueued during a parallel
 * lifecycle event runs on the main thread once the event has been dispatched. SteelWool dispatches
 * lifecycle events on the main thread, so this simply runs the queue afterwards in order.
 */
public class DeferredWorkQueue {
	private final String name;
	private final List<Runnable> tasks = new ArrayList<>();

	public DeferredWorkQueue(String name) {
		this.name = name;
	}

	public void runTasks() {
		List<Runnable> toRun = new ArrayList<>(tasks);
		tasks.clear();
		toRun.forEach(Runnable::run);
	}

	public CompletableFuture<Void> enqueueWork(ModContainer modInfo, Runnable work) {
		return enqueueWork(modInfo, () -> {
			work.run();
			return null;
		});
	}

	public <T> CompletableFuture<T> enqueueWork(ModContainer modInfo, Supplier<T> work) {
		CompletableFuture<T> future = new CompletableFuture<>();
		tasks.add(() -> {
			try {
				future.complete(work.get());
			} catch (Throwable t) {
				future.completeExceptionally(t);
				throw new RuntimeException("Deferred work for mod " + modInfo.getModId() + " in queue " + name + " failed", t);
			}
		});
		return future;
	}

	@Override
	public String toString() {
		return "DeferredWorkQueue{" + name + "}";
	}
}
