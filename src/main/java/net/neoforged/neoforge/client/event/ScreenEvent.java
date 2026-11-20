package net.neoforged.neoforge.client.event;

import java.util.List;
import java.util.function.Consumer;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.input.CharacterEvent;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.input.PreeditEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code ScreenEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class ScreenEvent extends Event {
	private final Screen screen;

	protected ScreenEvent(Screen arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the ScreenEvent constructor yet");
	}

	public Screen getScreen() {
		return this.screen;
	}

	public static abstract class CharacterTyped extends net.neoforged.neoforge.client.event.ScreenEvent {
		private final CharacterEvent charEvent;

		public CharacterTyped(Screen arg0, CharacterEvent charEvent) {
			super(arg0);
			this.charEvent = charEvent;
		}

		public CharacterEvent getCharacterEvent() {
			return this.charEvent;
		}

		public int getCodePoint() {
			throw new UnsupportedOperationException("SteelWool does not implement ScreenEvent.CharacterTyped.getCodePoint yet");
		}

		public static class Post extends net.neoforged.neoforge.client.event.ScreenEvent.CharacterTyped {
			public Post(Screen arg0, CharacterEvent arg1) {
				super(arg0, arg1);
			}
		}

		public static class Pre extends net.neoforged.neoforge.client.event.ScreenEvent.CharacterTyped implements ICancellableEvent {
			public Pre(Screen arg0, CharacterEvent arg1) {
				super(arg0, arg1);
			}
		}
	}

	public static class Closing extends net.neoforged.neoforge.client.event.ScreenEvent {
		public Closing(Screen arg0) {
			super(arg0);
		}
	}

	public static abstract class Init extends net.neoforged.neoforge.client.event.ScreenEvent {
		private final Consumer<GuiEventListener> add;
		private final Consumer<GuiEventListener> remove;
		private final List<GuiEventListener> listenerList;

		protected Init(Screen arg0, List<GuiEventListener> arg1, Consumer<GuiEventListener> arg2, Consumer<GuiEventListener> arg3) {
			super((Screen) null);
			throw new UnsupportedOperationException("SteelWool does not implement the ScreenEvent.Init constructor yet");
		}

		public List<GuiEventListener> getListenersList() {
			return this.listenerList;
		}

		public void addListener(GuiEventListener arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement ScreenEvent.Init.addListener yet");
		}

		public void removeListener(GuiEventListener arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement ScreenEvent.Init.removeListener yet");
		}

		public static class Post extends net.neoforged.neoforge.client.event.ScreenEvent.Init {
			public Post(Screen arg0, List<GuiEventListener> arg1, Consumer<GuiEventListener> arg2, Consumer<GuiEventListener> arg3) {
				super(arg0, arg1, arg2, arg3);
			}
		}

		public static class Pre extends net.neoforged.neoforge.client.event.ScreenEvent.Init implements ICancellableEvent {
			public Pre(Screen arg0, List<GuiEventListener> arg1, Consumer<GuiEventListener> arg2, Consumer<GuiEventListener> arg3) {
				super(arg0, arg1, arg2, arg3);
			}
		}
	}

	static abstract class KeyInput extends net.neoforged.neoforge.client.event.ScreenEvent {
		private final KeyEvent keyEvent;

		protected KeyInput(Screen arg0, KeyEvent keyEvent) {
			super(arg0);
			this.keyEvent = keyEvent;
		}

		public KeyEvent getKeyEvent() {
			return this.keyEvent;
		}

		public int getKey() {
			throw new UnsupportedOperationException("SteelWool does not implement ScreenEvent.KeyInput.getKey yet");
		}

		public int getKeycode() {
			throw new UnsupportedOperationException("SteelWool does not implement ScreenEvent.KeyInput.getKeycode yet");
		}

		public int getModifiers() {
			throw new UnsupportedOperationException("SteelWool does not implement ScreenEvent.KeyInput.getModifiers yet");
		}
	}

	public static abstract class KeyPressed extends net.neoforged.neoforge.client.event.ScreenEvent.KeyInput {
		public KeyPressed(Screen arg0, KeyEvent arg1) {
			super(arg0, arg1);
		}

		public static class Post extends net.neoforged.neoforge.client.event.ScreenEvent.KeyPressed implements ICancellableEvent {
			public Post(Screen arg0, KeyEvent arg1) {
				super(arg0, arg1);
			}
		}

		public static class Pre extends net.neoforged.neoforge.client.event.ScreenEvent.KeyPressed implements ICancellableEvent {
			public Pre(Screen arg0, KeyEvent arg1) {
				super(arg0, arg1);
			}
		}
	}

	public static abstract class KeyReleased extends net.neoforged.neoforge.client.event.ScreenEvent.KeyInput {
		public KeyReleased(Screen arg0, KeyEvent arg1) {
			super(arg0, arg1);
		}

		public static class Post extends net.neoforged.neoforge.client.event.ScreenEvent.KeyReleased implements ICancellableEvent {
			public Post(Screen arg0, KeyEvent arg1) {
				super(arg0, arg1);
			}
		}

		public static class Pre extends net.neoforged.neoforge.client.event.ScreenEvent.KeyReleased implements ICancellableEvent {
			public Pre(Screen arg0, KeyEvent arg1) {
				super(arg0, arg1);
			}
		}
	}

	public static abstract class MouseButtonPressed extends net.neoforged.neoforge.client.event.ScreenEvent.MouseInput {
		private final MouseButtonEvent mouseEvent;
		private final boolean doubleClick;

		public MouseButtonPressed(Screen arg0, MouseButtonEvent arg1, boolean arg2) {
			super((Screen) null, (double) 0, (double) 0);
			throw new UnsupportedOperationException("SteelWool does not implement the ScreenEvent.MouseButtonPressed constructor yet");
		}

		public MouseButtonEvent getMouseButtonEvent() {
			return this.mouseEvent;
		}

		public int getButton() {
			throw new UnsupportedOperationException("SteelWool does not implement ScreenEvent.MouseButtonPressed.getButton yet");
		}

		public boolean isDoubleClick() {
			return this.doubleClick;
		}

		public static class Post extends net.neoforged.neoforge.client.event.ScreenEvent.MouseButtonPressed {
			private final boolean handled;
			private net.neoforged.neoforge.client.event.ScreenEvent.MouseButtonPressed.Post.Result result;

			public Post(Screen arg0, MouseButtonEvent arg1, boolean arg2, boolean arg3) {
				super((Screen) null, (MouseButtonEvent) null, false);
				throw new UnsupportedOperationException("SteelWool does not implement the ScreenEvent.MouseButtonPressed.Post constructor yet");
			}

			public boolean wasClickHandled() {
				return this.handled;
			}

			public void setResult(net.neoforged.neoforge.client.event.ScreenEvent.MouseButtonPressed.Post.Result result) {
				this.result = result;
			}

			public net.neoforged.neoforge.client.event.ScreenEvent.MouseButtonPressed.Post.Result getResult() {
				return this.result;
			}

			public boolean getClickResult() {
				throw new UnsupportedOperationException("SteelWool does not implement ScreenEvent.MouseButtonPressed.Post.getClickResult yet");
			}

			public enum Result {
				FORCE_HANDLED, DEFAULT, FORCE_UNHANDLED;
			}
		}

		public static class Pre extends net.neoforged.neoforge.client.event.ScreenEvent.MouseButtonPressed implements ICancellableEvent {
			public Pre(Screen arg0, MouseButtonEvent arg1, boolean arg2) {
				super(arg0, arg1, arg2);
			}
		}
	}

	public static abstract class MouseButtonReleased extends net.neoforged.neoforge.client.event.ScreenEvent.MouseInput {
		private final MouseButtonEvent mouseEvent;

		public MouseButtonReleased(Screen arg0, MouseButtonEvent arg1) {
			super((Screen) null, (double) 0, (double) 0);
			throw new UnsupportedOperationException("SteelWool does not implement the ScreenEvent.MouseButtonReleased constructor yet");
		}

		public MouseButtonEvent getMouseButtonEvent() {
			return this.mouseEvent;
		}

		public int getButton() {
			throw new UnsupportedOperationException("SteelWool does not implement ScreenEvent.MouseButtonReleased.getButton yet");
		}

		public static class Post extends net.neoforged.neoforge.client.event.ScreenEvent.MouseButtonReleased {
			private final boolean handled;
			private net.neoforged.neoforge.client.event.ScreenEvent.MouseButtonReleased.Post.Result result;

			public Post(Screen arg0, MouseButtonEvent arg1, boolean arg2) {
				super((Screen) null, (MouseButtonEvent) null);
				throw new UnsupportedOperationException("SteelWool does not implement the ScreenEvent.MouseButtonReleased.Post constructor yet");
			}

			public boolean wasReleaseHandled() {
				return this.handled;
			}

			public void setResult(net.neoforged.neoforge.client.event.ScreenEvent.MouseButtonReleased.Post.Result result) {
				this.result = result;
			}

			public net.neoforged.neoforge.client.event.ScreenEvent.MouseButtonReleased.Post.Result getResult() {
				return this.result;
			}

			public boolean getReleaseResult() {
				throw new UnsupportedOperationException("SteelWool does not implement ScreenEvent.MouseButtonReleased.Post.getReleaseResult yet");
			}

			public enum Result {
				FORCE_HANDLED, DEFAULT, FORCE_UNHANDLED;
			}
		}

		public static class Pre extends net.neoforged.neoforge.client.event.ScreenEvent.MouseButtonReleased implements ICancellableEvent {
			public Pre(Screen arg0, MouseButtonEvent arg1) {
				super(arg0, arg1);
			}
		}
	}

	public static abstract class MouseDragged extends net.neoforged.neoforge.client.event.ScreenEvent.MouseInput {
		private final MouseButtonEvent mouseEvent;
		private final double dragX;
		private final double dragY;

		public MouseDragged(Screen arg0, MouseButtonEvent arg1, double arg2, double arg3) {
			super((Screen) null, (double) 0, (double) 0);
			throw new UnsupportedOperationException("SteelWool does not implement the ScreenEvent.MouseDragged constructor yet");
		}

		public MouseButtonEvent getMouseButtonEvent() {
			return this.mouseEvent;
		}

		public int getMouseButton() {
			throw new UnsupportedOperationException("SteelWool does not implement ScreenEvent.MouseDragged.getMouseButton yet");
		}

		public double getDragX() {
			return this.dragX;
		}

		public double getDragY() {
			return this.dragY;
		}

		public static class Post extends net.neoforged.neoforge.client.event.ScreenEvent.MouseDragged {
			public Post(Screen arg0, MouseButtonEvent arg1, double arg2, double arg3) {
				super(arg0, arg1, arg2, arg3);
			}
		}

		public static class Pre extends net.neoforged.neoforge.client.event.ScreenEvent.MouseDragged implements ICancellableEvent {
			public Pre(Screen arg0, MouseButtonEvent arg1, double arg2, double arg3) {
				super(arg0, arg1, arg2, arg3);
			}
		}
	}

	static abstract class MouseInput extends net.neoforged.neoforge.client.event.ScreenEvent {
		private final double mouseX;
		private final double mouseY;

		protected MouseInput(Screen arg0, double mouseX, double mouseY) {
			super(arg0);
			this.mouseX = mouseX;
			this.mouseY = mouseY;
		}

		public double getMouseX() {
			return this.mouseX;
		}

		public double getMouseY() {
			return this.mouseY;
		}
	}

	public static abstract class MouseScrolled extends net.neoforged.neoforge.client.event.ScreenEvent.MouseInput {
		private final double scrollDeltaX;
		private final double scrollDeltaY;

		public MouseScrolled(Screen arg0, double arg1, double arg2, double scrollDeltaX, double scrollDeltaY) {
			super(arg0, arg1, arg2);
			this.scrollDeltaX = scrollDeltaX;
			this.scrollDeltaY = scrollDeltaY;
		}

		public double getScrollDeltaX() {
			return this.scrollDeltaX;
		}

		public double getScrollDeltaY() {
			return this.scrollDeltaY;
		}

		public static class Post extends net.neoforged.neoforge.client.event.ScreenEvent.MouseScrolled {
			public Post(Screen arg0, double arg1, double arg2, double arg3, double arg4) {
				super(arg0, arg1, arg2, arg3, arg4);
			}
		}

		public static class Pre extends net.neoforged.neoforge.client.event.ScreenEvent.MouseScrolled implements ICancellableEvent {
			public Pre(Screen arg0, double arg1, double arg2, double arg3, double arg4) {
				super(arg0, arg1, arg2, arg3, arg4);
			}
		}
	}

	public static class Opening extends net.neoforged.neoforge.client.event.ScreenEvent implements ICancellableEvent {
		private final Screen currentScreen;
		private Screen newScreen;

		public Opening(Screen currentScreen, Screen newScreen) {
			super(newScreen);
			this.currentScreen = currentScreen;
			this.newScreen = newScreen;
		}

		public Screen getCurrentScreen() {
			return this.currentScreen;
		}

		public Screen getNewScreen() {
			return this.newScreen;
		}

		public void setNewScreen(Screen newScreen) {
			this.newScreen = newScreen;
		}
	}

	public static abstract class Preedit extends net.neoforged.neoforge.client.event.ScreenEvent {
		private final PreeditEvent preeditEvent;

		public Preedit(Screen arg0, PreeditEvent preeditEvent) {
			super(arg0);
			this.preeditEvent = preeditEvent;
		}

		public PreeditEvent getPreeditEvent() {
			return this.preeditEvent;
		}

		public static class Post extends net.neoforged.neoforge.client.event.ScreenEvent.Preedit {
			public Post(Screen arg0, PreeditEvent arg1) {
				super(arg0, arg1);
			}
		}

		public static class Pre extends net.neoforged.neoforge.client.event.ScreenEvent.Preedit implements ICancellableEvent {
			public Pre(Screen arg0, PreeditEvent arg1) {
				super(arg0, arg1);
			}
		}
	}

	public static abstract class Render extends net.neoforged.neoforge.client.event.ScreenEvent {
		private final GuiGraphicsExtractor guiGraphics;
		private final int mouseX;
		private final int mouseY;
		private final float partialTick;

		protected Render(Screen arg0, GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTick) {
			super(arg0);
			this.guiGraphics = guiGraphics;
			this.mouseX = mouseX;
			this.mouseY = mouseY;
			this.partialTick = partialTick;
		}

		public GuiGraphicsExtractor getGuiGraphics() {
			return this.guiGraphics;
		}

		public int getMouseX() {
			return this.mouseX;
		}

		public int getMouseY() {
			return this.mouseY;
		}

		public float getPartialTick() {
			return this.partialTick;
		}

		public static class Background extends net.neoforged.neoforge.client.event.ScreenEvent.Render {
			public Background(Screen arg0, GuiGraphicsExtractor arg1, int arg2, int arg3, float arg4) {
				super(arg0, arg1, arg2, arg3, arg4);
			}
		}

		public static class Foreground extends net.neoforged.neoforge.client.event.ScreenEvent.Render {
			public Foreground(Screen arg0, GuiGraphicsExtractor arg1, int arg2, int arg3, float arg4) {
				super(arg0, arg1, arg2, arg3, arg4);
			}
		}

		public static class Post extends net.neoforged.neoforge.client.event.ScreenEvent.Render {
			public Post(Screen arg0, GuiGraphicsExtractor arg1, int arg2, int arg3, float arg4) {
				super(arg0, arg1, arg2, arg3, arg4);
			}
		}

		public static class Pre extends net.neoforged.neoforge.client.event.ScreenEvent.Render implements ICancellableEvent {
			public Pre(Screen arg0, GuiGraphicsExtractor arg1, int arg2, int arg3, float arg4) {
				super(arg0, arg1, arg2, arg3, arg4);
			}
		}
	}

	public static class RenderInventoryMobEffects extends net.neoforged.neoforge.client.event.ScreenEvent implements ICancellableEvent {
		private final int availableSpace;
		private boolean compact;
		private int horizontalOffset;

		public RenderInventoryMobEffects(Screen arg0, int availableSpace, boolean compact, int horizontalOffset) {
			super(arg0);
			this.availableSpace = availableSpace;
			this.compact = compact;
			this.horizontalOffset = horizontalOffset;
		}

		public int getAvailableSpace() {
			return this.availableSpace;
		}

		public boolean isCompact() {
			return this.compact;
		}

		public int getHorizontalOffset() {
			return this.horizontalOffset;
		}

		public void setHorizontalOffset(int horizontalOffset) {
			this.horizontalOffset = horizontalOffset;
		}

		public void addHorizontalOffset(int arg0) {
			throw new UnsupportedOperationException("SteelWool does not implement ScreenEvent.RenderInventoryMobEffects.addHorizontalOffset yet");
		}

		public void setCompact(boolean compact) {
			this.compact = compact;
		}
	}
}
