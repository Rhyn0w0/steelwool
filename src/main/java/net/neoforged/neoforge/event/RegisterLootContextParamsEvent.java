package net.neoforged.neoforge.event;

import java.util.Map;

import net.minecraft.resources.Identifier;
import net.minecraft.util.context.ContextKey;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterLootContextParamsEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterLootContextParamsEvent extends Event implements IModBusEvent {
	private final Map<Identifier, ContextKey<?>> lootContextParams;

	public RegisterLootContextParamsEvent(Map<Identifier, ContextKey<?>> lootContextParams) {
		super();
		this.lootContextParams = lootContextParams;
	}

	public void register(ContextKey<?> arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterLootContextParamsEvent.register yet");
	}
}
