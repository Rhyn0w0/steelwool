package net.neoforged.fml.event.lifecycle;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import net.neoforged.fml.DeferredWorkQueue;
import net.neoforged.fml.ModContainer;

/**
 * A lifecycle event that NeoForge dispatches to mods in parallel. {@link #enqueueWork} runs work
 * on the main thread afterwards. (SteelWool dispatches on the main thread.)
 */
public abstract class ParallelDispatchEvent extends ModLifecycleEvent {
	private final DeferredWorkQueue workQueue;

	public ParallelDispatchEvent(ModContainer container, DeferredWorkQueue workQueue) {
		super(container);
		this.workQueue = workQueue;
	}

	public CompletableFuture<Void> enqueueWork(Runnable work) {
		return workQueue.enqueueWork(getContainer(), work);
	}

	public <T> CompletableFuture<T> enqueueWork(Supplier<T> work) {
		return workQueue.enqueueWork(getContainer(), work);
	}
}
