package net.neoforged.neoforge.client.event;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.neoforge.client.gui.GuiLayer;

/**
 * SteelWool re-implementation of NeoForge's {@code RenderGuiLayerEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class RenderGuiLayerEvent extends Event {
	private final GuiGraphicsExtractor guiGraphics;
	private final DeltaTracker partialTick;
	private final Identifier name;
	private final GuiLayer layer;

	protected RenderGuiLayerEvent(GuiGraphicsExtractor guiGraphics, DeltaTracker partialTick, Identifier name, GuiLayer layer) {
		super();
		this.guiGraphics = guiGraphics;
		this.partialTick = partialTick;
		this.name = name;
		this.layer = layer;
	}

	public GuiGraphicsExtractor getGuiGraphics() {
		return this.guiGraphics;
	}

	public DeltaTracker getPartialTick() {
		return this.partialTick;
	}

	public Identifier getName() {
		return this.name;
	}

	public GuiLayer getLayer() {
		return this.layer;
	}

	public static class Post extends net.neoforged.neoforge.client.event.RenderGuiLayerEvent {
		public Post(GuiGraphicsExtractor arg0, DeltaTracker arg1, Identifier arg2, GuiLayer arg3) {
			super(arg0, arg1, arg2, arg3);
		}
	}

	public static class Pre extends net.neoforged.neoforge.client.event.RenderGuiLayerEvent implements ICancellableEvent {
		public Pre(GuiGraphicsExtractor arg0, DeltaTracker arg1, Identifier arg2, GuiLayer arg3) {
			super(arg0, arg1, arg2, arg3);
		}
	}
}
