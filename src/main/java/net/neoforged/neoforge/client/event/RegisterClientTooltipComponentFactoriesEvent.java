package net.neoforged.neoforge.client.event;

import java.util.Map;
import java.util.function.Function;

import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterClientTooltipComponentFactoriesEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterClientTooltipComponentFactoriesEvent extends Event implements IModBusEvent {
	private final Map<Class<? extends TooltipComponent>, Function<TooltipComponent, ClientTooltipComponent>> factories;

	public RegisterClientTooltipComponentFactoriesEvent(Map<Class<? extends TooltipComponent>, Function<TooltipComponent, ClientTooltipComponent>> factories) {
		super();
		this.factories = factories;
	}

	public <T extends TooltipComponent> void register(Class<T> arg0, Function<? super T, ? extends ClientTooltipComponent> arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterClientTooltipComponentFactoriesEvent.register yet");
	}
}
