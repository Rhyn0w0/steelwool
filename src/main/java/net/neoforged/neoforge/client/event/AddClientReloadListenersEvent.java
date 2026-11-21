package net.neoforged.neoforge.client.event;

import java.util.List;

import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.event.SortedReloadListenerEvent;

/**
 * SteelWool re-implementation of NeoForge's {@code AddClientReloadListenersEvent}, with the same API.
 * Members that throw {@link UnsupportedOperationException} are not implemented yet.
 */
public class AddClientReloadListenersEvent extends SortedReloadListenerEvent implements IModBusEvent {
	public AddClientReloadListenersEvent(ReloadableResourceManager arg0) {
		super((List) null, (SortedReloadListenerEvent.NameLookup) null);
		throw new UnsupportedOperationException("SteelWool does not implement the AddClientReloadListenersEvent constructor yet");
	}

	private static Identifier lookupName(PreparableReloadListener arg0) {
		throw new UnsupportedOperationException("SteelWool does not implement AddClientReloadListenersEvent.lookupName yet");
	}
}
