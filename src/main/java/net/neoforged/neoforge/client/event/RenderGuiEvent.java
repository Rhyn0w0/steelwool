package net.neoforged.neoforge.client.event;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RenderGuiEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class RenderGuiEvent extends Event {
	private final GuiGraphicsExtractor guiGraphics;
	private final DeltaTracker partialTick;

	protected RenderGuiEvent(GuiGraphicsExtractor guiGraphics, DeltaTracker partialTick) {
		super();
		this.guiGraphics = guiGraphics;
		this.partialTick = partialTick;
	}

	public GuiGraphicsExtractor getGuiGraphics() {
		return this.guiGraphics;
	}

	public DeltaTracker getPartialTick() {
		return this.partialTick;
	}

	public static class Post extends net.neoforged.neoforge.client.event.RenderGuiEvent {
		public Post(GuiGraphicsExtractor arg0, DeltaTracker arg1) {
			super(arg0, arg1);
		}
	}

	public static class Pre extends net.neoforged.neoforge.client.event.RenderGuiEvent implements ICancellableEvent {
		public Pre(GuiGraphicsExtractor arg0, DeltaTracker arg1) {
			super(arg0, arg1);
		}
	}
}
