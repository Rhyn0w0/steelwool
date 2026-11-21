package net.neoforged.neoforge.client.event;

import java.util.List;

import com.mojang.datafixers.util.Either;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipPositioner;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.resources.Identifier;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RenderTooltipEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public abstract class RenderTooltipEvent extends Event {
	protected final ItemStack itemStack;
	protected final GuiGraphicsExtractor graphics;
	protected int x;
	protected int y;
	protected Font font;
	protected final List<ClientTooltipComponent> components;

	protected RenderTooltipEvent(ItemStack itemStack, GuiGraphicsExtractor graphics, int arg2, int arg3, Font arg4, List<ClientTooltipComponent> arg5) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the RenderTooltipEvent constructor yet");
	}

	public ItemStack getItemStack() {
		return this.itemStack;
	}

	public GuiGraphicsExtractor getGraphics() {
		return this.graphics;
	}

	public List<ClientTooltipComponent> getComponents() {
		return this.components;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public Font getFont() {
		return this.font;
	}

	public static class GatherComponents extends Event implements ICancellableEvent {
		private final ItemStack itemStack;
		private final int screenWidth;
		private final int screenHeight;
		private final List<Either<FormattedText, TooltipComponent>> tooltipElements;
		private int maxWidth;

		public GatherComponents(ItemStack itemStack, int screenWidth, int screenHeight, List<Either<FormattedText, TooltipComponent>> arg3, int arg4) {
			super();
			throw new UnsupportedOperationException("SteelWool does not implement the RenderTooltipEvent.GatherComponents constructor yet");
		}

		public ItemStack getItemStack() {
			return this.itemStack;
		}

		public int getScreenWidth() {
			return this.screenWidth;
		}

		public int getScreenHeight() {
			return this.screenHeight;
		}

		public List<Either<FormattedText, TooltipComponent>> getTooltipElements() {
			return this.tooltipElements;
		}

		public int getMaxWidth() {
			return this.maxWidth;
		}

		public void setMaxWidth(int maxWidth) {
			this.maxWidth = maxWidth;
		}
	}

	public static class Pre extends net.neoforged.neoforge.client.event.RenderTooltipEvent implements ICancellableEvent {
		private final int screenWidth;
		private final int screenHeight;
		private final ClientTooltipPositioner positioner;

		public Pre(ItemStack arg0, GuiGraphicsExtractor arg1, int arg2, int arg3, int screenWidth, int screenHeight, Font arg6, List<ClientTooltipComponent> arg7, ClientTooltipPositioner positioner) {
			super(arg0, arg1, arg2, arg3, arg6, arg7);
			this.screenWidth = screenWidth;
			this.screenHeight = screenHeight;
			this.positioner = positioner;
		}

		public int getScreenWidth() {
			return this.screenWidth;
		}

		public int getScreenHeight() {
			return this.screenHeight;
		}

		public ClientTooltipPositioner getTooltipPositioner() {
			return this.positioner;
		}

		public void setFont(Font font) {
			this.font = font;
		}

		public void setX(int x) {
			this.x = x;
		}

		public void setY(int y) {
			this.y = y;
		}
	}

	public static class Texture extends net.neoforged.neoforge.client.event.RenderTooltipEvent {
		private final Identifier originalTexture;
		private Identifier texture;

		public Texture(ItemStack arg0, GuiGraphicsExtractor arg1, int arg2, int arg3, Font arg4, List<ClientTooltipComponent> arg5, Identifier originalTexture) {
			super(arg0, arg1, arg2, arg3, arg4, arg5);
			this.originalTexture = originalTexture;
			this.texture = originalTexture;
		}

		public Identifier getOriginalTexture() {
			return this.originalTexture;
		}

		public Identifier getTexture() {
			return this.texture;
		}

		public void setTexture(Identifier texture) {
			this.texture = texture;
		}
	}
}
