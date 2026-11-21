package net.neoforged.neoforge.client;

import java.util.List;
import java.util.Map;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * SteelWool re-implementation of NeoForge's {@code ItemDecoratorHandler}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public final class ItemDecoratorHandler {
	private final List<IItemDecorator> itemDecorators;
	private static Map<Item, net.neoforged.neoforge.client.ItemDecoratorHandler> DECORATOR_LOOKUP;
	private static final net.neoforged.neoforge.client.ItemDecoratorHandler EMPTY = null /* SteelWool: TODO */;

	private ItemDecoratorHandler() {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the ItemDecoratorHandler constructor yet");
	}

	private ItemDecoratorHandler(List<IItemDecorator> arg0) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the ItemDecoratorHandler constructor yet");
	}

	public static void init() {
		throw new UnsupportedOperationException("SteelWool does not implement ItemDecoratorHandler.init yet");
	}

	public static net.neoforged.neoforge.client.ItemDecoratorHandler of(ItemStack arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemDecoratorHandler.of yet");
	}

	public void render(GuiGraphicsExtractor arg0, Font arg1, ItemStack arg2, int arg3, int arg4) {
		throw new UnsupportedOperationException("SteelWool does not implement ItemDecoratorHandler.render yet");
	}
}
