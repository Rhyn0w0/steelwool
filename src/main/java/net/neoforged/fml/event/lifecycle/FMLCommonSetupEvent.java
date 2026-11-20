package net.neoforged.fml.event.lifecycle;

import net.neoforged.fml.DeferredWorkQueue;
import net.neoforged.fml.ModContainer;

/**
 * Fired on both sides after registration, for common setup.
 */
public class FMLCommonSetupEvent extends ParallelDispatchEvent {
	public FMLCommonSetupEvent(ModContainer container, DeferredWorkQueue deferredWorkQueue) {
		super(container, deferredWorkQueue);
	}
}
