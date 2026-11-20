package net.neoforged.fml.event.lifecycle;

import net.neoforged.fml.DeferredWorkQueue;
import net.neoforged.fml.ModContainer;

/**
 * Fired on a dedicated server after common setup.
 */
public class FMLDedicatedServerSetupEvent extends ParallelDispatchEvent {
	public FMLDedicatedServerSetupEvent(ModContainer container, DeferredWorkQueue deferredWorkQueue) {
		super(container, deferredWorkQueue);
	}
}
