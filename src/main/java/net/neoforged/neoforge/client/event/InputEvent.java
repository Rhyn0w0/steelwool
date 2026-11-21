package net.neoforged.neoforge.client.event;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.input.MouseButtonInfo;
import net.minecraft.world.InteractionHand;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;
import org.joml.Vector2ic;

/**
 * SteelWool re-implementation of NeoForge's {@code InputEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class InputEvent extends Event {
	protected InputEvent() {
		super();
	}

	public static class InteractionKeyMappingTriggered extends net.neoforged.neoforge.client.event.InputEvent implements ICancellableEvent {
		private final int button;
		private final KeyMapping keyMapping;
		private final InteractionHand hand;
		private boolean handSwing;

		public InteractionKeyMappingTriggered(int button, KeyMapping keyMapping, InteractionHand hand) {
			super();
			this.handSwing = true;
			this.button = button;
			this.keyMapping = keyMapping;
			this.hand = hand;
		}

		public void setSwingHand(boolean handSwing) {
			this.handSwing = handSwing;
		}

		public boolean shouldSwingHand() {
			return this.handSwing;
		}

		public InteractionHand getHand() {
			return this.hand;
		}

		public boolean isAttack() {
			throw new UnsupportedOperationException("SteelWool does not implement InputEvent.InteractionKeyMappingTriggered.isAttack yet");
		}

		public boolean isUseItem() {
			throw new UnsupportedOperationException("SteelWool does not implement InputEvent.InteractionKeyMappingTriggered.isUseItem yet");
		}

		public boolean isPickBlock() {
			throw new UnsupportedOperationException("SteelWool does not implement InputEvent.InteractionKeyMappingTriggered.isPickBlock yet");
		}

		public KeyMapping getKeyMapping() {
			return this.keyMapping;
		}
	}

	public static class Key extends net.neoforged.neoforge.client.event.InputEvent {
		private final KeyEvent keyEvent;
		private final int action;

		public Key(KeyEvent keyEvent, int action) {
			super();
			this.keyEvent = keyEvent;
			this.action = action;
		}

		public KeyEvent getKeyEvent() {
			return this.keyEvent;
		}

		public int getKey() {
			throw new UnsupportedOperationException("SteelWool does not implement InputEvent.Key.getKey yet");
		}

		public int getKeycode() {
			throw new UnsupportedOperationException("SteelWool does not implement InputEvent.Key.getKeycode yet");
		}

		public int getAction() {
			return this.action;
		}

		public int getModifiers() {
			throw new UnsupportedOperationException("SteelWool does not implement InputEvent.Key.getModifiers yet");
		}
	}

	public static abstract class MouseButton extends net.neoforged.neoforge.client.event.InputEvent {
		private final MouseButtonInfo mouseButtonInfo;
		private final int action;

		protected MouseButton(MouseButtonInfo mouseButtonInfo, int action) {
			super();
			this.mouseButtonInfo = mouseButtonInfo;
			this.action = action;
		}

		public MouseButtonInfo getMouseButtonInfo() {
			return this.mouseButtonInfo;
		}

		public int getButton() {
			throw new UnsupportedOperationException("SteelWool does not implement InputEvent.MouseButton.getButton yet");
		}

		public int getAction() {
			return this.action;
		}

		public int getModifiers() {
			throw new UnsupportedOperationException("SteelWool does not implement InputEvent.MouseButton.getModifiers yet");
		}

		public static class Post extends net.neoforged.neoforge.client.event.InputEvent.MouseButton {
			public Post(MouseButtonInfo arg0, int arg1) {
				super(arg0, arg1);
			}
		}

		public static class Pre extends net.neoforged.neoforge.client.event.InputEvent.MouseButton implements ICancellableEvent {
			public Pre(MouseButtonInfo arg0, int arg1) {
				super(arg0, arg1);
			}
		}
	}

	public static class MouseScrollingEvent extends net.neoforged.neoforge.client.event.InputEvent implements ICancellableEvent {
		private final double scrollDeltaX;
		private final double scrollDeltaY;
		private final int accumulatedScrollX;
		private final int accumulatedScrollY;
		private final double mouseX;
		private final double mouseY;
		private final boolean leftDown;
		private final boolean middleDown;
		private final boolean rightDown;

		public MouseScrollingEvent(double scrollDeltaX, double scrollDeltaY, Vector2ic arg2, boolean arg3, boolean arg4, boolean arg5, double arg6, double arg7) {
			super();
			throw new UnsupportedOperationException("SteelWool does not implement the InputEvent.MouseScrollingEvent constructor yet");
		}

		public double getScrollDeltaX() {
			return this.scrollDeltaX;
		}

		public double getScrollDeltaY() {
			return this.scrollDeltaY;
		}

		public int getAccumulatedScrollX() {
			return this.accumulatedScrollX;
		}

		public int getAccumulatedScrollY() {
			return this.accumulatedScrollY;
		}

		public boolean isLeftDown() {
			return this.leftDown;
		}

		public boolean isRightDown() {
			return this.rightDown;
		}

		public boolean isMiddleDown() {
			return this.middleDown;
		}

		public double getMouseX() {
			return this.mouseX;
		}

		public double getMouseY() {
			return this.mouseY;
		}
	}
}
