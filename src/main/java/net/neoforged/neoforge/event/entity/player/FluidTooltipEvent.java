package net.neoforged.neoforge.event.entity.player;

import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.fluids.FluidStack;

/**
 * SteelWool re-implementation of NeoForge's {@code FluidTooltipEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class FluidTooltipEvent extends PlayerEvent {
	private final TooltipFlag flags;
	private final FluidStack fluidStack;
	private final List<Component> toolTip;
	private final Item.TooltipContext context;

	public FluidTooltipEvent(FluidStack fluidStack, Player arg1, List<Component> toolTip, TooltipFlag flags, Item.TooltipContext context) {
		super(arg1);
		this.fluidStack = fluidStack;
		this.toolTip = toolTip;
		this.flags = flags;
		this.context = context;
	}

	public TooltipFlag getFlags() {
		return this.flags;
	}

	public FluidStack getFluidStack() {
		return this.fluidStack;
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
}
