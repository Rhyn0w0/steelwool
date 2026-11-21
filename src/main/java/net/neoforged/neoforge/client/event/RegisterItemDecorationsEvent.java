package net.neoforged.neoforge.client.event;

import java.util.List;
import java.util.Map;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.client.IItemDecorator;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterItemDecorationsEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterItemDecorationsEvent extends Event implements IModBusEvent {
	private final Map<Item, List<IItemDecorator>> decorators;

	public RegisterItemDecorationsEvent(Map<Item, List<IItemDecorator>> decorators) {
		super();
		this.decorators = decorators;
	}

	public void register(ItemLike arg0, IItemDecorator arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterItemDecorationsEvent.register yet");
	}
}
