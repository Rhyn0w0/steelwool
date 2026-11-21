package net.neoforged.neoforge.client.event;

import net.minecraft.client.DeltaTracker;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code RenderFrameEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class RenderFrameEvent extends Event {
	protected final DeltaTracker partialTick;

	protected RenderFrameEvent(DeltaTracker partialTick) {
		super();
		this.partialTick = partialTick;
	}

	public DeltaTracker getPartialTick() {
		return this.partialTick;
	}

	public static class Post extends net.neoforged.neoforge.client.event.RenderFrameEvent {
		public Post(DeltaTracker arg0) {
			super(arg0);
		}
	}

	public static class Pre extends net.neoforged.neoforge.client.event.RenderFrameEvent {
		public Pre(DeltaTracker arg0) {
			super(arg0);
		}
	}
}
