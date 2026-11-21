package net.neoforged.neoforge.client.event.lifecycle;

import net.minecraft.client.Minecraft;

/**
 * SteelWool re-implementation of NeoForge's {@code ClientStartedEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ClientStartedEvent extends ClientLifecycleEvent {
	public ClientStartedEvent(Minecraft arg0) {
		super(arg0);
	}
}
