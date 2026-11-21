package net.neoforged.neoforge.client.event;

import com.mojang.blaze3d.platform.Window;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.LerpingBossEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code CustomizeGuiOverlayEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class CustomizeGuiOverlayEvent extends Event {
	private final Window window;
	private final GuiGraphicsExtractor guiGraphics;
	private final DeltaTracker partialTick;

	protected CustomizeGuiOverlayEvent(Window window, GuiGraphicsExtractor guiGraphics, DeltaTracker partialTick) {
		super();
		this.window = window;
		this.guiGraphics = guiGraphics;
		this.partialTick = partialTick;
	}

	public Window getWindow() {
		return this.window;
	}

	public GuiGraphicsExtractor getGuiGraphics() {
		return this.guiGraphics;
	}

	public DeltaTracker getPartialTick() {
		return this.partialTick;
	}

	public static class BossEventProgress extends net.neoforged.neoforge.client.event.CustomizeGuiOverlayEvent implements ICancellableEvent {
		private final LerpingBossEvent bossEvent;
		private final int x;
		private final int y;
		private int increment;

		public BossEventProgress(Window arg0, GuiGraphicsExtractor arg1, DeltaTracker arg2, LerpingBossEvent bossEvent, int x, int y, int increment) {
			super(arg0, arg1, arg2);
			this.bossEvent = bossEvent;
			this.x = x;
			this.y = y;
			this.increment = increment;
		}

		public LerpingBossEvent getBossEvent() {
			return this.bossEvent;
		}

		public int getX() {
			return this.x;
		}

		public int getY() {
			return this.y;
		}

		public int getIncrement() {
			return this.increment;
		}

		public void setIncrement(int increment) {
			this.increment = increment;
		}
	}

	public static class Chat extends net.neoforged.neoforge.client.event.CustomizeGuiOverlayEvent {
		private int posX;
		private int posY;

		public Chat(Window arg0, GuiGraphicsExtractor arg1, DeltaTracker arg2, int arg3, int arg4) {
			super((Window) null, (GuiGraphicsExtractor) null, (DeltaTracker) null);
			throw new UnsupportedOperationException("SteelWool does not implement the CustomizeGuiOverlayEvent.Chat constructor yet");
		}

		public int getPosX() {
			return this.posX;
		}

		public void setPosX(int posX) {
			this.posX = posX;
		}

		public int getPosY() {
			return this.posY;
		}

		public void setPosY(int posY) {
			this.posY = posY;
		}
	}
}
