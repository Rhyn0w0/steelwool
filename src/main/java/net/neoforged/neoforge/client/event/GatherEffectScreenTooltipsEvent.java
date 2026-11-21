package net.neoforged.neoforge.client.event;

import java.util.List;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.neoforged.bus.api.Event;

/**
 * SteelWool re-implementation of NeoForge's {@code GatherEffectScreenTooltipsEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class GatherEffectScreenTooltipsEvent extends Event {
	protected final AbstractContainerScreen<?> screen;
	protected final MobEffectInstance effectInst;
	protected final List<Component> tooltip;

	public GatherEffectScreenTooltipsEvent(AbstractContainerScreen<?> screen, MobEffectInstance effectInst, List<Component> arg2) {
		super();
		throw new UnsupportedOperationException("SteelWool does not implement the GatherEffectScreenTooltipsEvent constructor yet");
	}

	public AbstractContainerScreen<?> getScreen() {
		return this.screen;
	}

	public MobEffectInstance getEffectInstance() {
		return this.effectInst;
	}

	public List<Component> getTooltip() {
		return this.tooltip;
	}
}
