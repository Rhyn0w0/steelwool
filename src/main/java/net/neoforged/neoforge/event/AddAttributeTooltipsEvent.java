package net.neoforged.neoforge.event;

import java.util.function.Consumer;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.common.util.AttributeTooltipContext;

/**
 * SteelWool re-implementation of NeoForge's {@code AddAttributeTooltipsEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class AddAttributeTooltipsEvent extends Event {
	protected final ItemStack stack;
	protected final Consumer<Component> tooltip;
	protected final AttributeTooltipContext ctx;

	public AddAttributeTooltipsEvent(ItemStack stack, Consumer<Component> tooltip, AttributeTooltipContext ctx) {
		super();
		this.stack = stack;
		this.tooltip = tooltip;
		this.ctx = ctx;
	}

	public AttributeTooltipContext getContext() {
		return this.ctx;
	}

	public ItemStack getStack() {
		return this.stack;
	}

	public void addTooltipLines(Component... arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement AddAttributeTooltipsEvent.addTooltipLines yet");
	}

	public boolean shouldShow() {
		throw new UnsupportedOperationException("SteelWool does not implement AddAttributeTooltipsEvent.shouldShow yet");
	}
}
