package net.neoforged.neoforge.event;

import java.util.Set;

import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.common.util.AttributeTooltipContext;

/**
 * SteelWool re-implementation of NeoForge's {@code GatherSkippedAttributeTooltipsEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class GatherSkippedAttributeTooltipsEvent extends Event {
	protected final ItemStack stack;
	protected final AttributeTooltipContext ctx;
	private Set<Identifier> skippedIds;
	private Set<EquipmentSlotGroup> skippedGroups;
	private boolean skipAll;

	public GatherSkippedAttributeTooltipsEvent(ItemStack stack, AttributeTooltipContext ctx) {
		super();
		this.skippedIds = null;
		this.skippedGroups = null;
		this.skipAll = false;
		this.stack = stack;
		this.ctx = ctx;
	}

	public AttributeTooltipContext getContext() {
		return this.ctx;
	}

	public ItemStack getStack() {
		return this.stack;
	}

	public void skipId(Identifier arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement GatherSkippedAttributeTooltipsEvent.skipId yet");
	}

	public void skipGroup(EquipmentSlotGroup arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement GatherSkippedAttributeTooltipsEvent.skipGroup yet");
	}

	public boolean isSkipped(Identifier arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement GatherSkippedAttributeTooltipsEvent.isSkipped yet");
	}

	public boolean isSkipped(EquipmentSlotGroup arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement GatherSkippedAttributeTooltipsEvent.isSkipped yet");
	}

	public void setSkipAll(boolean skipAll) {
		this.skipAll = skipAll;
	}

	public boolean isSkippingAll() {
		return this.skipAll;
	}

	protected Set<Identifier> getSkippedIds() {
		throw new UnsupportedOperationException("SteelWool does not implement GatherSkippedAttributeTooltipsEvent.getSkippedIds yet");
	}

	protected Set<EquipmentSlotGroup> getSkippedGroups() {
		throw new UnsupportedOperationException("SteelWool does not implement GatherSkippedAttributeTooltipsEvent.getSkippedGroups yet");
	}
}
