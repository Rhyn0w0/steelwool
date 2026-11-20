package net.neoforged.fml.event.lifecycle;

import net.neoforged.fml.DeferredWorkQueue;
import net.neoforged.fml.ModContainer;

/**
 * Fired after InterModEnqueueEvent so mods can read inter-mod messages.
 */
public class InterModProcessEvent extends ParallelDispatchEvent {
	public InterModProcessEvent(ModContainer container, DeferredWorkQueue deferredWorkQueue) {
		super(container, deferredWorkQueue);
	}
}
