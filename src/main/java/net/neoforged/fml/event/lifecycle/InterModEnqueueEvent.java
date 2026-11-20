package net.neoforged.fml.event.lifecycle;

import net.neoforged.fml.DeferredWorkQueue;
import net.neoforged.fml.ModContainer;

/**
 * Fired after side setup so mods can send inter-mod messages.
 */
public class InterModEnqueueEvent extends ParallelDispatchEvent {
	public InterModEnqueueEvent(ModContainer container, DeferredWorkQueue deferredWorkQueue) {
		super(container, deferredWorkQueue);
	}
}
