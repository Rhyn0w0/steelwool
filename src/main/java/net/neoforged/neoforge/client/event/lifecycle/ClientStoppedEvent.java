package net.neoforged.neoforge.client.event.lifecycle;

import net.minecraft.client.Minecraft;

/**
 * SteelWool re-implementation of NeoForge's {@code ClientStoppedEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ClientStoppedEvent extends ClientLifecycleEvent {
	public ClientStoppedEvent(Minecraft arg0) {
		super(arg0);
	}
}
