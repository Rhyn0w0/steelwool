package net.neoforged.fml.event.lifecycle;

import net.neoforged.fml.DeferredWorkQueue;
import net.neoforged.fml.ModContainer;

/**
 * Fired on the client after common setup.
 */
public class FMLClientSetupEvent extends ParallelDispatchEvent {
	public FMLClientSetupEvent(ModContainer container, DeferredWorkQueue deferredWorkQueue) {
		super(container, deferredWorkQueue);
	}
}
