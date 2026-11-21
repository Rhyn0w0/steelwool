package net.neoforged.neoforge.client.event;

import java.util.Map;

import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code RegisterEntitySpectatorShadersEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class RegisterEntitySpectatorShadersEvent extends Event implements IModBusEvent {
	private final Map<EntityType<?>, Identifier> shaders;

	public RegisterEntitySpectatorShadersEvent(Map<EntityType<?>, Identifier> shaders) {
		super();
		this.shaders = shaders;
	}

	public void register(EntityType<?> arg0, Identifier arg1) {
		throw new UnsupportedOperationException("SteelWool does not implement RegisterEntitySpectatorShadersEvent.register yet");
	}
}
