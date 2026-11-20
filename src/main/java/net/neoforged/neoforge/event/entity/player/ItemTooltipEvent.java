package net.neoforged.neoforge.event.entity.player;

import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

/**
 * SteelWool re-implementation of NeoForge's {@code ItemTooltipEvent}, with the same API.
 */
public class ItemTooltipEvent extends PlayerEvent {
	private final TooltipFlag flags;
	private final ItemStack itemStack;
	private final List<Component> toolTip;
	private final Item.TooltipContext context;
	private final TooltipDisplay display;

	public ItemTooltipEvent(ItemStack itemStack, Player arg1, List<Component> toolTip, TooltipFlag flags, Item.TooltipContext context, TooltipDisplay display) {
		super(arg1);
		this.itemStack = itemStack;
		this.toolTip = toolTip;
		this.flags = flags;
		this.context = context;
		this.display = display;
	}

	public TooltipFlag getFlags() {
		return this.flags;
	}

	public ItemStack getItemStack() {
		return this.itemStack;
	}

	public List<Component> getToolTip() {
		return this.toolTip;
	}

	public Player getEntity() {
		return super.getEntity();
	}

	public Item.TooltipContext getContext() {
		return this.context;
	}

	public TooltipDisplay getDisplay() {
		return this.display;
	}
}
