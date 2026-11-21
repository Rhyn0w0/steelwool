package net.neoforged.neoforge.client.event.lifecycle;

import net.minecraft.client.Minecraft;

/**
 * SteelWool re-implementation of NeoForge's {@code ClientStoppingEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class ClientStoppingEvent extends ClientLifecycleEvent {
	public ClientStoppingEvent(Minecraft arg0) {
		super(arg0);
	}
}
