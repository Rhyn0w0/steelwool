package net.neoforged.neoforge.client.gui.widget;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.AbstractContainerEventHandler;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.input.MouseButtonEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code ScrollPanel}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class ScrollPanel extends AbstractContainerEventHandler implements Renderable,NarratableEntry {
	private final Minecraft client;
	protected final int width;
	protected final int height;
	protected final int top;
	protected final int bottom;
	protected final int right;
	protected final int left;
	private boolean scrolling;
	protected float scrollDistance;
	protected boolean captureMouse;
	protected final int border;
	private final int barWidth;
	private final int barLeft;
	private final int barBgColor;
	private final int barColor;
	private final int barBorderColor;

	public ScrollPanel(Minecraft arg0, int arg1, int arg2, int arg3, int arg4) {
		this(arg0, arg1, arg2, arg3, arg4, 4);
	}

	public ScrollPanel(Minecraft arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		this(arg0, arg1, arg2, arg3, arg4, arg5, 6);
	}

	public ScrollPanel(Minecraft arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		this(arg0, arg1, arg2, arg3, arg4, arg5, arg6, -16777216, -8355712, -4144960);
	}

	public ScrollPanel(Minecraft client, int width, int height, int top, int left, int arg5, int arg6, int arg7, int arg8, int arg9) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the ScrollPanel constructor yet");
	}

	protected abstract int getContentHeight();

	protected void drawBackground(GuiGraphicsExtractor arg0, float arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ScrollPanel.drawBackground yet");
	}

	protected abstract void drawPanel(GuiGraphicsExtractor arg0, int arg1, int arg2, int arg3, int arg4);

	protected boolean clickPanel(double arg0, double arg1, MouseButtonEvent arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ScrollPanel.clickPanel yet");
	}

	private int getMaxScroll() {
		throw new UnsupportedOperationException("SteelWool does not implement ScrollPanel.getMaxScroll yet");
	}

	private void applyScrollLimits() {
		throw new UnsupportedOperationException("SteelWool does not implement ScrollPanel.applyScrollLimits yet");
	}

	public boolean mouseScrolled(double arg0, double arg1, double arg2, double arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ScrollPanel.mouseScrolled yet");
	}

	protected int getScrollAmount() {
		throw new UnsupportedOperationException("SteelWool does not implement ScrollPanel.getScrollAmount yet");
	}

	public boolean isMouseOver(double arg0, double arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ScrollPanel.isMouseOver yet");
	}

	public boolean mouseClicked(MouseButtonEvent arg0, boolean arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement ScrollPanel.mouseClicked yet");
	}

	public boolean mouseReleased(MouseButtonEvent arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ScrollPanel.mouseReleased yet");
	}

	private int getBarHeight() {
		throw new UnsupportedOperationException("SteelWool does not implement ScrollPanel.getBarHeight yet");
	}

	public boolean mouseDragged(MouseButtonEvent arg0, double arg1, double arg2) {
		throw new UnsupportedOperationException("SteelWool does not implement ScrollPanel.mouseDragged yet");
	}

	public void extractRenderState(GuiGraphicsExtractor arg0, int arg1, int arg2, float arg3) {
		throw new UnsupportedOperationException("SteelWool does not implement ScrollPanel.extractRenderState yet");
	}

	protected void drawGradientRect(GuiGraphicsExtractor arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		throw new UnsupportedOperationException("SteelWool does not implement ScrollPanel.drawGradientRect yet");
	}

	public List<? extends GuiEventListener> children() {
		throw new UnsupportedOperationException("SteelWool does not implement ScrollPanel.children yet");
	}
}
