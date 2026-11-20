package net.neoforged.fml.event.lifecycle;

import net.neoforged.fml.DeferredWorkQueue;
import net.neoforged.fml.ModContainer;

/**
 * Fired once all mods have finished loading.
 */
public class FMLLoadCompleteEvent extends ParallelDispatchEvent {
	public FMLLoadCompleteEvent(ModContainer container, DeferredWorkQueue deferredWorkQueue) {
		super(container, deferredWorkQueue);
	}
}
