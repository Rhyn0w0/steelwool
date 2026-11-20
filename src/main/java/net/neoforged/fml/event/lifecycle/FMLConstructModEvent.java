package net.neoforged.fml.event.lifecycle;

import net.neoforged.fml.DeferredWorkQueue;
import net.neoforged.fml.ModContainer;

/**
 * Fired right after a mod's {@code @Mod} classes have been constructed.
 */
public class FMLConstructModEvent extends ParallelDispatchEvent {
	public FMLConstructModEvent(ModContainer container, DeferredWorkQueue deferredWorkQueue) {
		super(container, deferredWorkQueue);
	}
}
